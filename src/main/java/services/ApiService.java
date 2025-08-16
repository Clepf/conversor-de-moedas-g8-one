package services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;
import models.ExchangeRatesResponse;
import utils.ConfigLoader; // Importa a nova classe

public class ApiService {

    private static final HttpClient client = HttpClient.newHttpClient();
    private static final Gson gson = new Gson();

    /**
     * Retorna a taxa de câmbio da moeda origem em relação a TODAS as outras.
     */
    public ExchangeRatesResponse obterTaxas(String origem) {
        String apiKey = ConfigLoader.getApiKey();
        if (apiKey == null || apiKey.trim().isEmpty()) {
            System.err.println("Chave da API não encontrada. Verifique o arquivo config.properties.");
            return null;
        }
        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + origem;

        try {
            HttpRequest req = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> resp = client.send(req, HttpResponse.BodyHandlers.ofString());
            return gson.fromJson(resp.body(), ExchangeRatesResponse.class);
        } catch (Exception e) {
            System.err.println("Erro na requisição: " + e.getMessage());
            return null;
        }
    }
}