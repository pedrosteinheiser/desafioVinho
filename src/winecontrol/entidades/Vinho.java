/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package winecontrol.entidades;

import java.io.Serializable;

/**
 *
 * @author Pedro
 */
public class Vinho implements Serializable{
    private String nome;
    private String tipo;
    private double peso;
    private String descrição;
    private double valor;

 public Vinho(String nome, String tipo, double peso, String descrição, double valor) {
    this.nome = nome;
    this.tipo = tipo;
    this.peso = peso;
    this.descrição = descrição;
    this.valor = valor;
}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
}
