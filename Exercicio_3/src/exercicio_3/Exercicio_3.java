/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercicio_3;
/**
 *
 * @author Arthur
 */
import java.util.*;
import javax.swing.JOptionPane;

public class Exercicio_3 {

    
     
    public static void main(String[] args) {
        loja l = new loja();
        pedido p = new pedido();   // Aqui instanciamos os objetos para utilizar os métodos de suas respectivas classes
        funcionario f = new funcionario();
        InOut.MsgSemIcone("Seja Bem, vindo!", "Mercadinho Big Bom, sempre com você com os melhores descontos" );
        while(true){      // Essa é a estrutura de repetição para ler os valores do usuário
            int x = InOut.leInt("Por favor se identifique! \n"
                  + "[1] - Cliente\n"
                  + "[2] - Administrador\n"
                  + "[3] - Fechar app");
            if(x == 1){
                p.CriarMenu(); //Chamamos o método para a criação do Menu
                InOut.MsgSemIcone("Muito bom ter você aqui! ","Fique por dentro do nosso MENU!\n" + p.mostrarMenu());
                l.menus(); //Aqui chamamos o método para a abertura dos menus da loja
            }else if(x == 2){
                l.cadastrarFuncionario(); //Aqui chamamos o método para cadastrar os funcionários na lista de funcionário
                while(true){
                    int y = InOut.leInt("Bem vindo, olá administrador! O que deseja editar:\n"
                        + "[1] - Remover Funcionário \n"
                        + "[2] - Listar Funcionários\n"
                        + "[3] - Sair");
                    if(y == 1){//Inserimos um If simples para que o usuario consiga escolher uma opção e navegar pela loja
                        l.removerFunc(); //Aqui chamamos o método para remover o funcionário de acordo com sua matrícula
                        System.out.println(l.listarFunc());
                    } else if(y == 2){
                        InOut.MsgDeInformacao("Funcionarios", l.listarFunc());
                    }
                    else if(y == 3){
                        break;
                    }
                    
                    else{
                        InOut.MsgDeErro("ERROR", "Valores inválidos. Insira novamente");   //mostra todos os funcionários cadastraos na ljoja
                        break;
                    }
                }
            }
            else if( x == 3){
                InOut.MsgDeAviso("", "Você escolheu sair! App encerrado.");
                break;
            }
            else{//Tratamento de erro: Caso ocorra a inserção de um valor errado
              InOut.MsgDeErro("ERROR", "Valores inválidos. Insira novamente");
            } 
        }
    } 
}