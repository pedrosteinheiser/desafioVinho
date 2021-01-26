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
public class Cliente implements Serializable {
    private ArrayList<Pedido> historicoDePedidos;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private String senha;
            
    
    public Cliente(String nome, String email, String cpf, String telefone, String senha){
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
        this.senha = senha;
        this.historicoDePedidos = new ArrayList<>();
    }

    public ArrayList<Pedido> getHistoricoDePedidos() {
        return historicoDePedidos;
    }

    public void setHistoricoDePedidos(ArrayList<Pedido> historicoDePedidos) {
        this.historicoDePedidos = historicoDePedidos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
