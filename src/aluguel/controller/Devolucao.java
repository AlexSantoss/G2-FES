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
 * Controla a tela de devolu��o de ve�culos que j� est�o alugados.
 *
 */
public class Devolucao implements Initializable {

    public TextField cpf;
    public TextField placa;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     * Esse m�todo � executado quando o bot�o para devolver o carro � pressionado.
     */
    public void devolver(){
        try{
            MySQL a = new MySQL();
            Connection con = a.getConexaoMySQL();

            // S� haver� um aluguel que ainda n�o foi encerrado (retorno � nulo) relacionado ao carro em quest�o.
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
