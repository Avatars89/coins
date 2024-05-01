package modelos;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi{
    private String direccion = "https://v6.exchangerate-api.com/v6/";
    private String llaveApi = "18186738dfff542a51e8d526";

    public ConsultaApi() {
    }

    public void ConvertirParidad(String monedaOrigen, String monedaDestino, double monto) throws Exception{
        String url = direccion + llaveApi + "/pair/" + monedaOrigen + "/" + monedaDestino + "/" + monto;

        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());
        String respuestaJson = respuesta.body();

        Gson gson = new Gson();
        Divisa conversion = gson.fromJson(respuestaJson, Divisa.class);
        System.out.println(conversion);

    }

}