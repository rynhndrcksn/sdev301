package cards;

/**
 * SetCard class that is a child Class of Card
 * allows the user to create a "set card" using shading, color, shape, and number
 * @author Ryan Hendrickson
 * @version 1.0
 * @date October 2nd, 2020.
 */

public class SetCard extends Card {
    // fields
    private final String color;
    private final int number;
    private final String shading;
    private final String shape;

    /**
     * parameterized constructor for SetCard. takes all parameters and adds them
     * in one string within a "super()" constructor for Card
     * @param shading is a string to describe what kind of shading is on the card
     * @param color is a string to describe the color on the card
     * @param shape is a string to describe what kind of shape is on the card
     * @param number is an int to tell us what number is on the card
     */
    public SetCard(String shading, String color, String shape, int number) {
        super(shading + "-" + color + " " + shape + " " + number);
        this.shading = shading;
        this.color = color;
        this.shape = shape;
        this. number = number;
    }

    /**
     * getter for the color field
     * @return a string representing the color
     */
    public String getColor() {
        return color;
    }

    /**
     * getter for the number field
     * @return an int representing the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * getter for the shading field
     * @return a string representing the shading
     */
    public String getShading() {
        return shading;
    }

    /**
     * getter for the shape field
     * @return a string representing the shape
     */
    public String getShape() {
        return shape;
    }

    /**
     * overrides the default toString()
     * @return string
     */
    @Override
    public String toString() {
        return "SetCard{" +
                "color='" + color + '\'' +
                ", number=" + number +
                ", shading='" + shading + '\'' +
                ", shape='" + shape + '\'' +
                '}';
    }
}
