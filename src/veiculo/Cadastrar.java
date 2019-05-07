package veiculo;

import auxiliar.Address;
import auxiliar.CPF;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import bd.MySQL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class Cadastrar {


    @FXML
    private TextField classe;
    @FXML
    private TextField disponiveis;
    @FXML
    private TextField modelo;
    @FXML
    private TextField localO;

    public void handleButtonAction(ActionEvent actionEvent) {
        MySQL a = new MySQL();
        Connection con = a.getConexaoMySQL();

        String query = "insert into veiculo (modelo, classe, disponiveis, filialOrigem) values " + "(\'" + modelo.getText() + "\'"
                + ",\'" + classe.getText() + "\'"
                + ",\'" + disponiveis.getText() + "\'"
                + ",\'" + localO.getText() + "\'" + ")";

        System.out.println(query);
        try {
            con.prepareStatement(query).execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        a.FecharConexao();

    }
}
