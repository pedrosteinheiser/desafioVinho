/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package winecontrol.telas;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import winecontrol.controladores.ControladorPedidos;
import winecontrol.entidades.ItemDoPedido;
import winecontrol.entidades.Vinho;

/**
 *
 * @author Pedro
 */
public class TelaCatalogoVinhos extends javax.swing.JFrame {
    private ControladorPedidos owner;
    private DefaultTableModel model;
    private ItemDoPedido carrinho;
    
    public TelaCatalogoVinhos(ControladorPedidos owner) {
     carrinho = null;
     this.owner = owner;
     int linhas = 0;   
     this.model = new DefaultTableModel();
     model.addColumn("Nome");
     model.addColumn("Tipo");
     model.addColumn("Peso");
     model.addColumn("Valor");
     model.addColumn("Descrição");
   
      for(Vinho vinho : owner.getVinhos()){
          if(vinho.getNome()!=null){
              linhas++;
          }
      }
      this.model.setNumRows(linhas);
       this.listarVinhos();
        initComponents();
    }

     public void listarVinhos(){
    
        int linha = 0;
        for(Vinho vinho : owner.getVinhos()){
        model.setValueAt(vinho.getNome(),linha,0);
        model.setValueAt(vinho.getTipo(), linha, 1);
        model.setValueAt(vinho.getPeso(), linha, 2);     
        model.setValueAt(vinho.getValor(), linha, 3);
        model.setValueAt(vinho.getDescrição(), linha, 4);
        linha++;
    }
     }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        botaoAdicionarCarrinho = new javax.swing.JButton();
        botaoSair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        botaoAdicionarCarrinho.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botaoAdicionarCarrinho.setText("Adicionar ao Carrinho");
        botaoAdicionarCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAdicionarCarrinhoActionPerformed(evt);
            }
        });

        botaoSair.setText("Sair");
        botaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSairActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Wine Control - Catálogo de Vinhos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoAdicionarCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(164, 164, 164)
                        .addComponent(botaoSair)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(146, 146, 146))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoAdicionarCarrinho)
                    .addComponent(botaoSair))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     private String getVinhoSelecionado(){
        String nome = (String) jTable1.getValueAt(jTable1.getSelectedRow(),0);
        
        return nome;
    }
    private void botaoAdicionarCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionarCarrinhoActionPerformed
        if(carrinho == null){
            carrinho = new ItemDoPedido();
            owner.adicionaVinhoCarrinho(getVinhoSelecionado(), carrinho);
            JOptionPane.showMessageDialog(null,"Vinho adicionado ao carrinho!");
            owner.guardaCarrinho(carrinho);
            owner.exibeTelaCarrinho();
            this.setVisible(false);
        }
        else{
            owner.carregaCarrinho();
            owner.adicionaVinhoCarrinho(getVinhoSelecionado(), carrinho);
            JOptionPane.showMessageDialog(null,"Vinho adicionado ao carrinho!");
            owner.guardaCarrinho(carrinho);
            owner.exibeTelaCarrinho();
            this.setVisible(false);
        }
    }//GEN-LAST:event_botaoAdicionarCarrinhoActionPerformed

    private void botaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSairActionPerformed
        this.owner.exibeTelaLogin();
    }//GEN-LAST:event_botaoSairActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAdicionarCarrinho;
    private javax.swing.JButton botaoSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
