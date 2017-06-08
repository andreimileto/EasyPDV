/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import apoio.ConexaoBD;
import apoio.Formatacao;
import entidade.Cidade;
import entidade.Cliente;
import entidade.Faturamento;
import entidade.FaturamentoItem;
import entidade.FormaPagamentoPagas;
import entidade.Mercadoria;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import tela.JdgPedidoVenda;

/**
 *
 * @author Mileto
 */
public class FinanceiroReceberDAO {

    ArrayList<FormaPagamentoPagas> formasPagas;
    FormaPagamentoPagas formaPagamentoPagas;

    public boolean salvar(ArrayList<FormaPagamentoPagas> formasPagas, int idFaturamento) {

        //if (this.fat.getId() == 0) {
        try {

            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            //executeupdate = insert,update, delete
            //query = select

            //      if (fat.getId() == 0) {
            // System.out.println("entrou no if == 0 id cliente = " + fat.getCliente().getId() + "...");
            for (int i = 0; i < formasPagas.size(); i++) {
                String sql = "";
                if (formasPagas.get(i).getDataPagamento() == null) {

                    sql = "INSERT INTO financeiro_receber VALUES ("
                            + "DEFAULT," + "" + idFaturamento + ","
                            + "" + formasPagas.get(i).getCliente().getId() + ","
                            + "'" + formasPagas.get(i).getNumeroTitulo() + "',"
                            + "'" + formasPagas.get(i).getDataEmissao() + "',"
                            + "'" + formasPagas.get(i).getVencimento() + "',"
                            + "null,"
                            + formasPagas.get(i).getValor() + ","
                            + formasPagas.get(i).getValorPago() + ","
                            + "'" + formasPagas.get(i).getQuitado() + "',"
                            + "'" + formasPagas.get(i).getAtivo() + "'"
                            + ")";
                } else {
                    
                    sql = "INSERT INTO financeiro_receber VALUES ("
                            + "DEFAULT," + "" + idFaturamento + ","
                            + "" + formasPagas.get(i).getCliente().getId() + ","
                            + "'" + formasPagas.get(i).getNumeroTitulo() + "',"
                            + "'" + formasPagas.get(i).getDataEmissao() + "',"
                            + "'" + formasPagas.get(i).getVencimento() + "',"
                            + "'" + formasPagas.get(i).getDataPagamento() + "',"
                            + formasPagas.get(i).getValor() + ","
                            + formasPagas.get(i).getValorPago() + ","
                            + "'" + formasPagas.get(i).getQuitado() + "',"
                            + "'" + formasPagas.get(i).getAtivo() + "'"
                            + ")";
                }
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

    public ArrayList<FormaPagamentoPagas> consultar( FormaPagamentoPagas formaPagamentoPagas) {
        this.formaPagamentoPagas = formaPagamentoPagas;
        String sql = "select f.id idfinanceiro,f.id_faturamento,f.id_cliente,f.numero_titulo,f.data_emissao,"
                + "f.data_vencimento,f.data_pagamento,f.valor_titulo,"
                + "f.valor_pago,f.quitado, f.ativo ativofinanceiro,c.id idcliente,"
                + "c.razao_social,c.cpf_cnpj,c.endereco,c.telefone, c.ativo ativocliente"
                + " from financeiro_receber f, cliente c "
                + "where c.id = f.id_cliente";
        ArrayList<FormaPagamentoPagas> formas = new ArrayList<>();
        //faz consulta e adiciona os valores para o array...
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            System.out.println(sql);
            ResultSet resultado = st.executeQuery(sql);
            while (resultado.next()) {
                FormaPagamentoPagas forma = new FormaPagamentoPagas();
                //FaturamentoItem fatItem = new FaturamentoItem();
                Cidade cid = new Cidade();
                Cliente cli = new Cliente(cid);
                forma.setId(resultado.getInt("idfinanceiro"));
                forma.setNumeroTitulo(resultado.getString("numero_titulo"));
                forma.setDataEmissao(Formatacao.ajustaDataDMAHora(resultado.getString("data_emissao")));
                forma.setVencimento(Formatacao.ajustaDataDMA(resultado.getString("data_vencimento")));
                forma.setValor(resultado.getDouble("valor_titulo"));
                if (resultado.getString("data_pagamento")==null) {
                    forma.setDataPagamento("");
                }else{
                forma.setDataPagamento(Formatacao.ajustaDataDMA(resultado.getString("data_pagamento")));
                }
                forma.setValorPago(resultado.getDouble("valor_pago"));
                forma.setQuitado(resultado.getString("quitado").charAt(0));
                forma.setAtivo(resultado.getString("ativofinanceiro").charAt(0));
                cli.setId(resultado.getInt("id_cliente"));
                cli.setRazaoSocial(resultado.getString("razao_social"));
                cli.setCpfCnpj(resultado.getString("cpf_cnpj"));
                cli.setEndereco(resultado.getString("endereco"));
                forma.setCliente(cli);

//                merc.setReferencia(resultado.getString("referencia"));
//                merc.setDescricao(resultado.getString("descricao"));
//                fatItem.setQuantidade(resultado.getDouble("quantidade"));
//                fatItem.setValorUnitario(resultado.getDouble("valor_unitario"));
//                fatItem.setValorTotal(resultado.getDouble("valor_total"));
//                fatItem.setDesconto(resultado.getDouble("desconto"));
//                fatItem.setMercadoria(merc);
//                cliente.getCidade().getDescricao();
                //mercs.add(fatItem);
                formas.add(forma);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar mercadotias " + e);
        }

        return formas;
    }
}
