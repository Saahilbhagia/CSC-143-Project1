package world;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Home extends Building implements Residential {
    // Fields
    String occupant;

    // Construction
    public Home(String location) {
        super(location);
        this.occupant = "";
    }

    // Functions
    /**
     * Move in an occupant, if the home is presently empty. Otherwise, do nothing.
     *
     * @param occupant The occupant wants to move in
     */
    public void moveIn(String occupant) {
        if(this.occupant.isEmpty()) this.occupant = occupant;
    }

    /**
     * Move out an occupant, if the occupant is present. Otherwise, do nothing.
     *
     * @param occupant The occupant wants to move out
     */
    public void moveOut(String occupant) {
        // check if there is the occupant in the house
        // if yes, move hoim/her out
        if(!this.occupant.isEmpty() && this.occupant.equals(occupant)) {
            this.occupant = "";
        }
    }

    /**
     *  get the collection of occupants in the house
     *
     * @return the collection of occupants in the house
     */
    public Collection<String> getOccupants() {
        ArrayList<String> res = new ArrayList<>();
        // if there is a occupant in the house, add him/her to the collection
        if(!this.occupant.isEmpty()) res.add(this.occupant);
        return res;
    }

}
