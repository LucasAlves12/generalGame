import java.util.Scanner;



public class Campeonato {

    private Jogador[] jogadores;
    private int i;
    private int qtdJogadores;
    private int maxJogadores;
    private Scanner teclado = new Scanner(System.in);


    public Campeonato() {
        this.jogadores = new Jogador[10];
        this.qtdJogadores = 0;
        this.maxJogadores = 10;
    }

    public void incluirJogador() {
        System.out.println("Insira seu nome: ");
                    String nome = teclado.nextLine();
                    //teclado.nextLine();
                    System.out.println("Tipo de jogador (H - humano ou M - maquina):");
                    char p = teclado.nextLine().charAt(0);

        if(qtdJogadores < maxJogadores){
            jogadores[qtdJogadores] = new Jogador(nome, p);
            qtdJogadores++;
        }
        else {
            System.out.println("Não é possivel inserir mais jogadores !!!");
        }
    }
    

    public void removerJogador() {
        int posicaoRemovida = 0;
        String nomeAux; // variavel para remover pelo nome
        int aux;

        System.out.println("Informe o nome da pessoa que deseja remover:");
                    nomeAux = teclado.nextLine();
                    teclado.nextLine();
        for (i = 0; i < qtdJogadores; i++) {
            if (jogadores[i].getNome() == nomeAux) {
                jogadores[i] = null;
                posicaoRemovida = i;
                aux=qtdJogadores;
                for (i = posicaoRemovida; i < aux - 1; i++) {
                    jogadores[i] = jogadores[i+1]; //aqui ta errado
                }
                qtdJogadores--;

                System.out.println("Jogador removido!\n");
            }
        }

    }

    public int getMaxJogadores() {
        return maxJogadores;
    }

    public void setMaxJogadores(int maxJogadores) {
        this.maxJogadores = maxJogadores;
    }

    public Jogador[] getJogadores() {
        return jogadores;
    }

    public void setJogadores(Jogador jogadores, int pos) {
        this.jogadores[pos] = jogadores;
    }

    public int getQtdJogadores() {
        return qtdJogadores;
    }

    public void setQtdJogadores(int qtdJogadores) {
        this.qtdJogadores = qtdJogadores;
    }


    public void iniciarCampeonato() {
        if(qtdJogadores==0){
            System.out.println("Não há jogadores suficientes para iniciar o campeonato");
        }
        else{
            for(int rodada=0; rodada<13;rodada++){
                for(int i=0;i<qtdJogadores;i++){
                    jogadores[i].jogarDados();
                    jogadores[i].escolherJogada();

                }
            }
        }
    }

    public void mostrarCartela() {
        System.out.println("-- Cartela de Resultados--");
    }

    public void gravarEmArquivo() {

    }

    public void lerDoArquivo() {

    }

}