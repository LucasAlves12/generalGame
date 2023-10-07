import java.io.Serializable;
import java.util.Random;


public class Jogador {
    private String nome;
    private char tipoJogador;
    private JogoGeneral jogoG;



    public Jogador(String nome, char tipoJogador) {
        this.nome = nome;
        this.tipoJogador = tipoJogador;
        jogoG = new JogoGeneral();
    }

    public void jogarDados() {
        System.out.println("\nRolando dados para " + nome + " (" + tipoJogador + ")...");
        jogoG.rolarDados();
    }

  

    public int getValidaJogada(int jogadaEscolhida) {
        return jogoG.validarJogada(jogadaEscolhida);
    } 

    public void getPontuaJogada(int jogadaEscolhida, int pontuacao) {
        jogoG.pontuarJogada(jogadaEscolhida, pontuacao);
    }

    public int getJogada(int x) {
        return jogoG.getJogada(x);
    }

    public int getPontuacao(int x) {
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

    public int maquina(){
        Random r = new Random();
        return r.nextInt(13)+1;
    }

}
