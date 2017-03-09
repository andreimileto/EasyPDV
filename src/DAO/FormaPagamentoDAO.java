/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidade.FormaPagamento;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Mileto
 */
public class FormaPagamentoDAO {
     public boolean salvar(FormaPagamento fp) {
        try {
            Statement st = ConexaoDB.conexao.createStatement();
            //executeupdate = insert,update, delete
            //query = select
            if(fp.getId() == 0){
            String sql = "INSERT INTO forma_pagamento VALUES ("
                    + "DEFAULT," + "'" + fp.getDescricao() + "',"
                    + "'" + fp.getAtivo() + "'"
                    + ")";
            int resultado = st.executeUpdate(sql);
            }else{
                 String sql = "UPDATE forma_pagamento set descricao='"+fp.getDescricao()
                         +"', ativo ='"+fp.getAtivo()
                         +"' where id ="+fp.getId();
                 
          int resultado = st.executeUpdate(sql);
            }
            return true;
        } catch (Exception e) {
            System.out.println("Erro salvar Forma de Pagamento = " + e);
        }
        return false;
    }

    public ArrayList<FormaPagamento> consultar() {
        ArrayList<FormaPagamento> formasPagamento = new ArrayList<>();

        try {
            Statement st = ConexaoDB.conexao.createStatement();
            String sql = "select * from  forma_pagamento order by id";
            
            ResultSet resultado = st.executeQuery(sql);
            while (resultado.next()) {
                FormaPagamento fp = new FormaPagamento();
                fp.setId(resultado.getInt("id"));
                fp.setDescricao(resultado.getString("descricao"));
                fp.setAtivo(resultado.getString("ativo").charAt(0));
                formasPagamento.add(fp);
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar Forma de pagamento " + e);
        }

        return formasPagamento;
    }
    
     public ArrayList<FormaPagamento> consultarEspecifico(int id) {
        ArrayList<FormaPagamento> formaPagamento = new ArrayList<>();

        try {
            Statement st = ConexaoDB.conexao.createStatement();
            String sql = "select * from  forma_pagamento where id ="+id;
            
            ResultSet resultado = st.executeQuery(sql);
            while (resultado.next()) {
                FormaPagamento fp = new FormaPagamento();
                fp.setId(resultado.getInt("id"));
                fp.setDescricao(resultado.getString("descricao"));
                fp.setAtivo(resultado.getString("ativo").charAt(0));
                formaPagamento.add(fp);
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar Forma de pagamento " + e);
        }

        return formaPagamento;
    }
}
