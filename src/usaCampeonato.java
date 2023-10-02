import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class usaCampeonato {
    public static void main(String[] args) throws Exception {

        Scanner teclado = new Scanner(System.in);
        char opcao;
        Campeonato c = new Campeonato();
        String nome;
        String nomeAux; // variavel para remover pelo nome
        char p; // variavel de caractere q define se é humano ou maquina

        do {
            System.out.println("..:: Menu interativo ::..");
            System.out.println("a - Incluir jogador");
            System.out.println("b - Remover jogador");
            System.out.println("c - Executar rodada");
            System.out.println("d - Mostrar a cartela de resultados");
            System.out.println("e - Gravar os dados do campeonato em arquivo");
            System.out.println("f - Ler os dados do campeonato em arquivo");
            System.out.println("g - Sair");
            System.out.println("Entre com uma opcao do menu: ");
            opcao = teclado.next().charAt(0);

            switch (opcao) {
                case 'a':
                    System.out.println("Insira seu nome: ");
                    nome = teclado.nextLine();
                    teclado.nextLine();
                    System.out.println("Tipo de jogador (H - humano ou M - maquina):");
                    p = teclado.next().charAt(0);

                    c.incluirJogador(nome, p);

                    /*
                     * if (p == 'm' || p == 'M') {
                     * nome += "(M)";
                     * }
                     * else{
                     * nome += "(H)";
                     * }
                     */

                    break;
                case 'b':
                    System.out.println("Informe o nome da pessoa que deseja remover:");
                    nomeAux = teclado.nextLine();
                    c.removerJogador(nomeAux);

                    break;
                case 'c':
                    System.out.println("Saindo");
                    break;
                case 'd':
                    System.out.println("Saindo");
                    break;
                case 'e':
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
                    break;
                case 'f':
                    System.out.println("Saindo");
                    break;
                case 'g':
                    System.out.println("Saindo");
                    break;
                default:
                    System.out.println("Opcao invalida. Tente novamente");
            }
        } while (opcao != 'g');

        teclado.close();
    }
}
