/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidade.Cidade;
import entidade.Cliente;
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
                        + "'"+ cli.getCpfCnpj() + "',"
                        + "'"+ cli.getEndereco() + "',"
                        + "'"+ cli.getTelefone() + "',"
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
     }
//      public ArrayList<Cidade> consultar(Cliente cli) {
//          
//      }
     

