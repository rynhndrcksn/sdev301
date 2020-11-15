package abc;

public class ALU {

    private Nzp status; //holds Nzp.NEGATIVE, Nzp.ZERO, or Nzp.POSITIVE

    // TODO: Initialize the ALU status to Nzp.ZERO
    public ALU() {
        status = Nzp.ZERO;
    }

    //TODO: This method will perform a math operation on two numbers and set the nzp status
    // appropriately based on whether the math operation resulting in a postive, negative, or zero value

    public short operate(short num1, Operator operator, short num2) {


        return 0;//answer to ADD, SUB, MULT, DIV

    }

    // TODO: Write an accessor for the getStatus() method
    public Nzp getStatus() {
        return status;
    }



}
