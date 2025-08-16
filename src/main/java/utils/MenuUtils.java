package utils;

import java.util.List;
import models.Moeda;

public class MenuUtils {

    public static void exibirMenu() {
        System.out.println("\n==== CONVERSOR DE MOEDAS ====");
        System.out.println("1) Fazer conversão");
        System.out.println("2) Histórico de conversões");
        System.out.println("3) Sair");
        System.out.print("Escolha uma opção válida: ");
    }

    public static void exibirListaMoedas(List<Moeda> moedas) {
        System.out.println("\n=== Lista de Moedas ===");
        for (int i = 0; i < moedas.size(); i++) {
            System.out.printf("%2d) %s%n", i + 1, moedas.get(i));
        }
    }
}
