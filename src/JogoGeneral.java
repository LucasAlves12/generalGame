public class JogoGeneral {
    
    private Dado[] dados;
    private int[] jogadas;
    //private int[] cartela;
    private int[] cont;

    public JogoGeneral(){
        dados = new Dado[5];
        jogadas = new int[13];
        cont = new int[6];
        //cartela = new int[13];
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

    public int validarJogada(int x){
        for(int i=0;i<5;i++){
            cont[dados[i].getSideUp()-1] += 1;
        }

        switch(x){//fazer a logica de return direto de cada pontuação de cada tipo de jogada
            case 1://13 cases, 13 tipos de jogada
        }


        return 0;
    } 

    public void pontuarJogada(){
        //atualizar o vetor jogadas
    }
    
}
