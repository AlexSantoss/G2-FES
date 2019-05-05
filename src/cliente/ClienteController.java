package cliente;

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


public class ClienteController implements Initializable {

    @FXML
    private TextField nameField;
    @FXML
    private TextField ruaField;
    @FXML
    private TextField cepField;
    @FXML
    private TextField numberField;
    @FXML
    private TextField cpfField;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        Address address = null;
        CPF cpf = null;
        try{
            address = new Address(ruaField.getText(), cepField.getText(),numberField.getText());
            cpf = new CPF(cpfField.getText());
        }catch(Exception e){
            System.out.println(e);
        }finally{
            Cliente c = new Cliente(nameField.getText(), address, cpf);
            MySQL a = new MySQL();
            Connection con = a.getConexaoMySQL();

            String query = "insert into cliente values " + c.insert();
            try {
                con.prepareStatement(query).execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            a.FecharConexao();
            System.out.println(a.statusConection());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
