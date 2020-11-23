package abc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ALUTest {

	@Test
	public void testOperate() {
		ALU a1 = new ALU();
		ALU a2 = new ALU();
		ALU a3 = new ALU();
		ALU a4 = new ALU();

		a1.operate((short) 5, Operator.ADD, (short) 5);
		assertEquals(Nzp.POSITIVE, a1.getStatus());
		assertNotEquals(Nzp.ZERO, a1.getStatus());

		a2.operate((short) 5, Operator.SUB, (short) 5);
		assertEquals(Nzp.ZERO, a2.getStatus());
		assertNotEquals(Nzp.POSITIVE, a2.getStatus());

		a3.operate((short) 5, Operator.MULT, (short) 5);
		assertEquals(Nzp.POSITIVE, a3.getStatus());
		assertNotEquals(Nzp.ZERO, a3.getStatus());

		a4.operate((short) -5, Operator.DIV, (short) 5);
		assertEquals(Nzp.NEGATIVE, a4.getStatus());
		assertNotEquals(Nzp.ZERO, a4.getStatus());
	}
}