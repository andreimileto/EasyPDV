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
                    + "'" + fp.getSituacao() + "'"
                    + ")";
            int resultado = st.executeUpdate(sql);
            }else{
                System.out.println("fazer update");
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
            String sql = "select * from  forma_pagamento";
            
            ResultSet resultado = st.executeQuery(sql);
            while (resultado.next()) {
                FormaPagamento fp = new FormaPagamento();
                fp.setId(resultado.getInt("id"));
                fp.setDescricao(resultado.getString("descricao"));
                fp.setSituacao(resultado.getString("situacao").charAt(0));
                formasPagamento.add(fp);
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar Forma de pagamento " + e);
        }

        return formasPagamento;
    }
}
