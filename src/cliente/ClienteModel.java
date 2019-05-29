package cliente;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ClienteModel {
    private SimpleStringProperty nome;
    private SimpleStringProperty CPF;
    private SimpleStringProperty rua;
    private SimpleStringProperty num;
    private SimpleStringProperty CEP;

    public ClienteModel(String nome, String CPF, String rua, String num, String CEP){
        this.nome = new SimpleStringProperty(nome);
        this.CPF = new SimpleStringProperty(CPF);
        this.rua = new SimpleStringProperty(rua);
        this.num = new SimpleStringProperty(num);
        this.CEP = new SimpleStringProperty(CEP);
    }

    public String getNome() {
        return nome.get();
    }

    public SimpleStringProperty nomeProperty() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public String getCPF() {
        return CPF.get();
    }

    public SimpleStringProperty CPFProperty() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF.set(CPF);
    }

    public String getRua() {
        return rua.get();
    }

    public SimpleStringProperty ruaProperty() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua.set(rua);
    }

    public String getNum() {
        return num.get();
    }

    public SimpleStringProperty numProperty() {
        return num;
    }

    public void setNum(String num) {
        this.num.set(num);
    }

    public String getCEP() {
        return CEP.get();
    }

    public SimpleStringProperty CEPProperty() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP.set(CEP);
    }
}


