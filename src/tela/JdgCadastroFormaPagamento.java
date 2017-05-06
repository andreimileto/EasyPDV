/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import DAO.CidadeDAO;
import DAO.FormaPagamentoDAO;
import entidade.Cidade;
import entidade.FormaPagamento;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Mileto
 */
public class JdgCadastroFormaPagamento extends javax.swing.JDialog {

    FormaPagamento formaPagamento = new FormaPagamento();

    public JdgCadastroFormaPagamento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        popularGroupButton();
        verificarCadastroSelecionado();

    }

    private void popularGroupButton() {
        rbg.add(rbtAvista);
        rbg.add(rbtPrazo);
        rbtAvista.setSelected(true);
    }

    private void verificarCadastroSelecionado() {

        if (formaPagamento.getId() > 0) {

            tfdCodigo.setText(String.valueOf(formaPagamento.getId()));
            tfdDescricao.setText(formaPagamento.getDescricao());
            System.out.println(formaPagamento.getAtivo());
            System.out.println(formaPagamento.getFormaAvista()+".. prazo");
            if (formaPagamento.getAtivo() == 'T') {
                rbtAtivo.setSelected(true);

            } else {
                rbtAtivo.setSelected(false);
            }
            System.out.println("ativo"+ formaPagamento.getAtivo());
            if (formaPagamento.getFormaAvista() == 'T') {
                rbtAvista.setSelected(true);

            } else if (formaPagamento.getFormaAvista() == 'F')  {
                rbtPrazo.setSelected(true);
            }
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbg = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfdCodigo = new javax.swing.JTextField();
        tfdDescricao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        rbtAvista = new javax.swing.JRadioButton();
        rbtPrazo = new javax.swing.JRadioButton();
        rbtAtivo = new javax.swing.JRadioButton();
        btnLocalizar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("EasyPDV - Cadastro Forma pagamento");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro forma de Pagamento", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 204))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Código");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 33, -1, -1));

        tfdCodigo.setEnabled(false);
        jPanel1.add(tfdCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 71, -1));

        tfdDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdDescricaoActionPerformed(evt);
            }
        });
        jPanel1.add(tfdDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 268, -1));

        jLabel2.setText("Descrição*");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 64, -1, -1));

        rbtAvista.setText("Avista");
        jPanel1.add(rbtAvista, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, -1, -1));

        rbtPrazo.setText("Prazo");
        jPanel1.add(rbtPrazo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, -1, -1));

        rbtAtivo.setSelected(true);
        rbtAtivo.setText("Ativo");
        jPanel1.add(rbtAtivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        btnLocalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Lupa3.png"))); // NOI18N
        btnLocalizar.setText("Localizar");
        btnLocalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLocalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/confirmar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, -1, -1));

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon_Schutdown16.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        jPanel1.add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 79, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        try {
            if (verificarCadastrado()) {

                if (tfdDescricao.getText().length() <= 150 && tfdDescricao.getText().length() > 0) {
                    formaPagamento.setDescricao(tfdDescricao.getText());
                    if (rbtAtivo.isSelected()) {
                        formaPagamento.setAtivo('T');
                    } else {
                        formaPagamento.setAtivo('F');
                    }
                    if (rbtAvista.isSelected()) {
                        formaPagamento.setFormaAvista('T');
                    } else if (rbtPrazo.isSelected()) {
                        formaPagamento.setFormaAvista('F');
                    }
 
                        
                    

                    FormaPagamentoDAO formaPagamentoDAO = new FormaPagamentoDAO();
                    if (formaPagamentoDAO.salvar(formaPagamento)) {
                        limparCampos();
                        JOptionPane.showMessageDialog(null, "Forma de Pagamento Salva com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao salvar o registro");
                    }
                } else {
                    tfdDescricao.setText("");
                    tfdDescricao.requestFocus();
                    JOptionPane.showMessageDialog(null, "Erro ao salvar Forma de pagamento \n"
                            + "Descrição da forma de pagamento em branco ou maior que 150 caracteres");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao salvar Forma de pagamento: \n"
                        + "Forma de pagamento já cadastrada");
                tfdDescricao.requestFocus();
            }
        } catch (SQLException ex) {
            Logger.getLogger(JdgCadastroFormaPagamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed
    private boolean verificarCadastrado() throws SQLException {

        FormaPagamentoDAO formDAO = new FormaPagamentoDAO();
        formaPagamento.setDescricao(tfdDescricao.getText());

        ArrayList<FormaPagamento> formas = formDAO.consultar(formaPagamento);
        if (formaPagamento.getId() == 0) {

            if (formas.size() > 0) {

                if (tfdDescricao.getText().equalsIgnoreCase(formas.get(0).getDescricao())) {
                    System.out.println("false");
                    System.out.println(formaPagamento.getDescricao());
                    return false;
                } else {
                    System.out.println("true");
                    System.out.println(formaPagamento.getDescricao());
                    return true;
                }

            }
        }
        return true;
    }

    private void limparCampos() {
        formaPagamento.setAtivo(' ');
        rbtAtivo.setSelected(true);
        tfdCodigo.setText("");
        tfdDescricao.setText("");
        tfdDescricao.requestFocus();
        formaPagamento.setId(0);
        rbtAvista.setSelected(true);
    }
    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void tfdDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdDescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdDescricaoActionPerformed

    private void btnLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizarActionPerformed
        String auxFormaPagamento = tfdDescricao.getText();
        
        JdgListaFormaPagamento listaFormaPagamento;
        try {
            listaFormaPagamento = new JdgListaFormaPagamento(null, true, formaPagamento);
            listaFormaPagamento.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(JdgCadastroFormaPagamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        verificarCadastroSelecionado();
        if (tfdDescricao.getText().length() < 1) {
            tfdDescricao.setText(auxFormaPagamento);
        }

        tfdDescricao.requestFocus();

    }//GEN-LAST:event_btnLocalizarActionPerformed

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
            java.util.logging.Logger.getLogger(JdgCadastroFormaPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JdgCadastroFormaPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JdgCadastroFormaPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JdgCadastroFormaPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JdgCadastroFormaPagamento dialog = new JdgCadastroFormaPagamento(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLocalizar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.ButtonGroup rbg;
    private javax.swing.JRadioButton rbtAtivo;
    private javax.swing.JRadioButton rbtAvista;
    private javax.swing.JRadioButton rbtPrazo;
    private javax.swing.JTextField tfdCodigo;
    private javax.swing.JTextField tfdDescricao;
    // End of variables declaration//GEN-END:variables
}
