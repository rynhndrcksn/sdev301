# SDEV 301 - Systems Programming - Ryan Hendrickson

## Assembly - ZyBooks Ch. 2.1

A programmable processor includes:
- **CPU**: A central processing unit executes instructions by controlling an ALU, register file, and other hardware components
  - **ALU**: A component that performs arithmetic and logic operations, like addition or subtraction, on data in the register file. Short for arithmetic logic unit.
  - **Register file**: A set of registers that holds temporary data accessible by the ALU. A register is a digital circuit that can store multiple bits, such as 32 bits.
- **Instruction memory**: A memory that holds instructions.
- **Data memory**: A memory that holds data used by the instructions.
- **Memory**: Digital circuit that holds relatively large amount of data, often organized as bytes with each having a unique address, where each byte can be either read ("load") or written ("store").

A processor may support hundred of possible instruction types. Those instruction types can usually be classified into three categories:
- **Data Transfer Instruction**: Copies data among the data memory and register file.
- **ALU Instruction**: Operates on data.
- **Branch Instruction**: Specifies the location of the next instruction to execute, being different from the next instruction in instruction memory.

Each instruction typically is encoded into a limited number of bits, such as 32 bits. Using a small limited number of bits per instruction ensures more instructions can fit into the memory, and keeps the processor's circuit simple and fast. Some bits may represent the instruction type (like Load or Add), other bits may indicate the registers involved (like t0 or t1), and others a data memory address (like 5005). As such, the number of instruction types is limited. Ex: If the instruction type is represented in 8 bits, then only 28 = 256 instruction types are possible.

Thus, a processor's instruction types are limited and kept basic, like the basic Add, Store, and Load instructions seen above. A programmer must achieve desired functionality using just those relatively-few instruction types.

- **Instruction Set**: Set of instruction types supported by a particular processor.
- **Assembly Language Program**: A program written using a processors instructions.

**Zero Register**: A read-only register that always holds the value 0.

- **Reset**: An input that when asserted causes a circuit to enter a known state. A processor's reset causes 0's to be written to all registers, including the register file and program counter. After the reset, the processor executes the instruction at address 0.
- **Power-on-reset**: A circuit that resets the processor when power is first applied.

**MIPS** is a processor that was popular in various computers in the 1990's, and is found in some embedded computing devices today. MIPS is presently one of the most popular processors for learning assembly language programming, and also for learning processor design. MIPS is known for having a simple and elegant instruction set, which in turn enables simple and fast processor designs.

MIPS' instruction set has just over 100 instructions, and each instruction is 32 bits. The MIPS register file has 32 registers, each being 32 bits. Memory addresses are 32 bits. Memory can be accessed by words (4 bytes), half words (2 bytes), or bytes.

For educational purposes, this material teaches a greatly-simplified version of MIPS, known as MIPSzy, using a small subset of the MIPS instruction set, and using a register file with only 8 primary registers. **MIPSzy** only allows memory to be accessed by words (4 bytes).

---
## Assembly - ZyBooks Ch. 2.2

MIPS register names start with a $. MIPSzy supports 8 registers. Writeable registers are $t0, $t1, ..., $t6. A special $zero register always has the value 0 and can only be read, not written.

The load instruction's memory-address is a register whose value is the memory address from which data is copied.

**Load Instruction (lw)**: copies data from memory into a register. A MIPS load instruction format is shown below. Another section discusses the reason for the 0( ) around the memory-address.

*lw regA, 0(regB)*

- lw is short for "load word" and copies data from register $b to register $a.

**Store Instruction (sw)**: A store instruction copies data from a register to memory. A MIPS store instruction format is shown below. Another section discusses the reason for the 0( ) around the memory-address.

*sw regA, 0(regB)*

- sw is short for "store word" and copies data from regA to regB.

---
## Assembly - ZyBooks Ch. 2.3

**Memory Alignment**: The restriction of word addresses to multiples of 4 (or other multipled for different processors).

A particular memory may store a sequence of 32-bit wide words (instructions or data). One might assume addresses for each word would increment by 1, as in: 0, 1, 2, 3, 4, 5, etc. However, each byte in a word can be addressed individually. Thus, addresses of each word increment by 4: 0, 4, 8, 12, 16, etc.

Instructions that load or store words must use addresses that are multiples of four. Instructions that load or store bytes may use any address.

