public class Jogador {
    private String nome;
    private char tipoJogador;
    private JogoGeneral jogoG ;

    public Jogador(String nome, char tipoJogador) {
        this.nome = nome;
        this.tipoJogador = tipoJogador;
        jogoG = new JogoGeneral();
    }

    public void jogarDados() {
        jogoG.rolarDados();
    }

    public int escolherJogada(int n) {
        if (jogoG.validarJogada(n) == 1)
            return n;
        else
            return 0;

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

}
