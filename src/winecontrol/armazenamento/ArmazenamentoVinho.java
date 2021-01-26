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
import winecontrol.entidades.Vinho;

/**
 *
 * @author Pedro
 */
public class ArmazenamentoVinho {
    private HashMap<String,Vinho> cacheVinho = new HashMap<>();
    private final String filename = "vinhos.dat";
    
    
    public ArmazenamentoVinho(){
        
        this.load();
        
    }
    public Vinho get(String idVinho){
        return getCacheVinho().get(idVinho);
    }
    
    public void put(Vinho vinho){
        getCacheVinho().put(vinho.getNome(),vinho);
        this.persist();
    }
    
    public void remove(Vinho vinho){
        getCacheVinho().remove(vinho.getNome());
        this.persist();
    }
    
    public Collection<Vinho> getVinhos(){
        return getCacheVinho().values();
    }
    
     public void persist(){
        try{
            FileOutputStream fout = new FileOutputStream(filename);
            
            ObjectOutputStream oo = new ObjectOutputStream(fout);
            oo.writeObject(getCacheVinho());
            
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
             
             this.cacheVinho = (HashMap<String,Vinho>) oi.readObject();
             
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

    
    public HashMap<String,Vinho> getCacheVinho() {
        return cacheVinho;
    }
}

