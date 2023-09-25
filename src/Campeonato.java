
public class Campeonato {

    private Jogador[] jogadores;
    private int i = 0;
    private int qtdJogadores;
    private int maxJogadores = 10;

    public Campeonato() {
        this.jogadores = new Jogador[maxJogadores];
        this.i = 0;
        this.qtdJogadores = 0;
        this.maxJogadores = 10;
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

    public void setJogadores(Jogador[] jogadores) {
        this.jogadores = jogadores;
    }

    public int getQtdJogadores() {
        return qtdJogadores;
    }

    public void setQtdJogadores(int qtdJogadores) {
        this.qtdJogadores = qtdJogadores;
    }

    public void incluirJogador(String nome, char tipoJogador) {
        if (i > maxJogadores) {
            System.out.println("Numero máximo de jogadores atingido");
        }

        else {
            jogadores[i] = new Jogador(nome, tipoJogador);
            this.setQtdJogadores(this.getQtdJogadores() + 1);
            i++;
        }
    }

    public void removerJogador(String nome) {
        int posicaoRemovida = 0;
        for (i = 0; i < this.getQtdJogadores(); i++) {
            if (jogadores[i].getNome() == nome) {
                this.getJogadores()[i] = null;
                posicaoRemovida = i;
                for (i = posicaoRemovida; i < this.getQtdJogadores() - 1; i++) {
                    this.setJogadores(this.getJogadores()); //aqui ta errado
                    this.getQtdJogadores(); //aqui ta errado tbm
                }
            }
        }

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