
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BD {

    static final String URL_BD = "jdbc:mysql://localhost/wrestlers";
    static final String USUÁRIO = "root";
    static final String SENHA = null;
    public static Connection conexão = null;

    public static void criaConexão() {
        try {
            conexão = DriverManager.getConnection(URL_BD, USUÁRIO, SENHA);
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
    }

    public static void fechaConexão() {
        try {
            conexão.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
    }
}
