package aluguel.controller;

import auxiliar.CPF;
import bd.MySQL;
import cliente.model.Cliente;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

/**
 * Controla a tela de reserva de veículos.
 *
 */
public class ReservaController implements Initializable {


    public DatePicker dataRetorno;
    public TextField cpf;
    public TextField placa;
    public DatePicker dataInicio;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     * Método executado quando o botão para alugar um carro é pressionado.
     */
    public void alugar(){
        if(dataRetorno.getValue().compareTo(dataInicio.getValue()) > 0){
            try{
                MySQL a = new MySQL();
                Connection con = a.getConexaoMySQL();

                // Checar se existe algum aluguel com esse carro que ainda não foi encerrado (retorno é nulo).
                String query = "select * from Aluguel where retorno is null and placa=\'"+placa.getText()+"\'";
                ResultSet al = con.prepareStatement(query).executeQuery();
                if (al.next()){ return; }  // parar execução se tiver ao menos 1 resultado.

                String insert = "insert into Aluguel (cpf, placa, inicio, fim) values (" +
                        "\'" + cpf.getText() + "\'," +
                        "\'" + placa.getText() + "\'," +
                        "\'" + dataInicio.getValue().toString() + "\'," +
                        "\'" + dataRetorno.getValue().toString() + "\'" +
                        ")";
                con.prepareStatement(query).execute(insert);

                a.FecharConexao();
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
}
