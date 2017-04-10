/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import DAO.ClienteDAO;
import entidade.Cidade;
import entidade.Cliente;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Mileto
 */
public class JdgCadastroCliente extends javax.swing.JDialog {

    /**
     * Creates new form JdgCadastroCliente
     */
    private MaskFormatter mascaraCpf;
    private MaskFormatter mascaraCnpj;
    private MaskFormatter mascaraTelefone8Digitos;
    private MaskFormatter mascaraTelefone9Digitos;

    Cidade cidade = new Cidade();
    Cliente cliente = new Cliente(cidade);

    public JdgCadastroCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        popularComboBox();
        mascaraCpfCnpj();
        mascaraTelefone();
        atualizarCamposFormatados();

    }

    private void mascaraCpfCnpj() {
        try {
            mascaraCpf = new MaskFormatter("###.###.###-##");
            mascaraCnpj = new MaskFormatter("##.###.###/####-##");

        } catch (Exception e) {
        }

    }

    private void mascaraTelefone() {
        try {
            mascaraTelefone8Digitos = new MaskFormatter("(##)####-####");
            mascaraTelefone9Digitos = new MaskFormatter("(##)#####-####");

        } catch (Exception e) {
        }
    }

    private void popularComboBox() {
        cbxTipo.addItem("Pessoa Física");
        cbxTipo.addItem("Pessoa Jurídica");
        atualizarCamposFormatados();
    }

    private void atualizarCamposFormatados() {
        tffCpfCnpj.setValue(null);
        if (cbxTipo.getSelectedIndex() == 0) {
            lblRazaoSocial.setText("Nome:");
            lblCpfCnpj.setText("CPF:");
            tffCpfCnpj.setFormatterFactory(new DefaultFormatterFactory(mascaraCpf));

        } else {
            lblRazaoSocial.setText("Razão Social:");
            lblCpfCnpj.setText("CNPJ:");
            tffCpfCnpj.setFormatterFactory(new DefaultFormatterFactory(mascaraCnpj));
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
        jLabel2 = new javax.swing.JLabel();
        tfdId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbxTipo = new javax.swing.JComboBox<>();
        lblRazaoSocial = new javax.swing.JLabel();
        tfdRazaoSocial = new javax.swing.JTextField();
        lblCpfCnpj = new javax.swing.JLabel();
        tffCpfCnpj = new javax.swing.JFormattedTextField();
        lblEndereco = new javax.swing.JLabel();
        tfdEndereco = new javax.swing.JTextField();
        lblTelefone = new javax.swing.JLabel();
        tffTelefone = new javax.swing.JFormattedTextField();
        rbtAtivo = new javax.swing.JRadioButton();
        btnSalvar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        lblCidade = new javax.swing.JLabel();
        tfdCidade = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnLocalizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("Cadastro Cliente");

        jLabel2.setText("Código");

        tfdId.setEditable(false);

        jLabel3.setText("Tipo");

        cbxTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxTipoItemStateChanged(evt);
            }
        });

        lblRazaoSocial.setText("Nome*");

        lblCpfCnpj.setText("CPF*");

        try {
            tffCpfCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tffCpfCnpj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tffCpfCnpjActionPerformed(evt);
            }
        });

        lblEndereco.setText("Endereço");

        lblTelefone.setText("Telefone");

        try {
            tffTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tffTelefone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tffTelefoneFocusLost(evt);
            }
        });
        tffTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tffTelefoneActionPerformed(evt);
            }
        });
        tffTelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tffTelefoneKeyReleased(evt);
            }
        });

        rbtAtivo.setSelected(true);
        rbtAtivo.setText("Ativo");

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

        lblCidade.setText("Cidade*");

        tfdCidade.setEditable(false);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Lupa3.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnLocalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Lupa3.png"))); // NOI18N
        btnLocalizar.setText("Localizar");
        btnLocalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lblCpfCnpj)
                        .addGap(25, 25, 25)
                        .addComponent(tffCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTelefone)
                        .addGap(4, 4, 4)
                        .addComponent(tffTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lblCidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfdCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lblEndereco)
                        .addGap(4, 4, 4)
                        .addComponent(tfdEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(btnLocalizar)
                        .addGap(48, 48, 48)
                        .addComponent(btnSalvar)
                        .addGap(10, 10, 10)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(tfdId, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(4, 4, 4)
                                .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(rbtAtivo))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblRazaoSocial)
                                .addGap(18, 18, 18)
                                .addComponent(tfdRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfdId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rbtAtivo))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRazaoSocial)
                    .addComponent(tfdRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTelefone)
                            .addComponent(tffCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCpfCnpj)))
                    .addComponent(tffTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCidade)
                    .addComponent(tfdCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblEndereco))
                    .addComponent(tfdEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLocalizar)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSalvar)
                            .addComponent(btnSair))))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbxTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxTipoItemStateChanged
        atualizarCamposFormatados();
    }//GEN-LAST:event_cbxTipoItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int auxIdCidade = cliente.getCidade().getId();
        System.out.println(cliente.getCidade().getId()+"Id antes...");
        cidade.setAtivo('T');
        JdgListaCidade listaCidade = new JdgListaCidade(null, true, cidade);
        listaCidade.setVisible(true);
        cliente.setCidade(cidade);
        if (cliente.getCidade().getId() > 0) {       
            System.out.println("entrou no if do id > 0");
        tfdCidade.setText(cliente.getCidade().getDescricao());
        }else{
            cidade.setId(auxIdCidade);
        }
       
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tffCpfCnpjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tffCpfCnpjActionPerformed

    }//GEN-LAST:event_tffCpfCnpjActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (verificarCadastrado()) {
            if (validarCampos()) {
                cliente.setRazaoSocial(tfdRazaoSocial.getText());

                cliente.setCpfCnpj(tffCpfCnpj.getText().replace(".", "").replace("/", "").replace("-", ""));
                if (cliente.getTelefone() != "null") {
                    cliente.setTelefone(tffTelefone.getText().replace("(", "").replace(")", "").replace("-", ""));
                }
                if (cliente.getEndereco() != "null") {
                    cliente.setEndereco(tfdEndereco.getText());
                }

                if (cbxTipo.getSelectedIndex() == 0) {
                    cliente.setTipoCadastro('F');
                } else {
                    cliente.setTipoCadastro('J');
                }
                if (rbtAtivo.isSelected()) {
                    cliente.setAtivo('T');
                } else {
                    cliente.setAtivo('F');
                }
                ClienteDAO clienteDAO = new ClienteDAO();
                clienteDAO.salvar(cliente);

                limparCampos();
                JOptionPane.showMessageDialog(null, "Cadastro de cliente salvo com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao salvar cliente, campos inválidos ou nulos");

            }

        } else {
            JOptionPane.showMessageDialog(null, "CPF/CNPJ do cliente já utilizado em outro cadastro");
        }
    }//GEN-LAST:event_btnSalvarActionPerformed
    private void limparCampos() {
        cliente.setId(0);
        cidade.setId(0);
        cliente.setCpfCnpj("");
        tfdId.setText("");
        tffCpfCnpj.setText("");
        tffTelefone.setText("");
        tfdCidade.setText("");
        tfdRazaoSocial.setText("");
        tfdEndereco.setText("");
        rbtAtivo.setSelected(true);
        tfdRazaoSocial.requestFocus();
    }
    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void tffTelefoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tffTelefoneKeyReleased

    }//GEN-LAST:event_tffTelefoneKeyReleased

    private void tffTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tffTelefoneActionPerformed

    }//GEN-LAST:event_tffTelefoneActionPerformed

    private void tffTelefoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tffTelefoneFocusLost
        System.out.println(tffTelefone.getText().length());
        String a = "";
        if (tffTelefone.getText().replace(" ", "").length() == 13) {
            a = "" + tffTelefone.getText().charAt(1) + tffTelefone.getText().charAt(2)
                    + tffTelefone.getText().charAt(4) + tffTelefone.getText().charAt(5)
                    + tffTelefone.getText().charAt(6) + tffTelefone.getText().charAt(7)
                    + tffTelefone.getText().charAt(8) + tffTelefone.getText().charAt(10)
                    + tffTelefone.getText().charAt(11) + tffTelefone.getText().charAt(12);
            System.out.println(tffTelefone.getText().replace(" ", "").length());
            tffTelefone.setFormatterFactory(new DefaultFormatterFactory(mascaraTelefone8Digitos));
            tffTelefone.setText(a);

        }
    }//GEN-LAST:event_tffTelefoneFocusLost

    private void btnLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizarActionPerformed
        limparCampos();
        JdgListaCliente clientes = new JdgListaCliente(null, true, cliente, cidade);
        clientes.setVisible(true);
        verificarCadastroSelecionado();
    }//GEN-LAST:event_btnLocalizarActionPerformed
    private boolean validarCampos() {
        lblRazaoSocial.setForeground(Color.black);
        lblEndereco.setForeground(Color.black);
        lblCidade.setForeground(Color.black);
        lblCpfCnpj.setForeground(Color.black);
        lblTelefone.setForeground(Color.black);
        boolean ok = true;
        if (tfdRazaoSocial.getText().length() > 150 || tfdRazaoSocial.getText().length() <= 0) {
            ok = false;
            lblRazaoSocial.setForeground(Color.red);
        }
        if (tfdEndereco.getText().length() > 150) {
            ok = false;
            lblEndereco.setForeground(Color.red);
        }
        if (tfdCidade.getText().length() > 100 || tfdCidade.getText().length() <= 0) {
            ok = false;
            lblCidade.setForeground(Color.red);
        }

        if (cbxTipo.getSelectedIndex() == 1) {

            if (tffCpfCnpj.getText().replace(" ", "").length() != 18) {

                ok = false;
                lblCpfCnpj.setForeground(Color.red);

            }
        } else {
            if (tffCpfCnpj.getText().replace(" ", "").length() != 14) {
                ok = false;
                lblCpfCnpj.setForeground(Color.red);

            }
        }
        if (tffTelefone.getText().replace(" ", "").replace("(", "").replace(")", "").replace("-", "").length() < 10
                && tffTelefone.getText().replace(" ", "").replace("(", "").replace(")", "").replace("-", "").length() > 1) {

            lblTelefone.setForeground(Color.red);

            ok = false;
        }
        if (tffTelefone.getText().replace(" ", "").replace("(", "").replace(")", "").replace("-", "").length() == 0) {
            cliente.setTelefone("null");

        }
        if (tfdEndereco.getText().replace(" ", "").replace("(", "").replace(")", "").replace("-", "").length() == 0) {
            cliente.setEndereco("null");

        }

        return ok;
    }

    private boolean verificarCadastrado() {

        ClienteDAO cliDAO = new ClienteDAO();
        cliente.setCpfCnpj(tffCpfCnpj.getText().replace(".", "").replace("-", "").replace("/", ""));

        ArrayList<Cliente> clientes = cliDAO.consultar(cliente);
        if (cliente.getId() == 0) {

            if (clientes.size() > 0) {

                if (cliente.getCpfCnpj().equals(clientes.get(0).getCpfCnpj())) {
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

    private void verificarCadastroSelecionado() {

        if (cliente.getId() > 0) {
            if (cliente.getTipoCadastro() == 'F') {
                cbxTipo.setSelectedIndex(0);
            } else {
                System.out.println("entrou no else");
                System.out.println(cliente.getTipoCadastro() + "....");
                cbxTipo.setSelectedIndex(1);
            }
            tfdId.setText(String.valueOf(cliente.getId()));
            tfdRazaoSocial.setText(cliente.getRazaoSocial());
            tfdCidade.setText(cliente.getCidade().getDescricao());
            tfdEndereco.setText(cliente.getEndereco());
            tffCpfCnpj.setText(cliente.getCpfCnpj());
            tffTelefone.setText(cliente.getTelefone());
            if (cliente.getAtivo() == 'T') {
                rbtAtivo.setSelected(true);

            } else {
                rbtAtivo.setSelected(false);
            }

        } else {
            limparCampos();
        }
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
            java.util.logging.Logger.getLogger(JdgCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JdgCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JdgCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JdgCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JdgCadastroCliente dialog = new JdgCadastroCliente(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> cbxTipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblCpfCnpj;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblRazaoSocial;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JRadioButton rbtAtivo;
    private javax.swing.JTextField tfdCidade;
    private javax.swing.JTextField tfdEndereco;
    private javax.swing.JTextField tfdId;
    private javax.swing.JTextField tfdRazaoSocial;
    private javax.swing.JFormattedTextField tffCpfCnpj;
    private javax.swing.JFormattedTextField tffTelefone;
    // End of variables declaration//GEN-END:variables
}
