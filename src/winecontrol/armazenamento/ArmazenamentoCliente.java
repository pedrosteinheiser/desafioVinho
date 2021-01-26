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
import winecontrol.entidades.Cliente;

/**
 *
 * @author Pedro
 */
public class ArmazenamentoCliente {
     private HashMap<String,Cliente> cacheCliente = new HashMap<>();
    private final String filename = "clientes.dat";
    
    
    public ArmazenamentoCliente(){
        
        this.load();
        
    }
    public Cliente get(String idCliente){
        return getCacheCliente().get(idCliente);
    }
    
    public void put(Cliente cliente){
        getCacheCliente().put(cliente.getEmail(),cliente);
        this.persist();
    }
    
    public void remove(Cliente cliente){
        getCacheCliente().remove(cliente.getEmail());
        this.persist();
    }
    
    public Collection<Cliente> getClientes(){
        return getCacheCliente().values();
    }
    
     public void persist(){
        try{
            FileOutputStream fout = new FileOutputStream(filename);
            
            ObjectOutputStream oo = new ObjectOutputStream(fout);
            oo.writeObject(getCacheCliente());
            
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
             
             this.cacheCliente = (HashMap<String,Cliente>) oi.readObject();
             
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

    
    public HashMap<String,Cliente> getCacheCliente() {
        return cacheCliente;
    }
}

