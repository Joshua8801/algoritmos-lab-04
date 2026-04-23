package ejercicios;

import java.util.Scanner;

public class CostoViaje {

    public static int[][] rutaMinima(int[][] T, int n) {
        int[][] C = new int[n][n];

        for (int i = 0; i < n; i++) {
            C[i][i] = 0;
        }

        for (int d = 1; d < n; d++) {
            for (int i = 0; i + d < n; i++) {
                int j = i + d;
                C[i][j] = T[i][j];

                for (int k = i + 1; k < j; k++) {
                    C[i][j] = Math.min(C[i][j], T[i][k] + C[k][j]);
                }
            }
        }

        return C;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("N: ");
        int n = sc.nextInt();

        int[][] T = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                System.out.print("Costo " + i + " a " + j + ": ");
                T[i][j] = sc.nextInt();
            }
        }

        System.out.print("Origen: ");
        int origen = sc.nextInt();

        System.out.print("Destino: ");
        int destino = sc.nextInt();

        int[][] C = rutaMinima(T, n);

        System.out.println(C[origen][destino]);

        sc.close();
    }
}