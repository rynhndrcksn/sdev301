package copyconstructors;

import utilities.*;

public class Part extends Identifiable {

    private String name;
    private boolean broken = false;

    public Part(String name) {
        this.name = name;
    }

    public Part(Part other) {
        // Strings are immutable so no new is necessary
        this.name = other.name;
        // Booleans are primitive, so new isn't necessary
        this.broken = other.broken;
    }

    public String getName() {
        return name;
    }

    public void breakPart() {
        broken = true;
    }

    public void fixPart() {
        broken = false;
    }

    @Override
    public String toString() {
        return "Part [id=" + super.toString() + ", name=" + name + ", broken="
                + broken + "]";
    }
}
