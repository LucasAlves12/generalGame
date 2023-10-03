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
        System.out.println("\nRolando dados para" + this.nome + " (" + tipoJogador + ")...");
        jogoG.rolarDados();
    }

    public int escolherJogada(int n) {
        if (jogoG.validarJogada(n) != 0)
            return n;
        else
            return 0;
    }

    public void mostrarJogadasExecutadas(){
        //jogadas possiveis
        System.out.println("1\t2\t3\t4\t5\t6\t7(T)\t8(Q)\t9(F)\t10(S+)\t11(S-)\t12(G)\t13(X)");
        
        //jogadas executadas 
        for(int i = 0; i < 13; i++){
            if(jogoG.validarJogada(i) != 0){
                 System.out.print(jogoG.validarJogada(i) + "\t");
            }
            else{
                System.out.print("-\t");
            }
        }
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
