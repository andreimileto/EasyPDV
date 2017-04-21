/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import apoio.ConexaoBD;
import entidade.Cidade;
import entidade.FaturamentoItem;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Mileto
 */
public class FaturamentoItemDAO {

    private FaturamentoItem fat;

    public ArrayList<FaturamentoItem> consultar(FaturamentoItem fat, ArrayList<FaturamentoItem> mercs) {
        this.fat = fat;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            for (int i = 0; i < mercs.size(); i++) {

                String sql = "select id from  mercadoria  where referencia = '"
                        + mercs.get(i).getMercadoria().getReferencia() + "'";
                System.out.println("sql");
                ResultSet resultado = st.executeQuery(sql);
                while (resultado.next()) {
                    mercs.get(i).getMercadoria().setId(Integer.parseInt(resultado.getString("id")));

                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar mercadorias " + e);
        }
        return mercs;
    }
}
