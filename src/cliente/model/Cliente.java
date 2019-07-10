package cliente.model;

import auxiliar.CPF;
import javafx.beans.property.SimpleStringProperty;

public class Cliente {

    private SimpleStringProperty nomeProperty;
    private SimpleStringProperty cpfProperty;
    private SimpleStringProperty nascimentoProperty;
    private SimpleStringProperty emissaoCNHProperty;

    public String getNomeProperty() {
        return nomeProperty.get();
    }

    public SimpleStringProperty nomePropertyProperty() {
        return nomeProperty;
    }

    public void setNomeProperty(String nomeProperty) {
        this.nomeProperty.set(nomeProperty);
    }

    public String getCpfProperty() {
        return cpfProperty.get();
    }

    public SimpleStringProperty cpfPropertyProperty() {
        return cpfProperty;
    }

    public void setCpfProperty(String cpfProperty) {
        this.cpfProperty.set(cpfProperty);
    }

    public String getNascimentoProperty() {
        return nascimentoProperty.get();
    }

    public SimpleStringProperty nascimentoPropertyProperty() {
        return nascimentoProperty;
    }

    public void setNascimentoProperty(String nascimentoProperty) {
        this.nascimentoProperty.set(nascimentoProperty);
    }

    public String getEmissaoCNHProperty() {
        return emissaoCNHProperty.get();
    }

    public SimpleStringProperty emissaoCNHPropertyProperty() {
        return emissaoCNHProperty;
    }

    public void setEmissaoCNHProperty(String emissaoCNHPRoperty) {
        this.emissaoCNHProperty.set(emissaoCNHPRoperty);
    }

    private String name;
    private CPF cpf;
    private String nascimento;
    private String emissaoCNH;


    public Cliente(String name, CPF cpf, String nascimento, String emissaoCNH){
        setName(name);
        setCPF(cpf);
        setNascimento(nascimento);
        setEmissaoCNH(emissaoCNH);
    }

    public Cliente(String nome, String CPF, String nascimento, String emissaoCNH){
        this.nomeProperty = new SimpleStringProperty(nome);
        this.cpfProperty = new SimpleStringProperty(CPF);
        this.nascimentoProperty = new SimpleStringProperty(nascimento);
        this.emissaoCNHProperty = new SimpleStringProperty(emissaoCNH);
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