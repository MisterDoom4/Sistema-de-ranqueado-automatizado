package entidade;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import persistencia.BD;

public class Solo {
    private String nome;
    private String sexo;
    private int pontos;
    private boolean campeao;
    private boolean principal;
    private Dupla dupla;
    
    public Solo(String nome, String sexo,int pontos,boolean campeao, boolean principal){
        this.nome = nome;
        this.sexo = sexo;
        this.pontos = pontos;
        this.campeao = campeao;
        this.principal = principal;
    }
    
    public static Solo buscarSolo(String nome) throws IOException{
        Solo solo = null;
        String commandSQL = BD.createStatement(nome, 0);
        ResultSet result_list = BD.queryStatement(commandSQL);
        try{
            while (result_list.next()){
                solo = new Solo (nome,
                                result_list.getString("Sexo"),
                                result_list.getInt("Pontos"),
                                result_list.getBoolean("Campeao"),
                                result_list.getBoolean("Principal"));
            }
        }catch (SQLException e){
             if(BD.createLogs()){
               BD.writeLogs(e.getMessage());
            }
        }
        return solo;
    }
    //TODO:
    //public static void inserirCliente(Solo solo) {
        
        
    //}

    private String getNome() {
         return nome;
    }

    private String getSexo() {
        return sexo;
    }

    private boolean isPrincipal() {
        return principal;
    }

    private boolean isCampeao() {
        return campeao;
    }
    private void setNome(String nome){
        this.nome = nome;
    }
    private void setSexo(String sexo){
        this.sexo = sexo;
    }
    private void setPrincipal(boolean principal){
        this.principal = principal;
    }
    private void setCampeao(boolean campeao){
        this.campeao = campeao;
    }
    private void setPontos(int pontos){
        this.pontos = pontos;
    }
}
