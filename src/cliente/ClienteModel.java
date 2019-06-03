package cliente;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ClienteModel {
    private SimpleStringProperty nome;
    private SimpleStringProperty CPF;
    private SimpleStringProperty nascimento;
    private SimpleStringProperty emissaoCNH;

    public ClienteModel(String nome, String CPF, String nascimento, String emissaoCNH){
        this.nome = new SimpleStringProperty(nome);
        this.CPF = new SimpleStringProperty(CPF);
        this.nascimento = new SimpleStringProperty(nascimento);
        this.emissaoCNH = new SimpleStringProperty(emissaoCNH);
    }

    public String getNome() {
        return nome.get();
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public SimpleStringProperty nomeProperty() {
        return nome;
    }

    public String getCPF() {
        return CPF.get();
    }

    public void setCPF(String CPF) {
        this.CPF.set(CPF);
    }

    public SimpleStringProperty CPFProperty() {
        return CPF;
    }

    public String getNascimento() {
        return nascimento.get();
    }

    public void setNascimento(String nascimento) {
        this.nascimento.set(nascimento);
    }

    public SimpleStringProperty nascimentoProperty() {
        return nascimento;
    }

    public String getEmissaoCNH() {
        return emissaoCNH.get();
    }

    public void setNum(String emissaoCNH) {
        this.emissaoCNH.set(emissaoCNH);
    }

    public SimpleStringProperty emissaoCNHProperty() {
        return emissaoCNH;
    }
}


