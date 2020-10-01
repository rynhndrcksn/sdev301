package cards;

public class SetCard extends Card {
    // fields
    private String color;
    private int number;
    private String shading;
    private String shape;

    // constructor
    public SetCard(String color, int number, String shading, String shape) {
        this.color = color;
        this.number = number;
        this.shading = shading;
        this.shape = shape;
    }

    // getters
    public String getColor() {
        return color;
    }

    public int getNumber() {
        return number;
    }

    public String getShading() {
        return shading;
    }

    public String getShape() {
        return shape;
    }

    // toString()
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
