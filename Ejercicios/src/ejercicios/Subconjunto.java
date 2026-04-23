package ejercicios;

import java.util.Scanner;

public class Subconjunto {

    public static boolean validarSuma(int[] arr, int i, int suma) {
        if (i == arr.length) {
            return suma == 0;
        }

        if (arr[i] % 3 == 0) {
            return validarSuma(arr, i + 1, suma - arr[i]);
        }

        if (i < arr.length - 1 && arr[i] % 2 == 0 && arr[i + 1] % 2 == 0) {
            return validarSuma(arr, i + 1, suma);
        }

        if (validarSuma(arr, i + 1, suma - arr[i])) {
            return true;
        }

        return validarSuma(arr, i + 1, suma);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Cantidad: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Dato " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        System.out.print("Objetivo: ");
        int objetivo = sc.nextInt();

        boolean resultado = validarSuma(arr, 0, objetivo);

        System.out.println(resultado);

        sc.close();
    }
}
