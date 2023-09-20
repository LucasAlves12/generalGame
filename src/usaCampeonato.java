import java.util.Scanner;

public class usaCampeonato {
    public static void main(String[] args) throws Exception {
        
    }

    public static void menu(Campeonato c) {
        Scanner teclado = new Scanner(System.in);
        char opcao;

        do {
            System.out.println("..:: Menu interativo ::..");
            System.out.println("a - Incluir jogador");
            System.out.println("b - Remover jogador");
            System.out.println("c - Executar rodada");
            System.out.println("d - Mostrar a cartela de resultados");
            System.out.println("e - Gravar os dados do campeonato em arquivo");
            System.out.println("f - Ler os dados do campeonato em arquivo");
            System.out.println("g - Sair");
            System.out.println("Entre com uma opcao: ");
            opcao = teclado.next().charAt(0);

            switch (opcao) {
                case 'a':
                    System.out.println("Ola mundo");
                    break;
                case 'b':
                    System.out.println("Ola POO");
                    break;
                case 'c':
                    System.out.println("Saindo");
                    break;
                case 'd':
                    System.out.println("Saindo");
                    break;
                case 'e':
                    System.out.println("Saindo");
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
    }
}