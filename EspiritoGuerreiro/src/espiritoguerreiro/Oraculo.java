/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package espiritoguerreiro;

import java.util.Random;

/**
 *
 * @author abner
 */
import java.util.Random;

public class Oraculo{
    String nome;
    //Quando o oraculo for criado ,o guerreiro também sera instanciado dentro da classe oraculo
    Guerreiro guerr = new Guerreiro(); 

    public Oraculo(){

    }

    public Oraculo(String nome) {
        this.nome = nome;
        this.guerr = guerr;
    }
    // Método para setar o nome do Oraculo
    void setOraculoNome(){
      nome = InOut.leString("Olá, sou o oraculo deste mundo. Porém não lembro de nada..\nPode me lembrar de meu nome? ");
    }
    //Método para setar a vida do guerreiro de modo aleatorio entre 9 a 12
    int setVidas(){
        Random random = new Random();
        int vidas = random.nextInt(4) + 9;  
        guerr.setVidas(vidas);
        return vidas;
        
    }
    
    String prologoFase1(){
        //Prologo da Fase 1
         String intro = "Caro Guerreiro " + guerr.getNome() + ", eu, " + this.nome + " te darei  ->" + guerr.getVidas() + "<- vidas para esta Jornada.\n"
         + "O Seu primeiro oponente é o Gragas, testando sua habilidade de advinhacao, decidira se você prossegue ou não!";
        return intro;
    }
    // Deixa os números aleatórios de 1 a 100 para a Fase 1
    int Fase1(){
         Random random = new Random();
        int numSort = random.nextInt(100);
        return numSort;
    }

    String prologoFase2(){
        //Prologo da Fase 2
        String intro = "Agora para vencer, deve jogar ou morrer.\nAgora o grande Gragas você deve vencer! Você ainda tem " + guerr.vidas + " vidas";
        return intro;
    }
    // Fase 2
    int Fase2(int opcao){
        if(opcao !=0 && opcao !=1){
          //Caso escolha opção fora das alternativas
            return 0;
        }
        Random random = new Random();
        int orach = random.nextInt(5);
        int guer = random.nextInt(5);
        /*Pois caso seja par ip == 0, mesma int escolhida para par. Caso a soma seja impar, 
                         ip == 1, a mesma int escolhida para impar*/
        int ip = (orach + guer) % 2;
        if(ip == opcao){
                         
            //Tera ganho            
            return 1;
        }
        else{
            //Tera perdido
            return 2;
        }

    }
    // Prologo caso o guerreiro vença
    String prologoVencedor(){
        return "Você conseguiu, Parabèns!! " + guerr.getNome() + " com essa sua vitória você merece saber,\n"
                + "meu nome não é " + this.nome + ", mas sim Yashiro Samorai. Voce ainda tem " +guerr.vidas + " vidas, então pegarei todas!";
        
    }
    // Prologo caso o guerreiro perca
    String prologoPerdedor(){
        return "Uma pena para você nobre Guerreiro,\n Sua mente se afoga em aflição enquanto o mundo cair sobre você .\nVocê perdeu e cavou sua cova aqui neste lugar.";
    }

    
    boolean decidirVidaExtra(String decisao){
       /*Utilizando o método split() para fragmentar a String  em uma array de strings toda vez que for achado um espaço em branco*/
       String[] separado = decisao.split(" ");
        //Se o tamanho do array for maior que 5 , a vida extra será aprovada
        if (separado.length > 5) {
            return true;
        } else { 
            return false;
        }
    } 
}