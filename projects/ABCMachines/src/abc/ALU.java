package abc;

public class ALU {
    // fields
    private Nzp status; //holds Nzp.NEGATIVE, Nzp.ZERO, or Nzp.POSITIVE

    /**
     * ALU class constructor
     */
    public ALU() {
        status = Nzp.ZERO;
    }

    /**
     * performs arithmetic on num1 and num 2.
     * @param num1 is the src1 register
     * @param operator is the operator that tells us which arithmetic to do on our nums
     * @param num2 is the src2 register
     * @return result, which is the result of the arithmetic
     */
    public short operate(short num1, Operator operator, short num2) {
        short result = 0;

        switch (operator) {
            case ADD:
                result = (byte) (num1 + num2);
                break;
            case SUB:
                result = (byte) (num1 - num2);
                break;
            case MULT:
                result = (byte) (num1 * num2);
                break;
            case DIV:
                result = (byte) (num1 / num2);
                break;
        }

        if (result > 0) {
            status = Nzp.POSITIVE;
        } else if (result < 0) {
            status = Nzp.NEGATIVE;
        } else {
            status = Nzp.ZERO;
        }

        return result;//answer to ADD, SUB, MULT, DIV

    }

    /**
     * @return the status of the ALU
     */
    public Nzp getStatus() {
        return status;
    }

}
