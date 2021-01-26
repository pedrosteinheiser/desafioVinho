/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package winecontrol.entidades;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Pedro
 */
public class ItemDoPedido implements Serializable{
    private ArrayList<Vinho> vinhos;
    
    public ItemDoPedido(){
        vinhos = new ArrayList<>();
    }

    public ArrayList<Vinho> getVinhos() {
        return vinhos;
    }

    public void setVinhos(ArrayList<Vinho> vinhos) {
        this.vinhos = vinhos;
    }
}
