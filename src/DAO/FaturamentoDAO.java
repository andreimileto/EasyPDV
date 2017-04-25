/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import apoio.ConexaoBD;
import entidade.Cliente;
import entidade.Faturamento;
import entidade.FaturamentoItem;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import tela.JdgPedidoVenda;

/**
 *
 * @author Mileto
 */
public class FaturamentoDAO {

    ArrayList<FaturamentoItem> mercs;
    Faturamento fat;
    FaturamentoItem fatItem;

     public boolean salvar(Faturamento fat, ArrayList<FaturamentoItem> mercs, FaturamentoItem fatItem) {
//        this.mercs = mercs;
//        this.fat = fat;
//        this.fatItem = fatItem;
        try {
            System.out.println("entrou no try");
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            //executeupdate = insert,update, delete
            //query = select
            System.out.println("entrou no try depois do get instance");
            if (fat.getId() == 0) {
                System.out.println("entrou no if == 0 id cliente = "+fat.getCliente().getId()+"...");
                String sql = "INSERT INTO faturamento VALUES ("
                        + "DEFAULT," + "" + fat.getCliente().getId() + ","
                        + "" + fat.getFormaPagamento().getId() + ","
                        + "1,"
                        + "'" + fat.getDataEmissao() + "',"
                        + "'" + fat.getFase() + "',"
                        + "" + fat.getDesconto() + ","
                        + "" + fat.getValorTotal() + ","
                        + "" + fat.getParcelas() + ""
                        + ")";
                System.out.println("inser faturamento..... \n"+sql);
                
                int resultado = st.executeUpdate(sql);

                sql = "select max(id) from faturamento ";
                 System.out.println("select max..... \n"+sql);
                 ResultSet resulSelect = st.executeQuery(sql);
                 resulSelect.next();
                
                fatItem.setIdFaturamento(Integer.parseInt(resulSelect.getString("max")));
                System.out.println("id faturamento ultimo é = "+fatItem.getIdFaturamento());
                mercs.add(fatItem);
                for (int i = 0; i < mercs.size(); i++) {
                    
                    sql = "INSERT INTO faturamento_item VALUES (default"
                            
                            + fatItem.getIdFaturamento()+","
                            + mercs.get(i).getMercadoria().getId() + ","
                            + mercs.get(i).getQuantidade() + ","
                            + mercs.get(i).getMercadoria().getPrecoVenda() + ","
                            + mercs.get(i).getDesconto() + ","
                            + mercs.get(i).getValorTotal() + ")";
                    System.out.println("inser faturamento item..... \n"+sql);
                    resultado = st.executeUpdate(sql);
                     
                }
                
                

//            } else {
//                String sql = "UPDATE cliente set id_cidade='" + cli.getCidade().getId()
//                        + "', razao_social ='" + cli.getRazaoSocial()
//                        + "', tipo_cadastro ='" + cli.getTipoCadastro()
//                        + "', cpf_cnpj ='" + cli.getCpfCnpj()
//                        + "', endereco ='" + cli.getEndereco()
//                        + "', telefone ='" + cli.getTelefone()
//                        + "', ativo ='" + cli.getAtivo()
//                        + "' where id =" + cli.getId();
//
//                int resultado = st.executeUpdate(sql);
            }
            return true;
        } catch (Exception e) {
            Logger.getLogger(JdgPedidoVenda.class.getName()).log(Level.SEVERE, null, e);
//            System.out.println("Erro finalizar pedido = " + e);
        }
        return false;
    }
}
