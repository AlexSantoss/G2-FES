package veiculo.model;

import javafx.beans.property.SimpleStringProperty;

/**
 * Usada por ResultadoBuscaController para exibir valores na tabela de veículos.
 * 
 * @author Alex
 *
 */
public class VeiculoTableEntry {
    private SimpleStringProperty placa;
    private SimpleStringProperty filial;
    private SimpleStringProperty modelo;
    private SimpleStringProperty grupo;
    private SimpleStringProperty ultManutencao;
    private int kmRodados;


    public VeiculoTableEntry(String placa, String filial, String modelo, String grupo, String ultManutencao){
        this.placa = new SimpleStringProperty(placa);
        this.filial = new SimpleStringProperty(filial);
        this.modelo = new SimpleStringProperty(modelo);
        this.grupo = new SimpleStringProperty(grupo);
        this.ultManutencao = new SimpleStringProperty(ultManutencao);
    }

    public String getPlaca() {
        return placa.get();
    }

    public void setPlaca(String placa) {
        this.placa.set(placa);
    }

    public SimpleStringProperty placaProperty() {
        return placa;
    }

    public String getFilial() {
        return filial.get();
    }

    public void setFilial(String filial) {
        this.filial.set(filial);
    }

    public SimpleStringProperty filialProperty() {
        return filial;
    }

    public String getModelo() {
        return modelo.get();
    }

    public void setModelo(String modelo) {
        this.modelo.set(modelo);
    }

    public SimpleStringProperty modeloProperty() {
        return modelo;
    }

    public String getGrupo() {
        return grupo.get();
    }

    public void setGrupo(String grupo) {
        this.grupo.set(grupo);
    }

    public SimpleStringProperty grupoProperty() {
        return grupo;
    }

    public String getUltManutencao() {
        return ultManutencao.get();
    }

    public void setUltManutencao(String ultManutencao) {
        this.ultManutencao.set(ultManutencao);
    }

    public SimpleStringProperty ultManutencaoProperty() {
        return ultManutencao;
    }
}
