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

public class loja {
    Random r = new Random();
    Scanner sc = new Scanner(System.in);
    List < pedido > listaPedido = new ArrayList(); //lista para os pedidos serem armazenados na loja
    pedido p = new pedido();  
    funcionario f = new funcionario();  //instanciação de objetos para serem usados ao longo do codigo
    itemPedido it = new itemPedido();
    List < funcionario > listaFuncionario = new ArrayList();
//    Calendar datadopedido = Calendar.getInstance();
  
    
    

    void menus() {  // método para criação de um menu no qual o usuário consiga navegar pela loja
        boolean x = true;
        while (x == true) {    // While para rodar o menu todo, o laço permite que o usuario execute o menu diversas vezes, até o próprio cancelar 
            int miniMen = InOut.leInt("Oque Deseja: \n" +
                " [1] - Fazer uma compra \n" +
                " [2] - Sair");
            if (miniMen == 1) {//Condição que determina a inicialização do menu
                int fun = InOut.leInt("Escolha um funcionario para te atender!\n" +
                    " [1]- Abner \n" +
                    " [2]- Arthur \n" +
                    " [3]- Luis \n" +
                    " [4]- João \n" +
                    " [5]- Donatello");
                if (fun == 1) { //Um if simples, para dar a liberddade do usuário escolher o funcionário para atendelo
                    InOut.MsgDeInformacao("Atendimento", "Abner vai te atender!");
                } else if (fun == 2) {
                    InOut.MsgDeInformacao("Atendimento", "Arthur irá te atender!");
                } else if (fun == 3) {
                    InOut.MsgDeInformacao("Atendimento", "Luis, te atenderá! ");
                } else if (fun == 4) {
                    InOut.MsgDeInformacao("Atendimento", "João, irá lhe atender!");
                } else if (fun == 5) {
                    InOut.MsgDeInformacao("Atendimento", "Donatello vai te atender!");
                }
                boolean z = true;
                while (z == true) { // while dentro  para inicaçizar a seleção dentro do menu, também em quebrado de acordo com a vontade do cliente
                    int menu = InOut.leInt("<<<<Menu>>>>\n Escolha a ação que gostaria de realizar: \n" +
                        " [1] - Fazer Pedido \n" +
                        " [2] - Rastrear Pedido \n" +
                        " [3] - Remover Pedido \n" +
                        " [4] - Listar Pedido \n" +
                        " [5] - Sair ");
                    switch (menu){  // Switch usado para que o Usuário possa escolher uma opção que a loja disponibiliza
                        case 1:     // As opções são determinadas através de métodos que realizam as ações escolhidas
                            inserirPedido();
                            break;  //Chamando o método para inserir pedidos
                        case 2:
                            buscarPedido(); //Chamando o método para rastrear os pedidos
                            break;  //O break serve para parar o while utilizado, para que o menu não fique rodando infinitamente
                        case 3:
                            System.out.println("O que gostaria de remover?");
                            removerPedido();
                            break; //Chamando o método para remover os pedidos
                        case 4:
                            InOut.MsgDeInformacao("Lista dos Pedidos", listarPedidos()); //Chamando o método para listar os pedidos
                            break;
                        case 5:
                            InOut.MsgDeAviso("","Voce escolheu sair, obrigado!");
                            z = false; //quebra do while, assim o códgo seguira sequencialmente
                            break;
                        default:
                            System.out.println("Esta opção não existe");
                            break; // opção para caso a opção do usuário não seja a presente no menu, voltando uma mensgagem de erro
                    }
                }
            } else if (miniMen == 2) { 
                x = false; //Quebra dos menus
                InOut.MsgDeInformacao("", "Obrigado, Volte sempre!");
            }
        }
    }

