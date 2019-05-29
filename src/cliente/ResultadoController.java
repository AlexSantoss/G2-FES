package cliente;

import bd.MySQL;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ResultadoController implements Initializable {
    @FXML
    TableColumn<ClienteModel, String> columnName;
    @FXML
    TableColumn<ClienteModel, String> columnCPF;
    @FXML
    TableColumn<ClienteModel, String> columnRua;
    @FXML
    TableColumn<ClienteModel, String> columnNum;
    @FXML
    TableColumn<ClienteModel, String> columnCEP;
    @FXML
    TableView<ClienteModel> Tabela;

    ObservableList<ClienteModel> ol = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        columnName.setCellValueFactory(new PropertyValueFactory<>("nome"));
        columnCPF.setCellValueFactory(new PropertyValueFactory<>("CPF"));
        columnRua.setCellValueFactory(new PropertyValueFactory<>("rua"));
        columnNum.setCellValueFactory(new PropertyValueFactory<>("num"));
        columnCEP.setCellValueFactory(new PropertyValueFactory<>("CEP"));
        Tabela.setItems(ol);

        busca(resourceBundle.getString("nome").toString());

    }

    private void busca(String nome){
        MySQL a = new MySQL();
        Connection con = a.getConexaoMySQL();

        String query = "select * from cliente where nome like \"%" + nome + "%\"";
        System.out.println(query);
        try {
            ResultSet rs = con.prepareStatement(query).executeQuery();
            while(rs.next()){
                ol.add(new ClienteModel(
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("rua"),
                        rs.getString("num"),
                        rs.getString("cep")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        a.FecharConexao();
    }
}
