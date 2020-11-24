package copyconstructors;

public class Car {
    private String make;
    private String model;
    private Engine engine;

    public Car(String make, String model, Engine engine) {
        this.make = make;
        this.model = model;
        this.engine = engine; // shallow copy
    }

    public Car(Car other) {
        this.make = other.getMake(); // since Strings are immutable, this is fine to shallow copy
        this.model = other.getModel();
        this.engine = new Engine(other.getEngine()); // deep copy engine

    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    @Override
    public String toString() {
        return "Car [make=" + make + ", model=" + model + ", engine=" + engine
                + "]";
    }
}
