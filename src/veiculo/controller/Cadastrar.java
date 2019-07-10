package veiculo.controller;

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
import veiculo.model.Veiculo;

/**
 * Controlador da tela de cadastro de novos veículos.
 *
 */
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

    public void handleCadastraVeiculo(ActionEvent actionEvent) {
        Veiculo v = new Veiculo(modelo.getText(), placa.getText(), filial.getText(), grupo.getText());
        new MySQL().insert(v);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    
}
