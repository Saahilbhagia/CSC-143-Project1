
package world;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class Hotel extends Building implements Residential, Rentable, Business {
    // Field
    String company;

    HashSet<String> rentals = new HashSet<>(); // list of rental contracted occupants
    HashSet<String> occupants = new HashSet<>(); // list of occupant renting rooms

    // Construction
    public Hotel(String location, String company) {
        super(location);
        this.company = company;
    }

    // Functions

    /**
     * Set the name of the hotel/company
     *
     * @param company the name wants to set
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * Get the current name of the hotel/company
     *
     * @return the current name of the hotel/company
     */
    public String getCompany() {
        return this.company;
    }

    /**
     * Registers a rental under the provided name, allowing the named occupant to move in.
     *
     * @param occupant The occupant registers for the rent
     */
    public void registerRental(String occupant) {
        rentals.add(occupant);
    }

    /**
     * Unregisters the rental for a name. The occupant is no longer allowed to move in,
     * and is evicted if present.
     *
     * @param occupant The occupant who wants to end the rent
     */
    public void endRental(String occupant) {
        if(rentals.contains(occupant)) {
            occupants.remove(occupant);
            rentals.remove(occupant);
        }
    }

    /**
     * Move in an occupant, if they have a rental.
     *
     * @param occupant The occupant wants to move in
     */
    public void moveIn(String occupant){
        if(rentals.contains(occupant)) {
            occupants.add(occupant);
        }
    }

    /**
     * Move out an occupant, if they are present.
     *
     * @param occupant The presented occupant wants to move out
     */
    public void moveOut(String occupant){
        if(occupants.contains(occupant)) {
            rentals.remove(occupant);
            occupants.remove(occupant);
        }
    }

    /**
     * Get the collection of present occupants in the hotel
     *
     * @return The collection of present occupants in the hotel
     */
    public Collection<String> getOccupants() {
        return occupants;
    }



/* YOUR CODE HERE */

}

