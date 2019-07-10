package financeiro;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Enumeration;
import java.util.ResourceBundle;

import bd.MySQL;

public class VendaController {
    @FXML
    private TextField cnpj;
    @FXML
    private TextField placa;
    @FXML
    private DatePicker dataVenda;

    @FXML
    private void vender() throws IOException {
        System.out.println("foi chamado");
        new MySQL().delete(placa.getText());
    }
}