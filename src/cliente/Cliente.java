package cliente;

import auxiliar.Address;
import auxiliar.CPF;

public class Cliente {
    private String name;
    private Address address;
    private CPF cpf;
    private int id;

    Cliente(String name, Address address, CPF cpf){
        setName(name);
        setAddress(address);
        setCPF(cpf);
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString(){
        return "Nome: " + name
                + " CPF: " + cpf
                + " Endereco: " + address;
    }

    public String insert(){
        return "(\'" + name + "\'"
                + ",\'" + cpf + "\'"
                + ",\'" + address.getStreet() + "\'"
                + ",\'" + address.getCep() + "\'"
                + "," + address.getHouseNumber() + ")"
                ;
    }
}