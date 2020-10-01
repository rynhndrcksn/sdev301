package client;

import college.*;

import java.util.ArrayList;

public class TestCollege {
    public static void main(String[] args) {
        // construct a person
        Person fred = new Person("Fred", 34);
        System.out.println(fred);

        Student paul = new Student("Paul Smith", 22);
        System.out.println(paul);

        Student ada = new Student("Ada Lovelace", 87);
        System.out.println(ada);

        // construct ArrayList of students
        ArrayList<Student> list = new ArrayList<>();
        list.add(paul);
        list.add(ada);

        // pass to the College constructor (shallow copy)
        College grc = new College(list);
        System.out.println(grc);
    }
}
