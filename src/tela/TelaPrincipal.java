/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import DAO.ConexaoDB;

/**
 *
 * @author Mileto
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        imnCidades = new javax.swing.JMenuItem();
        imnMercadoria = new javax.swing.JMenuItem();
        imnFormaPagamento = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Easy PDV");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 714, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 405, Short.MAX_VALUE)
        );

        jMenu1.setText("Cadastros");

        jMenuItem1.setText("Clientes");
        jMenu1.add(jMenuItem1);

        imnCidades.setText("Cidades");
        imnCidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imnCidadesActionPerformed(evt);
            }
        });
        jMenu1.add(imnCidades);

        imnMercadoria.setText("Mercadorias");
        imnMercadoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imnMercadoriaActionPerformed(evt);
            }
        });
        jMenu1.add(imnMercadoria);

        imnFormaPagamento.setText("Formas de pagamento");
        imnFormaPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imnFormaPagamentoActionPerformed(evt);
            }
        });
        jMenu1.add(imnFormaPagamento);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("PDV");

        jMenuItem5.setText("PDV");
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("Listagem de vendas");
        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Financeiro");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void imnFormaPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imnFormaPagamentoActionPerformed
        
        JdgCadastroFormaPagamento cadastroFormaPagamento = new JdgCadastroFormaPagamento(this, true);
        
        cadastroFormaPagamento.setVisible(true);
        
    }//GEN-LAST:event_imnFormaPagamentoActionPerformed

    private void imnCidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imnCidadesActionPerformed
        JdgCadastroCidade cidade = new JdgCadastroCidade(this, true);
        cidade.setVisible(true);
    }//GEN-LAST:event_imnCidadesActionPerformed

    private void imnMercadoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imnMercadoriaActionPerformed
        JdgCadastroMercadoria mercadoria = new JdgCadastroMercadoria(this,true);
        mercadoria.setVisible(true);
    }//GEN-LAST:event_imnMercadoriaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem imnCidades;
    private javax.swing.JMenuItem imnFormaPagamento;
    private javax.swing.JMenuItem imnMercadoria;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
