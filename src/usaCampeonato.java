import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
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
            opcao = teclado.nextLine().charAt(0);

            switch (opcao) {
                case 'a':
                    c.incluirJogador();
                    break;
                case 'b':
                    c.removerJogador();
                    break;
                case 'c':
                    c.iniciarCampeonato();
                    break;
                case 'd':
                    c.mostrarCartela();

                    break;
                case 'e':
                    c.gravarEmArquivo();
                    break;
                    

                case 'f':
                   c.lerDoArquivo();

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
