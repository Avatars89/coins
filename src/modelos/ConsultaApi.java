package modelos;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultaApi{

    private String direccion = "https://v6.exchangerate-api.com/v6/";
    private String llaveApi = "18186738dfff542a51e8d526";
    public Scanner leer = new Scanner(System.in);
    public double monto ;
    public String monedaOrigen;
    public  String monedaDestino;
    static List<Divisa> lista = new ArrayList<>();

    public ConsultaApi() {
    }

    public static List<Divisa> getLista() {
        return lista;
    }

    public void leerMonto(){
        try {
            System.out.println("Ingresa la cantidad de dinero a convertir");
            monto = leer.nextDouble();
        } catch (Exception e){
            System.out.println("Ingresa solo cantidades.");
        }
    }

    public double getMonto() {
        return monto;
    }

    public void leerDivisas(){
        try {
            System.out.println("Ingresa el codigo de divisa de tu dinero\nPor ejemplo");
            monedaOrigen = leer.nextLine().toUpperCase();
            System.out.println("Ingresa el codigo de divisa al que quieres convertir");
            monedaDestino = leer.nextLine().toUpperCase();
        } catch (Exception e){
            System.out.println("Ingresaste mal tu divisa");
        }
    }

    public String getMonedaOrigen() {
        return monedaOrigen;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public void convertirParidad(String monedaOrigen, String monedaDestino, double monto) throws Exception{

        try {
            String url = direccion + llaveApi + "/pair/" + monedaOrigen + "/" + monedaDestino + "/" + monto;

            HttpClient cliente = HttpClient.newHttpClient();
            HttpRequest solicitud = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());
            String respuestaJson = respuesta.body();

            var gson = new Gson();
            var conversion = gson.fromJson(respuestaJson, Divisa.class);
            String imprime = "El tipo de cambio de 1 " + conversion.monedaOrigen + " = $ " + String.format("%.2f",conversion.tipoCambio) + " " + conversion.monedaDestino + "." + "\nLo que tu dinero equivale a $ " + String.format("%.2f",conversion.montoConvertido) + " " + conversion.monedaDestino + ".";
            System.out.println(imprime);

            lista.add(conversion);
            //Collections.reverse(lista);

        } catch (Exception e) {
            System.out.println("Tus datos son invalidos");
        }
    }
    public void historial(){
        System.out.println("----------------------------------------");
        System.out.println("Estas son las divisas que has cambiado");
        if (lista.size()==0){
            System.out.println("Sin divisas");
        } else {
            for (Divisa historial : lista) {
                System.out.println(historial);
            }
        }

    }

    public void consultaMoneda (String monedaOrigen) throws Exception{
        String url = direccion + llaveApi + "/latest/" + monedaOrigen ;

        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());
        String respuestaJson = respuesta.body();

        var gson = new Gson();
        var convertir = gson.fromJson(respuestaJson, Divisa.class);
        System.out.println(convertir.tipoConversion);

    }
}