package Auxiliar;

public class CPF {
	private String cpf;
	
	CPF(String cpf) throws Exception{
		setCPF(cpf);
	}
	
	public void setCPF(String cpf) throws Exception{
		if(cpf.charAt(3) == '.' && cpf.charAt(7) == '.' && cpf.charAt(11) == '-') {
			int soma=0;
			for(int idx=0, aux=10; idx < 11; idx++, aux--) {
				if(idx != 3 && idx != 7) soma += Integer.valueOf(cpf.charAt(idx)) * aux;
				else aux = aux+1;
			}
			int resto1 = (soma*10)%11;
			if(resto1 == 10) resto1 = 0;
			
			soma=0;
			for(int idx=0, aux=11; idx < 11; idx++, aux--) {
				if(idx != 3 && idx != 7) soma += Integer.valueOf(cpf.charAt(idx)) * aux;
				else aux = aux+1;
			}
			int resto2 = (soma*10)%11;
			if(resto2 == 10) resto2 = 0;
			
			
			if(resto1 == cpf.charAt(12) && resto2 == cpf.charAt(13)) this.cpf = cpf;
			else throw new Exception("CPF invalido");
		}
		else 
			throw new Exception("CPF malformado");
		
	}
	
	public String getCPF() {
		return this.cpf;
	}
}
