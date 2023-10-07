import java.io.Serializable;



public class Jogador {
    private String nome;
    private char tipoJogador;
    private JogoGeneral jogoG;
    private Scanner teclado = new Scanner(System.in);


    public Jogador(String nome, char tipoJogador) {
        this.nome = nome;
        this.tipoJogador = tipoJogador;
        jogoG = new JogoGeneral();
    }

    public void jogarDados() {
        System.out.println("\nRolando dados para " + nome + " (" + tipoJogador + ")...");
        jogoG.rolarDados();
    }

  

    public int setValidaJogada(int jogadaEscolhida) {
        return jogoG.getJogada(jogadaEscolhida);
    } 

    public void getPontuaJogada(int jogadaEscolhida, int pontuacao) {
        jogoG.pontuarJogada(jogadaEscolhida, pontuacao);
    }

    public int setJogada(int x) {
        return jogoG.getJogada(x);
    }

    public int setPontuacao(int x) {
        return jogoG.getPontuacao(x);
    }

    public char getTipoJogador() {
        return tipoJogador;
    }

    public void setTipoJogador(char tipoJogador) {
        this.tipoJogador = tipoJogador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getPontuacaoRodadaX(int x){
            return jogoG.getPontuacao(x);
    }
    public int getTotal(){
        int soma = 0;
        for(int i = 0;i < 13;i++){
            soma += jogoG.getPontuacao(i); 
        }
        return soma;
    }

}
