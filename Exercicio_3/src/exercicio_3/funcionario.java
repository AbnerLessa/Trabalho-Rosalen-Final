/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio_3;
/**
 *
 * @author Arthur
 */
public class funcionario {
    String nome;
    int matricula;
    loja lj;
    public funcionario(String nome, int matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }
    
    public funcionario(){
    
    }
    
    
    
    public void associarFuncNome(String nome){
       this.nome = nome;
    }
    
     public void associarFuncMA(int matricula){
        this.matricula = matricula;
     }
     
   public int voltarMatricula(){
     return this.matricula;
   }
   
   public String voltarNome(){
     return this.nome;
   }
   void associarLoja(loja lj){
       this.lj = lj;
     }
    
    
    
}