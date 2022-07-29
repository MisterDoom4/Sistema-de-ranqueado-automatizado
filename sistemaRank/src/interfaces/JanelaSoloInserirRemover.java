
package interfaces;
import controle.ControladorCadastroSolo;
import entidade.Solo;
import java.io.IOException;
public class JanelaSoloInserirRemover extends javax.swing.JFrame {

    ControladorCadastroSolo controlador;
    public JanelaSoloInserirRemover(ControladorCadastroSolo controlador) {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        sexField = new javax.swing.JTextField();
        championCheck = new javax.swing.JCheckBox();
        principalCheck = new javax.swing.JCheckBox();
        pointsField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inserir/Remover");
        setAlwaysOnTop(true);
        setType(java.awt.Window.Type.POPUP);

        nameField.setMinimumSize(new java.awt.Dimension(200, 220));

        jButton1.setText("Pesquisar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("jLabel1");

        sexField.setMinimumSize(new java.awt.Dimension(200, 220));

        championCheck.setText("Campeão");

        principalCheck.setText("Rank principal");

        pointsField.setMinimumSize(new java.awt.Dimension(200, 220));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(championCheck)
                    .addComponent(sexField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addComponent(principalCheck)
                    .addComponent(pointsField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sexField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pointsField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(principalCheck)
                .addGap(2, 2, 2)
                .addComponent(championCheck)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//teste
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        
        try {
            jLabel1.setText(getSoloSearch());
            /*Solo solo = null;
            try {
            solo = getSoloSearch();
            } catch (IOException ex) {
            }
            if(solo != null){
            jLabel1.setText(solo.getNome());
            }
            else{
            jLabel1.setText("Não encontrado");
            }*/
        } catch (IOException ex) {
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox championCheck;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField pointsField;
    private javax.swing.JCheckBox principalCheck;
    private javax.swing.JTextField sexField;
    // End of variables declaration//GEN-END:variables
//teste
    private String getSoloSearch() throws IOException {
        String name = nameField.getText();
        String sexo = sexField.getText();
        int points = Integer.parseInt(pointsField.getText());
        boolean principal = principalCheck.isSelected();
        boolean campeao = championCheck.isSelected();
        return ""+ Solo.updateSolo(new Solo(name,sexo,points,principal,campeao)).getPontos();
    }
}
