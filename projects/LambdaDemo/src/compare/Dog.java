package compare;

public class Dog implements Comparable<Dog> {
    private String name;
    private int age;
    private double weight;

    public Dog() {
        name = "";
        age = 0;
        weight = 0.0;
    }

    public Dog(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * This method compares the Dog objects by age so it is the default sorting mechanism when
     * Collections.sort() or Arrays.sort() is used
     * @param other Dog
     * @return  <0 this Dog is younger than the other Dog
     *          >0 this Dog is older than the other Dog
     *          = 0 this Dog has the same age as the other Dog
     */
    public int compareTo(Dog other){
        return this.getAge() - other.getAge();
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name +
                ", age=" + age +
                ", weight=" + weight +
                '}' + System.lineSeparator();
    }
}
