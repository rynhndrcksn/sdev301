package compare;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DogTester {
    public static void main(String[] args) {
        List<Dog> dogList = readFile("data/dogs.txt");

        System.out.println("Before Sort: "+ dogList);

        // Collections.sort(list) will use the compareTo in the Dog class by default
        Collections.sort(dogList);

        System.out.println("After Sort: "+ dogList);

        // What if you do not want to use the compareTo provided in the Dog class - use a
        // lambda expression to change the default sorting behavior
        dogList.sort((Dog thisPet, Dog otherPet) -> thisPet.getName().compareTo(otherPet.getName()));

        System.out.println("After Sort: "+ dogList);

    }

    public static List<Dog> readFile(String fileName){
        List<Dog> pets = new ArrayList<>();

        try(Scanner fileIn = new Scanner(new File(fileName))){
            while(fileIn.hasNextLine()){
                String[] items = fileIn.nextLine().split(",");
                pets.add(new Dog(items[0],Integer.parseInt(items[1]),Double.parseDouble(items[2])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return pets;
    }
}
