package entidade;

import controle.ControladorCadastroSolo;
import java.io.IOException;

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
    //pesquisar por nome : SELECT * FROM wrestlers.solo WHERE Nome LIKE 'John%'
    
    public static Solo findSolo(String name) throws IOException{
        Solo solo = null;
        solo = ControladorCadastroSolo.selectSolo(name);
        return solo;
    }
    public static String removerSolo(String name) throws IOException{
        return ControladorCadastroSolo.deleteSolo(name);
    }
    public static String insertSolo(Solo solo) throws IOException {
        return ControladorCadastroSolo.insertSolo(solo);
        
    }
    public static Solo updateSolo(Solo solo) throws IOException{
        String name = ControladorCadastroSolo.updateSolo(solo);
        return findSolo(name);
    }

    public String getNome() {
         return nome;
    }

    public String getSexo() {
        return sexo;
    }

    public boolean isPrincipal() {
        return principal;
    }

    public boolean isCampeao() {
        return campeao;
    }
    public int getPontos(){
        return pontos;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setSexo(String sexo){
        this.sexo = sexo;
    }
    public void setPrincipal(boolean principal){
        this.principal = principal;
    }
    public void setCampeao(boolean campeao){
        this.campeao = campeao;
    }
    public void setPontos(int pontos){
        this.pontos = pontos;
    }
    
}
