package app;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        String[] productos = {"Hamburguesas", "Perro caliente", "Papas Fritas"};
        String[] turnos = {"Almuerzo", "Tarde", "Noche", "Madrugada"};

        double[][] ventas = new double[3][4];

        registrarVentas(ventas, productos, turnos);
        calculoReportes(ventas, productos, turnos);
    }

    public static void registrarVentas(double[][] ventas, String[] productos, String[] turnos) {
        for (int i = 0; i < productos.length; i++) {
            for (int j = 0; j < turnos.length; j++) {
                System.out.println("Ingresa el valor de la venta de " + productos[i] + " en el turno " + turnos[j] + ": ");
                ventas[i][j] = validarDato();
            }
        }
    }

    public static double validarDato() {
        double dato = 0;
        while (true) {
            if (!sc.hasNextDouble()) {
                System.out.println("Error: Ingrese un número válido.");
                sc.next();
                continue;
            }
            dato = sc.nextDouble();
            if (dato < 0) {
                System.out.println("Error: Ingrese un número mayor o igual a 0.");
                continue;
            }
            return dato;
        }
    }

    public static void calculoReportes(double[][] ventas, String[] productos, String[] turnos) {

        double[] totalesProductos = new double[productos.length];
        double[] totalesTurnos = new double[turnos.length];
        double sumaTotal = 0;

        for (int i = 0; i < ventas.length; i++) {
            for (int j = 0; j < ventas[i].length; j++) {
                totalesProductos[i] += ventas[i][j];
                totalesTurnos[j] += ventas[i][j];
                sumaTotal += ventas[i][j];
            }
        }

        for (int i = 0; i < productos.length; i++) {
            System.out.println("Total recaudado de " + productos[i] + ": $" + totalesProductos[i]);
        }
        for (int j = 0; j < turnos.length; j++) {
            System.out.println("Total recaudado en el turno " + turnos[j] + ": $" + totalesTurnos[j]);
        }

        int mayorProductos = 0, menorProductos = 0;
        for (int i = 1; i < totalesProductos.length; i++) {
            if (totalesProductos[i] > totalesProductos[mayorProductos]) mayorProductos = i;
            if (totalesProductos[i] < totalesProductos[menorProductos]) menorProductos = i;
        }
        System.out.println("Producto con mayor recaudo: " + productos[mayorProductos] + " ($" + totalesProductos[mayorProductos] + ")");
        System.out.println("Producto con menor recaudo: " + productos[menorProductos] + " ($" + totalesProductos[menorProductos] + ")");

        int mayorTurnos = 0, menorTurnos = 0;
        for (int j = 1; j < totalesTurnos.length; j++) {
            if (totalesTurnos[j] > totalesTurnos[mayorTurnos]) mayorTurnos = j;
            if (totalesTurnos[j] < totalesTurnos[menorTurnos]) menorTurnos = j;
        }
        System.out.println("Turno con mayor recaudo: " + turnos[mayorTurnos] + " ($" + totalesTurnos[mayorTurnos] + ")");
        System.out.println("Turno con menor recaudo: " + turnos[menorTurnos] + " ($" + totalesTurnos[menorTurnos] + ")");

        System.out.println("Total General recaudado: $" + sumaTotal);

        if (sumaTotal > 500000) {
            System.out.println("Meta de ventas alcanzada");
        } else {
            System.out.println("Meta no alcanzada");
        }
    }
}