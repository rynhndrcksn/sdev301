package shallowcopy;

import utilities.Identifiable;

public class Part extends Identifiable {

    private String name;
    private boolean broken = false;

    public Part(String name) {
        this.name = name;
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
