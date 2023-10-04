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
    private Scanner teclado = new Scanner(System.in);

    public Campeonato() {
        this.jogadores = new Jogador[10];
        this.qtdJogadores = 0;
        this.maxJogadores = 10;
    }

    public void incluirJogador(String nome, char tipoJogador) {
        if (qtdJogadores < maxJogadores) {
            jogadores[qtdJogadores] = new Jogador(nome, tipoJogador);
            qtdJogadores++;
        } else {
            System.out.println("Não é possivel inserir mais jogadores !!!");
        }
    }

    public void removerJogador(String nome) {
        int posicaoRemovida = 0;
        for (i = 0; i < this.getQtdJogadores(); i++) {
            if (jogadores[i].getNome() == nome) {
                this.getJogadores()[i] = null;
                posicaoRemovida = i;
                for (i = posicaoRemovida; i < this.getQtdJogadores() - 1; i++) {
                    this.setJogadores(this.getJogadores()[i + 1], i); // aqui ta errado
                }
                this.setQtdJogadores(this.getQtdJogadores() - 1);

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
                    System.out.println("Escolha uma jogada: "); // fazer a logica de escolher a jogada
                    int jogada = teclado.nextInt();
                    jogadores[i].mostrarJogadasExecutadas();
                    jogadores[i].escolherJogada(jogada);

                }
            }
        }
    }

    public void mostrarCartela() {
        System.out.println("-- Cartela de Resultados--");
    }

    public void gravarEmArquivo() {
        teclado.nextLine();
        System.out.println("Informe o caminho para salvar o arquivo (formato \"C:\\caminho\\\"):");
        String pathOut = teclado.nextLine();
        System.out.println("Informe o nome do arquivo: ");
        String nomeOut = teclado.nextLine();

        File simOut = new File(pathOut + "\\" + nomeOut + ".txt");
        try {
            FileOutputStream fos = new FileOutputStream(simOut);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(c);

            oos.flush();
            oos.close();
            fos.close();
        } catch (Exception ex) {
            System.err.println("erro: " + ex);
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