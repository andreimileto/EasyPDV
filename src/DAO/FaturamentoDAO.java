/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import apoio.ConexaoBD;
import apoio.Formatacao;
import apoio.Validacao;
import entidade.Cidade;
import entidade.Cliente;
import entidade.Faturamento;
import entidade.FaturamentoItem;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
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
                System.out.println("entrou no if == 0 id cliente = " + fat.getCliente().getId() + "...");
                String sql = "INSERT INTO faturamento VALUES ("
                        + "DEFAULT," + "" + fat.getCliente().getId() + ","
                        + "1,"
                        + "'" + fat.getDataEmissao() + "',"
                        + "'" + fat.getFase() + "',"
                        + "" + fat.getDesconto() + ","
                        + "" + fat.getValorTotal() + ","
                        + "" + fat.getValorTotalLiquido()
                        + ")";
                System.out.println("insert faturamento..... \n" + sql);

                int resultado = st.executeUpdate(sql);

                sql = "select max(id) from faturamento ";
                System.out.println("select max..... \n" + sql);
                ResultSet resulSelect = st.executeQuery(sql);
                resulSelect.next();

                fatItem.setIdFaturamento(Integer.parseInt(resulSelect.getString("max")));
//                fatItem.setIdFaturamento(fatItem.getIdFaturamento()+1);
//                mercs.add(fatItem);

                for (int i = 0; i < mercs.size(); i++) {

                    sql = "INSERT INTO faturamento_item VALUES (DEFAULT,"
                            + fatItem.getIdFaturamento() + ","
                            + mercs.get(i).getMercadoria().getId() + ","
                            + mercs.get(i).getQuantidade() + ","
                            + mercs.get(i).getMercadoria().getPrecoVenda() + ","
                            + mercs.get(i).getDesconto() + ","
                            + mercs.get(i).getValorTotal() + ")";
                    System.out.println(mercs.get(i).getMercadoria().getReferencia() + "...referencia insert");
                    System.out.println("insert faturamento item..... \n" + sql);
                    resultado = st.executeUpdate(sql);

                }

                sql = "update faturamento set fase = 'e' where id =" + fatItem.getIdFaturamento();
                resultado = st.executeUpdate(sql);

            }
            return true;
        } catch (Exception e) {
            Logger.getLogger(JdgPedidoVenda.class.getName()).log(Level.SEVERE, null, e);
//            System.out.println("Erro finalizar pedido = " + e);
        }
        return false;
    }

    public ArrayList<Faturamento> consultar(Faturamento fat) {
        this.fat = fat;
        ArrayList<Faturamento> vendas = new ArrayList<>();
        String sql = "";
        JOptionPane.showMessageDialog(null, fat.getValorTotal());
        JOptionPane.showMessageDialog(null, "data emissao " + fat.getDataEmissaoInicio());

        if ((fat.getDataEmissaoInicio() != null && fat.getDataEmissaoFim() != null)
                && (fat.getFase() == 'e' || fat.getFase() == 'c')) {
            JOptionPane.showMessageDialog(null, "entrou no if 2 " + fat.getDataEmissaoFim());
            sql = "select  f.id,f.id_cliente,cli.cpf_cnpj, cli.razao_social,f.id_empresa, f.data_emissao,f.valor_total,f.desconto,f.valor_total_liquido,f.fase "
                    + "from faturamento f, cliente cli "
                    + "where f.fase = '" + fat.getFase() + "' "
                    + "and f.data_emissao >= '" + fat.getDataEmissaoInicio() + "'"
                    + "and f.data_emissao <= '" + fat.getDataEmissaoFim() + " 23:59:59'"
                    + "and f.id_cliente = cli.id "
                    + " order by f.id";

        } else if (fat.getFase() == 'e' || fat.getFase() == 'c'
                && (fat.getDataEmissaoInicio() == null && fat.getDataEmissaoFim() == null)) {
            JOptionPane.showMessageDialog(null, "entrou no if 1 " + fat.getDataEmissaoFim());
            sql = "select  f.id,f.id_cliente,cli.cpf_cnpj, cli.razao_social,f.id_empresa, f.data_emissao,f.valor_total,f.desconto,f.valor_total_liquido,f.fase "
                    + "from faturamento f, cliente cli "
                    + "where f.fase = '" + fat.getFase() + "' "
                    + "and f.id_cliente = cli.id"
                    + " order by f.id";

        } else if (fat.getFase() == 't'
                && fat.getDataEmissaoInicio() == null && fat.getDataEmissaoFim() == null) {
            JOptionPane.showMessageDialog(null, "entrou no if 1");
            sql = "select  f.id,f.id_cliente,cli.cpf_cnpj, cli.razao_social,f.id_empresa, f.data_emissao,f.valor_total,f.desconto,f.valor_total_liquido,f.fase "
                    + "from faturamento f, cliente cli "
                    + "where f.id_cliente = cli.id"
                    + " order by f.id";

        } else if (fat.getFase() == 't' && fat.getDataEmissaoInicio() != null && fat.getDataEmissaoFim() != null) {

            JOptionPane.showMessageDialog(null, "entrou no else");
            sql = "select  f.id,f.id_cliente,cli.cpf_cnpj, cli.razao_social,f.id_empresa, f.data_emissao,f.valor_total,f.desconto,f.valor_total_liquido,f.fase "
                    + "from faturamento f, cliente cli "
                    + "where f.data_emissao >= '" + fat.getDataEmissaoInicio() + "'"
                    + "and f.data_emissao <= '" + fat.getDataEmissaoFim() + " 23:59:59' "
                    + "and f.id_cliente = cli.id"
                    + " order by f.id";

        }
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            System.out.println(sql);
            ResultSet resultado = st.executeQuery(sql);
            while (resultado.next()) {
                Faturamento fats = new Faturamento();
                Cidade cid = new Cidade();
                Cliente cliente = new Cliente(cid);

                cliente.setId(resultado.getInt("id_cliente"));
                cliente.setRazaoSocial(resultado.getString("razao_social"));

                cliente.setCpfCnpj(String.valueOf(resultado.getString("cpf_cnpj")));
                fats.setCliente(cliente);
                fats.setId(resultado.getInt("id"));

                fats.setDataEmissao(Formatacao.ajustaDataDMAHora(resultado.getString(("data_emissao"))));
                fats.setFase(resultado.getString("fase").charAt(0));
                fats.setValorTotal(resultado.getDouble("valor_total"));
                fats.setDesconto(resultado.getDouble("desconto"));
                fats.setValorTotalLiquido(resultado.getDouble("valor_total_liquido"));
//                fats.setEmpresa(empresa);

//                if (resultado.getString("telefone").equals("null")) {
//                    
//                    cliente.setTelefone("");
//                } else {
//                    cliente.setTelefone(String.valueOf(resultado.getString("telefone")));
//                }
//                cliente.setTipoCadastro((resultado.getString("tipo_cadastro").charAt(0)));
//                if (resultado.getString("endereco").equals("null")) {
//                    cliente.setEndereco("");
//                } else {
//                    cliente.setEndereco(String.valueOf(resultado.getString("endereco")));
//                }
//                cliente.setAtivo(resultado.getString("ativo").charAt(0));
                vendas.add(fats);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar Venda " + e);
        }

        return vendas;
    }

}