    void inserirPedido() { // método para que os pedidos do usúario sejam inseridos na lista dentro da loja FEITO EM DUAS PARTES**
        //PARTE 1: Utilização da classe item pedido. Aqui são puxados métodos da classe "itemPedido"
        double valor = 0;
        while (true) {
            int v = InOut.leInt("Deseja abrir o MENU? \n" +
                " [all] - Não \n" +
                " [1] - Sim \n");
            if (v == 1) {
                 p.CriarMenu(); //Criação do Catálogo
                InOut.MsgDeInformacao("Menu",p.mostrarMenu()); //Listagem do Menu
            }
            while (true) {
                p.inserirQuantidade(); //chamando o método para inserir quantidade de produtos
                p.inserirValor(); //chamando o método para inserir quantidade de produtos
                double vt = p.calcValortotal(valor); //chamando o método para calcular o valor total do pedido
                valor = vt; //armazenando o valor total do pedido dentro de uma variavel, afim de ser inserida na lista
                p.atribuirValorTotal(valor); //inserção do valor na lista de produtos
                int c = InOut.leInt("Deseja escolher outro Produto? \n[1] - Sim \n[2] - Não"); //Opção para o usuário escolher mais de um produto
                if (c == 2) {
                    break;
                } 
            }
            break;
        }
        //PARTE 2: Utilização da Classe pedido, para inserir os valores presentes na classe, na loja
        Date data = p.dataEmissao; // Instanciando a data para buscar a data do sistema
        String nomePropProduto = InOut.leString("Escreva o nome que será vinculado ao pedido: "); //Daqui para baixo foram inseridos na lista de pedidos os atributos atravez do ".add" e do chamados dos métodos get
        int pedidoid = r.nextInt(1000);
        listaPedido.add(new pedido(nomePropProduto,pedidoid,p.valorTotalCalculado,data));
        p.atribuirPedidonome(nomePropProduto);
        p.associarPedidoid(pedidoid);
        p.atribuirDataEmissao(data);
       
        InOut.MsgDeAviso("Pedido","O pedido de " + nomePropProduto + " foi lançado com o seguinte id: " + pedidoid + "\nCom o valor de R$: " + p.valorTotalCalculado + " \nCom a data de: " + data);
    }
    
    String listarPedidos() { // método para criar uma lista com os pedidos realizados na loja
        if (listaPedido.isEmpty()) { // Tratatemntos de erro: Caso a lista esteja Vazia
           InOut.MsgDeAviso("Lista de Pedidos","A lista sua esta vazia!");
        }
        String out = "========================\n---------------------------";
        for(pedido p: listaPedido){
            out = out + "\nPedido de: " + p.nomePedido  + "\nId: " + p.pedidoid +"\nValor do pedido: R$ " + p.valorTotalCalculado +"\n---------------------------";
        }
        out = out + "\n========================";
        return out;  //Utilização do for para que ele passe por todos os itens da lista e ir printando de acordo com o que está presente nela, com os valores deetermiados(Id,nome e valor)
    }

    String listarIdPedidos(){ //Método para criar uma lista apenas com os ids dos pedidos(Utilizado apenas em métodos específicos)
        String out = "========================\n---------------------------";
        for(pedido p: listaPedido){
            out = out + "\nId: " + p.pedidoid + "\n---------------------------";
        }
        out = out + "\n========================";
        return out;
    }
    
    void buscarPedido() { // método para rastrear os pedidos presentes na lista
        boolean verify = false;
        int n;
        int i = 0;
        if (listaPedido.isEmpty()) {
            InOut.MsgDeAviso("Lista de Pedidos","A lista esta vazia!");
            verify = true;
        }else{
            n = InOut.leInt("Escreva o ID do pedido a ser localizado: \n" + listarIdPedidos());
            for(pedido ped : listaPedido){
                if(ped.pedidoid == n){
                    InOut.MsgDeInformacao("Lista","Pedido: " + listaPedido.get(i) +
                        "- ID: " +
                        listaPedido.get(i).voltarPedidoid() + " Data de Emissão: " + listaPedido.get(i).voltarDataEmissao());
                    verify = true;
                    break;   //O for busca dentro da lista, passando por todos os itens, aquele que possui o id igual ao selecionado pelo usuário
                }           
                i++; 
            }
        }
        if(!verify){ //Negando a condição de verdadeiro, logo, o for é quebrado
            InOut.MsgDeErro("Erro Pedido", "Esse pedido nao consta em nossa base de dados!");
        }
    }

