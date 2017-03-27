/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easypdv;

import tela.TelaPrincipal;
import apoio.ConexaoBD;
import javax.swing.JOptionPane;
import tela.Senha;

/**
 *
 * @author Mileto
 */
public class EasyPDV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (ConexaoBD.getInstance().getConnection() != null) {
            Senha senha = new Senha();
            senha.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "Erro ao abrir banco de dados, entre em contato com o suporte!");
        }

    }

}
