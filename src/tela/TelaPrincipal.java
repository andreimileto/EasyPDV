/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import apoio.ConexaoBD;
import entidade.FinanceiroPagar;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

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
        this.setExtendedState(MAXIMIZED_BOTH);

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
        imnClientes = new javax.swing.JMenuItem();
        imnCidades = new javax.swing.JMenuItem();
        imnMercadoria = new javax.swing.JMenuItem();
        imnFormaPagamento = new javax.swing.JMenuItem();
        imnFornecedores = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        imnPDV = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        imnTitulosReceber = new javax.swing.JMenuItem();
        imnCadastroTituloPagar = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        imnLFormasPagamentos = new javax.swing.JMenuItem();
        imnLMercadorias = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        imnAlterarSenha = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EasyPDV");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 713, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 407, Short.MAX_VALUE)
        );

        jMenu1.setText("Cadastros");

        imnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Iconusers48.png"))); // NOI18N
        imnClientes.setText("Clientes");
        imnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imnClientesActionPerformed(evt);
            }
        });
        jMenu1.add(imnClientes);

        imnCidades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/IconLocation.png"))); // NOI18N
        imnCidades.setText("Cidades");
        imnCidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imnCidadesActionPerformed(evt);
            }
        });
        jMenu1.add(imnCidades);

        imnMercadoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Iconbox48.png"))); // NOI18N
        imnMercadoria.setText("Mercadorias");
        imnMercadoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imnMercadoriaActionPerformed(evt);
            }
        });
        jMenu1.add(imnMercadoria);

        imnFormaPagamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Icon_credit_cards48.png"))); // NOI18N
        imnFormaPagamento.setText("Formas de pagamento");
        imnFormaPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imnFormaPagamentoActionPerformed(evt);
            }
        });
        jMenu1.add(imnFormaPagamento);

        imnFornecedores.setText("Fornecedores");
        imnFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imnFornecedoresActionPerformed(evt);
            }
        });
        jMenu1.add(imnFornecedores);

        jMenuBar1.add(jMenu1);

        jMenu2.setMnemonic('p');
        jMenu2.setText("PDV");

        imnPDV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon_shopping_trolley.png"))); // NOI18N
        imnPDV.setMnemonic('v');
        imnPDV.setText("PDV");
        imnPDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imnPDVActionPerformed(evt);
            }
        });
        jMenu2.add(imnPDV);

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon_list.png"))); // NOI18N
        jMenuItem6.setText("Listagem de vendas");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Financeiro");

        imnTitulosReceber.setText("Lista Títulos a receber");
        imnTitulosReceber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imnTitulosReceberActionPerformed(evt);
            }
        });
        jMenu3.add(imnTitulosReceber);

        imnCadastroTituloPagar.setText("Cadatro Títulos a pagar");
        imnCadastroTituloPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imnCadastroTituloPagarActionPerformed(evt);
            }
        });
        jMenu3.add(imnCadastroTituloPagar);

        jMenuBar1.add(jMenu3);

        jMenu5.setText("Listagem");

        imnLFormasPagamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Icon_credit_cards48.png"))); // NOI18N
        imnLFormasPagamentos.setText("Formas de pagamento");
        imnLFormasPagamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imnLFormasPagamentosActionPerformed(evt);
            }
        });
        jMenu5.add(imnLFormasPagamentos);

        imnLMercadorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Iconbox48.png"))); // NOI18N
        imnLMercadorias.setText("Mercadorias");
        imnLMercadorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imnLMercadoriasActionPerformed(evt);
            }
        });
        jMenu5.add(imnLMercadorias);

        jMenuBar1.add(jMenu5);

        jMenu4.setText("Configurações");

        imnAlterarSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/preferences_desktop_user_password (2).png"))); // NOI18N
        imnAlterarSenha.setText("Alterar senha");
        imnAlterarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imnAlterarSenhaActionPerformed(evt);
            }
        });
        jMenu4.add(imnAlterarSenha);

        jMenuBar1.add(jMenu4);

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
        JdgCadastroMercadoria mercadoria = new JdgCadastroMercadoria(this, true);
        mercadoria.setVisible(true);
    }//GEN-LAST:event_imnMercadoriaActionPerformed

    private void imnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imnClientesActionPerformed
        JdgCadastroCliente cadastroCliente = new JdgCadastroCliente(this, true);
        cadastroCliente.setVisible(true);
    }//GEN-LAST:event_imnClientesActionPerformed

    private void imnPDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imnPDVActionPerformed
        JdgPedidoVenda pedido = new JdgPedidoVenda(this, true);
        pedido.setVisible(true);
    }//GEN-LAST:event_imnPDVActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        JdgListagemVendas vendas = new JdgListagemVendas(this, false);
