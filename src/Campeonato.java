import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Campeonato {

    private Jogador[] jogadores;
    private int i;
    private int qtdJogadores;
    private int maxJogadores;
    private File arq;
    private Scanner teclado;

    //Construtor, limite de 10 jogadores na partida
    public Campeonato() {
        this.jogadores = new Jogador[10];
        this.qtdJogadores = 0;
        this.maxJogadores = 10;
        this.arq = new File("jogoGeneral.dat");
        this.teclado = new Scanner(System.in);
    }

    //adiciona o jogador informado pelo usuário e seu tipo também
    public void incluirJogador() {
        char p;

        System.out.println("Insira seu nome: ");
        String nome = teclado.nextLine();

        do {
            System.out.println("Tipo de jogador (H - humano ou M - maquina):");
            p = teclado.nextLine().toUpperCase().charAt(0);
        } while (p != 'H' && p != 'M');

        if (qtdJogadores < maxJogadores) {
            jogadores[qtdJogadores] = new Jogador(nome, p);
            qtdJogadores++;
        } else {
            System.out.println("Não é possivel inserir mais jogadores !!!");
        }
    }

    //Remove o jogador pelo nome digitado pelo usuário
    public void removerJogador() {
        int posicaoRemovida = 0;
        String nomeAux; // variavel para remover pelo nome
        int aux;

        

        System.out.println("Informe o nome da pessoa que deseja remover:");
        nomeAux = teclado.nextLine();
        teclado.nextLine();
        for (i = 0; i < qtdJogadores; i++) {
            if (jogadores[i].getNome().equals(nomeAux)) {
                jogadores[i] = null;
                posicaoRemovida = i;
                aux = qtdJogadores;
                for (i = posicaoRemovida; i < aux - 1; i++) {
                    jogadores[i] = jogadores[i + 1];
                }
                qtdJogadores--;

                System.out.println("Jogador removido!\n");
            }
        }

    }

    //Inicar campeonato: metódo em que o campeonato é inicializado e as rodadas ão executadas
    public void iniciarCampeonato() {
        int pontuacao;
        int jogadaEscolhida;
        int auxjogada;


        for(int i=0; i<qtdJogadores; i++) {
            jogadores[i].zerarJogadas();
        }

        if (qtdJogadores == 0) {
            System.out.println("Não há jogadores suficientes para iniciar o campeonato"); // se não houver jogadores suficientes
        }
        else {

            for (int rodada = 0; rodada < 13; rodada++) {
                for (int i = 0; i < qtdJogadores; i++) {
                    jogadores[i].jogarDados();

                    if (jogadores[i].getTipoJogador() == 'H') {

                        // jogadas possiveis
                        System.out.println("1\t2\t3\t4\t5\t6\t7(T)\t8(Q)\t9(F)\t10(S+)\t11(S-)\t12(G)\t13(X)");

                        // jogadas executadas
                        for (int j = 0; j < 13; j++) {
                            auxjogada = jogadores[i].getPontuacao(j);
                            if (auxjogada != -1) {
                                System.out.print(auxjogada + "\t");
                            } else {
                                System.out.print("-\t");
                            }
                        }
                        do {
                            System.out.println("\nEscolha uma jogada: ");
                            jogadaEscolhida = teclado.nextInt();
                        } while (jogadaEscolhida < 1 || jogadaEscolhida > 13);

                        if (jogadores[i].getPontuacao(jogadaEscolhida-1) == -1) {
                            pontuacao = jogadores[i].getValidaJogada(jogadaEscolhida);
                        } else {
                            do {
                                System.out.println("Jogada já executada, escolha outra jogada: ");
                                jogadaEscolhida = teclado.nextInt();
                            } while (jogadores[i].getPontuacao(jogadaEscolhida-1) != -1);

                            pontuacao = jogadores[i].getValidaJogada(jogadaEscolhida);
                        }

                        jogadores[i].getPontuaJogada(jogadaEscolhida, pontuacao);

                    } else if (jogadores[i].getTipoJogador() == 'M') {
                    
                         int   jogadaMaquina = jogadores[i].maquina();
                     

                        System.out.println("Jogada escolhida por " + jogadores[i].getNome() + " (M): " + jogadaMaquina);

                        pontuacao = jogadores[i].getValidaJogada(jogadaMaquina);
                        jogadores[i].getPontuaJogada(jogadaMaquina, pontuacao);

                        // jogadas possiveis
                        System.out.println("1\t2\t3\t4\t5\t6\t7(T)\t8(Q)\t9(F)\t10(S+)\t11(S-)\t12(G)\t13(X)");

                        // jogadas executadas
                        for (int j = 0; j < 13; j++) {
                            auxjogada = jogadores[i].getPontuacao(j);
                            if (auxjogada != -1) {
                                System.out.print(auxjogada + "\t");
                            } else {
                                System.out.print("-\t");
                            }
                        }
                        System.out.println("\n");
                    }
                }

            }

        }
    }

    //Mostra a pontuação do ultimo jogo executado
    public void mostrarCartela() {
        System.out.println("----- Cartela de Resultados -----\n");
        System.out.printf("%s", "\t");

        for (i = 0; i < qtdJogadores; i++)
            System.out.printf("%s", "\t" + jogadores[i].getNome() + "(" + jogadores[i].getTipoJogador() + ")\t");
        System.out.println();

        for (i = 1; i <= 13; i++)

        {
            if (i <= 6)
                System.out.printf("%s", i + "\t");
            else if (i == 7)
                System.out.printf("%s", i + "(T)\t");
            else if (i == 8)
                System.out.printf("%s", i + "(Q)\t");
            else if (i == 9)
                System.out.printf("%s", i + "(F)\t");
            else if (i == 10)
                System.out.printf("%s", i + "(S+)\t");
            else if (i == 11)
                System.out.printf("%s", i + "(S-)\t");
            else if (i == 12)
                System.out.printf("%s", i + "(G)\t");
            else if (i == 13)
                System.out.printf("%s", i + "(X)\t");

            for (int j = 0; j < qtdJogadores; j++) {
                System.out.printf("%s", "\t" + jogadores[j].getPontuacao(i - 1) + "\t");

            }
            System.out.println();
        }
        for(int i=0;i<qtdJogadores;i++){
            System.out.print("---------------------");
        }
        System.out.print("\nTotal\t");

        for (i = 0; i < qtdJogadores; i++) {
            System.out.print("\t" + jogadores[i].getTotal() + "\t");
        }
        System.out.println("\n");
    }


    //grava em arquivo .dat a rodada executada
    public void gravarEmArquivo() {
        try {
            FileOutputStream fout = new FileOutputStream(arq);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            // gravando o vetor de pessoas no arquivo
            oos.writeObject(jogadores);
            oos.flush();
            oos.close();
            fout.close();

            System.out.println("Dados gravados com sucesso!\n");
        } catch (Exception ex) {
            System.err.println("erro: " + ex.toString());
        }

    }

    //le os dados do arquvo .dat
    public void lerDoArquivo() {
        try {
            FileInputStream fin = new FileInputStream(arq);
            ObjectInputStream oin = new ObjectInputStream(fin);

            // Lendo os objetos de um arquivo e fazendo a coercao de tipos

            Jogador[] jogaArq = (Jogador[]) oin.readObject();
            oin.close();
            fin.close();
            jogadores = jogaArq;
            qtdJogadores = 0;
            
            for(Jogador j : jogadores) {
                if(j != null) {
                    qtdJogadores++;
                }
            }

            System.out.println("Dados lidos com sucesso!\n");
        } catch (Exception ex) {
            System.err.println("erro: " + ex.toString());
        }

    }

}