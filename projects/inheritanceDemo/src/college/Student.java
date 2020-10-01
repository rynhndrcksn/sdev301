package college;

public class Student extends Person {
    // fields
    private int id;
    private static int idGen = 9999; // only for the class


    public Student() {
        // calls Person default constructor
        super();
        generateId();
    }

    public Student(String name, int age) {
        super(name, age);
        generateId();
    }

    // helper method should be private
    private void generateId() {
        this.id = idGen;
        idGen++;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
