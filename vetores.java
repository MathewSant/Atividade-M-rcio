import java.util.Scanner;

public class BuscaVetorSimples {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] valores = new int[10];

        System.out.println("Digite 10 valores:");
        for (int i = 0; i < 10; i++) {
            valores[i] = scanner.nextInt();
        }

        boolean ordenado = verificarOrdenacao(valores);
        System.out.println("O vetor " + (ordenado ? "está" : "não está") + " ordenado.");

        boolean continuarBusca = true;
        while (continuarBusca) {
            System.out.print("Digite um elemento para buscar: ");
            int elemento = scanner.nextInt();
            int posicao = ordenado ? buscaBinaria(valores, elemento) : buscaLinear(valores, elemento);

            if (posicao != -1) {
                System.out.println("Encontrado na posição: " + posicao);
            } else {
                System.out.println("Não encontrado.");
            }

            System.out.print("Deseja continuar? (s/n): ");
            continuarBusca = scanner.next().equalsIgnoreCase("s");
        }

        scanner.close();
    }

    private static boolean verificarOrdenacao(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return false;
            }
        }
        return true;
    }

    private static int buscaLinear(int[] array, int elemento) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == elemento) {
                return i;
            }
        }
        return -1;
    }

    private static int buscaBinaria(int[] array, int elemento) {
        int esquerda = 0, direita = array.length - 1;
        while (esquerda <= direita) {
            int meio = (esquerda + direita) / 2;
            if (array[meio] == elemento) {
                return meio;
            } else if (array[meio] < elemento) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }
        return -1;
    }
}
