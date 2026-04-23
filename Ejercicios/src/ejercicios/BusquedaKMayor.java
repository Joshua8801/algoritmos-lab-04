package ejercicios;

import java.util.Scanner;

public class BusquedaKMayor {

    public static int obtenerKMayor(int[] arr, int k) {
        return selectQuick(arr, 0, arr.length - 1, arr.length - k);
    }

    private static int selectQuick(int[] arr, int inicio, int fin, int k) {
        if (inicio == fin) {
            return arr[inicio];
        }

        int pivote = particionar(arr, inicio, fin);

        if (k == pivote) {
            return arr[k];
        } else if (k < pivote) {
            return selectQuick(arr, inicio, pivote - 1, k);
        } else {
            return selectQuick(arr, pivote + 1, fin, k);
        }
    }

    private static int particionar(int[] arr, int inicio, int fin) {
        int pivote = arr[fin];
        int i = inicio;

        for (int j = inicio; j < fin; j++) {
            if (arr[j] <= pivote) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }

        int temp = arr[i];
        arr[i] = arr[fin];
        arr[fin] = temp;

        return i;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("N: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Dato " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        System.out.print("K: ");
        int k = sc.nextInt();

        System.out.println(obtenerKMayor(arr, k));

        sc.close();
    }
}
