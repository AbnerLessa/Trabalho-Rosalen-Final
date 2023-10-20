/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iptu;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author abner
 */
public class Municipio {
    String nome;
    List<Imovel> listaImoveis;
    
    public Municipio(String nome) {
        this();
        this.nome = nome;
    }
    // Realiza o cadastro do Imovel no municipio
    void cadastroImoveis(Imovel im){
        
        listaImoveis.add(im);
        im.setMunicipio(this);
    }
    
    public Municipio(){
        listaImoveis = new ArrayList<>();
    }
    // Remove o Imovel da lista
    void removerImovel(Imovel im){
        listaImoveis.remove(im);
    }
}
