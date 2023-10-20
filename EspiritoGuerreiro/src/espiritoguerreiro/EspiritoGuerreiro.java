/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package espiritoguerreiro;

/**
 *
 * @author abner
 */
public class EspiritoGuerreiro {
    public static void main(String[] args) {
        //Cria o objeto oracu
        Oraculo oracu = new Oraculo(); 
        //Variavel para verificar se ja foi ganho vida extra por fase
        boolean verifica = true;
        //Variavel para retornar o resultado da chance extra 
        boolean chance;
        //Variavel para se ocorrer do jogador morrer na primeira fase e dar FIM DE JOGO
        boolean fimJogo = false; 
        InOut.MsgDeInformacao("JOGO", "Bem vindo ao desafio do Yashiro Samorai.\n Que você consiga completar, Boa sorte..");
        // Nomeia o Oraculo
        oracu.setOraculoNome();
        // Nomeia o Guerreiro
        oracu.guerr.setGuerNome();
        //Instancia a vida guerreiro
        int vidas = oracu.setVidas();
        //Prologo do Jogo
        InOut.MsgDeInformacao("PROLOGO", oracu.prologoFase1());
        //Início da Fase 1
        InOut.MsgDeAviso("JOGO", "Fase 1 começou, de olho no Gragas!");
        //Coloca um while para o jogador poder jogar novamente
        while (true){
            int numSort = oracu.Fase1();
            InOut.MsgDeInformacao("Gragas", "Eu sou o gragas e tenho uma pergunta,\n"
                                                     + "Advinhe o número que estou pensando ou morra em minhas mãos!!");
            while(true){
                System.out.println(vidas);
                //Se as vidas acabaram ele verifica
                if(vidas <= 0){
                    if(verifica){
                        //Pelo guerreiro ter sido criado pelo oraculo, ele só pode ser chamado pelo objeto oracu
                        chance = oracu.decidirVidaExtra(oracu.guerr.vidaExtra());
                        if(chance){
                            // Vida extra ao jogador
                            InOut.MsgDeAviso("Oraculo", "Você ganhou uma nova chance, Boa sorte!!");
                            vidas = 1;
                            // Nega a vida extra
                            verifica = false;
                        }
                      //Caso ja tenha recebido a vida extra ele não pode receber outra
                    }else{
                        InOut.MsgDeAviso("Oraculo", "Você já teve uma nova chance. Por isso , aqui se encerra sua jornada...");
                        InOut.MsgDeInformacao("Oraculo", oracu.prologoPerdedor());
                        //Liga o FIM DE JOGO
                        fimJogo = true;
                       //Termina o jogo na primeira fase
                        break;
                    }
                }
                //Aqui o jogador tenta adivinhar o numero de 1 a 100
                int advinhar = InOut.leInt("Tente advinhar o numero de 1 a 100");
                //caso o numero secreto for maior o jogador perde 1 vida
                if(advinhar >= 0 && advinhar < numSort){
                    InOut.MsgDeInformacao("Oraculo", "Segredo é MAIOR que o palpite");
                    vidas--;
                }
                //caso o numero secreto for menor o jogador perde 1 vida
                else if(advinhar <= 100 && advinhar > numSort){
                    InOut.MsgDeInformacao("Oraculo", "Segredo é MENOR que o palpite");
                    vidas--;
                }
                //Caso o advinhe o número 
                else if(advinhar == numSort){
                    InOut.MsgDeInformacao("Gragas", "Como isso foi acontecer !!! mas aceito que fui derrotado...");
                    InOut.MsgDeAviso("Historia", "Gragas o glacinata demonstrava raiva e ódio em suas expressões,\n"
                                                      + "explode seu barril em si mesmo e acaba morrendo...\n"
                                                      + "Voce segue seu caminho em sua jornada ...");
                    oracu.guerr.setVidas(vidas);
                    break;
                }
                 // Caso o jogador tente adivinhar um numero muito distante ele perde 2 vidas
                else{
                    InOut.MsgDeErro("Gargola", "Tolo!!! Como você pode achar isso?");
                    InOut.MsgDeAviso("Oraculo", "Voce perdeu 2 vidas por ter escolhido um numero impossivel...");
                    vidas = vidas - 2;
                }
                
            }
            //caso voce tenha morrido na primeira fase, quebra o loop e o jogador não pode jogar denovo
            if(fimJogo){
                break;
            }
            else{
                 //Reseta a vida extra, sendo 1 por fase
                verifica = false;
                InOut.MsgDeInformacao("Oraculo", oracu.prologoFase2());
                InOut.MsgDeAviso("JOGO", "Fase 2 começou, cuidado com o poderoso Braum !");
                InOut.MsgDeInformacao("Braum", "Eu sou o poderoso Braum, destemido e bravo em minha vida .\n"
                        + "Me derrote no impar e par e sobrevivera para contar a história!");
                //Loop while da fase 2
                while(true){
                   //Mesma verificação de vidas da fase 1
                    if(vidas <=0){
                        if(verifica){
                            chance = oracu.decidirVidaExtra(oracu.guerr.vidaExtra());
                            if(chance){
                                InOut.MsgDeAviso("Oraculo", "Com essa nova vida você retorna , e tera uma nova chance");
                                verifica = false;
                                vidas = 1;
                            }
                        }else{
                            InOut.MsgDeAviso("Oraculo", "Você já teve uma nova chance. Por isso , aqui se encerra sua jornada...");
                            InOut.MsgDeInformacao("Oraculo", oracu.prologoPerdedor());
                            fimJogo = true;
                            break;
                        }
                    }
                    else{
                        int escolha = oracu.Fase2(InOut.leInt("Faça sua escolha: \n [0]-Impar \n [1]-Par"));
                         //caso a escolha seja errada perde todas as vidas
                        if(escolha == 0){
                            InOut.MsgDeErro("Braum", "Fraco, sem coragem , sem Atitude!\n"
                                    + "Por tal atitute você morrerá aqui!!");
                            InOut.MsgDeAviso("Oraculo", "Voce perdeu todas as vidas por ter tomado tal decisão......");
                            vidas = 0;
                        }
                        // Caso o jogador ganhe
                        else if(escolha == 1){
                            InOut.MsgDeAviso("Braum", "Parabéns, voce conseguiu o premio. O coração.\n"
                                    + "O verdadeiro desafio Yashiro Samorai é ter consideração e saber o certo a se fazedr...");
                            InOut.MsgDeAviso("Oraculo", oracu.prologoVencedor());
                            InOut.MsgDeInformacao("Historia", "O Oraculo tirou todas as vidas de " + oracu.guerr.getNome() + " e a levou para sua terra.\n"
                                    + "Agora seu corpo era vazio, e Braum se perguntou \n"
                                    + "Seria o coração o musculo mais forte??");
                            break;
                        }
                        //Caso erre perde uma vida
                        else{
                            InOut.MsgDeAviso("Oraculo", "Você errou \n você perdeu uma vida..");
                            vidas--;
                        }
                    }
                }    
            }
            int escolhaJogo = InOut.leInt( "FIM DE JOGO!\nDeseja jogar novamente?\n[]-Sim\n[1]-Não");
            if(escolhaJogo == 1){
                break;
            }else{
                InOut.MsgDeInformacao("JOGO", "O Jogo recomeçou!");
            }
        }
        InOut.MsgDeAviso("JOGO", "Jogo acabou!");
    }
    
}
