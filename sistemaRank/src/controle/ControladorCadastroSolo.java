package controle;

import interfaces.JanelaSoloInserirRemover;

public class ControladorCadastroSolo {

    public ControladorCadastroSolo() {
        new JanelaSoloInserirRemover(this).setVisible(true);
    }

}
