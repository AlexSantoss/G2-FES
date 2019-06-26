package veiculo;

import bd.MySQL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ResultadoBuscaController implements Initializable {

    @FXML
    TableColumn<VeiculoModel, String> columnModelo;
    @FXML
    TableColumn<VeiculoModel, String> columnGrupo;
    @FXML
    TableColumn<VeiculoModel, String> columnFilial;
    @FXML
    TableColumn<VeiculoModel, String> columnPlaca;
    @FXML
    TableView<VeiculoModel> Tabela;

    ObservableList<VeiculoModel> ol = FXCollections.observableArrayList();

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
                ol.add(new VeiculoModel(
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
