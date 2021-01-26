/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package winecontrol.controladores;

import java.util.Collection;
import javax.swing.JOptionPane;
import winecontrol.entidades.Vinho;
import winecontrol.armazenamento.ArmazenamentoVinho;
import winecontrol.telas.TelaCadastrarVinho;
import winecontrol.telas.TelaEditarVinho;
import winecontrol.telas.TelaGerenciamentoVinho;

/**
 *
 * @author Pedro
 */
public class ControladorVinho {
    private ControladorPrincipal owner;
    private TelaGerenciamentoVinho telaGerenciamentoVinho;
    private TelaCadastrarVinho telaCadastrarVinho;
    private ArmazenamentoVinho armazenamentoVinho;
    private TelaEditarVinho telaEditarVinho;

    public ControladorVinho(ControladorPrincipal owner) {
        this.owner=owner;
        this.armazenamentoVinho= new ArmazenamentoVinho();
        this.telaGerenciamentoVinho= new TelaGerenciamentoVinho(this);
        this.telaEditarVinho = new TelaEditarVinho(this);
        this.telaCadastrarVinho = new TelaCadastrarVinho(this);
    }
        

    public void exibeTelaGerenciamentoVinho() {
        this.telaGerenciamentoVinho.setVisible(true);
    }
    
     public void exibeTelaCadastroVinho() {
      this.telaCadastrarVinho.setVisible(true);
    }

    public Collection<Vinho> getVinhos() {
      return armazenamentoVinho.getVinhos();
    }
    public boolean jaPossuiVinho(String nome){
        for(Vinho vinho : armazenamentoVinho.getVinhos()){
            if(vinho.getNome().equals(nome)){
                   return true;  
                 }
             }
             return false;
         }
        
   
    public void cadastraVinho(String nome, String tipo, double peso, String descrição, double valor) {
       Vinho novoVinho = new Vinho(nome, tipo, peso,descrição, valor);
       if(this.jaPossuiVinho(novoVinho.getNome())){
           JOptionPane.showMessageDialog(null, "Já existe um vinho com esse nome cadastrado!");
       }
        else if(!jaPossuiVinho(novoVinho.getNome())){  
       armazenamentoVinho.put(novoVinho);
        JOptionPane.showMessageDialog(null, "Vinho cadastrado com sucesso!");
       
        atualizaLista();
        owner.exibeTelaGerenciamentoVinho();
         telaCadastrarVinho.setVisible(false);
    }
    }
    
    public void atualizaLista(){
        this.telaGerenciamentoVinho = new TelaGerenciamentoVinho(this);
        telaGerenciamentoVinho.listarVinhos();
    }

    public void telaEditarVinho(Vinho vinho) {
       telaEditarVinho.setVinhoEditar(vinho);
       telaEditarVinho.setVisible(true);
    }
    
    public void editarVinho(Vinho vinhoEditar, Vinho novoVinho) {
        if(vinhoEditar.getNome().equals(novoVinho.getNome())){
            armazenamentoVinho.remove(vinhoEditar);
            armazenamentoVinho.put(novoVinho);
            JOptionPane.showMessageDialog(null, "Vinho alterado com sucesso!");
            atualizaLista();
            owner.exibeTelaGerenciamentoVinho();
            telaEditarVinho.setVisible(false);
           
        }
       
        if(!vinhoEditar.getNome().equals(novoVinho.getNome())){
             if(this.jaPossuiVinho(novoVinho.getNome())){
            JOptionPane.showMessageDialog(null, "Vinho com esse nome já cadastrado!");
        }
        else if(!this.jaPossuiVinho(novoVinho.getNome())){
            armazenamentoVinho.remove(vinhoEditar);
            armazenamentoVinho.put(novoVinho);
            JOptionPane.showMessageDialog(null, "Vinho alterado com sucesso!");
            atualizaLista();
            owner.exibeTelaGerenciamentoVinho();  
            telaEditarVinho.setVisible(false);
        }
    }
      
    

    }

    public void removerVinho(Vinho vinho) {
      armazenamentoVinho.remove(vinho);
      JOptionPane.showMessageDialog(null, "Vinho removido com sucesso!");
      telaGerenciamentoVinho.setVisible(false);
      atualizaLista();
      owner.exibeTelaGerenciamentoVinho();
       
    }

    public void exibeTelaLogin() {
         owner.exibeTelaLogin();
    }

    public void exibeTelaEditarVinho() {
       this.telaEditarVinho.setVisible(true);
    }
    
    public Vinho buscaVinho(String nome){
        for(Vinho vinho : armazenamentoVinho.getVinhos()){
            if(vinho.getNome().equals(nome)){
                   return vinho;  
                 }
             }
            return null;
         }
   
    
}
