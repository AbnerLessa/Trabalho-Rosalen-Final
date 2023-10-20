/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package iptu;
/**
 *
 * @author abner
 */
import java.text.DecimalFormat;

public class IPTU {
    
    public static void main(String[] args) {
        ListaMunicipios list = new ListaMunicipios();
        //Usado para formatar o Dinheiro
        DecimalFormat df = new DecimalFormat("R$ #,##0.00");
        
        //Variaveis do main 
        int cadastro = 0;
        int opcao;
        int escolhaMunicipio;
        int escolhaImovel;
        while (true){
            
            opcao = InOut.leInt("""
                                  Qual opção deseja:
                                  [1]-Municipios
                                  [2]-Imoveis
                                  []- FIM DO PROGRAMA """);

            if(opcao != 1 && opcao!= 2){
                InOut.MsgDeAviso("PROGRAMA", "Encerrado!");
                break;
            }
            
            switch (opcao) {
                // Case para fazer as escolhas/manipular os Municipios
                case 1:
               
                    escolhaMunicipio = InOut.leInt("""
                                            Qual opção deseja:
                                            [1]-Adcionar Municipio
                                            [2]-Remover Municipio
                                            [3]- Listar Municipios
                                            []-Voltar ao Menu""");
                    if(escolhaMunicipio == 1){
                        //Adiciona o Municipio
                        cadastroMunicipio(list);
                        break;
                    } else if(escolhaMunicipio == 2){
                        //Serve para remover o Municipio
                        removerMunicipio(list);
                        break;
                    } else if (escolhaMunicipio == 3) {
                        //Lista os Muncipios já cadastrados
                        InOut.MsgDeInformacao("Lista", listarMunicipios(list));
                        break;
                    } else{
                        //Retorna o Programa ao MENU
                        break;
                    }
                // Case para fazer as escolhas/manipular os Imóveis   
                case 2:
                    //Necessita de pelo menos 1 municipio para Manipular o imovel
                    if(list.listaMunicipio.size() >= 1){
                       
                        escolhaImovel = InOut.leInt("""
                                                [1]-Adcionar Imovel
                                                [2]-Remover Imovel
                                                [3]-Informacoes do imovel
                                                [4]-Listar Imoveis de um municipio
                                                []-Voltar""");
                        switch(escolhaImovel){
                            case 1:
                                //Adcionar o Imóvel
                                adicionarImovel(cadastro, list);
                                cadastro +=10;
                                break;
                            case 2:
                                //Remove o Imóvel
                                removerImovel(list); 
                                break;
                            case 3:
                                //Receber Informações de um imóvel
                                getInfoImovel(list, df);
                                break;
                            case 4:
                                //Listar imóveis de um determinado municipio
                                InOut.MsgDeInformacao("Imovel", getListaImovel(list));
                                break;
                            default:
                                break;
                        }
                    }else{
                        InOut.MsgDeErro("Atenção", "Para criar um imóvel deve haver 1 municipio");
                    }
                    
                default:
                    break;
            }
        }
    }
    // Métodos 
    // Método de Cadastrar o Municipio
    public static void cadastroMunicipio(ListaMunicipios list){
        String nomeMunicipio = InOut.leString("Escreva o nome do Municipio");
        Municipio novoMuni = new Municipio(nomeMunicipio);
        list.cadastrarMunicipios(novoMuni);
        InOut.MsgDeInformacao("Cadastro" , nomeMunicipio + " cadastrado com sucesso!");
    }
    // Método Remover Municipio
    public static void removerMunicipio(ListaMunicipios list){
        String remover = InOut.leString("Digite o nome do municipio para remover:\n" + listarMunicipios(list));
        int i = 0;
        //Se utiliza o verificar para ver se há ou nao um municipio com esse nome
        boolean verificar = false;
        //caso a lista não tenha municipios
        if (list.listaMunicipio.isEmpty()) {
            InOut.MsgDeErro("ERRO!", "Nao há municipios!");
        } else {
            
            for(Municipio m : list.listaMunicipio){//para cada municipio declarado na lista o codigo no for roda
            
                if (m.nome.equals(remover)){
                    //Só pode remover um Municipio caso NAO haja Imoveis atribuidos à ele
                    if(!m.listaImoveis.isEmpty()){
                        InOut.MsgDeErro("ERRO!", "Nao é possivel remover um municipio com Imoveis cadastrados!");
                    }else{
                        //Remove o item de indice = i
                        list.removerMunicipio(i);
                        verificar = true;
                        InOut.MsgDeInformacao("Remover" ,"Municipio removido!");
                        break;
                    }
                }
                i++;
            }
            //(!boolean) Negando o boolean.
            if (!verificar) { 
                InOut.MsgDeErro("ERRO!", "Municipio não encontrado");
            }
        }
    }
    // Método para listar os Municipios
    private static String listarMunicipios(ListaMunicipios list) {
       
        String out = "====================\n";
        int i = 0;
        for(Municipio m : list.listaMunicipio){
            i++;
            out = out + m.nome + "\n";
        }
        out = out + "====================\n";
        return out;
    }

