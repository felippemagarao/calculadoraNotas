import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class CalculadoraMedia {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean continuar = true;

        while (continuar) {
            System.out.println("Escolha uma opção");
            System.out.println("1 - Calcular média");
            System.out.println("2 - Fechar o programa");

            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    calcularMedia(scanner);
                    break;
                case 2:
                    continuar = false;
                    System.out.println("Encerrando o programa.");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }

    private static void calcularMedia(Scanner scanner) {
        System.out.println("Digite o nome da disciplina: ");
        String disciplina = scanner.nextLine();

        System.out.println("Digite a nota da AP1:");
        double notaAp1 = scanner.nextDouble();

        System.out.println("Digite a nota da AC:");
        double notaAc = scanner.nextDouble();

        System.out.println("Digite a nota da AP2:");
        double notaAp2 = scanner.nextDouble();

        double media = calcularMedia(notaAp1, notaAc, notaAp2);

        System.out.println("A sua média na disciplina " + disciplina + " é " + media);

        salvarInformacoesTxt(disciplina, notaAp1, notaAc, notaAp2, media);
    }

    private static double calcularMedia(double notaAp1, double notaAc, double notaAp2) {
        return ((notaAp1 * 0.4) + (notaAc * 0.2) + (notaAp2 * 0.4));
    }

    private static void salvarInformacoesTxt(String disciplina, double notaAp1, double notaAc, double notaAp2,
            double media) {
        try (FileWriter writer = new FileWriter("informacoes_aluno.txt", true)) {
            writer.write("Disciplina: " + disciplina + "\n");
            writer.write("Nota 1: " + notaAp1 + "\n");
            writer.write("Nota 2: " + notaAc + "\n");
            writer.write("Nota 3: " + notaAp2 + "\n");
            writer.write("Média: " + media + "\n");

            System.out.println("Informações salvas no arquivo 'informacoes_aluno.txt'");
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
}
