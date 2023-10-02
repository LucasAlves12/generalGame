public class JogoGeneral {

    private Dado[] dados;
    private int[] jogadas;
    // private int[] cartela;
    private int[] cont;

    public JogoGeneral() {
        dados = new Dado[5];
        jogadas = new int[13];
        cont = new int[6];
        // cartela = new int[13];
    }

    public void rolarDados() {
        for (int i = 0; i < 5; i++) {
            dados[i].roll();
        }
    }

    /*
     * public void toString(){
     * for(int i = 0;i < 5;i++)
     * System.out.println("Dado "+ i +":" + dado[i].getSideUp());
     * }
     */

    public int validarJogada(int x) {
        for (int i = 0; i < 5; i++) {
            cont[dados[i].getSideUp() - 1]++;
        }
        int soma = 0;//para opções 7 e 8
        int valida = 0;

        switch (x) {// fazer a logica de return direto de cada pontuação de cada tipo de jogada
            case 1:// 13 cases, 13 tipos de jogada
                return cont[0]; // jogada de 1
            case 2:
                return cont[1] * 2; // jogada de 2
            case 3:
                return cont[2] * 3; // jogada de 3
            case 4:
                return cont[3] * 4; // jogada de 4
            case 5:
                return cont[4] * 5; // jogada de 5
            case 6:
                return cont[5] * 6; // jogada de 6

            case 7:        //trinca
                for (int i = 0; i < 5; i++) {
                    soma += cont[i] * (i + 1);
                    if (cont[i] >= 3)
                        valida = 1;
                }
                if (valida == 1)
                    return soma;
                    // jogada inválida não tem trinca
                return 0;

            case 8:       //Quarteto         
                for (int i = 0; i < 5; i++) {
                    soma += cont[i] * (i + 1);
                    if (cont[i] >= 4)
                        valida = 1;
                }
                if (valida == 1)
                    return soma;
                    // jogada inválida não tem quarteto
                return 0;
                
            case 9://Full-hand: trinca e par, vale 25
                for (int i = 0; i < 5; i++)
                    if(cont[i] == 3)
                        valida += 2;
                    else if(cont[i] == 2)
                        valida += -1;
                
                if(valida == 1)
                    return 25;
                return 0;

            case 10:
                for (int i = 1; i < 5; i++)//começa do numero 2
                    if(cont[i] == 0)
                        return 0;
                
                return 30;
                 
            case 11:
                for (int i = 0; i < 4; i++)//começa do numero 1 e vai até o 5
                    if(cont[i] == 0)
                        return 0;
                
                return 40;

            case 12: //general
                for(int i = 0;i < 5;i++)
                    if(cont[i] == 5)
                        return 50;
                
                return 0;

            case 13: //jogada aleatória
                for(int i = 0;i < 5;i++){
                    soma += cont[i]*(i+1);
                }
                return soma;
        }
        return 0;
        
    }

    public void pontuarJogada() {
        // atualizar o vetor jogadas
    }

}
