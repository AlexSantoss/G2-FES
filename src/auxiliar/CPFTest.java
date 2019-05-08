package auxiliar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CPFTest {

	@Test
	void test() {
		CPF a = new CPF("838.937.060-38");
		
		if (a.toString() != "838.937.060-38") {
			fail("CPF string not the same as the string passed to the constructor?");
		}
		
		try {
			a = new CPF("123.123.123-01");
			fail("Invalid CPF '123.123.123-01' was created without error.");
		}
		catch (IllegalArgumentException e) {}
		
		
		try {
			a = new CPF("123.123");
			fail("Invalid CPF '123.123' was created without error.");
		}
		catch (IllegalArgumentException e) {}
		
	}

}
