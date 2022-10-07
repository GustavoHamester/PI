/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import entidades.Jogo;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import persistencia.jogoDAO;

public class TelaListaJogo extends javax.swing.JFrame {
    private List<Jogo> listaJogos;
    
    public TelaListaJogo() {
        initComponents();
        listarJogos();
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        tabCategoriaa = new javax.swing.JScrollPane();
        tabJogos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        tabJogos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Titulo", "Categoria", "Preço", "Nº Dias"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabCategoriaa.setViewportView(tabJogos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(tabCategoriaa, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnAlterar)
                    .addComponent(btnExcluir))
                .addGap(18, 18, 18)
                .addComponent(tabCategoriaa, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        new TelaCadastroJogo(this).setVisible(true);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        int linha = tabJogos.getSelectedRow();
        if(linha == -1){
            JOptionPane.showMessageDialog(null, "Selecione um jogo para alterar");
        }else{
            TelaCadastroJogo cadastro = new TelaCadastroJogo(this);
            cadastro.setJogo(listaJogos.get(linha));
            cadastro.setVisible(true);
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linha = tabJogos.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um jogo para excluir!");
        }else{
            Jogo jogo = listaJogos.get(linha);
            String mensagem = "Deseja realmente excluir o jogo " + jogo.getTitulo() + "?";
            int opcao = JOptionPane.showConfirmDialog(null, mensagem, "Confirme a exclusão",JOptionPane.YES_NO_OPTION);
            
            if (opcao == JOptionPane.YES_OPTION) {
                if (jogoDAO.excluir(jogo.getId())) {
                    listarJogos();
                    JOptionPane.showMessageDialog(null, "Filme excluído com sucesso!");
                }else{
                    JOptionPane.showMessageDialog(null, "Erro ao excluir o jogo!");
                }
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    public void listarJogos() {
        listaJogos = jogoDAO.listar();
        DefaultTableModel modelo = (DefaultTableModel)tabJogos.getModel();
        for(Jogo j : listaJogos) {
            Object[] linha = {
                j.getTitulo(),
                j.getCategoria().getNome(),
                j.getPreco(),
                j.getNumeroDias()
            };
            modelo.addRow(linha);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JScrollPane tabCategoriaa;
    private javax.swing.JTable tabJogos;
    // End of variables declaration//GEN-END:variables
}
