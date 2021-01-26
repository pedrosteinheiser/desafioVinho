/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package winecontrol;

import winecontrol.controladores.ControladorPrincipal;

/**
 *
 * @author Pedro
 */
public class WineControl {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ControladorPrincipal controladorPrincipal = ControladorPrincipal.getInstance();
        controladorPrincipal.exibeTelaLogin();
    }
    
}
