

public class Campeonato{

    private Jogador[] jogadores;
    private int i;

    public Campeonato(){
        jogadores = new Jogador[10];
        i = 0;
    }

    public void incluirJogador(String nome,String tipoJogador){
        if( i > 9){System.out.println("Numero máximo de jogadores atingido");}
        
        else{jogadores[i] = new Jogador(nome,tipoJogador);i++;}
        
    }
    public void iniciarCampeonato(){

    }

    public void mostrarCartela(){
        System.out.println("    -- Cartela de Resultados--");
    }

    public void gravarEmArquivo(){

    }

    public void lerDoArquivo(){

    }






}