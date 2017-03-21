/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidade.Cidade;
import entidade.Cliente;
import entidade.Mercadoria;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Mileto
 */
public class ClienteDAO {

    Cliente cli;

    public boolean salvar(Cliente cli) {
        try {
            Statement st = ConexaoDB.conexao.createStatement();
            //executeupdate = insert,update, delete
            //query = select
            if (cli.getId() == 0) {

                String sql = "INSERT INTO cliente VALUES ("
                        + "DEFAULT," + "'" + cli.getCidade().getId() + "',"
                        + "'" + cli.getRazaoSocial() + "',"
                        + "'" + cli.getTipoCadastro() + "',"
                        + "'" + cli.getCpfCnpj() + "',"
                        + "'" + cli.getEndereco() + "',"
                        + "'" + cli.getTelefone() + "',"
                        + "'" + cli.getAtivo() + "'"
                        + ")";
                System.out.println(sql);
                int resultado = st.executeUpdate(sql);
            } else {
//                String sql = "UPDATE mercadoria set referencia='" + merc.getReferencia()
//                        + "', descricao ='" + merc.getDescricao()
//                        + "', estoque ='" + merc.getEstoque()
//                        + "', preco_custo ='" + merc.getPrecoCusto()
//                        + "', preco_venda ='" + merc.getPrecoVenda()
//                        + "', ativo ='" + merc.getAtivo()
//                        + "' where id =" + merc.getId();
//
//                int resultado = st.executeUpdate(sql);
            }
            return true;
        } catch (Exception e) {
            System.out.println("Erro salvar Mercadoria = " + e);
        }
        return false;
    }

    public ArrayList<Cliente> consultar(Cliente cli) {
        this.cli = cli;
        ArrayList<Cliente> clientes = new ArrayList<>();
//        if (cli.getAtivo() == 'T' || cli.getAtivo() == 'F') {
        System.out.println("entrou no if");
        try {
            Statement st = ConexaoDB.conexao.createStatement();
            System.out.println("aaa" + cli.getAtivo());

//                String sql = "select * from  cliente where ativo='" + cli.getAtivo()
//                        + "' and razao_social ilike '" + cli.getRazaoSocial()+ "%'" + "order by razao_social";
            String sql = "select * from  cliente   where razao_social ilike  '%'order by razao_social";
            System.out.println(sql);
            ResultSet resultado = st.executeQuery(sql);
            while (resultado.next()) {
                CidadeDAO cidDAO = new CidadeDAO();
                Cidade cids = new Cidade();
                cidDAO.consultar(cids);
                Cidade cid = new Cidade();
                Cliente cliente = new Cliente(cids);
                cliente.setId(resultado.getInt("id"));
                cliente.setRazaoSocial(resultado.getString("razao_social"));
                cliente.setCidade(cids);
                cliente.getCidade().getDescricao();
                cliente.setTelefone(String.valueOf(resultado.getString("telefone")));
                cliente.setCpfCnpj(String.valueOf(resultado.getString("cpf_cnpj")));
//                    merc.setPrecoVenda(resultado.getDouble("preco_venda"));
                cliente.setAtivo(resultado.getString("ativo").charAt(0));
                clientes.add(cliente);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar Mercadoria " + e);
        }
//        } else {
//            try {
//                Statement st = ConexaoDB.conexao.createStatement();
//                String sql = "select * from  mercadoria where referencia like '" + mercadoria.getReferencia() + "%'" + "order by id";
//
//                ResultSet resultado = st.executeQuery(sql);
//                while (resultado.next()) {
//                    Mercadoria merc = new Mercadoria();
//                    merc.setId(resultado.getInt("id"));
//                    merc.setReferencia(resultado.getString("referencia"));
//                    merc.setDescricao(resultado.getString("descricao"));
//                    merc.setEstoque(resultado.getDouble("estoque"));
//                    merc.setPrecoCusto(resultado.getDouble("preco_custo"));
//                    merc.setPrecoVenda(resultado.getDouble("preco_venda"));
//                    merc.setAtivo(resultado.getString("ativo").charAt(0));
//                    mercadorias.add(merc);
//                }
//            } catch (Exception e) {
//                System.out.println("Erro ao consultar Mercadoria " + e);
//            }
//        }
        return clientes;
    }

}
