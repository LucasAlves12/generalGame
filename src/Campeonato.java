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
    private File arq = new File("agenda.dat");
    private Scanner teclado = new Scanner(System.in);

    public Campeonato() {
        this.jogadores = new Jogador[10];
        this.qtdJogadores = 0;
        this.maxJogadores = 10;
    }

    public void incluirJogador() {
        System.out.println("Insira seu nome: ");
        String nome = teclado.nextLine();
        // teclado.nextLine();
        System.out.println("Tipo de jogador (H - humano ou M - maquina):");
        char p = teclado.nextLine().charAt(0);

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
                    jogadores[i] = jogadores[i + 1]; // aqui ta errado
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
        if (qtdJogadores == 0) {
            System.out.println("Não há jogadores suficientes para iniciar o campeonato");
        } else {
            for (int rodada = 0; rodada < 13; rodada++) {
                for (int i = 0; i < qtdJogadores; i++) {
                    jogadores[i].jogarDados();
                    jogadores[i].escolherJogada();

                }
            }
        }
    }

    public void mostrarCartela() {
        System.out.println("----- Cartela de Resultados -----\n");
        System.out.printf("%s", "\t");

        for (i = 0; i < qtdJogadores; i++)
            System.out.printf("%s", "    " + jogadores[i].getNome() + "(" + jogadores[i].getTipoJogador() + ")");
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
                    System.out.printf("%s", jogadores[j].getPontuacaoRodadaX(i-1) + "\t\t");
                
            }
            System.out.println();
        }

        System.out.println("----------------------------");
        System.out.print("Total\t");

        for (i = 0; i < qtdJogadores; i++) {
            System.out.print(jogadores[i].getTotal() + "\t" );
        }
        System.out.println();
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
        } catch (Exception ex) {
            System.err.println("erro: " + ex.toString());
        }

    }

    public void lerDoArquivo() {
        teclado.nextLine();
        System.out.println("Informe o caminho para ler o arquivo (formato \"C:\\caminho\\\"):");
        String pathIn = teclado.nextLine();
        System.out.println("Informe o nome do arquivo: ");
        String nomeIn = teclado.nextLine();

        File simIn = new File(pathIn + "\\" + nomeIn + ".txt");
        try {
            FileInputStream fin = new FileInputStream(simIn);
            ObjectInputStream oin = new ObjectInputStream(fin);

            // Lendo os objetos de um arquivo e fazendo a coercao de tipos

            Jogador[] jogadoresArq = (Jogador[]) oin.readObject();
            oin.close();
            fin.close();

            // for por elementos de jogadores arq
            for (Jogador j : jogadoresArq) {
                j.mostrarJogadasExecutadas();
            }
        } catch (Exception ex) {
            System.err.println("erro: " + ex.toString());
        }

    }

}