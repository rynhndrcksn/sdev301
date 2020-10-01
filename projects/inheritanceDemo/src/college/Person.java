package college;

/**
 * this class represents a Person with a name and age
 */
public class Person {
    // fields - protected = subclasses can access the data directly
    protected String name;
    protected int age;

    // default constructor
    public Person() {
        this.name = "";
        this.age = 0;
    }

    // parameterized constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
