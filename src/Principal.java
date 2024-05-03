import modelos.ConsultaApi;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws Exception {

        try {
            Scanner leer = new Scanner(System.in);

            boolean salirMenu=false;

            while (!salirMenu) {
                System.out.println("""
                    ----------------------------------------
                    Bienvenid@, elije una opción:
                                        
                    ****** Exchanges comunes******
                    1. [USD] => [MXN] - Dólar a peso mexicano.
                    2. [MXN] => [USD] - Peso mexicano a dólar.
                    3. [USD] => [ARS] - Dólar a peso argentino.
                    4. [ARS] => [USD] - Peso argentino a dólar.
                    5. [USD] => [BRL] - Dólar a real brasileño.
                    6. [BRL] => [USD] - Real brasileño a dólar
                    
                    ****** Todas las monedas ******
                    7. Pendiente.
                    8. Ver historial divisas.
                    9. Escoger divisas.
                    0. Salir.
                    ----------------------------------------
                    """);

                int opcionMenu = leer.nextInt();
                var consulta = new ConsultaApi();

                if (opcionMenu == 0){
                    salirMenu = true;
                } else {

                    switch (opcionMenu) {
                        case 1:
                            consulta.leerMonto();
                            consulta.convertirParidad("USD", "MXN", consulta.getMonto());
                            break;
                        case 2:
                            consulta.leerMonto();
                            consulta.convertirParidad("MXN", "USD", consulta.getMonto());
                            break;
                        case 3:
                            consulta.leerMonto();
                            consulta.convertirParidad("USD", "ARS", consulta.getMonto());
                            break;
                        case 4:
                            consulta.leerMonto();
                            consulta.convertirParidad("ARS", "USD", consulta.getMonto());
                            break;
                        case 5:
                            consulta.leerMonto();
                            consulta.convertirParidad("USD", "BRL", consulta.getMonto());
                            break;
                        case 6:
                            consulta.leerMonto();
                            consulta.convertirParidad("BRL", "USD", consulta.getMonto());
                            break;
                        case 7:

                            consulta.leerMonto();
                            consulta.consultaMoneda(consulta.getMonedaOrigen());
                            break;
                        case 8:
                            consulta.historial();
                            break;
                        case 9:
                            consulta.leerDivisas();
                            consulta.leerMonto();
                            consulta.convertirParidad(consulta.getMonedaOrigen(), consulta.getMonedaDestino(), consulta.getMonto());
                            break;
                        default:
                            System.out.println("Opcion incorrecta, ingrese un número del menu.");
                    }
                }
            }
        } catch (Exception e ) {
            System.out.println("Ingresa solo numeros");
        }
    }

}