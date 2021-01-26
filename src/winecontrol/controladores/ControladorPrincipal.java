/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package winecontrol.controladores;

import java.util.Collection;
import javax.swing.JPasswordField;
import winecontrol.entidades.Cliente;
import winecontrol.entidades.Pedido;
import winecontrol.entidades.Vinho;
import winecontrol.telas.TelaLogin;

/**
 *
 * @author Pedro
 */
public class ControladorPrincipal {
    private TelaLogin telaLogin;
    private static ControladorPrincipal instance;
    private ControladorPedidos controladorPedidos;
    private ControladorCliente controladorCliente;
    private ControladorVinho controladorVinho;
    
    private ControladorPrincipal(){
        
        this.telaLogin = new TelaLogin(this);
        this.controladorCliente = new ControladorCliente(this);
        this.controladorPedidos = new ControladorPedidos(this);
        this.controladorVinho = new ControladorVinho(this);
    }
    
    public static ControladorPrincipal getInstance() {
        if(instance == null){
            instance = new ControladorPrincipal();
        }
        return instance;
    }
    
    public void exibeTelaLogin() {
       telaLogin.setVisible(true);
    }

    public void exibeTelaGerenciamentoVinho() {
       controladorVinho.exibeTelaGerenciamentoVinho();
    }

    public void exibeTelaCadastroCliente() {
       controladorCliente.exibeTelaCadastroCliente();
    }

    public void exibeTelaPedido() {
      controladorPedidos.exibeTelaPedido();
    }

    public void listaCliente() {
      controladorCliente.listaClientes();
    }

    
    public boolean jaPossuiEmail(String email) {
        return controladorCliente.jaPossuiEmail(email);
    }

    public Collection<Vinho> getVinhos() {
     return controladorVinho.getVinhos();
    }


    public Collection<Cliente> getClientes() {
     return controladorCliente.getClientes();
    }

    public Collection<Pedido> getPedidos() {
       return controladorPedidos.getPedidos();
    }

   
    public void adicionaCliente(Cliente clientePedido){
       controladorCliente.adicionaCliente(clientePedido);
    }

    public void removeClientePedido(Cliente cliente) {
       controladorCliente.removePedidoCliente(cliente);
    }
    
    public boolean verificaSenha(String senha){
       boolean busca = controladorCliente.buscaPorSenha(senha);
       return busca;
    }

    public void exibeTelaCatalogoVinhos() {
        controladorPedidos.exibeTelaCatalogoVinhos();
    }

    

  }  


