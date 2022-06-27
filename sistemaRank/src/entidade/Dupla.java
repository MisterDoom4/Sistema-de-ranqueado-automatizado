
package entidade;


class Dupla {

    private String nome;
    private Solo solo1;
    private Solo solo2;
    private int pontos;
    private boolean campeao;
    
    public Dupla(String nome, Solo solo1, Solo solo2, int pontos, boolean campeao){
        this.nome = nome;
        this.solo1 = solo1;
        this.solo2 = solo2;
        this.pontos = pontos;
        this.campeao = campeao;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Solo getSolo1() {
        return solo1;
    }
    public void setSolo1(Solo solo1) {
        this.solo1 = solo1;
    }
    public Solo getSolo2() {
        return solo2;
    }
    public void setSolo2(Solo solo2) {
        this.solo2 = solo2;
    }
    public int getPontos() {
        return pontos;
    }
    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
    public boolean isCampeao() {
        return campeao;
    }
    public void setCampeao(boolean campeao) {
        this.campeao = campeao;
    }
}
