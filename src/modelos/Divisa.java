package modelos;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class Divisa {
    @SerializedName("base_code")
    public String monedaOrigen;
    @SerializedName("target_code")
    public String monedaDestino;
    @SerializedName("conversion_rate")
    public double tipoCambio;
    @SerializedName("conversion_result")
    public double montoConvertido;
    @SerializedName("conversion_rates")
    public String[] tipoConversion;

    public String[] getTipoConversion() {
        return tipoConversion;
    }

    public Divisa(){

    }
    public Divisa(String monedaOrigen, String monedaDestino, double monto) {
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.montoConvertido = monto;
    }



    @Override
    public String toString() {
        double moneda= montoConvertido/tipoCambio;
        String textoDivisa = "Cambiaste  $" + String.format("%.2f",moneda) + " " + monedaOrigen + " a " + montoConvertido + " " + monedaDestino;
        return textoDivisa;

    }
}