import java.io.Serializable;

public class Jogador implements Serializable{
    private String nome;
    private char tipoJogador;
    private JogoGeneral jogoG;

    //Construtor da classe
    public Jogador() {
        this.nome = "noName";
        this.tipoJogador = '-';
    }

    //Construtor da classe carregado com os dados do jogador
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

    //metodo para logica da maquina
    public int maquina(){
        int maior = 0;
        int jogadaEscolhida = 0;
        for(int i = 0;i < 13;i++){
            if(jogoG.getPontuacao(i) == -1){
                if(getValidaJogada(i+1) > maior){
                    maior = getValidaJogada(i+1);
                    jogadaEscolhida = i+1;
                }
            }
        }

        if(jogadaEscolhida==0){ // se todas as jogadas ja foram feitas
            for(int i=12; i>=0;i--){
                if(jogoG.getPontuacao(i) == -1){
                    jogadaEscolhida = i+1;
                    break;
                }
            }

        }


        return jogadaEscolhida;
    }

    //metodo para zerar as jogadas
    public void zerarJogadas(){
        for(int i = 1;i <= 13;i++){
            jogoG.pontuarJogada(i, -1);
        }
    }
}
