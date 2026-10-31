import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== SIMULADOR DE SUBSTITUIÇÃO DE PÁGINAS ===");

        System.out.println("\nDigite a sequência de páginas separadas por espaço:");
        String entrada = scanner.nextLine();

        String[] numeros = entrada.trim().split("\\s+");
        int[] paginas = new int[numeros.length];

        for (int i = 0; i < numeros.length; i++) {
            paginas[i] = Integer.parseInt(numeros[i]);
        }

        System.out.print("\nDigite a quantidade de quadros da memória: ");
        int quadros = scanner.nextInt();

        if (quadros <= 0) {
            System.out.println("A quantidade de quadros deve ser maior que zero.");
            scanner.close();
            return;
        }

        int faltasFIFO = fifo(paginas, quadros);
        int faltasLRU = lru(paginas, quadros);
        int faltasClock = clock(paginas, quadros);
        int faltasOtimo = otimo(paginas, quadros);

        System.out.println("\n=== RESULTADOS ===");
        System.out.println("FIFO - " + faltasFIFO + " faltas de página");
        System.out.println("LRU - " + faltasLRU + " faltas de página");
        System.out.println("Relógio - " + faltasClock + " faltas de página");
        System.out.println("Ótimo - " + faltasOtimo + " faltas de página");

        scanner.close();
    }

    // FIFO - First In, First Out
    public static int fifo(int[] paginas, int quantidadeQuadros) {

        List<Integer> memoria = new ArrayList<>();

        int faltas = 0;
        int ponteiro = 0;

        for (int pagina : paginas) {

            if (!memoria.contains(pagina)) {

                faltas++;

                if (memoria.size() < quantidadeQuadros) {
                    memoria.add(pagina);

                } else {
                    memoria.set(ponteiro, pagina);
                    ponteiro = (ponteiro + 1) % quantidadeQuadros;
                }
            }
        }

        return faltas;
    }

    // LRU - Least Recently Used
    public static int lru(int[] paginas, int quantidadeQuadros) {

        List<Integer> memoria = new ArrayList<>();
        int faltas = 0;

        for (int pagina : paginas) {

            if (memoria.contains(pagina)) {

                memoria.remove(Integer.valueOf(pagina));
                memoria.add(pagina);

            } else {

                faltas++;

                if (memoria.size() >= quantidadeQuadros) {
                    memoria.remove(0);
                }

                memoria.add(pagina);
            }
        }

        return faltas;
    }

    // Relógio / Clock
    public static int clock(int[] paginas, int quantidadeQuadros) {

        int[] memoria = new int[quantidadeQuadros];
        boolean[] ocupado = new boolean[quantidadeQuadros];
        int[] bitReferencia = new int[quantidadeQuadros];

        int ponteiro = 0;
        int faltas = 0;

        for (int pagina : paginas) {

            int indicePagina = -1;

            // Verifica se a página já está na memória
            for (int i = 0; i < quantidadeQuadros; i++) {

                if (ocupado[i] && memoria[i] == pagina) {
                    indicePagina = i;
                    break;
                }
            }

            // Se já está na memória, recebe uma nova referência
            if (indicePagina != -1) {

                bitReferencia[indicePagina] = 1;

            } else {

                faltas++;

                // Procura uma página que possa ser substituída
                while (ocupado[ponteiro]
                        && bitReferencia[ponteiro] == 1) {

                    bitReferencia[ponteiro] = 0;
                    ponteiro = (ponteiro + 1) % quantidadeQuadros;
                }

                memoria[ponteiro] = pagina;
                ocupado[ponteiro] = true;
                bitReferencia[ponteiro] = 1;

                ponteiro = (ponteiro + 1) % quantidadeQuadros;
            }
        }

        return faltas;
    }

    // Algoritmo Ótimo
    public static int otimo(int[] paginas, int quantidadeQuadros) {

        List<Integer> memoria = new ArrayList<>();
        int faltas = 0;

        for (int i = 0; i < paginas.length; i++) {

            int paginaAtual = paginas[i];

            if (memoria.contains(paginaAtual)) {
                continue;
            }

            faltas++;

            if (memoria.size() < quantidadeQuadros) {

                memoria.add(paginaAtual);

            } else {

                int indiceSubstituir = -1;
                int usoMaisDistante = -1;

                // Verifica qual página será usada mais tarde no futuro
                for (int j = 0; j < memoria.size(); j++) {

                    int paginaMemoria = memoria.get(j);
                    int proximoUso = Integer.MAX_VALUE;

                    for (int k = i + 1; k < paginas.length; k++) {

                        if (paginas[k] == paginaMemoria) {
                            proximoUso = k;
                            break;
                        }
                    }

                    if (proximoUso > usoMaisDistante) {
                        usoMaisDistante = proximoUso;
                        indiceSubstituir = j;
                    }
                }

                memoria.set(indiceSubstituir, paginaAtual);
            }
        }

        return faltas;
    }
}
