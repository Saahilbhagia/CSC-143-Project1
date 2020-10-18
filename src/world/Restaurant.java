package world;

import lib.Pair;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Restaurant extends Store {
    // Field
    public HashMap<String, Collection<Pair<String, Integer>>> recipes = new HashMap<>();

    // Construction
    public Restaurant(String location, String company) {
        super(location, company);
    }

    // Functions

    /**
     * Adds a recipe to the restaurant,
     * with the name and list of required ingredients as pairs of item and quantity.
     *
     * @param name The name of the meal that the restaurant wants to learn
     * @param ingredients The ingredients need for the meal
     */
    public void learnRecipe(String name, Collection<Pair<String, Integer>> ingredients) {
        recipes.put(name, ingredients);
    }

    /**
     * Returns a list of food items and quantities that the restaurant can create from recipes,
     * using existing supply inventory
     *
     * @return The collection of available quantities of meals that the restaurant can make from its inventory
     */
    public Collection<Pair<String, Integer>> getProducts() {
        ArrayList<Pair<String, Integer>> res = new ArrayList<>();
        for(String s : recipes.keySet()) {
            int maxOrder = 0; // check the max quantities of meal can make from the ingredients
            for(Pair<String, Integer> p : recipes.get(s)) { // iterating the inventory\
                // Go to the next meal if a ingredent doesn't have in the inventory
                if(!supplies.containsKey(p.left) || supplies.get(p.left)==0) {
                    maxOrder = 0;
                    break;
                } else {
                    // get the maximum meal can make from the ingredien
                    maxOrder = (maxOrder != 0) ? Math.min(maxOrder, supplies.get(p.left) / p.right) : supplies.get(p.left) / p.right;
                }
            }
            res.add(new Pair<>(s, maxOrder));
        }
        return res;
    }

    /**
     * Inherited from Store. The restaurant should attempt to fulfill the food order described by the collection
     * as best as possible, in the order that each request is received.
     * Fulfilling an order requires deducting, from supplies, the raw ingredients specified by the recipe.
     *
     * @param order The collection of meal orders from customers
     * @return The collection of fulfilled meals for the customers
     */
    public Collection<Pair<String, Integer>> purchase(Collection<Pair<String, Integer>> order) {
        ArrayList<Pair<String, Integer>> res = new ArrayList<>();
        // return empty list if there is no recipes
        if(recipes.isEmpty()) return res;
        // Get the available ingredient using getProducts function
        ArrayList<Pair<String, Integer>> inSupplie = (ArrayList)this.getProducts();
        // Convert the collection to a map
        HashMap<String, Integer> map = new HashMap<>();
        for(Pair<String, Integer> p : inSupplie) {
            map.put(p.left, p.right);
        }
        // Iterating the order names
        for(Pair<String, Integer> p : order) {
            if(map.get(p.left) == 0){ // If the quantities of meal can make is 0 move to next order
                continue;
            }else if (p.right <= map.get(p.left)) { // fulfill all the order if the inventory has more than the order
                res.add(new Pair<>(p.left, p.right));
                // Update the supplies:
                for(Pair<String, Integer> p2 : recipes.get(p.left)) {
                    this.supplies.put(p2.left, this.supplies.get(p2.left) - p.right * p2.right);
                }
            } else { // fulfill the order with what the store has left
                res.add(new Pair<>(p.left, map.get(p.left)));
                // Update the supplies
                for(Pair<String, Integer> p2 : recipes.get(p.left)) {
                    this.supplies.put(p2.left, 0);
                }
            }
        }

        return res;
    }

}

