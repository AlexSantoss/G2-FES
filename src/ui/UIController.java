package ui;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import cliente.*;


public class UIController implements Initializable {

	@FXML
	private Pane LoadPane;

	
	@FXML
	private void handleButtonAction() throws IOException {
		Pane newPane =  FXMLLoader.load(getClass().getResource("/cliente/Cliente.fxml"));
		if(LoadPane.getChildren().size() > 0) LoadPane.getChildren().remove(0);
		LoadPane.getChildren().add(newPane);
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	public void handleCadastrarVeiculo() throws IOException{
		Pane newPane =  FXMLLoader.load(getClass().getResource("/veiculo/Cadastrar.fxml"));
		if(LoadPane.getChildren().size() > 0) LoadPane.getChildren().remove(0);
		LoadPane.getChildren().add(newPane);
	}
}