    void removerPedido() {// Metodo para caso o cliente queira cancelar seu pedido na loja
        boolean verify = false;
        int n;
        int i = 0;
        if (listaPedido.isEmpty()) {
            InOut.MsgDeAviso("Lista de Pedidos","A lista esta vazia!");
            verify = true;
        }
        else{
            n = InOut.leInt("Escreva o ID do item a ser removido: " + listarIdPedidos()); // Chama o método de listar os ids, para p usúario ter a noção dos pedidos que foram realizados
            for(pedido p: listaPedido){
                if(p.pedidoid == n){
                    listaPedido.remove(i);
                    InOut.MsgDeAviso("Pedidos","O pedido: " + p.pedidoid + " foi removido");
                    verify = true;
                    break;
                }
                i++;
            }
            if(!verify){
                InOut.MsgDeErro("Pedidos", "Esse pedido nao está alocado em no0ssa base de dados!");
            }
        } // O pedido é cancelado atraves da escolha do usuário, utilizando o ID
          //A remoção ocorre atraves do for, quie busca dentro de toda lista o valor de id igual ao digitado, tirando tudo desse pedido do Array
    }

    void cadastrarFuncionario() { // Método que faz o cadastro de todos os funcionários na lista, para que assim eles possam utilizados ao longo do código
        listaFuncionario.add(new funcionario("Abner", 1111));
        f.associarFuncNome("Abner");
        listaFuncionario.add(new funcionario("Arthur", 2222));
        f.associarFuncNome("Arthur");
        listaFuncionario.add(new funcionario("Luis", 3333));
        f.associarFuncNome("Luis");
        listaFuncionario.add(new funcionario("João", 4444));
        f.associarFuncNome("João");
        listaFuncionario.add(new funcionario("Donatello", 5555));
        f.associarFuncNome("Donatello");


    }

    String listarFunc() { // Um método para mostrar os funcionários presentes na loja, mostrando seu nome e matricula respectivamente
        int l = 1;
        String out = "\n==============================\n";
        for (funcionario f: listaFuncionario) {
            out = out + ("Funcionário " + l + ": " + f.nome + " - Matricula: " + f.matricula + "\n");
            l++;
        } // Um for silmples, no qual percorre toda a lista e printa os dados inseridos nela
        return out + "==============================";
    }

    void buscarFunc() {
        int d = 1;
        int n;
        do { // Do-while utilziado para realizar um laço de acordo com uma condição pré determinada.
            System.out.println("Buscar pedido");
            n = sc.nextInt() - 1;
            if (listaFuncionario.isEmpty()) { // Tratamento de erro: caso a lista esteja vazia, uma mensgaem de erro
                System.out.println("Lista vazia");
                return;
            } else if (n >= listaFuncionario.size() || n < 0) {// Tratamento de erro: caso o funcionario buscado não esteja na lista ou seja inserido um número errado
                System.out.println("Erro: Este funcionário não esta na lista.");
            } else { // Exibe os dados dos funcionaros selecionado
                System.out.println("Funcionario " + listaFuncionario.get(n) +
                    "- Matrícula: " +
                    listaFuncionario.get(n).voltarMatricula());  
            }
            System.out.println("Rastrear outro [1] - Voltar- [0]");
            d = sc.nextInt(); // Aqui pode ocorrer a quebra da condição, caso o usuário escolha um valor diferente de 1, o while quebra
        } while (d == 1);
    }

    void removerFunc() {
        int i = 0;
        boolean verify = false;
        int mat = InOut.leInt("Insira a matrícula do funcionário a ser removido" + listarFunc()); //Exibe a lista dos funcionarios, para assim o usuario ver a lista e o funcionariuo que quer remover
        for (funcionario f2: listaFuncionario) { //For usado para percorer toda a lista até achar uma matricula igual a digitada pelo usuário
            if (listaFuncionario.isEmpty()) {// Tratamento de erro: caso a lista esteja vazia, uma mensgaem de erro
                InOut.MsgDeInformacao("Funcionários", "Lista vazia");
                break;
            }else{
                if (f2.matricula == mat) {
                listaFuncionario.remove(i);
                InOut.MsgDeInformacao("", "Funcionário removido");
                verify = true;
                break;
                }
            }
            i++;
        }
        if (!verify) {// negação do for, aparece caso algum dado não esteja na lista
            InOut.MsgDeErro("Funcionario", "O Funcionário especificado nao existe!");
        }
    }
}
