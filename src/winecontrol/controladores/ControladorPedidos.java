/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package winecontrol.controladores;

import java.util.Collection;
import java.util.List;
import javax.swing.JOptionPane;
import winecontrol.armazenamento.ArmazenamentoPedido;
import winecontrol.entidades.ItemDoPedido;
import winecontrol.entidades.Pedido;
import winecontrol.entidades.Vinho;
import winecontrol.telas.TelaCarrinho;
import winecontrol.telas.TelaCatalogoVinhos;
import winecontrol.telas.TelaPedido;

/**
 *
 * @author Pedro
 */
public class ControladorPedidos {
    private ControladorPrincipal owner;
    private ArmazenamentoPedido armazenamentoPedido;
    private TelaPedido telaPedido;
    private TelaCatalogoVinhos telaCatalogoVinhos;
    private TelaCarrinho telaCarrinho;
    private ItemDoPedido carrinho;
    
   public ControladorPedidos(ControladorPrincipal owner){
       this.owner=owner;
       this.armazenamentoPedido = new ArmazenamentoPedido();
       this.telaPedido= new TelaPedido(this);
       this.telaCatalogoVinhos = new TelaCatalogoVinhos(this);
       this.telaCarrinho = new TelaCarrinho(this);
   } 
 


    public Collection<Pedido> getPedidos() {
        return armazenamentoPedido.getPedidos();
    }
    
    public void adicionaVinhoCarrinho(String vinhoSelecionado, ItemDoPedido carrinho){
        for(Vinho vinho : owner.getVinhos()){
            if(vinho.getNome().equals(vinhoSelecionado)){
                carrinho.getVinhos().add(vinho);
            }
        }  
        
    }
    
    public double somaPeso(ItemDoPedido itemDoPedido){
        double peso = 0;
        for(Vinho vinho: itemDoPedido.getVinhos()){
            peso = peso + vinho.getPeso();
        }
        return peso;
    }
    
    public int calculaFrete(ItemDoPedido itemDoPedido, double distancia){
        int pesoTotal = (int) this.somaPeso(itemDoPedido);
        if(distancia < 100){
            int frete = pesoTotal * 5;
            return frete;
        }
        else{
            int frete = (int) ((pesoTotal * 5) + (distancia/100));
            return frete;
        }
    }
    
    public double somaPreçoVinhos(ItemDoPedido itemDoPedido){
        double preçoVinhos = 0;
        for(Vinho vinho: itemDoPedido.getVinhos()){
            preçoVinhos = preçoVinhos = vinho.getValor();
        }
        return preçoVinhos;
    }
    public int pegaChave(){
       int chave =  armazenamentoPedido.getChave();
       return chave;
    }
    
    public void concluiPedido(Pedido pedido){
        armazenamentoPedido.put(pedido);
        JOptionPane.showMessageDialog(null,"Pedido concluido com sucesso!");
    }
    
    public Collection<Vinho> getVinhos(){
        return owner.getVinhos();
    }

    public void exibeTelaCarrinho() {
       telaCarrinho.setVisible(true);
    }

    public void exibeTelaLogin() {
       owner.exibeTelaLogin();
    }
    
    public void guardaCarrinho(ItemDoPedido carrinho){
        this.carrinho = carrinho;
    }
    
    public ItemDoPedido carregaCarrinho(){
        return carrinho;
    }

    public Vinho buscaVinhoNoCarrinho(String vinhoSelecionado, ItemDoPedido carrinho) {
        for(Vinho vinho : carrinho.getVinhos())
            if(vinho.getNome().equals(vinhoSelecionado)){
                return vinho;
            }
        return null;
    }

    public void atualizaListaTelaCarrinho() {
       this.telaCarrinho = new TelaCarrinho(this);
       telaCarrinho.listarVinhos();
       
    }

    public void exibeTelaPedido() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void exibeTelaCatalogoVinhos() {
        this.telaCatalogoVinhos.setVisible(true);
    }
        
}