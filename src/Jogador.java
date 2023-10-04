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

    public void escolherJogada() {
        int pontuacao;
        //jogadas possiveis
        System.out.println("1\t2\t3\t4\t5\t6\t7(T)\t8(Q)\t9(F)\t10(S+)\t11(S-)\t12(G)\t13(X)");
        
        //jogadas executadas 
        for(int i = 0; i < 13; i++){
            if(jogoG.getPontuacao(i) != -1){
                 System.out.print(jogoG.getPontuacao(i) + "\t");
            }
            else{
                System.out.print("-\t");
            }
        }
        System.out.println("\nEscolha uma jogada: ");
        int jogadaEscolhida = teclado.nextInt();    
        
        if(jogoG.getJogada(jogadaEscolhida) == -1){
            pontuacao = jogoG.validarJogada(jogadaEscolhida);
        }
        else{
            do{
                System.out.println("Jogada já executada, escolha outra jogada: ");
                jogadaEscolhida = teclado.nextInt();
            }while(jogoG.getJogada(jogadaEscolhida) != -1);
            
            pontuacao = jogoG.validarJogada(jogadaEscolhida);
        }

        jogoG.pontuarJogada(jogadaEscolhida, pontuacao);

    }

    public void mostrarJogadasExecutadas(){
        
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
