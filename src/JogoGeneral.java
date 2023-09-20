public class JogoGeneral {
    
    private Dado[] dados;
    private int[] jogadas;
    private int[] cartela;

    public JogoGeneral(){
        dados = new Dado[5];
        jogadas = new int[13];
        cartela = new int[13];
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

    public int validarJogada(int x){//ta errado
        if (cartela[x] == 0)
            return 0;
        
            cartela[x] = 1;
            return 1;
    } 

    public void pontuarJogada(){

    }
    
}
