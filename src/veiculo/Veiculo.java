package veiculo;

import auxiliar.Address;

import java.sql.Date;

//create table if not exists veiculo(
//        modelo varchar(255) not null,
//        classe char not null,
//        disponiveis int not null,
//        filialOrigem varchar(255),
//
//        alugado boolean,
//        inicioA date,
//        fimA date,
//
//        manutencao boolean,
//        inicioM date,
//        fimM date,
//        primary key (modelo)
//        );
public class Veiculo {
    String modelo;
    String classe;
    Address filialOrigem;

    boolean alugado;
    Date inicioA;
    Date fimA;

    boolean manutencao;
    Date inicioM;
    Date fimM;

    public Veiculo(String modelo, String classe, int disp, Address origem){
        this.modelo = modelo;
        this.classe = classe;
        this.filialOrigem = origem;

        this.alugado = false;
        this.manutencao = false;
    }

    public boolean isManutencao(){
        return manutencao;
    }

    public void setManutencao(boolean man, Date inicio, Date fim){
        this.inicioM = inicio;
        this.fimM = fim;
        manutencao = man;
    }

    public boolean alugar(boolean alug, Date inicio, Date fim){
        if(!alugado){
            this.inicioA = inicio;
            this.fimA = fim;
            alugado = alug;
            return true;
        }
        alugado = alug;
        return false;
    }
}
