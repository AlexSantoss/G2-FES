package cliente.controller;

import bd.MySQL;
import cliente.model.Cliente;
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

/**
 * Controlador da tela de resultados da busca por cliente.
 *
 */
public class ResultadoController implements Initializable {
    @FXML
    TableColumn<Cliente, String> columnName;
    @FXML
    TableColumn<Cliente, String> columnCPF;
    @FXML
    TableColumn<Cliente, String> columnNascimento;
    @FXML
    TableColumn<Cliente, String> columnEmissaoCNH;
    @FXML
    TableView<Cliente> Tabela;

    ObservableList<Cliente> ol = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        columnName.setCellValueFactory(new PropertyValueFactory<>("nomeProperty"));
        columnCPF.setCellValueFactory(new PropertyValueFactory<>("cpfProperty"));
        columnNascimento.setCellValueFactory(new PropertyValueFactory<>("nascimentoProperty"));
        columnEmissaoCNH.setCellValueFactory(new PropertyValueFactory<>("emissaoCNHProperty"));
        Tabela.setItems(ol);

        busca(resourceBundle.getString("nome"));

    }

    private void busca(String nome){
        MySQL a = new MySQL();
        Connection con = a.getConexaoMySQL();

        String query = "select * from Cliente where nome like \"%" + nome + "%\"";
        System.out.println(query);
        try {
            ResultSet rs = con.prepareStatement(query).executeQuery();
            while(rs.next()){
                ol.add(new Cliente(
                        rs.getString(2),
                        rs.getString(1),
                        rs.getString(3),
                        rs.getString(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        a.FecharConexao();
    }
}
