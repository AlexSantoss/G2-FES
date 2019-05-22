/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auxiliar;

/**
 * Essa classe representa um CPF na forma de string. É uma classe imutável.
 * 
 * @author Alex
 *
 */
public class CPF{
	private String cpf;

	/**
	 * Construtor que recebe CPF na forma de uma string. O CPF deve estar formatado na forma xxx.yyy.zzz-ww. Além disso, o CPF deve ser válido, seguindo os algoritimos que validam um CPF.
	 * 
	 * @param cpf CPF na forma de uma String. Se estiver malformado ou inválido, lança IllegalArgumentException.
	 */
	public CPF(String cpf){
		setCPF(cpf);
	}

	/**
	 * Seta o valor do CPF (usado apenas no construtor). Usa algoritimo para checar se o CPF é válido.
	 * 
	 * @param cpf
	 */
	private void setCPF(String cpf){
		if(cpf.length() == 14 && cpf.charAt(3) == '.' && cpf.charAt(7) == '.' && cpf.charAt(11) == '-') {
			this.cpf = cpf;

			int soma=0;
			for(int idx=0, aux=10; idx < 11; idx++, aux--) {
				if(idx != 3 && idx != 7) 
					soma += Character.getNumericValue(cpf.charAt(idx)) * aux;
				else 
					aux = aux+1;
			}
			
			int resto1 = (soma*10)%11;
			if(resto1 == 10)
				resto1 = 0;

			soma=0;
			for(int idx=0, aux=11; idx < 13; idx++, aux--) {
				if(idx != 3 && idx != 7 && idx != 11) 
					soma += Character.getNumericValue(cpf.charAt(idx)) * aux;
				else 
					aux = aux+1;
			}
			
			int resto2 = (soma*10)%11;
			if(resto2 == 10) 
				resto2 = 0;

			if(resto1 == Character.getNumericValue(cpf.charAt(12)) && resto2 == Character.getNumericValue(cpf.charAt(13))) 
				this.cpf = cpf;
			else 
				throw new IllegalArgumentException("CPF inválido.");
		}
		else
			throw new IllegalArgumentException("CPF malformado.");
	}
	
	/**
	 * Retorna uma String contendo o CPF. Essa string é idêntica à string passada no construtor do CPF.
	 * 
	 */
	public String toString(){
		return this.cpf;
	}
}