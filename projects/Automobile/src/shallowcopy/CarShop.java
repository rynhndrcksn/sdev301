package shallowcopy;

import utilities.Console;

import java.util.ArrayList;


public class CarShop {

    public static final Console IN = new Console();

    public static void main(String[] args) {
        //request data for a new car
        System.out.println("Create a new Car object!");
        String make = IN.readText("Car Make? ");
        String model = IN.readText("Car Model? ");


        //create an object representing the car
        Car car = new Car(make, model, getNewEngine());
        Car copy = car; // shallow copy - sharing the same memory in the heap

        //print original car and copy object
        System.out.println(car);
        System.out.println(copy);
        System.out.println();

        // TODO: Break the car's engine - DONE
        car.getEngine().breakEngine();

        //TODO: Output - Are engines broken in both the car and copy object? - DONE
        System.out.println(car);
        System.out.println(copy);
        System.out.println();

        //TODO:  Break an engine part in the car - DONE
        car.getEngine().getParts().get(0).breakPart();

        //TODO: Output - Are engine parts broken in both the car and copy object? - DONE and yes, they're both broken
        System.out.println(car);
        System.out.println(copy);

    }

    private static Engine getNewEngine( ) {
        //get engine field
        String type = IN.readText("Car Engine Type? ");

        //generate parts
        ArrayList<Part> parts = new ArrayList<>();
        System.out.println();
        int numParts = IN.readInt("Number of car engine parts?");
        System.out.println();
        for (int i = 0; i < numParts; i++) {
            //int partId = IN.readInt("Engine Part Number?");
            Part part = getNewPart();
            System.out.println();
            parts.add(part);
        }

        //create the engine
        Engine engine = new Engine(type, parts);

        return engine;
    }

    private static Part getNewPart() {
        //retrieve part fields
        String name = IN.readText("Engine Part Name? ");

        //create a new part
        Part part = new Part(name);
        System.out.println();
        return part;
    }




}
