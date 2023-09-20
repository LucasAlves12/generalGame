public class JogoGeneral {
    
    private Dados[] dado;
    private int[] jogadas;

    public JogoGeneral(){
        dado = new Dados[5];
        jogadas = int[13];
    }

    public void rolarDados(){
        for(i = 0; i < 5;i++){
            dado[i].roll();
        }
    }

    public String toString(){

        for(i = 0;i < 5;i++)
            System.out.println("Dado "+ i +":" + getSideUp());
    }

    public void validarJogada(){

    } 

    public void pontuarJogada(){

    }
    
}
