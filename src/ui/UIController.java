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


/**
 * Controlador do menu principal (� esquerda da janela do aplicativo).
 *
 */
public class UIController implements Initializable {

	@FXML
	private Pane LoadPane;

	
	@FXML
	private void handleButtonAction() throws IOException {
		Pane newPane =  FXMLLoader.load(getClass().getResource("/cliente/view/Cliente.fxml"));
		if(LoadPane.getChildren().size() > 0) LoadPane.getChildren().remove(0);
		LoadPane.getChildren().add(newPane);
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	public void handleCadastrarVeiculo() throws IOException{
		Pane newPane =  FXMLLoader.load(getClass().getResource("/veiculo/view/Cadastrar.fxml"));
		if(LoadPane.getChildren().size() > 0) LoadPane.getChildren().remove(0);
		LoadPane.getChildren().add(newPane);
	}

	public void handleConsultaCliente() throws IOException{
		Pane newPane =  FXMLLoader.load(getClass().getResource("/cliente/view/Consulta.fxml"));
		if(LoadPane.getChildren().size() > 0) LoadPane.getChildren().remove(0);
		LoadPane.getChildren().add(newPane);
	}
	
	public void handleAluguelVeiculo() throws IOException{
		Pane newPane =  FXMLLoader.load(getClass().getResource("/aluguel/view/Reserva.fxml"));
		if(LoadPane.getChildren().size() > 0) LoadPane.getChildren().remove(0);
		LoadPane.getChildren().add(newPane);
	}

	public void handleBuscaVeiculo() throws IOException {
		Pane newPane = FXMLLoader.load(getClass().getResource("/veiculo/view/Consulta.fxml"));
		if(LoadPane.getChildren().size()>0) LoadPane.getChildren().remove(0);
		LoadPane.getChildren().add(newPane);

	}

	public void handleDevolucaoVeiculo() throws IOException{
		Pane newPane = FXMLLoader.load(getClass().getResource("/aluguel/view/Devolucao.fxml"));
		if(LoadPane.getChildren().size()>0) LoadPane.getChildren().remove(0);
		LoadPane.getChildren().add(newPane);
	}
	
	public void handleVendaDeCarros() throws IOException{
		Pane newPane = FXMLLoader.load(getClass().getResource("/financeiro/view/Venda.fxml"));
		if(LoadPane.getChildren().size()>0) LoadPane.getChildren().remove(0);
		LoadPane.getChildren().add(newPane);
	}


}