
package persistencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class BD {

    static final String URL_SERVER = "jdbc:mysql://localhost:3306/";
    static final String URL_DATABASE = "jdbc:mysql://localhost:3306/wrestlers";
    static final String USER = "root";
    static final String PASSWORD = null;
    public static Connection conexão = null;
    private static Statement comando = null;
    private static String sql;
    private static final String SQLFILE = "database.txt";
    public static final String SQLCOMMANDS = "commandsSQL.txt";
    
    public static void initiateDatabase(){
        serverConnection();
        if(bancodedadosExiste()){
           fechaConexão();
           databaseConnection();
        }
        else{
            createDatabase();
        }
    }
    public static void serverConnection() {
        try {
            conexão = DriverManager.getConnection(URL_SERVER, USER, PASSWORD);
        } catch (SQLException exceção_sql) {
        }
    }
    public static void databaseConnection(){
        try {
            conexão = DriverManager.getConnection(URL_DATABASE, USER, PASSWORD);
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
    
   public static void createDatabase(){
       try {
            FileReader arq = new FileReader(SQLFILE);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine();
            sql = linha;
            updateStatement(sql); //CREATE SCHEMA
            fechaConexão();
            databaseConnection();
            linha = lerArq.readLine();
            sql = linha;
            while (linha != null) {
                linha = lerArq.readLine();
                if(linha.trim().length()==0){
                    break;
                }
                sql += linha;
            }
            updateStatement(sql); //CREATE TABLE
            linha = lerArq.readLine();
            sql = linha;
            while (linha != null) {
                linha = lerArq.readLine();
                if(linha.trim().length()==0){
                    break;
                }
                sql += linha;
            }
            updateStatement(sql); //CREATE TABLE
            linha = lerArq.readLine();
            sql = linha;
            while (linha != null) {
                linha = lerArq.readLine();
                if(linha.trim().length()==0){
                    break;
                }
                sql += linha;
            }
            executeStatement(sql); // ALTER TABLE
            arq.close();
        } catch (IOException error) {
                System.err.printf("Erro na abertura do arquivo: %s.\n",
                error.getMessage());
            }
   }
   private static void updateStatement(String sql){
       try {
           comando = conexão.createStatement();
           comando.executeUpdate(sql);
           comando.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
   }
   private static void executeStatement(String sql){
       try {
           comando = conexão.createStatement();
           comando.execute(sql);
           comando.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
   }
   private static boolean bancodedadosExiste(){
       try{
            ResultSet lista_resultados = conexão.getMetaData().getCatalogs();
            while (lista_resultados.next()) {
                String databaseName = lista_resultados.getString(1);
                if(databaseName.equals("wrestlers")){
                    return true;
                }
            }
            lista_resultados.close();
        } catch(Exception e){
            e.printStackTrace();
        }
       return false;
   }
}
