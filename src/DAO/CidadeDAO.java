/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidade.Cidade;
import entidade.FormaPagamento;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author pc05
 */
public class CidadeDAO {
public boolean salvar(Cidade cidade) {
        try {
            Statement st = ConexaoDB.conexao.createStatement();
            //executeupdate = insert,update, delete
            //query = select
            
            if(cidade.getId() == 0){
            String sql = "INSERT INTO cidade VALUES ("
                    + "DEFAULT," + "'" + cidade.getAtivo() + "',"
                    + "'" + cidade.getDescricao() + "'"
                    + ")";
            int resultado = st.executeUpdate(sql);
            }else{
                 String sql = "UPDATE cidade set descricao='"+cidade.getDescricao()
                         +"', ativo ='"+cidade.getAtivo()
                         +"' where id ="+cidade.getId();
                 
          int resultado = st.executeUpdate(sql);
            
            }
            return true;
        } catch (Exception e) {
            
            System.out.println("Erro salvar Cidade = " + e);
        }
        return false;
    }

    public ArrayList<Cidade> consultar() {
        ArrayList<Cidade> cidades = new ArrayList<>();

        try {
            Statement st = ConexaoDB.conexao.createStatement();
            String sql = "select * from  cidade order by id";
            
            ResultSet resultado = st.executeQuery(sql);
            while (resultado.next()) {
                Cidade cidade = new Cidade();
                cidade.setId(resultado.getInt("id"));
                cidade.setDescricao(resultado.getString("descricao"));
                cidade.setAtivo(resultado.getString("ativo").charAt(0));
                cidades.add(cidade);
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar cidades " + e);
        }

        return cidades;
    }
    
    
}