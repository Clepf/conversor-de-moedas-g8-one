import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import models.Moeda;
import services.ConversorService;
import utils.MenuUtils;

public class Principal {

    private static final List<Moeda> MOEDAS = Arrays.asList(
            new Moeda("USD","Dólar americano"),
            new Moeda("EUR","Euro"),
            new Moeda("JPY","Iene japonês"),
            new Moeda("GBP","Libra esterlina"),
            new Moeda("AUD","Dólar australiano"),
            new Moeda("CAD","Dólar canadense"),
            new Moeda("CHF","Franco suíço"),
            new Moeda("CNY","Yuan chinês"),
            new Moeda("HKD","Dólar de Hong Kong"),
            new Moeda("NZD","Dólar neozelandês"),
            new Moeda("SEK","Coroa sueca"),
            new Moeda("KRW","Won sul-coreano"),
            new Moeda("SGD","Dólar de Cingapura"),
            new Moeda("NOK","Coroa norueguesa"),
            new Moeda("MXN","Peso mexicano"),
            new Moeda("INR","Rúpia indiana"),
            new Moeda("RUB","Rublo russo"),
            new Moeda("ZAR","Rand sul-africano"),
            new Moeda("TRY","Lira turca"),
            new Moeda("BRL","Real brasileiro")
    );

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorService conv = new ConversorService();
        int opcao;

        System.out.println("Bem-vindo ao Conversor de Moedas!");

        do {
            MenuUtils.exibirMenu();
            opcao = lerInt(scanner);

            switch (opcao) {
                case 1 -> executarConversao(scanner, conv);
                case 2 -> conv.exibirHistorico();
                case 3 -> System.out.println("Saindo... Obrigado por usar o Conversor!");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 3);

        scanner.close();
    }

    private static void executarConversao(Scanner scanner, ConversorService conv) {
        String origem = selecionarMoeda(scanner, "origem");
        if (origem == null) return;

        String destino = selecionarMoeda(scanner, "destino");
        if (destino == null) return;

        System.out.print("Digite o valor a ser convertido: ");
        double valor = lerDouble(scanner);
        if (valor <= 0) {
            System.out.println("Valor deve ser maior que zero!");
            return;
        }
        conv.realizarConversao(origem, destino, valor);
    }

    private static String selecionarMoeda(Scanner scanner, String tipo) {
        MenuUtils.exibirListaMoedas(MOEDAS);
        System.out.print("Selecione uma moeda (" + tipo + ") pelo número: ");
        int idx = lerInt(scanner) - 1;
        if (idx < 0 || idx >= MOEDAS.size()) {
            System.out.println("Seleção inválida de " + tipo + ".");
            return null;
        }
        return MOEDAS.get(idx).codigo();
    }

    private static int lerInt(Scanner s) {
        while (!s.hasNextInt()) {
            System.out.print("Digite um número válido: ");
            s.next();
        }
        return s.nextInt();
    }

    private static double lerDouble(Scanner s) {
        while (!s.hasNextDouble()) {
            System.out.print("Entrada inválida. Digite um número válido (ex: 150.75): ");
            s.next(); // Limpa o buffer do scanner
        }
        return s.nextDouble();
    }
}
