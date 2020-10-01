package college;

import java.util.ArrayList;

public class College {
    // field (aggregation of Student class | 'has a' relationship)
    private ArrayList<Student> college;


    public College() {
        this.college = new ArrayList<>();
    }

    public College(ArrayList<Student> college) {
        // shallow copy from TestCollege
        this.college = college;
    }

    @Override
    public String toString() {
        return "College{" +
                "college=" + college +
                '}';
    }
}
