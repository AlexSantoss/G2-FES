package cliente.controller;

import auxiliar.Address;
import auxiliar.CPF;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.ResourceBundle;

import bd.MySQL;
import cliente.model.Cliente;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 * Controlador do cadastro de novos clientes e da busca de clientes na base de dados.
 * 
 * @author Alex
 *
 */
public class ClienteController implements Initializable {

    @FXML
    private TextField campoNome;
    @FXML
    private TextField campoCPF;
    @FXML
    private TextField campoNascimento;
    @FXML
    private TextField campoEmissaoCNH;

    /**
     * M�todo chamado ao clicar o bot�o de cadastrar um novo cliente.
     */
    @FXML
    private void handleButtonAction(ActionEvent event) {
        CPF cpf = null;
        try{
            cpf = new CPF(campoCPF.getText());
            Cliente c = new Cliente(campoNome.getText(), cpf, campoNascimento.getText(), campoEmissaoCNH.getText());
            MySQL a = new MySQL();
            Connection con = a.getConexaoMySQL();

            String query = "insert into Cliente values " + c.insert();
            con.prepareStatement(query).execute();

            a.FecharConexao();
        }catch(Exception e){
            System.out.println(e);
        }

    }
    /**
     * M�todo chamado ao clicar no bot�o para buscar um cliente j� existente.
     */
    @FXML
    private void retornaBusca(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cliente/view/ResultadoBusca.fxml"));
        ResourceBundle rb = new ResourceBundle() {
            @Override
            protected Object handleGetObject(String key) {
                return campoNome.getText();
            }

            @Override
            public Enumeration<String> getKeys() {
                return null;
            }
        };
        fxmlLoader.setResources(rb);
        Parent root1 = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	
    	// Adicionar listner que updata automaticamente o campo do CPF, para evitar que o usu�rio precise digitar pontos ou h�fens.
        campoCPF.textProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.length() > 14){
                campoCPF.setText(oldValue);
            } else if(newValue.length() > oldValue.length()){
                if(newValue.length() == 3 || newValue.length() == 7 ) campoCPF.setText(newValue + '.');
                else if(newValue.length() == 11) campoCPF.setText(newValue + '-');
            } else if (newValue.length() < oldValue.length()){
                if(oldValue.charAt(oldValue.length()-1) == '.' || oldValue.charAt(oldValue.length()-1) == '-') campoCPF.setText(newValue.substring(0, newValue.length()-1));
            }
            System.out.println("textfield changed from " + oldValue + " to " + newValue);
        });
    }
    
    

}
