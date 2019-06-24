package veiculo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Enumeration;
import java.util.ResourceBundle;

public class VeiculoController {

    @FXML
    private TextField campoModelo;

    @FXML
    private void resultadoBusca(ActionEvent e) throws IOException {
        System.out.println("foi chamado");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/veiculo/ResultadoBusca.fxml"));
        //OBS : não faço ideia do que seja isso
        ResourceBundle rb = new ResourceBundle() {
            @Override
            protected Object handleGetObject(String key) {
                return campoModelo.getText();
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
}
