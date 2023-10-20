/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio_3;

/**
 *
 * @author Arthur
 */
public class itemPedido {
    String item;
    int quantidade;
    double precoUnitario;
    pedido p;

    public itemPedido(String item, double precoUnitario) {
        this.item = item;
        this.precoUnitario = precoUnitario;
    }

    public itemPedido( int quantidade) {
        this.quantidade = quantidade;
    }

    public itemPedido(double precoUnitario){
        this.precoUnitario = precoUnitario;
    }
    
    public itemPedido(){
    
   }
    
    public void atribuirPedidoItem(String item){
        this.item = item;
    }
    
    public String voltarPedidoItem(){
      return this.item;
    }

    public void atribuirPedidoQuan(int quantidade){
        this.quantidade = quantidade;
    }
    
    public int voltarPedidoQuan(){
      return this.quantidade;
    }
    
    public void atribuirPedidoPrecou(double precoUnitario){
        this.precoUnitario = precoUnitario;
    }
    
    public double voltarPedidoPrecoU(){
      return this.precoUnitario;
    }
    
    
    
}