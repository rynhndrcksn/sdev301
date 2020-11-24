package copyconstructors;

import java.util.*;

public class Engine {

    private String type;
    private List<Part> parts;
    private boolean broken = false;

    public Engine(String type, List<Part> parts) {

        this.type = type;
        this.parts = parts; // shallow copy
    }

    // creat deep copy constructor for Engine
    public Engine(Engine other) {
        this.type = other.type;

        this.parts = new ArrayList<>();
        // doesn't work for creating the new ArrayList populated with the parts already
        // this.parts = new ArrayList<>(other.getParts());
        // this.parts = new ArrayList<>(new ArrayList<>(other.getParts()));

        // doesn't work
        // parts.addAll(new ArrayList<Part>(other.getParts()));

        // this works, shame we can't make it more concise
        for (Part p : other.getParts()) {
            this.parts.add(new Part(p));
        }
    }

    public String getType() {
        return type;
    }

    public void breakEngine() {
        broken = true;
    }

    public void fixEngine() {
        broken = false;
    }

    public List<Part> getParts() {
        return parts;
    }

    @Override
    public String toString() {
        return "Engine [type=" + type + ", parts=" + parts
                + ", broken=" + broken + "]";
    }
}
