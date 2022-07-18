package controle;

import entidade.Solo;
import interfaces.JanelaSoloInserirRemover;

public class ControladorCadastroSolo {

    public ControladorCadastroSolo() {
        new JanelaSoloInserirRemover(this).setVisible(true);
    }
    //TODO:
    /*public String inserirSolo(Solo solo){
        
        Solo solo1 = Solo.buscarSolo(solo.getNome());
    }*/

}
