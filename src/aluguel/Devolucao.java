package aluguel;

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

public class Devolucao implements Initializable {

    public TextField cpf;
    public TextField placa;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void devolver(){
        try{
            MySQL a = new MySQL();
            Connection con = a.getConexaoMySQL();

            String insert = "update Aluguel set retorno = ? where placa = ? and cpf = ?";

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
