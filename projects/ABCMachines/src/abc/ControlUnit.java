package abc;

/**
 * This class represents the Control Unit for the ABC Machine
 * @author Susan Uland (Starter file) & Ryan Hendrickson (fleshed everything else out)
 * date: November 23rd, 2020.
 * @version 1.0
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

    /**
     *  This method performs the fetch step for the ControlUnit
     *  1. Access the memory address for the next instruction in RAM(memory array) (use the PC register)
     *  2. Load this instruction from memory into the Instruction Register  (IR)
     *  3. Increment the Program Counter (PC) register
     */
    public void fetch() {
        // load instruction register
        machine.setIr(machine.getMemory()[machine.getPc()]);
        // increment program counter
        machine.setPc((byte) (machine.getPc() + 1));
    }

    /**
     * This method decodes and executes the instruction according to the
     * ABCMachine Instruction Set and stores the result
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
            case 1: // sub
                registers[getDestRegister()] = machine.getAlu().operate(src1, Operator.SUB, src2);
                break;
            case 2: // mult
                registers[getDestRegister()] = machine.getAlu().operate(src1, Operator.MULT, src2);
                break;
            case 3: // div
                registers[getDestRegister()] = machine.getAlu().operate(src1, Operator.DIV, src2);
                break;
            case 4: // st
                machine.getMemory()[getMemAddr()] = registers[getSrc1Register()];
            case 5: // ld
                machine.getRegisters()[getSrc1Register()] = machine.getMemory()[getMemAddr()];
                // maybe change this ^ to src1 for conciseness if it works?
                break;
            case 6: // br
                if (src1 == 4 && machine.getAlu().getStatus() == Nzp.NEGATIVE ||
                    src1 == 2 && machine.getAlu().getStatus() == Nzp.ZERO ||
                    src1 == 1 && machine.getAlu().getStatus() == Nzp.POSITIVE) {
                    // jump to the new address and insert it into the pc
                    machine.setPc(getMemAddr());
                }
            case 7: // jmp
                machine.setPc(getMemAddr());
        }

    }

    /**
     * This method returns the numerical value stored in bits numbered 14 - 16
     * of the instruction register (IR) so the proper opcode can be determined
     * IR     1  1  1  0   0  0  0  0   0  0  0  0   0  0  0  0
     * Bit # 16 15 14 13  12 11 10  9   8  7  6  5   4  3  2  1
     *
     * @return a number in range 0 - 7
     * 000 - ADD,  001 - SUB, 010 - MULT, 011 - DIV, 100 - ST(ORE), 101 - LD (LOAD)
     * 110 - BR (BRANCH), 111 - JMP (JUMP)
     */
    public byte getOpcode() {
        // do an inline mask, & it with getIr(), then shift it, cast as byte, and return it
        return (byte) (0b111 & machine.getIr() >>> 13);
    }

    /**
     * This method returns the numerical value stored in bits numbered 11 - 13
     * of the instruction register (IR)
     * IR     0  0  0  1   1  1  0  0   0  0  0  0   0  0  0  0
     * Bit # 16 15 14 13  12 11 10  9   8  7  6  5   4  3  2  1
     *
     * @return a number in range 0 - 7 - indicates
     */
    public byte getSrc1Register() {
        return (byte) (0b111 & machine.getIr() >>> 10);
    }

    /**
     * This method returns the numerical value stored in bits numbered 8 - 10
     * of the instruction register (IR)
     * IR     0  0  0  0   0  0  1  1   1  0  0  0   0  0  0  0
     * Bit # 16 15 14 13  12 11 10  9   8  7  6  5   4  3  2  1
     *
     * @return a number in range 0 - 7
     */
    public byte getSrc2Register() {
        return (byte) (0b111 & machine.getIr() >>> 7);
    }

    /**
     * This method returns the numerical value stored in bits numbered 5 - 7
     * of the instruction register (IR)
     * IR     0  0  0  0   0  0  0  0   0  1  1  1   0  0  0  0
     * Bit # 16 15 14 13  12 11 10  9   8  7  6  5   4  3  2  1
     *
     * @return a number in range 0 - 7
     */
    public byte getDestRegister() {
        return (byte) (0b111 & machine.getIr() >>> 4);
    }

    /**
     * This method returns the numerical value stored in bits numbered 1 - 4
     * of the instruction register (IR)
     * IR     0  0  0  0   0  0  0  0   0  0  0  0   1  1  1  1
     * Bit # 16 15 14 13  12 11 10  9   8  7  6  5   4  3  2  1
     *
     * @return a number in range 0 - 15
     */
    public byte getMemAddr() {
        return (byte) (0b1111 & machine.getIr());
    }

    /**
     *
     * @return true if next instruction contains all zeros, otherwise false
     */
    public boolean halt() {
        return machine.getMemory()[machine.getPc()] == 0;
    }
}
