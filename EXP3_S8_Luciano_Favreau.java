import java.util.Scanner;

public class EXP3_S8_Luciano_Favreau {
    private static final int TAMANO_MAX = 100; // el teatro tiene 100 butacas para generar un tope 
    private static String[] ventas = new String[TAMANO_MAX];
    private static int indiceVentas = 0; // contador para ventas e índices en el array

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

               final double PRECIO_VIP = 100.0;
        final double PRECIO_PLATEA = 70.0;
        final double PRECIO_BALCON = 50.0;

        while (continuar) {
            System.out.println("----------------------------");
            System.out.println("Bienvenido al sistema de venta de entradas del Teatro Moro");
            System.out.println("1. Vender entrada");
            System.out.println("2. Ver resumen de ventas");
            System.out.println("3. Generar boleta");
            System.out.println("4. Salir del programa");
            System.out.print("Por favor, elija una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    venderEntrada(scanner, PRECIO_VIP, PRECIO_PLATEA, PRECIO_BALCON);
                    break;
                case 2:
                    mostrarResumenVentas();
                    break;
                case 3:
                    generarBoleta();
                    break;
                case 4:
                    System.out.println("Gracias por su compra. ¡Hasta pronto!");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
                    break;
            }
        }
        scanner.close();
    }

    private static void venderEntrada(Scanner scanner, double PRECIO_VIP, double PRECIO_PLATEA, double PRECIO_BALCON) {
        System.out.println("----------------------------");
        System.out.println("Seleccione la ubicación de la entrada:");
        System.out.println("1. VIP");
        System.out.println("2. Platea");
        System.out.println("3. Balcón");
        int eleccionUbicacion = scanner.nextInt();

        double precioBase;
        String zonaElegida;
        switch (eleccionUbicacion) {
            case 1:
                precioBase = PRECIO_VIP;
                zonaElegida = "VIP";
                break;
            case 2:
                precioBase = PRECIO_PLATEA;
                zonaElegida = "Platea";
                break;
            case 3:
                precioBase = PRECIO_BALCON;
                zonaElegida = "Balcón";
                break;
            default:
                System.out.println("Opción no válida, regresando al menú principal.");
                return;
        }

        System.out.println("¿El comprador es estudiante o de la tercera edad?");
        System.out.println("1. Ninguno");
        System.out.println("2. Estudiante (10% de descuento)");
        System.out.println("3. Tercera edad (15% de descuento)");
        int tipoDescuento = scanner.nextInt();

        double descuentoAplicado = 0;
        if (tipoDescuento == 2) {
            descuentoAplicado = precioBase * 0.10;
        } else if (tipoDescuento == 3) {
            descuentoAplicado = precioBase * 0.15;
        }

        double precioFinal = precioBase - descuentoAplicado;
        System.out.println("Entrada vendida para " + zonaElegida + " por $" + precioFinal);

        // Registro de venta
        String detalleVenta = "Ubicación: " + zonaElegida + ", Precio Base: $" + precioBase + ", Descuento: $" + descuentoAplicado + ", Precio Final: $" + precioFinal;
        ventas[indiceVentas] = detalleVenta;
        indiceVentas++;

        System.out.println("Detalle de Venta: " + detalleVenta);
    }

    private static void mostrarResumenVentas() {
        System.out.println("----------------------------");
        System.out.println("Resumen de todas las ventas:");
        if (indiceVentas == 0) {
            System.out.println("No se han realizado ventas aún.");
        } else {
            for (int i = 0; i < indiceVentas; i++) {
                System.out.println((i + 1) + ". " + ventas[i]);
            }
        }
        System.out.println("----------------------------");
    }

    private static void generarBoleta() {
        System.out.println("----------------------------");
        System.out.println("       Teatro Moro          ");
        System.out.println("      Boleta de Venta       ");
        System.out.println("----------------------------");

        if (indiceVentas == 0) {
            System.out.println("No se han realizado ventas aún.");
        } else {
            for (int i = 0; i < indiceVentas; i++) {
                System.out.println("Venta " + (i + 1) + ": " + ventas[i]);
            }
        }

        System.out.println("Gracias por su visita al Teatro Moro");
        System.out.println("----------------------------");
    }
}
