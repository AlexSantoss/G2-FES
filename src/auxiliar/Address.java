package auxiliar;

public class Address {
	private String street;
	private String cep;
	private String houseNumber;
	
	public Address(String street, String cep, String houseNumber) throws Exception{
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
<<<<<<< HEAD
			throw new Exception("Endere�o vazio");
=======
			throw new Exception("Endereço vazio");
>>>>>>> e5d395e1e6dfcb69a27e562d78753b222ea1ae12
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