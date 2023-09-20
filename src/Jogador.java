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
        return n;
    }
}
