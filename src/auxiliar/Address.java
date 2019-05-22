package auxiliar;

/**
 * Essa classe representa um endereço usando strings.
 * 
 * 
 * @author Alex
 *
 */
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

	/**
	 * Altera a rua de um endereço.
	 * 
	 * @param street a nova rua. Se for string vazia, lança IllegalArgumentException.
	 */
	public void setStreet(String street) {
		if(street.trim().length() > 0)
			this.street = street.trim();
		else
			throw new IllegalArgumentException("Endereço vazio.");
	}

	public String getCep() {
		return cep;
	}

	/**
	 * Altera o CEP de uma rua. O CEP deve possuir nove caracteres, e o caractére na poisição 5 deve ser um hífen (-).
	 * 
	 * @param cep o novo cep. Se estiver formatado de forma inválida, lança IllegalArgumentException.
	 */
	public void setCep(String cep) {
		if(cep.length() == 9 && cep.charAt(5) == '-')
			this.cep = cep;
		else
			throw new IllegalArgumentException("CEP: " + cep + " malformado.");
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	/**
	 * Altera o número de rua do endereço.
	 * 
	 * @param houseNumber o novo número de rua. Se estiver vazio, lança IllegalArgumentException.
	 */
	public void setHouseNumber(String houseNumber) {
		if(street.trim().length() > 0)
			this.houseNumber = houseNumber;
		else
			throw new IllegalArgumentException("Número de rua vazio.");
	}
        
		/**
		 * Retorna todos os elementos do endereço em uma string. Formato:
		 * 
		 * Rua (street) n(houseNumber). CEP:(cep)
		 */
        public String toString(){
            return "Rua " + street + " n" + houseNumber + ". CEP:" + cep;
        }
	

}