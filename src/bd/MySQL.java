package bd;

import veiculo.Veiculo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Essa classe È usada para realizar operaÁıes com o banco de dados.
 * 
 * @author Alex
 *
 */
public class MySQL {

    public static String status = "N√£o conectou...";

    public MySQL() {}

    /**
     * Esse mÈtodo cria uma conex„o local com o banco de dados usando MySql.
     * 
     * @return objeto Connection (uma conex„o com o banco de dados).
     */
    public Connection getConexaoMySQL() {

        Connection connection = null;
        try {
            String serverName = "localhost";

            String mydatabase ="g2fes";        //nome do seu banco de dados

            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

            String username = "alex";        //nome de um usu√°rio de seu BD
            String password = "alex";      //sua senha de acesso

            connection = DriverManager.getConnection(url, username, password);

            if (connection != null) {
                status = ("STATUS--->Conectado com sucesso!");
            } else {
                status = ("STATUS--->N√£o foi possivel realizar conex√£o");
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
