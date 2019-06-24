package auxiliar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AddressTest {

	@Test
	void setCep() {
		Address add = new Address("Rua 1", "22230-001","1");
		
		try {
			add.setCep("189");
			fail("Invalid Cep '189' was set without throwing exception.");
		}
		catch(IllegalArgumentException e){
		}
		try {
			add.setCep("1820-0123");
			fail("Invalid Cep '1820-0123' was set without throwing exception.");
		}
		catch(IllegalArgumentException e){
		}
		try {
			add.setCep("18200-1230");
			fail("Invalid Cep '18200-1230' was set without throwing exception.");
		}
		catch(IllegalArgumentException e){
		}
	}

}
