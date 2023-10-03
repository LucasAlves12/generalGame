
public class Campeonato {

    private Jogador[] jogadores;
    private int i;
    private int qtdJogadores;
    private int maxJogadores;

    public Campeonato() {
        this.jogadores = new Jogador[10];
        this.qtdJogadores = 0;
        this.maxJogadores = 10;
    }

    public void incluirJogador(String nome, char tipoJogador) {
        if(qtdJogadores < maxJogadores){
            jogadores[qtdJogadores] = new Jogador(nome, tipoJogador);
            qtdJogadores++;
        }
        else {
            System.out.println("Não é possivel inserir mais jogadores !!!");
        }
    }
    

    public void removerJogador(String nome) {
        int posicaoRemovida = 0;
        for (i = 0; i < this.getQtdJogadores(); i++) {
            if (jogadores[i].getNome() == nome) {
                this.getJogadores()[i] = null;
                posicaoRemovida = i;
                for (i = posicaoRemovida; i < this.getQtdJogadores() - 1; i++) {
                    this.setJogadores(this.getJogadores()[i+1],i); //aqui ta errado
                }
                this.setQtdJogadores(this.getQtdJogadores()-1);

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
                    jogadores[i].mostrarJogadasExecutadas();
                }
            }
        }
    }

    public void mostrarCartela() {
        System.out.println("    -- Cartela de Resultados--");
    }

    public void gravarEmArquivo() {

    }

    public void lerDoArquivo() {

    }

}