package services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import models.ExchangeRatesResponse;

public class ConversorService {
    private final ApiService api = new ApiService();
    private final List<String> historico = new ArrayList<>();
    private final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Converte valor de origem → destino usando taxas obtidas via API.
     */
    public void realizarConversao(String origem, String destino, double valor) {
        ExchangeRatesResponse resp = api.obterTaxas(origem);
        if (resp != null && "success".equals(resp.getResult())) {
            Double taxa = resp.getConversion_rates().get(destino);
            if (taxa == null) {
                System.out.println("Moeda destino não encontrada nas taxas.");
                return;
            }
            double resultado = valor * taxa;
            String linha = String.format(
                    "[%s] %.2f %s = %.2f %s (taxa=%.4f)",
                    LocalDateTime.now().format(fmt),
                    valor, origem, resultado, destino, taxa
            );
            System.out.println("\n*** RESULTADO DA CONVERSÃO ***");
            System.out.printf("%.2f %s = %.2f %s%n", valor, origem, resultado, destino);
            System.out.printf("Taxa de câmbio: %.4f%n", taxa);
            System.out.println("LOG: " + linha);
            historico.add(linha);
        } else {
            System.out.println("Falha ao obter taxas da API.");
        }
    }

    public void exibirHistorico() {
        if (historico.isEmpty()) {
            System.out.println("Nenhuma conversão registrada.");
            return;
        }
        System.out.println("\n=== HISTÓRICO DE CONVERSÕES ===");
        for (int i = 0; i < historico.size(); i++) {
            System.out.printf("%2d) %s%n", i + 1, historico.get(i));
        }
    }
}
