package auxiliar;

/**
 * Essa classe representa um endere�o usando strings.
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
	 * Altera a rua de um endere�o.
	 * 
	 * @param street a nova rua. Se for string vazia, lan�a IllegalArgumentException.
	 */
	public void setStreet(String street) {
		if(street.trim().length() > 0)
			this.street = street.trim();
		else
			throw new IllegalArgumentException("Endere�o vazio.");
	}

	public String getCep() {
		return cep;
	}

	/**
	 * Altera o CEP de uma rua. O CEP deve possuir nove caracteres, e o caract�re na poisi��o 5 deve ser um h�fen (-).
	 * 
	 * @param cep o novo cep. Se estiver formatado de forma inv�lida, lan�a IllegalArgumentException.
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
	 * Altera o n�mero de rua do endere�o.
	 * 
	 * @param houseNumber o novo n�mero de rua. Se estiver vazio, lan�a IllegalArgumentException.
	 */
	public void setHouseNumber(String houseNumber) {
		if(street.trim().length() > 0)
			this.houseNumber = houseNumber;
		else
			throw new IllegalArgumentException("N�mero de rua vazio.");
	}
        
		/**
		 * Retorna todos os elementos do endere�o em uma string. Formato:
		 * 
		 * Rua (street) n(houseNumber). CEP:(cep)
		 */
        public String toString(){
            return "Rua " + street + " n" + houseNumber + ". CEP:" + cep;
        }
	

}