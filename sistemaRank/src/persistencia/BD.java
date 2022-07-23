
package persistencia;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class BD {

    static final String URL_SERVER = "jdbc:mysql://localhost:3306/";
    static final String USER = "root";
    static final String PASSWORD = "1234";
    private static Connection connection = null;
    private static Statement comand = null;
    private static String sql;
    private static final String SQLFILE = "database.txt";
    private static final String SQLCOMMANDS = "commandsSQL.txt";
    
    public static void initiateDatabase() throws IOException{
        serverConnection();
        if(hasDB()){
           fechaConexão();
           databaseConnection();
        }
        else{
            createDatabase();
        }
    }
   
    private static void serverConnection() throws IOException {
        try {
            connection = DriverManager.getConnection(URL_SERVER, USER, PASSWORD);
        } catch (SQLException exceção_sql) {
            if(createLogs()){
                writeLogs(exceção_sql.getMessage());
            }
        }
    }
    private static boolean createLogs(){
        String logs = "Logs";
        Path path = Paths.get(logs);
        if(!Files.exists(path)){
            try{
                Files.createDirectory(path);
                logs += "/Erros.txt";
                PrintWriter file = new PrintWriter(logs);
                file.close();
            }catch (IOException error){
                return false;
            }
        }
        else{
            return true;
        }
        return true;
    }
    private static void writeLogs(String error) throws IOException{
        FileWriter file = new FileWriter("Logs/Erros.txt",true);
        file.write(error);
        file.close();
    }
    private static boolean hasDB() throws IOException{
       try{
            ResultSet result_list = connection.getMetaData().getCatalogs();
            while (result_list.next()) {
                String databaseName = result_list.getString(1);
                if(databaseName.equals("wrestlers")){
                    return true;
                }
            }
            result_list.close();
        } catch(Exception e){
            if(createLogs()){
               writeLogs(e.getMessage());
            }
        }
       return false;
   }
    private static void databaseConnection() throws IOException{
        String urlDatabase = URL_SERVER + "wrestlers";
        try {
            connection = DriverManager.getConnection(urlDatabase, USER, PASSWORD);
        } catch (SQLException exceção_sql) {
            if(createLogs()){
               writeLogs(exceção_sql.getMessage());
            }
        }
    }
    public static void fechaConexão() throws IOException {
        try {
            connection.close();
        } catch (SQLException e) {
            if(createLogs()){
               writeLogs(e.getMessage());
            }
        }
    }
    private static void createDatabase() throws IOException{
       try {
            FileReader arq = new FileReader(SQLFILE);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine();
            sql = linha;
            executeStatement(sql); //CREATE SCHEMA
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
            executeStatement(sql); //CREATE TABLE
            linha = lerArq.readLine();
            sql = linha;
            while (linha != null) {
                linha = lerArq.readLine();
                if(linha.trim().length()==0){
                    break;
                }
                sql += linha;
            }
            executeStatement(sql); //CREATE TABLE
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
        } catch (IOException e) {
            if(createLogs()){
                writeLogs(e.getMessage());
            }
        }
   }
    public static String createStatement(String info, int index) throws IOException{
        String linha = null;
        try{
            FileReader arq = new FileReader(SQLCOMMANDS);
            BufferedReader lerArq = new BufferedReader(arq);
            for (int i = 0; i <index ; i++){
                lerArq.readLine();
            }
            linha = lerArq.readLine();
            linha += info;
        } catch(IOException e){
            if(createLogs()){
                writeLogs(e.getMessage());
            }
        }
        return linha;
    }
    public static void executeStatement(String sql) throws IOException{
       try {
           comand = connection.createStatement();
           comand.executeUpdate(sql);
           comand.close();
        } catch (SQLException e){
            if(createLogs()){
                writeLogs(e.getMessage());
            }
        }
   }
    public static ResultSet queryStatement(String sql) throws IOException{
        ResultSet result_list = null;
        try {
           comand = connection.createStatement();
           result_list = comand.executeQuery(sql);
           comand.close();
        } catch (SQLException e){
            if(createLogs()){
                writeLogs(e.getMessage());
            }
        }
        return result_list;
    }
  
}
