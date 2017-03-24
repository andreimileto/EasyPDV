/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import DAO.CidadeDAO;
import DAO.ClienteDAO;
import DAO.MercadoriaDAO;
import entidade.Cidade;
import entidade.Cliente;
import entidade.Mercadoria;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pc05
 */
public class JdgListaCliente extends javax.swing.JDialog {

    /**
     * Creates new form JdgListaCliente
     */
    Cliente cliente;
    Cidade cid;

    public JdgListaCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

    }

    public JdgListaCliente(java.awt.Frame parent, boolean modal, Cliente cliente, Cidade cid) {
        super(parent, modal);

        initComponents();
        this.cliente = cliente;
        this.cid = cid;
        popularComboBox();
        listarClientes();

    }

    private void popularComboBox() {
        cbxStatus.addItem("Ativos");
        cbxStatus.addItem("Inativos");
        cbxStatus.addItem("Todos");

    }

    private void listarClientes() {
        try {
            //setar para tabela modelo de dados
            tblListaClientes.setModel(this.obterDadosParaTabelaCompleto());
            tblListaClientes.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblListaClientes.getColumnModel().getColumn(1).setPreferredWidth(170);
            tblListaClientes.getColumnModel().getColumn(2).setPreferredWidth(40);
            tblListaClientes.getColumnModel().getColumn(3).setPreferredWidth(80);
            tblListaClientes.getColumnModel().getColumn(4).setPreferredWidth(170);
            tblListaClientes.getColumnModel().getColumn(5).setPreferredWidth(20);
            tblListaClientes.getColumnModel().getColumn(6).setPreferredWidth(0);

        } catch (Exception ex) {
            Logger.getLogger(JdgListaFormaPagamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private DefaultTableModel obterDadosParaTabelaCompleto() throws Exception {
        DefaultTableModel dtm = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
//adiciona titulo para as colunas

        CidadeDAO cidadeDAO = new CidadeDAO();
        ArrayList<Cidade> cidades = cidadeDAO.consultar(cid);

        ClienteDAO cliDAO = new ClienteDAO();
        ArrayList<Cliente> clientes = cliDAO.consultar(cliente);

        dtm.addColumn("ID");
        dtm.addColumn("NOME");
        dtm.addColumn("CPF/CNPJ");
        dtm.addColumn("CIDADE");
        dtm.addColumn("ENDERECO");
        dtm.addColumn("TELEFONE");
        dtm.addColumn("STATUS");

        for (int i = 0; i < clientes.size(); i++) {
            //popular tabela
            String result = "";
            if (String.valueOf(clientes.get(i).getAtivo()).equalsIgnoreCase("T")) {
                result = "Ativo";
            } else {
                result = "Inativo";
            }
            dtm.addRow(new String[]{String.valueOf(clientes.get(i).getId()),
                clientes.get(i).getRazaoSocial(),
                clientes.get(i).getCpfCnpj(),
                String.valueOf(clientes.get(i).getCidade().getDescricao()),
                String.valueOf(clientes.get(i).getEndereco()),
                String.valueOf(clientes.get(i).getTelefone()),
                result
            });
        }
//retorna o modelo
        return dtm;
    }

    private void selecionado() throws Exception {

        //pega a linha selecionada
        int row = tblListaClientes.getSelectedRow();

        //seta o ID do objeto da linha selecionada
//        obterDadosParaTabelaCompleto();
        this.cliente.setId(Integer.parseInt(tblListaClientes.getValueAt(row, 0).toString()));

//        CidadeDAO cidadeDAO = new CidadeDAO();
//        ArrayList<Cidade> cidades = cidadeDAO.consultar(cid);
        ClienteDAO cliDAO = new ClienteDAO();
        ArrayList<Cliente> clientes = cliDAO.consultar(cliente);
        cliente.setCidade(clientes.get(0).getCidade());
        cliente.setEndereco(clientes.get(0).getEndereco());


        System.out.println("cidade id..." + cliente.getCidade().getId());
//
//        this.cliente.setRazaoSocial(tblListaClientes.getValueAt(row, 1).toString());
//        this.cliente.setCpfCnpj(tblListaClientes.getValueAt(row, 2).toString());
//        this.cid.setDescricao(tblListaClientes.getValueAt(row, 3).toString());
//        this.cliente.setEndereco(tblListaClientes.getValueAt(row, 4).toString());
//        this.cliente.setTelefone(tblListaClientes.getValueAt(row, 5).toString());
        if (tblListaClientes.getValueAt(row, 6).toString().equals("Ativo")) {
            this.cliente.setAtivo('T');
        } else {
            this.cliente.setAtivo('F');
        }

        dispose();
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
        tfdFiltro = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbxStatus = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListaClientes = new javax.swing.JTable();
        btnConfirmar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("Lista Cadastro de Cliente");

        jLabel3.setText("Status:");

        tblListaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblListaClientes);

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addComponent(tfdFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(481, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnConfirmar)
                .addGap(18, 18, 18)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmar)
                    .addComponent(btnSair))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        try {
            selecionado();
        } catch (Exception ex) {
            Logger.getLogger(JdgListaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

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
            java.util.logging.Logger.getLogger(JdgListaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JdgListaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JdgListaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JdgListaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JdgListaCliente dialog = new JdgListaCliente(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnSair;
    private javax.swing.JComboBox<String> cbxStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListaClientes;
    private javax.swing.JTextField tfdFiltro;
    // End of variables declaration//GEN-END:variables
}
