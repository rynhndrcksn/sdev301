package kennel;

/**
 * This class represents a pet that can be housed in a boarding facility.
 * @author Ryan Hendrickson
 * @version 0.1
 */

public class Pet {
    // fields
    private boolean isVaccinated;
    private char sex;
    private char species;
    private double weight;
    private int age;
    private String breed;
    private String name;

    /**
     * constructs a pet object for us
     * @param isVaccinated tells us whether the animals rabies vaccine is up to date or not
     * @param sex allows M for male and F for female
     * @param species allows C for cat and D for dog
     * @param weight measures their weight in lbs
     * @param age measures their age in years
     * @param breed allows for their breed name to be entered
     * @param name what to call the animal
     */
    public Pet(boolean isVaccinated, char sex, char species, double weight, int age, String breed, String name) {
        this.isVaccinated = isVaccinated;
        this.sex = sex;
        this.species = species;
        this.weight = weight;
        this.age = age;
        this.breed = breed;
        this.name = name;
    }

    /**
     * retrieves the isVaccinated variable
     * @return isVaccinated
     */
    public boolean isVaccinated() {
        return isVaccinated;
    }

    /**
     * allows the user to set the isVaccinated field
     * @param vaccinated is whether the pet's rabies vaccine is up to date or not
     */
    public void setVaccinated(boolean vaccinated) {
        isVaccinated = vaccinated;
    }

    /**
     * retrieves the sex variable
     * @return sex
     */
    public char getSex() {
        return sex;
    }

    /**
     * allows user to set the sex variable
     * @param sex is what sex the animal is
     */
    public void setSex(char sex) {
        this.sex = sex;
    }

    /**
     * retrieves the species variable
     * @return species
     */
    public char getSpecies() {
        return species;
    }

    /**
     * allows user to set the species variable
     * @param species is whatever species the animal is
     */
    public void setSpecies(char species) {
        this.species = species;
    }

    /**
     * retrieves the weight variable
     * @return weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * allows user to set weight variable
     * @param weight in lbs
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * retrieves the age variable
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * allows user to set age variable
     * @param age in years
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * retrieves the breed variable
     * @return breed
     */
    public String getBreed() {
        return breed;
    }

    /**
     * allows user to set breed variable
     * @param breed is what breed the animal is
     */
    public void setBreed(String breed) {
        this.breed = breed;
    }

    /**
     * retrieves the name variable
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * allows user to set the name variable
     * @param name is what to call the animal
     */
    public void setName(String name) {
        this.name = name;
    }
}
