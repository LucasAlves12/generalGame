
public class Campeonato {

    private Jogador[] jogadores;
    private int i;
    private int qtdJogadores;
    private int maxJogadores;

    public Campeonato() {
        this.jogadores = new Jogador[this.getMaxJogadores()];
        this.i = 0;
        this.qtdJogadores = 0;
        this.maxJogadores = 10;
        this.setQtdJogadores(0);
    }

    public void incluirJogador(String nome, char tipoJogador) {
        if (this.getQtdJogadores() < this.getMaxJogadores()) {
            if (tipoJogador == 'H' || tipoJogador == 'h') {
                this.setJogadores(new Jogador(nome,tipoJogador), this.getQtdJogadores());
                this.setQtdJogadores(this.getQtdJogadores() + 1);
            } else if (tipoJogador == 'M' || tipoJogador == 'm') {
                this.setJogadores(new Jogador(nome,tipoJogador), this.getQtdJogadores());
                this.setQtdJogadores(this.getQtdJogadores() + 1);
            } else {
                System.out.println("Tipo de jogador invalido!");
            }
        } else {
            System.out.println("Numero maximo de jogadores atingido!");
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

    }

    public void mostrarCartela() {
        System.out.println("    -- Cartela de Resultados--");
    }

    public void gravarEmArquivo() {

    }

    public void lerDoArquivo() {

    }

}