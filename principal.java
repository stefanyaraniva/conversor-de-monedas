import com.google.gson.Gson;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Scanner;

public class Principal {

    static class ExchangeResponse {
        String result;
        Map<String, Double> conversion_rates;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        String menu = """
                \n Por favor ingrese la opción deseada:
                1. Dólar ==> Peso argentino
                2. Peso argentino ==> Dólar
                3. Dólar ==> Real brasileño
                4. Real brasileño ==> Dólar
                5. Dólar ==> Peso colombiano
                6. Peso colombiano ==> Dólar
                7. Salir
                """;

        Scanner usuario = new Scanner(System.in);

        while (true) {
            System.out.println(menu);
            System.out.print("Opción: ");
            int opcion = usuario.nextInt();

            String monedaOrigen = "";
            String monedaDestino = "";

            switch (opcion) {
                case 1 -> {
                    monedaOrigen = "USD";
                    monedaDestino = "ARS";
                }
                case 2 -> {
                    monedaOrigen = "ARS";
                    monedaDestino = "USD";
                }
                case 3 -> {
                    monedaOrigen = "USD";
                    monedaDestino = "BRL";
                }
                case 4 -> {
                    monedaOrigen = "BRL";
                    monedaDestino = "USD";
                }
                case 5 -> {
                    monedaOrigen = "USD";
                    monedaDestino = "COP";
                }
                case 6 -> {
                    monedaOrigen = "COP";
                    monedaDestino = "USD";
                }
                case 7 -> {
                    System.out.println("¡Gracias por usar nuestro conversor!");
                    return;
                }
                default -> {
                    System.out.println("***Por favor ingrese una opción válida***");
                    continue;
                }
            }

            System.out.print("Por favor ingrese el monto a convertir: ");
            double montoAConvertir = usuario.nextDouble();

            String direccion = "https://v6.exchangerate-api.com/v6/c11c35190321fd4cc237ac9b/latest/" + monedaOrigen;

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Usar Gson para parsear la respuesta
            Gson gson = new Gson();
            ExchangeResponse datos = gson.fromJson(response.body(), ExchangeResponse.class);

            double tasa = datos.conversion_rates.get(monedaDestino);
            double resultado = montoAConvertir * tasa;

            System.out.printf("%.2f %s equivale a %.2f %s\n\n", montoAConvertir, monedaOrigen, resultado, monedaDestino);
        }
    }
}