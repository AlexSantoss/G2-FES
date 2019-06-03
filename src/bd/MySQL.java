package bd;

import veiculo.Veiculo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {

    public static String status = "Não conectou...";

    public MySQL() {}

    public Connection getConexaoMySQL() {

        Connection connection = null;
        try {
            String serverName = "localhost";

            String mydatabase ="g2fes";        //nome do seu banco de dados

            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

            String username = "alex";        //nome de um usuário de seu BD
            String password = "alex";      //sua senha de acesso

            connection = DriverManager.getConnection(url, username, password);

            if (connection != null) {
                status = ("STATUS--->Conectado com sucesso!");
            } else {
                status = ("STATUS--->Não foi possivel realizar conexão");
            }
            return connection;
        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
            return null;
        }
    }

    public void insert(Veiculo v){
        String query = "insert into Veiculo values " + v.insert();
        Connection con = getConexaoMySQL();
        try {
            con.prepareStatement(query).execute();
            FecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public String statusConection() {
        return status;
    }

    public boolean FecharConexao() {

        try {
            getConexaoMySQL().close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public Connection ReiniciarConexao() {
        FecharConexao();
        return getConexaoMySQL();
    }

}
