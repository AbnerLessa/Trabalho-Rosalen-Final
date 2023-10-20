/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iptu;
/**
 *
 * @author abner
 */
public class Imovel {
    // Variaveis da classe Imovel
   public String matricula;
   public String nomePro;
   public double imposto;
   public int mesesAtraso;
   public double valor;
   public double multa;
   public Municipio municipio;
    
    public Imovel(){
        
    }
    // Construtor Imovel
    public Imovel(String nomePro, double imposto, int mesesAtraso, Municipio m, String matricula, double juros) {
        this.nomePro = nomePro;
        this.imposto = imposto;
        this.mesesAtraso = mesesAtraso;
        this.valor = valor;
        this.municipio = m;
        this.matricula = matricula;
        this.multa = multa;
    }
    //Método para calcular o juros , será usado o math.pow para exponenciação
   public double calcularMulta(){
        double calculo = 0;
        if(this.mesesAtraso <= 0){
            this.multa = 0;
        }
        else if(this.mesesAtraso > 0 && this.mesesAtraso <= 5){
            
            calculo = Math.pow((1.01),this.mesesAtraso);
            System.out.println("<=5");
            this.multa = this.imposto * calculo;
        }
        else if(this.mesesAtraso > 5 && this.mesesAtraso <= 8){
            calculo = Math.pow((1.023),this.mesesAtraso);
            System.out.println("<=8");
            this.multa = this.imposto * calculo;
        }
        else if(this.mesesAtraso > 8 && this.mesesAtraso <= 10){
            calculo = Math.pow((1.03),this.mesesAtraso);
            System.out.println("<=10");
            this.multa = this.imposto * calculo;
        }
        else if(this.mesesAtraso > 10 && this.mesesAtraso <= 12){
            calculo = Math.pow((1.054),this.mesesAtraso);
            System.out.println("<=12");
            this.multa = this.imposto * calculo;
        }
        else if(this.mesesAtraso > 12){
            calculo = Math.pow(1.1,this.mesesAtraso);
            System.out.println(">12");
            this.multa = this.imposto * calculo;
        }
        return multa;
    }
    
    // Os métodos Set e Get
    void setMunicipio(Municipio m){
       this.municipio = m;
    }
    
    void setNomeProprietario(String val){
        this.nomePro = val;
    }
    
    void setValor(double val){
        this.valor = val;
    }
    
    void setImposto(double val){
        this.imposto = val;
    }
    
    void setMesesAtraso(int val){
        this.mesesAtraso = val;
    }
    
    void setMulta(double val){
        this.multa = val;
    }
    
    String getNomeProp(){
        return this.nomePro;
    }
    
    double getImposto(){
        return this.imposto;
    }
    
    double getValor(){
        return this.valor;
    }
    
    double getMulta(){
        this.multa = calcularMulta();
        return this.multa;
    }
}