/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidade.FormaPagamento;
import entidade.Mercadoria;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Mileto
 */
public class MercadoriaDAO {
     public boolean salvar(Mercadoria merc) {
        try {
            Statement st = ConexaoDB.conexao.createStatement();
            //executeupdate = insert,update, delete
            //query = select
            if(merc.getId() == 0){
            String sql = "INSERT INTO mercadoria VALUES ("
                    + "DEFAULT," + "'" + merc.getReferencia() + "',"
                    + "'" + merc.getDescricao() + "',"
                    + merc.getEstoque() + ","
                    + merc.getPrecoCusto() + ","
                    + merc.getPrecoVenda() + ","
                    + "'" + merc.getAtivo() + "',"                   
                    + ")";
            int resultado = st.executeUpdate(sql);
            }else{
                 String sql = "UPDATE forma_pagamento set descricao='"+merc.getReferencia()
                         +"', ativo ='"+merc.getDescricao()
                         +"', ativo ='"+merc.getEstoque()
                         +"', ativo ='"+merc.getPrecoCusto()
                         +"', ativo ='"+merc.getPrecoVenda()
                         +"', ativo ='"+merc.getAtivo()
                         +"' where id ="+merc.getId();
                 
          int resultado = st.executeUpdate(sql);
            }
            return true;
        } catch (Exception e) {
            System.out.println("Erro salvar Mercadoria = " + e);
        }
        return false;
    }

    public ArrayList<Mercadoria> consultar() {
        ArrayList<Mercadoria> mercadorias = new ArrayList<>();

        try {
            Statement st = ConexaoDB.conexao.createStatement();
            String sql = "select * from  mercadoria order by id";
            
            ResultSet resultado = st.executeQuery(sql);
            while (resultado.next()) {
                Mercadoria merc = new Mercadoria();
                merc.setId(resultado.getInt("id"));
                merc.setReferencia(resultado.getString("referencia"));
                merc.setDescricao(resultado.getString("descricao"));
                merc.setEstoque(resultado.getDouble("estoque"));
                merc.setPrecoCusto(resultado.getDouble("precoCusto"));
                merc.setPrecoVenda(resultado.getDouble("precoVenda"));
                merc.setAtivo(resultado.getString("ativo").charAt(0));
                mercadorias.add(merc);
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar Forma de pagamento " + e);
        }

        return mercadorias;
    }
    
}