package streamobjects;

import java.util.Random;

public class Die {

    private int numSides;

    public Die(int numSides){
        this.numSides = numSides;
    }

    public int getNumSides(){
        return this.numSides;
    }

    public int rollDie(){
        Random gen = new Random();
        return gen.nextInt(numSides) + 1;
    }

    @Override
    public String toString() {
        return "Die has " + getNumSides() + " sides.";
    }

}
