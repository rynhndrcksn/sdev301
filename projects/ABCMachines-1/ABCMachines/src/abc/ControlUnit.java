package abc;

/**
 * This class represents the Control Unit for the
 * ABC Machine
 *
 */
public class ControlUnit {

    private ABCMachine machine;

    /**
     * @param machine The ABC machine this ControlUnit belongs to
     */
    public ControlUnit(ABCMachine machine) {
        this.machine = machine;
    }

    /*
     * This method will continuously fetch, decode, execute, and store instructions/data that are
     * loaded into the ABCMachine's memory map. The program "halts" when it reaches an instruction
     * that is zero.
     */
    public void startProcessing() {

        while (!halt()) {
            fetch();
            decodeExecuteStore();
        }

    }

    /*
     * TODO: This method performs the fetch step for the ControlUnit
     *  1. Access the memory address for the next instruction in RAM(memory array) (use the PC register)
     *  2. Load this instruction from memory into the Instruction Register  (IR)
     *  3. Increment the Program Counter (PC) register
     */
    public void fetch() {
        // get machine's memory
        short[] mem = machine.getMemory();

        // get the program counter
        byte pc = machine.getPc();

        // get the instruction from mem[pc]
        short instruction = mem[pc];

        // load instruction into IR
        machine.setIr(instruction);

        // increment program counter
        pc = (byte)(pc+1);
        machine.setPc(pc);
    }

    /*
     * TODO: This method decodes and executes the instruction according to the
     *  ABCMachine Instruction Set and stores the result
     */
    public void decodeExecuteStore() {
        byte opCode = getOpcode();
        short[] registers = machine.getRegisters();
        short src1 = registers[getSrc1Register()];
        short src2 = registers[getSrc2Register()];
        switch(opCode) {
            case 0: // add
                registers[getDestRegister()] = machine.getAlu().operate(src1, Operator.ADD, src2);
                break;
            case 1: // subtract

                break;
            case 2: // multiply

                break;
            case 3: // divide

                break;
            case 4:
            case 7: // jump
        }

    }

    /**
     * TODO: This method returns the numerical value stored in bits numbered 14 - 16
     *  of the instruction register (IR) so the proper opcode can be determined
     *  IR     1  1  1  0   0  0  0  0   0  0  0  0   0  0  0  0
     *  Bit # 16 15 14 13  12 11 10  9   8  7  6  5   4  3  2  1
     *
     * @return a number in range 0 - 7
     * 000 - ADD,  001 - SUB, 010 - MULT, 011 - DIV, 100 - ST(ORE), 101 - LD (LOAD)
     * 110 - BR (BRANCH), 111 - JMP (JUMP)
     */
    public byte getOpcode() {
        final int SHIFT_RIGHT = 13;
        short instr = machine.getIr();
        // return the bits at bit #'s 14, 15, and 16
        return (byte) (instr >> SHIFT_RIGHT);

    }

    /**
     * TODO: This method returns the numerical value stored in bits numbered 11 - 13
     * of the instruction register (IR)
     * IR     0  0  0  1   1  1  0  0   0  0  0  0   0  0  0  0
     * Bit # 16 15 14 13  12 11 10  9   8  7  6  5   4  3  2  1
     *
     * @return a number in range 0 - 7 - indicates
     */
    public byte getSrc1Register() {
        final int SHIFT_RIGHT = 10;
        short instr = machine.getIr();
        // return the bits at bit #'s 11, 12, and 13
        return (byte) (instr >> SHIFT_RIGHT);
    }

    /**
     * TODO: This method returns the numerical value stored in bits numbered 8 - 10
     * of the instruction register (IR)
     * IR     0  0  0  0   0  0  1  1   1  0  0  0   0  0  0  0
     * Bit # 16 15 14 13  12 11 10  9   8  7  6  5   4  3  2  1
     *
     * @return a number in range 0 - 7
     */
    public byte getSrc2Register() {
        final int SHIFT_RIGHT = 7;
        short instr = machine.getIr();
        // return the bits at bit #'s 11, 12, and 13
        return (byte) (instr >> SHIFT_RIGHT);
    }

    /**
     * TODO: This method returns the numerical value stored in bits numbered 5 - 7
     * of the instruction register (IR)
     * IR     0  0  0  0   0  0  0  0   0  1  1  1   0  0  0  0
     * Bit # 16 15 14 13  12 11 10  9   8  7  6  5   4  3  2  1
     *
     * @return a number in range 0 - 7
     */
    public byte getDestRegister() {
        final int SHIFT_RIGHT = 4;
        short instr = machine.getIr();
        // return the bits at bit #'s 11, 12, and 13
        return (byte) (instr >> SHIFT_RIGHT);
    }

    /**
     * TODO: This method returns the numerical value stored in bits numbered 1 - 4
     * of the instruction register (IR)
     * IR     0  0  0  0   0  0  0  0   0  0  0  0   1  1  1  1
     * Bit # 16 15 14 13  12 11 10  9   8  7  6  5   4  3  2  1
     *
     * @return a number in range 0 - 15
     */
    public byte getMemAddr() {
        final int SHIFT_RIGHT = 0;
        short instr = machine.getIr();
        // return the bits at bit #'s 11, 12, and 13
        return (byte) (instr >> SHIFT_RIGHT);
    }

    /**
     *
     * @return true if next instruction contains all zeros, otherwise false
     */
    public boolean halt() {
        return machine.getMemory()[machine.getPc()] == 0;
    }
}
