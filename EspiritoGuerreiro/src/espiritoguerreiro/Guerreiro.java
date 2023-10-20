/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package espiritoguerreiro;

/**
 *
 * @author abner
 */
public class Guerreiro {
    String nome;
    int vidas;
    
    public Guerreiro() {
    }
    
    //Método para setar o nome
    void setGuerNome(){
        //Setar o nome do guerreiro
        this.nome = InOut.leString("Me diga o seu nome: ");
    }
   // Método getVidas
    int getVidas(){
        //Retornar as vidas
        return vidas;
    }
    
    String getNome(){
        //Retorna o nome
        return nome;
    }
    // Método para setar as vidas
    void setVidas(int vidas){
        //setando as vidas do guerreiro
        this.vidas = vidas;
    }
    
    String vidaExtra(){
    String s = InOut.leString("Acabaram suas vidas, sua morte é certa...\n"
                            + "Mas caso suplique ,talvez uma nova chance irá ganhar!");
    return s;
}
}


