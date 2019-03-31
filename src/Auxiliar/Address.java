package Auxiliar;

public class Address {
	private String street;
	private String cep;
	private int houseNumber;
	
	Address(String street, String cep, int houseNumber) throws Exception{
		setStreet(street);
		setCep(cep);
		setHouseNumber(houseNumber);
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) throws Exception {
		if(street.trim().length() > 0)
			this.street = street.trim();
		else
			throw new Exception("Endereço vazio");
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) throws Exception {
		if(cep.charAt(5) == '-' && cep.length() == 9)
			this.cep = cep;
		else
			throw new Exception("CEP: " + cep + " malformado");
	}

	public int getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}
	

}
