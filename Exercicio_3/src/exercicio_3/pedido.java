/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio_3;

/**
 *
 * @author Arthur
 */
import java.util.*;



public class pedido {
    String nomePedido;
    int pedidoid;
    Date dataEmissao = new Date();
    double valorTotalCalculado;
    List<itemPedido> listaProdutos = new ArrayList(); //Criamos uma lista para armazenar os items que o pedido vai possuir
    itemPedido it = new itemPedido(); //Instanciacão de um objeto, item pedido, para que ele possa utilizar os métodos de sua classe
    Scanner sc = new Scanner(System.in);
    public pedido() {
    }

    public pedido(String nome,int id,double valorTotalCalculado, Date dataEmissao){ //Construtor sobrecarregado, que permite a instanciação dos objetos na classe loja
        this.nomePedido  = nome; //Aqui transformamos os atriutos em instasncias
        this.pedidoid = id;
        this.valorTotalCalculado = valorTotalCalculado;
        this.dataEmissao = dataEmissao;
    }

    // Apartir daqui esão presentes os métodos get-set, que consistem em transformar os atributos da loja em instancias, para que possam ser inseridos na lista dentro de loja
    public String voltarPedidonome(){
        return this.nomePedido;
    }

    public void atribuirPedidonome(String pedidoNome){
        this.nomePedido = pedidoNome;
    }

    public int voltarPedidoid(){
        return this.pedidoid;
    } 

    public void associarPedidoid(int pedidoid){
        this.pedidoid = pedidoid;
    }

    public Date voltarDataEmissao(){
        return this.dataEmissao;
    }

    public void atribuirDataEmissao(Date dataEmissao){
        this.dataEmissao = dataEmissao;
    } 

    public void atribuirValorTotal(double valorTotalCalculado){
        this.valorTotalCalculado = valorTotalCalculado;
    }
  
       public double voltarValorTotal(){ 
        return this.valorTotalCalculado;
    }

    
    //Fim dos get-set
 
    public String toString(){
        return this.nomePedido;    
    }
   
    void CriarMenu(){ // Adiciona os produtos da loja, para a lista de pedido
        listaProdutos.add(new itemPedido("Milho",179.99)); //Adicionando
        it.atribuirPedidoItem("Milho");// Transformando-os instancia
        it.atribuirPedidoPrecou(179.99);
        listaProdutos.add(new itemPedido("Tomate",299.99));
        it.atribuirPedidoItem("Tomate");
        it.atribuirPedidoPrecou(299.99);
        listaProdutos.add(new itemPedido("Cebola", 500));
        it.atribuirPedidoItem("Cebola");
        it.atribuirPedidoPrecou(500);
        listaProdutos.add(new itemPedido("Cenoura", 251.50));
        it.atribuirPedidoItem("Cenoura");
        it.atribuirPedidoPrecou(251.50);
    }
   
String mostrarMenu(){ // Um método que mostra os produtos da loja
    String txt = "|========================================| \n";   
    int i = 1;
    for(itemPedido ip: listaProdutos){ //Adicionamos um for simples, que percorre toda a lista e mostra tudo o que tem nela
        i++;
        txt = txt + ip.item + " Valor:  " + ip.precoUnitario + "\n";
    }   
    return txt;
}
 void inserirQuantidade(){ //Este é um método siples para se inserir a quantidade de items na lista
    int quan = InOut.leInt("Inisira a quantidade desejada de produtos: ");
    listaProdutos.add(new itemPedido(quan));
    it.atribuirPedidoQuan(quan);
 }
 
void inserirValor(){//Este é um método siples para se inserir o valor dos items na lista
    double valor = InOut.leDouble("Insira o valor do produto: ");
    listaProdutos.add(new itemPedido(valor));
    it.atribuirPedidoPrecou(valor);
}
     
 
double calcValortotal(double valor){ //Este é o método que calcula o valor total do pedido
    valor += (it.quantidade * it.precoUnitario); // Ele faz a soma de todas as vezes que a operaçao preco x quantidade acontece
    return valor;                     
}

   
    
}