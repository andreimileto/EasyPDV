/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import apoio.ConexaoBD;
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

    Mercadoria mercadoria;

    public boolean salvar(Mercadoria merc) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            //executeupdate = insert,update, delete
            //query = select
            if (merc.getId() == 0) {

                String sql = "INSERT INTO mercadoria VALUES ("
                        + "DEFAULT," + "'" + merc.getReferencia() + "',"
                        + "'" + merc.getDescricao() + "',"
                        + merc.getEstoque() + ","
                        + merc.getPrecoCusto() + ","
                        + merc.getPrecoVenda() + ","
                        + "'" + merc.getAtivo() + "'"
                        + ")";

                int resultado = st.executeUpdate(sql);
            } else {
                String sql = "UPDATE mercadoria set referencia='" + merc.getReferencia()
                        + "', descricao ='" + merc.getDescricao()
                        + "', estoque ='" + merc.getEstoque()
                        + "', preco_custo ='" + merc.getPrecoCusto()
                        + "', preco_venda ='" + merc.getPrecoVenda()
                        + "', ativo ='" + merc.getAtivo()
                        + "' where id =" + merc.getId();

                int resultado = st.executeUpdate(sql);
            }
            return true;
        } catch (Exception e) {
            System.out.println("Erro salvar Mercadoria = " + e);
        }
        return false;
    }

    public ArrayList<Mercadoria> consultar(Mercadoria mercadoria) {
        this.mercadoria = mercadoria;
        ArrayList<Mercadoria> mercadorias = new ArrayList<>();
        if (mercadoria.getAtivo() == 'T' || mercadoria.getAtivo() == 'F') {
            try {
                Statement st = ConexaoBD.getInstance().getConnection().createStatement();
                System.out.println("aaa" + mercadoria.getAtivo());
                String sql = "select * from  mercadoria where ativo='" + mercadoria.getAtivo()
                        + "' and referencia like '" + mercadoria.getReferencia() + "%'" + "order by id";

                ResultSet resultado = st.executeQuery(sql);
                while (resultado.next()) {
                    Mercadoria merc = new Mercadoria();
                    merc.setId(resultado.getInt("id"));
                    merc.setReferencia(resultado.getString("referencia"));
                    merc.setDescricao(resultado.getString("descricao"));
                    merc.setEstoque(resultado.getDouble("estoque"));
                    merc.setPrecoCusto(resultado.getDouble("preco_custo"));
                    merc.setPrecoVenda(resultado.getDouble("preco_venda"));
                    merc.setAtivo(resultado.getString("ativo").charAt(0));
                    mercadorias.add(merc);
                }
            } catch (Exception e) {
                System.out.println("Erro ao consultar Mercadoria " + e);
            }
        } else {
            try {
                Statement st = ConexaoBD.getInstance().getConnection().createStatement();
                String sql = "select * from  mercadoria where referencia like '" + mercadoria.getReferencia() + "%'" + "order by id";

                ResultSet resultado = st.executeQuery(sql);
                while (resultado.next()) {
                    Mercadoria merc = new Mercadoria();
                    merc.setId(resultado.getInt("id"));
                    merc.setReferencia(resultado.getString("referencia"));
                    merc.setDescricao(resultado.getString("descricao"));
                    merc.setEstoque(resultado.getDouble("estoque"));
                    merc.setPrecoCusto(resultado.getDouble("preco_custo"));
                    merc.setPrecoVenda(resultado.getDouble("preco_venda"));
                    merc.setAtivo(resultado.getString("ativo").charAt(0));
                    mercadorias.add(merc);
                }
            } catch (Exception e) {
                System.out.println("Erro ao consultar Mercadoria " + e);
            }
        }
        return mercadorias;
    }
}
