/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easypdv;

import DAO.ConexaoDB;
import tela.TelaPrincipal;

/**
 *
 * @author Mileto
 */
public class EasyPDV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConexaoDB.abrirConexao();
        TelaPrincipal tela = new TelaPrincipal();
        tela.setVisible(true);
        
    }
    
}
