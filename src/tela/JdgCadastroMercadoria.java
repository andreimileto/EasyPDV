/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import DAO.CidadeDAO;
import DAO.MercadoriaDAO;
import entidade.Mercadoria;
import java.awt.Color;
import java.util.ArrayList;
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
            tfdReferencia.setEnabled(false);
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

        jPanel1 = new javax.swing.JPanel();
        lblCodigo = new javax.swing.JLabel();
        tfdCodigo = new javax.swing.JTextField();
        lblReferencia = new javax.swing.JLabel();
        tfdReferencia = new javax.swing.JTextField();
        lblDescricao = new javax.swing.JLabel();
        tfdDescricao = new javax.swing.JTextField();
        lblPrecoCusto = new javax.swing.JLabel();
        tfdPrecoCusto = new javax.swing.JFormattedTextField();
        tfdPrecoVenda = new javax.swing.JFormattedTextField();
        lblPrecoVenda = new javax.swing.JLabel();
        rbtAtivo = new javax.swing.JRadioButton();
        lblEstoque = new javax.swing.JLabel();
        tfdEstoque = new javax.swing.JFormattedTextField();
        btnLocalizar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("EasyPDV - Cadastro mercadoria");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de Mercadoria", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 153))); // NOI18N

        lblCodigo.setText("Código");

        tfdCodigo.setEditable(false);

        lblReferencia.setText("Referencia*");

        lblDescricao.setText("Descrição*");

        lblPrecoCusto.setText("Preço de custo*");

        tfdPrecoCusto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        tfdPrecoVenda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        lblPrecoVenda.setText("Preço de venda*");

        rbtAtivo.setSelected(true);
        rbtAtivo.setText("Ativo");
        rbtAtivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtAtivoActionPerformed(evt);
            }
        });

        lblEstoque.setText("Estoque*");

        tfdEstoque.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        btnLocalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Lupa3.png"))); // NOI18N
        btnLocalizar.setText("Localizar");
        btnLocalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalizarActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/confirmar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon_Schutdown16.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnLocalizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblReferencia)
                                    .addComponent(lblCodigo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfdCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfdReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblDescricao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfdDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPrecoCusto)
                                    .addComponent(lblPrecoVenda))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfdPrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfdPrecoCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(lblEstoque)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfdEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rbtAtivo)))))
                        .addGap(0, 20, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(tfdCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblReferencia)
                    .addComponent(tfdReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescricao)
                    .addComponent(tfdDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEstoque)
                            .addComponent(tfdEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtAtivo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPrecoCusto)
                            .addComponent(tfdPrecoCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPrecoVenda)
                            .addComponent(tfdPrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnSair)
                    .addComponent(btnLocalizar)))
        );

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (validarCadastro()) {

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
            }
        } else {

            JOptionPane.showMessageDialog(null, "Referência de mercadoria já utilizado em outro cadastro");


        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizarActionPerformed
        limparCampos();
        JdgListaMercadorias mercadorias = new JdgListaMercadorias(null, true, mercadoria);
        mercadorias.setVisible(true);
        verificarCadastroSelecionado();
    }//GEN-LAST:event_btnLocalizarActionPerformed

    private void rbtAtivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtAtivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtAtivoActionPerformed

    private void limparCampos() {
        mercadoria.setId(0);
        mercadoria.setReferencia("");
        mercadoria.setAtivo(' ');
        tfdReferencia.setEnabled(true);
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
        lblDescricao.setForeground(Color.black);
        lblReferencia.setForeground(Color.black);
        lblEstoque.setForeground(Color.black);
        lblPrecoCusto.setForeground(Color.black);
        lblPrecoVenda.setForeground(Color.black);
        boolean ok = true;
        if (tfdDescricao.getText().length() > 150 || tfdDescricao.getText().length() <= 0) {
            ok = false;
//            camposErrados = camposErrados+"Descrição";
            lblDescricao.setForeground(Color.red);

        }
        if (tfdReferencia.getText().length() > 45 || tfdReferencia.getText().length() <= 0) {
            ok = false;
            lblReferencia.setForeground(Color.red);

        }
        if (tfdEstoque.getText().equals("")
                || Double.parseDouble(tfdEstoque.getText().replace(",", ".")) <= 0.00) {
            ok = false;
            lblEstoque.setForeground(Color.red);

        }
        if (tfdPrecoCusto.getText().equals("")
                || Double.parseDouble(tfdPrecoCusto.getText().replace(",", ".")) <= 0.00) {
            ok = false;
            lblPrecoCusto.setForeground(Color.red);
        }
        if (tfdPrecoVenda.getText().equals("")
                || Double.parseDouble(tfdPrecoVenda.getText().replace(",", ".")) <= 0.00
                || Double.parseDouble(tfdPrecoVenda.getText().replace(",", "."))
                < Double.parseDouble(tfdPrecoCusto.getText().replace(",", "."))) {
            ok = false;
            lblPrecoVenda.setForeground(Color.red);
        }
        return ok;

    }

    private boolean validarCadastro() {
        MercadoriaDAO mercDAO = new MercadoriaDAO();
        mercadoria.setReferencia(tfdReferencia.getText());

        ArrayList<Mercadoria> mercadorias = mercDAO.consultar(mercadoria);

        if (mercadoria.getId() == 0) {

            if (mercadorias.size() > 0) {

                if (mercadoria.getReferencia().equals(mercadorias.get(0).getReferencia())) {
                    System.out.println("false");
                    return false;
                } else {
                    System.out.println("true");
                    return true;
                }
            }
        }
        return true;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblEstoque;
    private javax.swing.JLabel lblPrecoCusto;
    private javax.swing.JLabel lblPrecoVenda;
    private javax.swing.JLabel lblReferencia;
    private javax.swing.JRadioButton rbtAtivo;
    private javax.swing.JTextField tfdCodigo;
    private javax.swing.JTextField tfdDescricao;
    private javax.swing.JFormattedTextField tfdEstoque;
    private javax.swing.JFormattedTextField tfdPrecoCusto;
    private javax.swing.JFormattedTextField tfdPrecoVenda;
    private javax.swing.JTextField tfdReferencia;
    // End of variables declaration//GEN-END:variables
}
