package shallowcopy;

import java.util.*;

public class Engine {

    private String type;
    private List<Part> parts;
    private boolean broken = false;

    public Engine(String type, List<Part> parts) {

        this.type = type;
        this.parts = parts; // shallow copy
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
