/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package winecontrol.armazenamento;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import winecontrol.entidades.Pedido;

/**
 *
 * @author Pedro
 */
public class ArmazenamentoPedido {
     private HashMap<Integer,Pedido> cachePedido = new HashMap<>();
    private final String filename = "pedidos.dat";
    private int chave;
    
    
    public ArmazenamentoPedido(){
        
        this.load();
        for(Pedido pedido : getPedidos()){
            chave=pedido.getChavePedido();
            
        }
        chave=chave+1;
                
    }
    public Pedido get(Integer idPedido){
        return getCachePedido().get(idPedido);
    }
    public void implementaChave(){
        this.chave=this.chave+1;
    }
    public void put(Pedido pedido){
        getCachePedido().put(chave,pedido);
        implementaChave();
        this.persist();
    }
    
    public void remove(Pedido pedido){
        getCachePedido().remove(pedido.getChavePedido());
        this.persist();
    }

    public int getChave() {
        return chave;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }
    
    public Collection<Pedido> getPedidos(){
        return getCachePedido().values();
    }
    
     public void persist(){
        try{
            FileOutputStream fout = new FileOutputStream(filename);
            
            ObjectOutputStream oo = new ObjectOutputStream(fout);
            oo.writeObject(getCachePedido());
            
            oo.flush();
            fout.flush();
            
            oo.close();
            fout.close();
            
            oo = null;
            fout = null;
            
        }   catch (FileNotFoundException ex){
            System.out.println(ex);
        }   catch(IOException ex){
            System.out.println(ex);
        }
        }
     
     public void load(){
         try {
             FileInputStream fin = new FileInputStream(filename);
             ObjectInputStream oi = new ObjectInputStream(fin);
             
             this.cachePedido = (HashMap<Integer,Pedido>) oi.readObject();
             
             oi.close();
             fin.close();
             oi = null;
             fin = null;
             
         } catch(ClassNotFoundException ex){
             System.out.println(ex);
         } catch(FileNotFoundException ex){
             System.out.println(ex);
         } catch(IOException ex){
             System.out.println(ex);
          
         }
     }

    
    public HashMap<Integer,Pedido> getCachePedido() {
        return cachePedido;
    }
}


