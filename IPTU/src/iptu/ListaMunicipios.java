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
// Classe para criado para ser uma Lista de Municipios
public class ListaMunicipios {
    
    List<Municipio> listaMunicipio;
    // Cadastra os Municipios
    void cadastrarMunicipios(Municipio m){
        listaMunicipio.add(m);
    }
    // Cria a Lista de Municipios
    public ListaMunicipios(){
        listaMunicipio = new ArrayList<>();
    }
    // Serve para remover Municipio da Lista
    void removerMunicipio(int n){
        listaMunicipio.remove(n);
    }

}
