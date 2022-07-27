package controle;

import entidade.Solo;
import interfaces.JanelaSoloInserirRemover;
import java.io.IOException;
import persistencia.BD;

public class ControladorCadastroSolo {

    public ControladorCadastroSolo() {
        new JanelaSoloInserirRemover(this).setVisible(true);
    }
    public static Solo selectSolo(String name) throws IOException{
        String commandSQL = BD.createStatement(0);
        String[] result = BD.queryStatement(commandSQL,name);
        if(result[2] == null){
            return null;
        }
        boolean campeao = false;
        boolean principal = false;
        if(result[2].equals("true")){
            campeao = true;
        }
        if(result[3].equals("true")){
            principal = true;
        }
        return new Solo(name,result[0],Integer.parseInt(result[1]),campeao,principal);
    }
    //TODO:
    /*public String inserirSolo(Solo solo){
        
        Solo solo1 = Solo.buscarSolo(solo.getNome());
    }*/

}
