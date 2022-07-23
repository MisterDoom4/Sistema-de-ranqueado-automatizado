package entidade;

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
    // TODO: 
    /*public static Solo buscarSolo(String nome){
        String 
        ResultSet result_list = BD.queryStatement(nome);
    }*/
    //public static void inserirCliente(Solo solo) {
        
        /*String sql = "INSERT INTO solo (Nome, Sexo, Principal,Campeao)"
                + " VALUES (?,?,?,?)";
        try {
            PreparedStatement comando = BD.connection.prepareStatement(sql);
            comando.setString(1, solo.getNome());
            comando.setString(2, solo.getSexo());
            comando.setBoolean(3, solo.isPrincipal());
            comando.setBoolean(4, solo.isCampeao());
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return "Erro na Inserção do Cliente no BD";
        }*/
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
