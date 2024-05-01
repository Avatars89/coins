import modelos.ConsultaApi;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws Exception {
        Scanner leer = new Scanner(System.in);
        boolean salirMenu=true;

        while (salirMenu) {
            System.out.println("""
                    ----------------------------------------
                    Bienvenid@, elije una opción:
                    Estas son las monedas mas comunes:
                    
                    1. [USD] => [MXN] - Dólar a peso mexicano.
                    2. [MXN] => [USD] - Peso mexicano a dólar.
                    3. [USD] => [ARS] - Dólar a peso argentino.
                    4. [ARS] => [USD] - Peso argentino a dólar.
                    5. [USD] => [BRL] - Dólar a real brasileño.
                    6. [BRL] => [USD] - Real brasileño a dólar
                    7. [USD] => [COP] - Dólar a peso colombiano.
                    8. [COP] => [USD] - Peso colombiano a dólar.
                    0. Salir.
                    ----------------------------------------
                    """);

            int opcionMenu = leer.nextInt();
            ConsultaApi consulta = new ConsultaApi();

            if (opcionMenu == 0){
                salirMenu = false;
            } else {
                System.out.println("Ingresa la cantidad a convertir");
                double monto = leer.nextDouble();

                switch (opcionMenu) {
                    case 1:
                        consulta.ConvertirParidad("USD", "MXN", monto);
                        break;
                    case 2:
                        consulta.ConvertirParidad("MXN", "USD", monto);
                        break;
                    case 3:
                        consulta.ConvertirParidad("USD", "ARS", monto);
                        break;
                    case 4:
                        consulta.ConvertirParidad("ARS", "USD", monto);
                        break;
                    case 5:
                        consulta.ConvertirParidad("USD", "BRL", monto);
                        break;
                    case 6:
                        consulta.ConvertirParidad("BRL", "USD", monto);
                        break;
                    case 7:
                        consulta.ConvertirParidad("USD", "COP", monto);
                        break;
                    case 8:
                        consulta.ConvertirParidad("COP", "USD", monto);
                        break;
                    default:
                        System.out.println("Opcion incorrecta, ingrese un numero del menu.");
                }
            }
        }
    }
}