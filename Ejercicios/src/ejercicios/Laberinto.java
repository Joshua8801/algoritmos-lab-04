package ejercicios;

import java.util.Scanner;

public class Laberinto {

    static int N;
    static int[][] matrizLaberinto;
    static int[][] ruta;

    public static boolean buscarCamino(int x, int y) {
        
        if (x == N - 1 && y == N - 1 && matrizLaberinto[x][y] == 0) {
            ruta[x][y] = 1;
            return true;
        }

        if (esValido(x, y)) {
            ruta[x][y] = 1;

            if (buscarCamino(x + 1, y)) return true; // abajo
            if (buscarCamino(x, y + 1)) return true; // derecha
            if (buscarCamino(x - 1, y)) return true; // arriba
            if (buscarCamino(x, y - 1)) return true; // izquierda

            ruta[x][y] = 0;
        }

        return false;
    }

    public static boolean esValido(int x, int y) {
        return x >= 0 && x < N &&
               y >= 0 && y < N &&
               matrizLaberinto[x][y] == 0 &&
               ruta[x][y] == 0;
    }

    public static void mostrarSolucion() {
        System.out.println("Ruta:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(ruta[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Tamaño: ");
        N = sc.nextInt();

        matrizLaberinto = new int[N][N];
        ruta = new int[N][N];

        System.out.println("Ingrese matriz (0 libre, 1 bloque):");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrizLaberinto[i][j] = sc.nextInt();
            }
        }

        boolean existe = buscarCamino(0, 0);

        System.out.println("¿Hay camino?: " + existe);

        if (existe) {
            mostrarSolucion();
        }

        sc.close();
    }
}
