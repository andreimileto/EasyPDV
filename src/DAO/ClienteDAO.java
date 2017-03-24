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
                String sql = "UPDATE cliente set id_cidade='" + cli.getCidade().getId()
                        + "', razao_social ='" + cli.getRazaoSocial()
                        + "', tipo_cadastro ='" + cli.getTipoCadastro()
                        + "', cpf_cnpj ='" + cli.getCpfCnpj()
                        + "', endereco ='" + cli.getEndereco()
                        + "', telefone ='" + cli.getTelefone()
                        + "', ativo ='" + cli.getAtivo()
                        + "' where id =" + cli.getId();

                int resultado = st.executeUpdate(sql);
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
//            String sql = "select * from  cliente   where razao_social ilike  '%'order by razao_social";
            String sql = "select c.id id_cliente,c.id_cidade,c.razao_social,c.cpf_cnpj,c.endereco, c.telefone,c.ativo,"
                    + "cid.id id_cid, cid.descricao,cid.ativo ativo_cid "
                    + "from cliente c, cidade cid "
                    + "where (cpf_cnpj ilike '"+cli.getCpfCnpj()+"%' or"
                    + " razao_social ilike '"+ cli.getRazaoSocial()+"%') and cid.id = c.id_cidade";
            System.out.println(sql);
            ResultSet resultado = st.executeQuery(sql);
            while (resultado.next()) {
                Cidade cids = new Cidade();
                Cliente cliente = new Cliente(cids);
                cliente.setId(resultado.getInt("id_cliente"));
                cliente.setRazaoSocial(resultado.getString("razao_social"));
                cliente.setCpfCnpj(String.valueOf(resultado.getString("cpf_cnpj")));
                cids.setDescricao(resultado.getString("descricao"));
                cids.setId(resultado.getInt("id_cid"));
                cliente.setCidade(cids);
                cliente.getCidade().getDescricao();
                cliente.setEndereco(resultado.getString("endereco"));
                cliente.setTelefone(String.valueOf(resultado.getString("telefone")));
                
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
