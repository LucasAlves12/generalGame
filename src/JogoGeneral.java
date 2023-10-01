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
            cont[dados[i].getSideUp()-1]++;
        }

        switch(x){//fazer a logica de return direto de cada pontuação de cada tipo de jogada
            case 1://13 cases, 13 tipos de jogada
                return cont[0]; //jogada de 1
            case 2:
                return cont[1]*2; //jogada de 2
            case 3:
                return cont[2]*3; //jogada de 3
            case 4:
                return cont[3]*4; //jogada de 4
            case 5:
                return cont[4]*5; //jogada de 5
            case 6:    
                return cont[5]*6; //jogada de 6
        }


        return 0;
    } 

    public void pontuarJogada(){
        //atualizar o vetor jogadas
    }
    
}
