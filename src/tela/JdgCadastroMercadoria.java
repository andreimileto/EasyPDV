/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import DAO.CidadeDAO;
import DAO.MercadoriaDAO;
import entidade.Mercadoria;
import javax.swing.JOptionPane;

/**
 *
 * @author Mileto
 */
public class JdgCadastroMercadoria extends javax.swing.JDialog {

    Mercadoria mercadoria = new Mercadoria();

    public JdgCadastroMercadoria(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        verificarCadastroSelecionado();
    }

    private void verificarCadastroSelecionado() {

        if (mercadoria.getId() > 0) {

            tfdCodigo.setText(String.valueOf(mercadoria.getId()));
            tfdReferencia.setText(String.valueOf(mercadoria.getReferencia()));
            tfdDescricao.setText(mercadoria.getDescricao());
            tfdEstoque.setText(String.valueOf(mercadoria.getEstoque()));
            tfdPrecoCusto.setText(String.valueOf(mercadoria.getPrecoCusto()));
            tfdPrecoVenda.setText(String.valueOf(mercadoria.getPrecoVenda()));
            if (mercadoria.getAtivo() == 'T') {
                rbtAtivo.setSelected(true);

            } else {
                rbtAtivo.setSelected(false);
            }

        } else {
            limparCampos();
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

        jLabel1 = new javax.swing.JLabel();
        tfdCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfdReferencia = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfdDescricao = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfdPrecoVenda = new javax.swing.JFormattedTextField();
        tfdPrecoCusto = new javax.swing.JFormattedTextField();
        btnSalvar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnLocalizar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        tfdEstoque = new javax.swing.JFormattedTextField();
        rbtAtivo = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Código:");

        tfdCodigo.setEditable(false);

        jLabel2.setText("Referencia:");

        jLabel3.setText("Descrição: ");

        jLabel4.setText("Estoque:");

        jLabel5.setText("Preço de custo:");

        jLabel6.setText("Preço de venda:");

        tfdPrecoVenda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        tfdPrecoCusto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/confirmar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconcancel3.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnLocalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Lupa3.png"))); // NOI18N
        btnLocalizar.setText("Localizar");
        btnLocalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalizarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 255));
        jLabel7.setText("Cadastro de Mercadoria");

        tfdEstoque.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        rbtAtivo.setSelected(true);
        rbtAtivo.setText("Ativo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(227, Short.MAX_VALUE)
                        .addComponent(btnSalvar)
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfdPrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfdPrecoCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(tfdEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(rbtAtivo))))
                                    .addComponent(btnLocalizar)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfdDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfdCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfdReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(133, 133, 133))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfdCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfdReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfdDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tfdEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtAtivo))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tfdPrecoCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tfdPrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnSair)
                    .addComponent(btnLocalizar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (validarCampos()) {

            mercadoria.setDescricao(tfdDescricao.getText());

            mercadoria.setReferencia(tfdReferencia.getText());

            mercadoria.setEstoque(Double.parseDouble(tfdEstoque.getText().replace(',', '.')));

            mercadoria.setPrecoCusto(Double.parseDouble(tfdPrecoCusto.getText().replace(',', '.')));

            mercadoria.setPrecoVenda(Double.parseDouble(tfdPrecoVenda.getText().replace(',', '.')));

            if (rbtAtivo.isSelected()) {
                mercadoria.setAtivo('T');
            } else {
                mercadoria.setAtivo('F');
            }

            MercadoriaDAO mercadoriaDAO = new MercadoriaDAO();

            if (mercadoriaDAO.salvar(mercadoria)) {
                limparCampos();
                JOptionPane.showMessageDialog(null, "Cadastro de Mercadoria Salva com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao salvar o registro");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Erro ao salvar, Caracteres inválidos ou nulos");
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizarActionPerformed
        limparCampos();
        JdgListaMercadorias mercadorias = new JdgListaMercadorias(null, true, mercadoria);
        mercadorias.setVisible(true);
        verificarCadastroSelecionado();
    }//GEN-LAST:event_btnLocalizarActionPerformed

    private void limparCampos() {
        mercadoria.setId(0);
        mercadoria.setReferencia("");
        mercadoria.setAtivo(' ');
        tfdCodigo.setText("");
        tfdDescricao.setText("");
        tfdEstoque.setText("0");
        tfdPrecoCusto.setText("0");
        tfdPrecoVenda.setText("0");
        tfdReferencia.setText("");
        tfdReferencia.requestFocus();
        rbtAtivo.setSelected(true);
    }

    private boolean validarCampos() {
        boolean ok = true;
        if (tfdDescricao.getText().length() > 150) {
            ok = false;

        }
        if (tfdReferencia.getText().length() > 45) {
            ok = false;

        }
        if (tfdEstoque.getText().equals("")
                || Double.parseDouble(tfdEstoque.getText().replace(",", ".")) <= 0.00) {
            ok = false;

        }
        if (tfdPrecoCusto.getText().equals("")
                || Double.parseDouble(tfdPrecoCusto.getText().replace(",", ".")) <= 0.00) {
            ok = false;

        }
        if (tfdPrecoVenda.getText().equals("")
                || Double.parseDouble(tfdPrecoVenda.getText().replace(",", ".")) <= 0.00
                || Double.parseDouble(tfdPrecoVenda.getText().replace(",", "."))
                < Double.parseDouble(tfdPrecoCusto.getText().replace(",", "."))) {
            ok = false;
        }
        return ok;

    }

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
            java.util.logging.Logger.getLogger(JdgCadastroMercadoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JdgCadastroMercadoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JdgCadastroMercadoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JdgCadastroMercadoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JdgCadastroMercadoria dialog = new JdgCadastroMercadoria(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton rbtAtivo;
    private javax.swing.JTextField tfdCodigo;
    private javax.swing.JTextField tfdDescricao;
    private javax.swing.JFormattedTextField tfdEstoque;
    private javax.swing.JFormattedTextField tfdPrecoCusto;
    private javax.swing.JFormattedTextField tfdPrecoVenda;
    private javax.swing.JTextField tfdReferencia;
    // End of variables declaration//GEN-END:variables
}
