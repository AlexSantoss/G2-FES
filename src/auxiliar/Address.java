package auxiliar;

public class Address {
	private String street;
	private String cep;
	private String houseNumber;
	
	public Address(String street, String cep, String houseNumber){
		setStreet(street);
		setCep(cep);
		setHouseNumber(houseNumber);
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		if(street.trim().length() > 0)
			this.street = street.trim();
		else
			throw new IllegalArgumentException("Endereço vazio");
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		if(cep.length() == 9 && cep.charAt(5) == '-')
			this.cep = cep;
		else
			throw new IllegalArgumentException("CEP: " + cep + " malformado");
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
        
        public String toString(){
            return "Rua " + street + " n" + houseNumber + ". CEP:" + cep;
        }
	

}