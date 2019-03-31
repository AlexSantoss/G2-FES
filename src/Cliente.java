import Auxiliar.Address;
import Auxiliar.CPF;

public class Cliente {
	String name;
	Address address;
	CPF cpf;
	int id;
	
	Cliente(String name, Address address, CPF cpf){
		setName(name);
		setAddress(address);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
