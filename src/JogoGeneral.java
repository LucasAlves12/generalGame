public class JogoGeneral {
    
    private Dado[] dados;
    private int[] jogadas;

    public JogoGeneral(){
        dados = new Dado[5];
        jogadas = new int[13];
    }

    public void rolarDados(){
        for(int i = 0; i < 5;i++){
            dados[i].roll();
        }
    }

    /*public void toString(){
        for(int i = 0;i < 5;i++)
            System.out.println("Dado "+ i +":" + dado[i].getSideUp());
    }*/

    public void validarJogada(){

    } 

    public void pontuarJogada(){

    }
    
}
