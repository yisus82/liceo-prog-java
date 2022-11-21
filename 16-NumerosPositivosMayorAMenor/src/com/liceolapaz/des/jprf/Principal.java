package com.liceolapaz.des.jprf;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        System.out.println("Introduzca 10 números enteros positivos:");
        int[] numeros = new int[10];
        for (int i = 0; i < numeros.length; i++) {
            int numero = leerNumero();
            while (numero <= 0) {
                System.out.println("Los números tienen que ser enteros positivos");
                numero = leerNumero();
            }
            numeros[i] = numero;
        }
        int[] numerosOrdenados = ordenarNumeros(numeros);
        System.out.print("Los números introducidos fueron: ");
        for (int i = 0; i < numerosOrdenados.length; i++) {
            System.out.print(numerosOrdenados[i] + " ");
        }
        System.out.println("\n¡Hasta la próxima!");
    }

    private static int[] ordenarNumeros(int[] numeros) {
        int[] numerosOrdenados = new int[numeros.length];
        for (int i = 0; i < numerosOrdenados.length; i++) {
            int max = -1;
            int maxPos = -1;
            for (int j = 0; j < numeros.length; j++) {
                if (numeros[j] > max) {
                    max = numeros[j];
                    maxPos = j;
                }
            }
            numerosOrdenados[i] = max;
            numeros[maxPos] = -1;
        }
        return numerosOrdenados;
    }

    private static int leerNumero() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextInt();
    }
}
