package aluguel.controller;

import bd.MySQL;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ResourceBundle;

/**
 * Controla a tela de devolução de veículos que já estão alugados.
 *
 */
public class Devolucao implements Initializable {

    public TextField cpf;
    public TextField placa;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     * Esse método é executado quando o botão para devolver o carro é pressionado.
     */
    public void devolver(){
        try{
            MySQL a = new MySQL();
            Connection con = a.getConexaoMySQL();

            // Só haverá um aluguel que ainda não foi encerrado (retorno é nulo) relacionado ao carro em questão.
            String insert = "update Aluguel set retorno = ? where retorno is null and placa = ?";

            System.out.println(placa.getText());

            PreparedStatement q = con.prepareStatement(insert);
            q.setDate(1, Date.valueOf(LocalDate.now()));
            q.setString(2, placa.getText());
            q.setString(3, cpf.getText());

            System.out.println(q.execute());
            a.FecharConexao();
        }catch(Exception e){
            System.out.println(e);
        }

    }
}
