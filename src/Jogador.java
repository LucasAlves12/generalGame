public class Jogador {
    private String nome;
    private String tipoJogador;
    private JogoGeneral jogoG;

    public Jogador(String nome, String tipoJogador){
        this.nome=nome;
        this.tipoJogador=nome;
        jogoG = new JogoGeneral(); 
    }

    public void jogarDados(){
        jogoG.rolarDados();
    }
    
    public int escolherJogada(int n){
        if(jogoG.validarJogada(n) == 1)
            return n;
        else
            return 0;

    }


    
}
