package visao;


import javax.swing.JOptionPane;
import entidades.Categoria;
import persistencia.CategoriaDAO;


/**
 *
 * @author gustavo.hamester
 */
public class TelaCadastroCategoria extends javax.swing.JFrame {

    private Categoria categoria = new Categoria();
    private TelaListaCategoria telaListagem;
    
    public TelaCadastroCategoria(TelaListaCategoria telaListagem) {
        initComponents();
        this.telaListagem = telaListagem;
    }

    public void setCategoria(Categoria categoria){
        this.categoria = categoria;
        txtCategoria.setText(categoria.getNome());
        if (categoria.getTipo() == 'F') {
            rdbFilme.setSelected(true);
        }else if (categoria.getTipo()== 'J'){
            rdbJogo.setSelected(true);
        }
    }
    
    private void inserir(){
        if (CategoriaDAO.inserir(categoria)) {
            JOptionPane.showMessageDialog(this, "Categoria inserida com sucesso!");
            telaListagem.montarListaCategorias();
            dispose();
        }else{
            JOptionPane.showMessageDialog(this, "Erro ao inserir categoria");
        }
    }
    

    /*private void alternar(){
        if (CategoriaDAO.alterar(categoria)) {
            JOptionPane.showMessageDialog(this, "Categoria alterada com sucesso");
            telaListagem.montarListaCategorias();
            dispose();
        }else{
            JOptionPane.showMessageDialog(this, "Erro ao alterar categoria");
        }
    }
    */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpTipo = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        txtCategoria = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        rdbFilme = new javax.swing.JRadioButton();
        rdbJogo = new javax.swing.JRadioButton();
        btnGravar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Categoria");

        jLabel2.setText("Tipo");

        grpTipo.add(rdbFilme);
        rdbFilme.setText("Filme");
        rdbFilme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbFilmeActionPerformed(evt);
            }
        });

        grpTipo.add(rdbJogo);
        rdbJogo.setText("Jogo");

        btnGravar.setText("Gravar");
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnGravar)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(rdbFilme)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(rdbJogo))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbFilme)
                    .addComponent(rdbJogo))
                .addGap(35, 35, 35)
                .addComponent(btnGravar)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rdbFilmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbFilmeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbFilmeActionPerformed

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        categoria.setNome(txtCategoria.getText());
        if (rdbFilme.isSelected()) {
            categoria.setTipo('F');
            
        }else if (rdbJogo.isSelected()) {
            categoria.setTipo('J');
        }
        if (categoria.getTipo() != ' ') {
            if (categoria.getId() == 0) {
                inserir();
            }else {
                alterar();
            }
        }else{
            JOptionPane.showMessageDialog(this, "Selecione o tipo de categoria");
        }
        
    }//GEN-LAST:event_btnGravarActionPerformed

    /**
     * @param args the command line arguments
     */

    private void alterar(){
        if (CategoriaDAO.alterar(categoria)) {
            JOptionPane.showMessageDialog(this, "Categoria alterada com sucesso");
            telaListagem.montarListaCategorias();
            dispose();
        }else{
            JOptionPane.showMessageDialog(this, "Erro ao alterar categoria");
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGravar;
    private javax.swing.ButtonGroup grpTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton rdbFilme;
    private javax.swing.JRadioButton rdbJogo;
    private javax.swing.JTextField txtCategoria;
    // End of variables declaration//GEN-END:variables
}
