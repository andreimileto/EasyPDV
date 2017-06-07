/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import apoio.ConexaoBD;
import entidade.Cliente;
import entidade.Faturamento;
import entidade.FaturamentoItem;
import entidade.FormaPagamentoPagas;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import tela.JdgPedidoVenda;

/**
 *
 * @author Mileto
 */
public class FinanceiroReceberDAO {

    ArrayList<FormaPagamentoPagas> formasPagas;

    public boolean salvar(ArrayList<FormaPagamentoPagas> formasPagas, int idFaturamento) {

        //if (this.fat.getId() == 0) {
        try {

            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            //executeupdate = insert,update, delete
            //query = select

            //      if (fat.getId() == 0) {
           // System.out.println("entrou no if == 0 id cliente = " + fat.getCliente().getId() + "...");
            for (int i = 0; i < formasPagas.size(); i++) {

                String sql = "INSERT INTO financeiro VALUES ("
                        + "DEFAULT," + "" + idFaturamento + ","
                        + "'" + formasPagas.get(i).getNumeroTitulo() + "',"
                        + "'" + formasPagas.get(i).getDataEmissao() + "',"
                        + "'"+formasPagas.get(i).getVencimento() + "',"
                        + formasPagas.get(i).getValor() + ","
                        + formasPagas.get(i).getValorPago() + ","
                        + "'" + formasPagas.get(i).getQuitado() + "',"
                        + "'" + formasPagas.get(i).getAtivo() + "'"
                        + ")";
                System.out.println(sql);
                int resultado = st.executeUpdate(sql);
            }

            return true;
        } catch (Exception e) {
            Logger.getLogger(JdgPedidoVenda.class.getName()).log(Level.SEVERE, null, e);
//            System.out.println("Erro finalizar pedido = " + e);
        }

        return false;
    }
}
