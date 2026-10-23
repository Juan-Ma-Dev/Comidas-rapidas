package app;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        String[] productos = {"Hamburguesas", "Perro caliente", "Papas Fritas"};
        String[] turnos = {"Almuerzo", "Tarde", "Noche", "Madrugada"};

        double[][] ventas = new double[3][4];

        registrarVentas(ventas, productos, turnos);
    }
    public static void registrarVentas(double[][] ventas, String[] productos, String[] turnos) {
        for (int i = 0; i < productos.length; i++) {
            for (int j = 0; j < productos.length; j++) {
                System.out.println("Ingresa el valor de la venta de " + productos[i] + " en el turno " + turnos[j] + ": ");
                ventas[i][j] = validarDato();
            }
        }
    }
}
