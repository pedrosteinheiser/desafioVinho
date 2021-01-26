/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package winecontrol.controladores;

import java.util.Collection;
import javax.swing.JOptionPane;
import winecontrol.armazenamento.ArmazenamentoCliente;
import winecontrol.entidades.Cliente;
import winecontrol.telas.TelaCadastroCliente;
import winecontrol.telas.TelaLogin;

/**
 *
 * @author Pedro
 */
public class ControladorCliente {
    private ControladorPrincipal owner;
    private TelaCadastroCliente telaCadastroCliente;
    private ArmazenamentoCliente armazenamentoCliente;
    
    public ControladorCliente(ControladorPrincipal owner) {
       this.owner=owner;
       armazenamentoCliente = new ArmazenamentoCliente();
       telaCadastroCliente= new TelaCadastroCliente(this);
    }
    
    public Collection<Cliente> getClientes(){
        return armazenamentoCliente.getClientes();
    }
    
    public ArmazenamentoCliente getArmazenamentoCliente() {
        return armazenamentoCliente;
    }

    public void setArmazenamentoCliente(ArmazenamentoCliente armazenamentoCliente) {
        this.armazenamentoCliente = armazenamentoCliente;
    }
    
    public void cadastraCliente(String nome, String email, String cpf, String telefone,String senha) {
      Cliente cliente = new Cliente(nome,email,cpf,telefone,senha);
        if(this.jaPossuiCpf(cliente.getCpf())){
            JOptionPane.showMessageDialog(null, "CPF já cadastrado!");
           }
      if(this.jaPossuiEmail(cliente.getEmail())){
               JOptionPane.showMessageDialog(null, "Email já cadastrado!");
               }
        
        else if(!jaPossuiCpf(cliente.getCpf()) && !jaPossuiEmail(cliente.getEmail())){  
       armazenamentoCliente.put(cliente);
        JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
      
        owner.exibeTelaLogin();
          telaCadastroCliente.setVisible(false);
          
        }
}

    private boolean jaPossuiCpf(String cpf) {
         for(Cliente clienteBuscar : this.getClientes()){
                 if(clienteBuscar.getCpf().equals(cpf)){
                   return true;  
                 }
             }
             return false;
    }

    boolean jaPossuiEmail(String email) {
        for(Cliente clienteBuscar : this.getClientes()){
                 if(clienteBuscar.getEmail().equals(email)){
                     return true;
                 }
             }
             return false;
    }

    void listaClientes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void exibeTelaCadastroCliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void adicionaCliente(Cliente clientePedido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void removePedidoCliente(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean buscaPorSenha( String senha){
        for(Cliente clienteBuscar : this.getClientes()){
                 if(clienteBuscar.getSenha().equals(senha)){
                     return true;
                 }
        }   
        return false;
    } 
    
    public void exibeTelaLogin(){
        owner.exibeTelaLogin();
    }
}