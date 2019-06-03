package veiculo;

import auxiliar.Address;

import java.sql.Date;
import java.util.Calendar;

public class Veiculo {
    private String placa;
    private String filial;
    private String modelo;
    private String grupo;
    private String ultManutencao;
    private int kmRodados;

    public Veiculo(String modelo, String placa, String filial, String grupo){
        this.modelo = modelo;
        this.placa = placa;
        this.filial = filial;
        this.grupo = grupo;

        this.kmRodados = 0;
        this.ultManutencao = "2019-06-03";
    }

    public String insert(){
        return "("
            + "\'"  + placa + "\'"
            + ",\'" + filial + "\'"
            + ",\'" + modelo + "\'"
            + ",\'" + grupo + "\'"
            + ",\'" + kmRodados + "\'"
            + ",\'" + ultManutencao + "\'"
            + ")";
    }
}
