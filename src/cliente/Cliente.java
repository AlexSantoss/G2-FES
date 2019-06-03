package cliente;

import auxiliar.CPF;

public class Cliente {
    private String name;
    private CPF cpf;
    private String nascimento;
    private String emissaoCNH;


    Cliente(String name, CPF cpf, String nascimento, String emissaoCNH){
        setName(name);
        setCPF(cpf);
        setNascimento(nascimento);
        setEmissaoCNH(emissaoCNH);
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getEmissaoCNH() {
        return emissaoCNH;
    }

    public void setEmissaoCNH(String emissaoCNH) {
        this.emissaoCNH = emissaoCNH;
    }

    public CPF getCPF(){
        return cpf;
    }

    public void setCPF(CPF cpf){
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return "Nome: " + name
                + " CPF: " + cpf;
    }

    public String insert(){
        return "("
                + "\'"  + cpf + "\'"
                + ",\'" + name + "\'"
                + ",\'" + nascimento + "\'"
                + ",\'" + emissaoCNH + "\'"
                + ")";
    }
}