package modelos;
import com.google.gson.annotations.SerializedName;

import java.util.List;

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
    public List tipoConversion;

    public Divisa(){

    }
    public Divisa(String monedaOrigen, String monedaDestino, double monto) {
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.montoConvertido = monto;
    }

    @Override
    public String toString() {
        return "El tipo de cambio de 1 " + monedaOrigen +" = $ " + tipoCambio + " " + monedaDestino +"." + "\nLo que tu dinero equivale a $ " + montoConvertido + " " + monedaDestino +".";
    }

}