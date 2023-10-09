import java.io.Serializable;
import java.util.Random;


public class Jogador implements Serializable{
    private String nome;
    private char tipoJogador;
    private JogoGeneral jogoG;



    //Construtor da classe
    public Jogador(String nome, char tipoJogador) {
        this.nome = nome;
        this.tipoJogador = tipoJogador;
        jogoG = new JogoGeneral();
    }


    //sorteia os 5 números da rodada
    public void jogarDados() {
        System.out.println("\nRolando dados para " + nome + " (" + tipoJogador + ")...");
        jogoG.rolarDados();
    }

  
    //Valida se a jogada está dentro das regras do jogo
    public int getValidaJogada(int jogadaEscolhida) {
        return jogoG.validarJogada(jogadaEscolhida);
    } 

    public void getPontuaJogada(int jogadaEscolhida, int pontuacao) {
        jogoG.pontuarJogada(jogadaEscolhida, pontuacao);
    }

    
    //getters da classe
    public int getPontuacao(int x) {
        return jogoG.getPontuacao(x);
    }

    public char getTipoJogador() {
        return tipoJogador;
    }

    public String getNome() {
        return nome;
    }

    public int getTotal(){
        int soma = 0;
        for(int i = 0;i < 13;i++){
            soma += jogoG.getPontuacao(i); 
        }
        return soma;
    }

    //Se for um jogador maquina é necessário criar um eandom e o sorteio de 1 a 13 
    //do numero int que é gerado para a escolha do numero da cartela
    public int maquina(){
        Random r = new Random();
        return r.nextInt(13)+1;
    }

    public void zerarJogadas(){
        for(int i = 1;i <= 13;i++){
            jogoG.pontuarJogada(i, -1);
        }
    }
}
