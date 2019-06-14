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

public class Cadastrar implements Initializable {

	@FXML
	private TextField cpf;
    @FXML
    private TextField filial;
    @FXML
    private TextField placa;
    @FXML
    private TextField modelo;
    @FXML
    private TextField grupo;

    public void handleButtonAction(ActionEvent actionEvent) {
        Veiculo v = new Veiculo(modelo.getText(), placa.getText(), filial.getText(), grupo.getText());
        new MySQL().insert(v);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cpf.textProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.length() > 14){
                cpf.setText(oldValue);
            } else if(newValue.length() > oldValue.length()){
                if(newValue.length() == 3 || newValue.length() == 7 ) cpf.setText(newValue + '.');
                else if(newValue.length() == 11) cpf.setText(newValue + '-');
            } else if (newValue.length() < oldValue.length()){
                if(oldValue.charAt(oldValue.length()-1) == '.' || oldValue.charAt(oldValue.length()-1) == '-') cpf.setText(newValue.substring(0, newValue.length()-1));
            }
            System.out.println("textfield changed from " + oldValue + " to " + newValue);
        });
    }
    
}
