package world;

import lib.Pair;

import java.util.ArrayList;
import java.util.Collection;

public class Supermarket extends Store {
    // Construction
    public Supermarket(String location, String company) {
        super(location, company);
    }

    //Function
    /**
     *  Inherited from Store. Returns a list of products (as pairs, name and quantity)
     *  that reflects the store inventory.
     *
     *  @return The collection of available products in the store inventory
     */
    @Override
    public Collection<Pair<String, Integer>> getProducts() {
        ArrayList<Pair<String, Integer>> productList = new ArrayList<>();
        for(String s: this.supplies.keySet()) { //Iterate over the products' names
            productList.add(new Pair<>(s, this.supplies.get(s)));// get the products' quantities
        }
        return productList;
    }

    /**
     * Inherited from Store. The supermarket should attempt to fulfill the order described by the collection
     * (a list of pairs, products and quantities) as best as possible. Purchased items are subtracted from the store's supplies.
     * If the requested item does not exist, nothing is purchased.
     * If there are not enough items to fulfill the order, fulfill as many as available.
     *
     * @param order The collection of order
     * @return The collection of fulfilled order
     */
    @Override
    public  Collection<Pair<String, Integer>> purchase(Collection<Pair<String, Integer>> order) {
        ArrayList<Pair<String, Integer>> res = new ArrayList<>();
        for(Pair<String, Integer> p : order) {// Iterating every product name in the order
            if(supplies.containsKey(p.left)) { // check if the inventory has that product
                // Check if the quantities of the product is enough to fulfill all the order quantities
                if (p.right <= this.supplies.get(p.left)) {  // if yes:
                    res.add(new Pair<>(p.left, p.right)); // add all
                    this.supplies.put(p.left, this.supplies.get(p.left) - p.right); // update the inventory
                } else { // if no:
                    res.add(new Pair<>(p.left, this.supplies.get(p.left))); // get as much as poss
                    this.supplies.put(p.left, 0); // remove all the quantities
                }
            }
        }
        return res;
    }
}