    // Método para adicional o Imóvel
    private static void adicionarImovel(int cadastro, ListaMunicipios list) {
        // Para criar a matricula
        cadastro += 10; 
        Imovel novoIm = new Imovel();
        novoIm.setNomeProprietario(InOut.leString("Qual o nome do proprietário do imovel:"));
        novoIm.setValor(InOut.leDouble("Escreva o valor do imovel a ser cadastrado"));
        novoIm.setImposto(InOut.leDouble("Escreva o imposto em reais do imovel a ser cadastrado"));
        novoIm.setMesesAtraso(InOut.leInt("Escreva a quantidade de meses em atraso do pagamento do imovel:"));
        novoIm.setMulta(novoIm.getMulta());
        String mun = InOut.leString("Escreva o nome do municipio que o imovel sera atribuido: \n" + listarMunicipios(list));
        boolean verificar = false;
        for(Municipio m : list.listaMunicipio){
            //caso o nome do municipio seja encontrado, ele é cadastrado
            if(m.nome.equals(mun)){
                m.cadastroImoveis(novoIm);
                novoIm.matricula = cadastro + novoIm.municipio.nome;
                InOut.MsgDeInformacao("Cadastro Finalizado", "Pronto! A matricula do Imóvel é: ["+ novoIm.matricula +"]");
                verificar = true;
            }  
        }
        //para caso o municipio nao exista.
        if(!verificar){
            InOut.MsgDeErro("ERRO!", "Municipio nao encontrado");
        }
    }
    //Método para Remover o imóvel
    private static void removerImovel(ListaMunicipios list) {
        String municipioNome = InOut.leString("Insira o municipio a qual o imovel pertence: \n" + listarMunicipios(list));
        //verifica se o municipio existe
        boolean verificar2 = false;
        for(Municipio m : list.listaMunicipio){
            if(m.nome.equals(municipioNome)){
                //Caso não tenha imoveis no municipio 
                if(m.listaImoveis.isEmpty()){
                    InOut.MsgDeErro("ERRO!", "Nao possui imoveis neste municipio!");
                }else{
                    //verificar se possui o imóvel
                    boolean verificar = false;
                    String mat = InOut.leString("Escreva o cadastro do imovel que vai ser removido:\n" + getListaImovel(list));
                    for(Imovel im : m.listaImoveis){
                        //caso seja encontrada a matricula 
                        if(im.matricula.equals(mat)){
                            m.removerImovel(im);
                            InOut.MsgDeAviso("Imoveis", "Imovel Removido: ");
                            verificar = true;
                            break;
                        }   
                    }
                    //caso não encontre o imóvel
                    if(!verificar){
                        InOut.MsgDeErro("ERRO!", "Imovel não encontrado");
                    }
                }
                verificar2 = true;
                break;
            }
        }
        //Caso não econtre o municipio
        if(!verificar2){
            InOut.MsgDeErro("ERRO!", "Municipio não encontrado");
        }
    }
    // Método para ter Informações do Imovel
    private static void getInfoImovel(ListaMunicipios list, DecimalFormat df){
        String nomeMun = InOut.leString("Escreva o municipio onde o imovel é cadastrado:\n" + listarMunicipios(list));
        //Não encontrou o municipio
        boolean verificar = false;
        for(Municipio m:list.listaMunicipio){
            if(m.nome.equals(nomeMun)){
                if(m.listaImoveis.isEmpty()){
                    InOut.MsgDeErro("ERRO!", "Este municipio não possui imóveis!");
                }else{
                    String cadImo = InOut.leString("Digite CORRETAMENTE a matricula do imóvel: \n" + setListaImoveis(m));
                   //verifica o imovel
                    boolean verificar2 = false;
                    for(Imovel im:m.listaImoveis){
                        if(im.matricula.equals(cadImo)){
                            InOut.MsgDeInformacao(cadImo, "Nome do Proprietario: " + im.getNomeProp() + "\n"
                                                    + "Valor do imovel: " + df.format(im.getValor()) + "\n"
                                                    + "Imposto: " + df.format(im.getImposto())+ "\n"
                                                    + "Multa: " + df.format(im.getMulta()) + "\n");
                            verificar2 = true;
                            break;
                        }
                    }
                    // Verificar a matricula
                    if(!verificar2){
                        InOut.MsgDeErro("ERRO!", "Matricula de Imovel não encontrada");
                    }
                }
                verificar = true;
            }
        }
        if(!verificar){
            InOut.MsgDeErro("ERRO!", "Municipio não encontrado");
        }
    }
    // Método para listar os Imóveis de um municipio
    private static String getListaImovel(ListaMunicipios list) {
        //listagem de imoveis de um determinado municipio
        String mu = InOut.leString("Escreva o muncipio que deseja listar os Imóveis:\n" + listarMunicipios(list));
        boolean verificar = false;
        String out = "";
        for(Municipio m:list.listaMunicipio){
            if(m.nome.equals(mu)){
                if(m.listaImoveis.isEmpty()){
                    out = "Nao ha imoveis neste municipio";
                }else{
                    out = setListaImoveis(m);
                }
            }
            verificar = true;
        }
        if(!verificar){
            out = "Municipio nao encontrado";    
        }
        return out;
    }
    //Lista dos imoveis em String
    private static String setListaImoveis(Municipio m){
        String listaImovelString;
        listaImovelString = "============================\n";
        for(Imovel im:m.listaImoveis){
            listaImovelString = listaImovelString + im.matricula + "\n";
        }
        listaImovelString = listaImovelString + "============================";
        return listaImovelString;
    }
}