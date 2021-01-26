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
public class Pedido implements Serializable {
    private int distancia;
    private double valorVinhos;
    private int valorFrete;
    private double valorTotal;
    private ItemDoPedido carrinho;
    private int chavePedido;
    
    public Pedido(int chavePedido, ItemDoPedido carrinho, int valorFrete, double valorVinhos, double valorTotal, int distancia){
        this.chavePedido = chavePedido;
        this.carrinho = carrinho;
        this.valorFrete = valorFrete;
        this.valorVinhos = valorVinhos;
        this.valorTotal = valorTotal;
        this.distancia = distancia;
    }
    
    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public int getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(int valorFrete) {
        this.valorFrete = valorFrete;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public ItemDoPedido getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(ItemDoPedido carrinho) {
        this.carrinho = carrinho;
    }

    public int getChavePedido() {
        return chavePedido;
    }

    public void setChavePedido(int chavePedido) {
        this.chavePedido = chavePedido;
    }

    public double getValorVinhos() {
        return valorVinhos;
    }

    public void setValorVinhos(double valorVinhos) {
        this.valorVinhos = valorVinhos;
    }
    
    
    
}