**Endianness**: refers to whether bytes in a word are ordered starting with the most-significant byte first (**big-endian**) or the least-significant byte first (**little-endian**). Some processors use big-endian format while others use little-endian.

- **Big-Endian**: op, regA, regB, regC | same with binary numbers (00000000 00001111 00011000 11111110)
- **Little-Endian**: regC, regB, regA, op | same with binary numbers (11111110 00011000 00001111 00000000)

*Note*: Endianness is usually hidden from the programmer. However, knowledge of endianness is relevant when designing a processor and when learning how processors work. Endianness also matters for the (rare) cases when a programmer is doing byte-level operations on data.

---
## Assembly - ZyBooks Ch. 2.4

**Add Immediate (addi)**: Adds a register's value and an immediate value. An imediate is a vlue specified within an instruction. In MIPS, the immediate is a 16-bit number that can range from -32,768 to 32,767. A MIPS addi instruction format is shown below, which computer regA = regB + immediate.

*addi regA, regB, immediate*

Commonly, a specific value needs to be written to a register. The addi instruction format below computes regA = immediate:

*addi regA, $zero, immediate*

Since $zero always holds the value 0, the sum is equal to the immediate value, and the immediate value is written to the register.

**Add Instruction (add)**: Computes the sum of two register values, and writes the sum into a register. A MIPS add instruction format is shown below, which computes regA = regB + regC.

*add regA, regB, regC*

The register written by an instruction is called the destination register. A register read by an instruction is called a source register. For the add instruction, regA is the destination register, and regB and regC are source registers.

---
## Assembly - ZyBooks Ch. 2.5

A comment is text in a program intended just for humans reading the program, rather than for the processor executing the program. In MIPS, a comment is any text on a line following the # symbol.

*lw regA, 0(regB)    # This is a comment*

*add $t1, $t1, $t1  # Another comment*

---
## Assembly - ZyBooks Ch. 2.6

Registers are limited, so programmers should conserve registers. If a value in a register is not read later, the register can be reused by writing another value. Ex: Assume $t4 holds a memory address used in a lw instruction. If that memory address is not used by another instruction, $t4 can be reused to hold a different memory address or used to hold the result of a computation. 

---
## Assembly - ZyBooks Ch. 2.7

**Subtract Instruction (sub)**: Computes the difference of two register values, and writes the difference into a register. A MIPS subtract instruction format is shown below, which computes regA = regB - regC.

*sub regA, regB, regC*

**Multiply Instruction (mul)**: Computes the product of two register values, and writes the product into a register. A MIPS multiply instruction format is shown below, which computes regA = regB * regC. The multiply instruction computes a 32-bit product, and ignores any overflow that may result from multiplying two 32-bit values.

*mul regA, regB, regC*


**Pseudoinstructions**: An assembly instruction that must be replaced by one or more native instructions before being executed. Pseudoinstructions are used to keep the number of native instructions small, which leads to more efficient processor hardware, while providing programmers a large set of instructions for common operations. The MIPS mul instruction is a pseudoinstruction implemented using mult and mflo native instructions, discussed elsewhere.

---
## Assembly - ZyBooks Ch. 2.8


Branch instructions: Specifies the location of the next instruction to execute, depending on the branch instruction's condition.
- **Branch on Equal (beq)**: Branches to the instruction at BLabel if the values held in regA and regB are equal. Otherwise, instruction immediately after beq is executed. 
  - *beq regA, regB, BLabel*
- **Branch Not Equal (bne)**: Branches to the instruction at BLabel if the values held in regA and regB are not equal. Otherwise, instruction immediately after bne is executed. 
  - *bne regA, regB, BLabel*

A branch instruction typically uses a label to specify the next instruction's location. A label is a named position in a program that represents an instruction's memory address. The MIPS beq instruction format below branches to the instruction at location Label if the values held in regA and regB are equal.

A label is a sequence of letters (a-z, A-Z, _) and digits (0-9) starting with a letter and followed by a colon (:).

**Jump (j)**: Causes execution to continue with the instruction at JLabel.
- *j JLabel*

Branch and jump instructions are commonly used together to direct a program to conditionally execute either one group of instructions or another group, but not both. A branch instruction is used to decide which group of statements to execute. If the branch is taken, the instruction group at the label specified in the branch is executed. If the branch is not taken, the instruction group after the branch is executed. That instruction group ends with a jump instruction to the first instruction after the other instruction group, so the other instruction group is not executed.
