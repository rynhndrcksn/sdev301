package kennel;

/**
 * this class handles the "housing" side of things that houses the pets.
 * @author Ryan Hendrickson
 * @version 0.1
 */
public class Housing {
    // fields
    private int numCats; // keeps track of how many cats are in the facility
    private int numDogs; // keeps track of how many dogs are in the facility
    private int occupancy; // keeps track of the total occupancy
    private String checkIn; // use either Calendar or Date
    private String checkOut; // use either Calendar or Date
    private String housingType; // dog kennel or cat house

    /**
     * constructs a "housing" object
     * @param checkIn // tells us the check in date for the pet
     * @param checkOut // tells us the check out date for the pet
     * @param housing // tells us whether the pet will be in a kennel or house
     */
    public Housing(String checkIn, String checkOut, String housing) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.housingType = housing;
    }

    /**
     * allows the user to create a Pet object using the Pet constructor
     * @return a Pet object
     */
    public Pet addPet() {
        // gather user inputs for Pet object
        // parse information and see if it's a dog or cat, then increment that counter.
        // increment occupancy counter
     return Pet();
    }

    /**
     * allows the user to remove a Pet object that was previously created
     */
    public void removePet() {

    }
}