//        JdgListagemVendas vendas = new JdgListagemVendas(this, true);
//        vendas.setLocationRelativeTo(this);
        vendas.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void imnAlterarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imnAlterarSenhaActionPerformed
        JdgAlteracaoSenha alteracaoSenha = new JdgAlteracaoSenha(this,true);
        alteracaoSenha.setVisible(true);
    }//GEN-LAST:event_imnAlterarSenhaActionPerformed

    private void imnLFormasPagamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imnLFormasPagamentosActionPerformed
         try {
            // Compila o relatorio//

            //C:\Users\Mileto\Documents\NetBeansProjects\EasyPDV\libs\Relatórios
//            JOptionPane.showMessageDialog(rootPane,Thread.currentThread().getContextClassLoader().getResourceAsStream("/relatorios/Faturamento.jrxml"));
            JasperReport relatorio = JasperCompileManager.compileReport(getClass().getResourceAsStream("/relatorios/ListagemFormaPagamento.jrxml"));

            // Mapeia campos de parametros para o relatorio, mesmo que nao existam

            Map parametros = new HashMap();


            // Executa relatoio


            JasperPrint impressao = JasperFillManager.fillReport(relatorio, parametros, ConexaoBD.getInstance().getConnection());

            // Exibe resultado em video
            JasperViewer.viewReport(impressao, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório: " + e);
            System.out.println(e);
        }
    }//GEN-LAST:event_imnLFormasPagamentosActionPerformed

    private void imnLMercadoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imnLMercadoriasActionPerformed
        try {
            // Compila o relatorio//

            //C:\Users\Mileto\Documents\NetBeansProjects\EasyPDV\libs\Relatórios
//            JOptionPane.showMessageDialog(rootPane,Thread.currentThread().getContextClassLoader().getResourceAsStream("/relatorios/Faturamento.jrxml"));
            JasperReport relatorio = JasperCompileManager.compileReport(getClass().getResourceAsStream("/relatorios/ListagemDeMercadoria.jrxml"));

            // Mapeia campos de parametros para o relatorio, mesmo que nao existam

            Map parametros = new HashMap();


            // Executa relatoio


            JasperPrint impressao = JasperFillManager.fillReport(relatorio, parametros, ConexaoBD.getInstance().getConnection());

            // Exibe resultado em video
            JasperViewer.viewReport(impressao, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório: " + e);
            System.out.println(e);
        }
    }//GEN-LAST:event_imnLMercadoriasActionPerformed

    private void imnTitulosReceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imnTitulosReceberActionPerformed
        JdgListagemFinanceiroReceber listaReceber = new JdgListagemFinanceiroReceber(this, true);
        listaReceber.setVisible(true);
    }//GEN-LAST:event_imnTitulosReceberActionPerformed

    private void imnFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imnFornecedoresActionPerformed
        JdgCadastroFornecedor fornecedor = new JdgCadastroFornecedor(this, true);
        fornecedor.setVisible(true);
    }//GEN-LAST:event_imnFornecedoresActionPerformed

    private void imnCadastroTituloPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imnCadastroTituloPagarActionPerformed
        FinanceiroPagar financeiroPagar = new FinanceiroPagar();
        JdgCadastroFinanceiroPagar cadastroFinanceiroPagar = new JdgCadastroFinanceiroPagar(this ,true);
        cadastroFinanceiroPagar.setVisible(true);
    }//GEN-LAST:event_imnCadastroTituloPagarActionPerformed

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
    private javax.swing.JMenuItem imnAlterarSenha;
    private javax.swing.JMenuItem imnCadastroTituloPagar;
    private javax.swing.JMenuItem imnCidades;
    private javax.swing.JMenuItem imnClientes;
    private javax.swing.JMenuItem imnFormaPagamento;
    private javax.swing.JMenuItem imnFornecedores;
    private javax.swing.JMenuItem imnLFormasPagamentos;
    private javax.swing.JMenuItem imnLMercadorias;
    private javax.swing.JMenuItem imnMercadoria;
    private javax.swing.JMenuItem imnPDV;
    private javax.swing.JMenuItem imnTitulosReceber;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
