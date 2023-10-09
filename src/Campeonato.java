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
    private File arq = new File("jogoGeneral.dat");
    private Scanner teclado = new Scanner(System.in);

    public Campeonato() {
        this.jogadores = new Jogador[10];
        this.qtdJogadores = 0;
        this.maxJogadores = 10;
    }

    public void incluirJogador() {
        char p;

        System.out.println("Insira seu nome: ");
        String nome = teclado.nextLine();

        do {
            System.out.println("Tipo de jogador (H - humano ou M - maquina):");
            p = teclado.nextLine().charAt(0);
        } while (p != 'H' && p != 'M');

        if (qtdJogadores < maxJogadores) {
            jogadores[qtdJogadores] = new Jogador(nome, p);
            qtdJogadores++;
        } else {
            System.out.println("Não é possivel inserir mais jogadores !!!");
        }
    }

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

    public int getMaxJogadores() {
        return maxJogadores;
    }

    public void setMaxJogadores(int maxJogadores) {
        this.maxJogadores = maxJogadores;
    }

    public Jogador[] getJogadores() {
        return jogadores;
    }

    public void setJogadores(Jogador jogadores, int pos) {
        this.jogadores[pos] = jogadores;
    }

    public int getQtdJogadores() {
        return qtdJogadores;
    }

    public void setQtdJogadores(int qtdJogadores) {
        this.qtdJogadores = qtdJogadores;
    }

    public void iniciarCampeonato() {
        int pontuacao;
        int jogadaEscolhida;
        int auxjogada;

        if (qtdJogadores == 0) {
            System.out.println("Não há jogadores suficientes para iniciar o campeonato");
        } else {

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

                        if (jogadores[i].getJogada(jogadaEscolhida) == -1) {
                            pontuacao = jogadores[i].getValidaJogada(jogadaEscolhida);
                        } else {
                            do {
                                System.out.println("Jogada já executada, escolha outra jogada: ");
                                jogadaEscolhida = teclado.nextInt();
                            } while (jogadores[i].getJogada(jogadaEscolhida) != -1);

                            pontuacao = jogadores[i].getValidaJogada(jogadaEscolhida);
                        }

                        jogadores[i].getPontuaJogada(jogadaEscolhida, pontuacao);

                    } else if (jogadores[i].getTipoJogador() == 'M') {
                        int jogadaMaquina = 1;
                        do {
                            jogadaMaquina = jogadores[i].maquina();
                        } while (jogadores[i].getJogada(jogadaMaquina) != -1);

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

    public void mostrarCartela() {
        System.out.println("----- Cartela de Resultados -----\n");
        System.out.printf("%s", "\t");

        for (i = 0; i < qtdJogadores; i++)
            System.out.printf("%s", "\t" + jogadores[i].getNome() + "(" + jogadores[i].getTipoJogador() + ")");
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
                System.out.printf("%s", "\t" + jogadores[j].getPontuacaoRodadaX(i - 1) + "\t");

            }
            System.out.println();
        }

        System.out.println("---------------------------------------");
        System.out.print("Total\t");

        for (i = 0; i < qtdJogadores; i++) {
            System.out.print("\t" + jogadores[i].getTotal() + "\t");
        }
        System.out.println("\n");
    }

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

    public void lerDoArquivo() {
        try {
            FileInputStream fin = new FileInputStream(arq);
            ObjectInputStream oin = new ObjectInputStream(fin);

            // Lendo os objetos de um arquivo e fazendo a coercao de tipos

            Jogador[] jogadoresArq = (Jogador[]) oin.readObject();
            oin.close();
            fin.close();
            jogadores = jogadoresArq;
            qtdJogadores = 0;
            i = 0;
            while (jogadores[i] != null) {
                qtdJogadores++;
                i++;
            }

            System.out.println("Dados lidos com sucesso!\n");
        } catch (Exception ex) {
            System.err.println("erro: " + ex.toString());
        }

    }

}