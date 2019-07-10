package veiculo.controller;

import bd.MySQL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import veiculo.model.VeiculoTableEntry;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Controlador da tela de resultados da busca por veículos.
 *
 */
public class ResultadoBuscaController implements Initializable {

    @FXML
    TableColumn<VeiculoTableEntry, String> columnModelo;
    @FXML
    TableColumn<VeiculoTableEntry, String> columnGrupo;
    @FXML
    TableColumn<VeiculoTableEntry, String> columnFilial;
    @FXML
    TableColumn<VeiculoTableEntry, String> columnPlaca;
    @FXML
    TableView<VeiculoTableEntry> Tabela;

    ObservableList<VeiculoTableEntry> ol = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        columnModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        columnGrupo.setCellValueFactory(new PropertyValueFactory<>("grupo"));
        columnFilial.setCellValueFactory(new PropertyValueFactory<>("filial"));
        columnPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
        Tabela.setItems(ol);

        busca(resourceBundle.getString("modelo"));
    }

    private void busca(String nome){
        MySQL a = new MySQL();
        Connection con = a.getConexaoMySQL();

        String query = "select * from Veiculo where modelo like \"%" + nome + "%\"";
        System.out.println(query);
        try {
            ResultSet rs = con.prepareStatement(query).executeQuery();
            while(rs.next()){
                ol.add(new VeiculoTableEntry(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(6)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        a.FecharConexao();
    }
}
