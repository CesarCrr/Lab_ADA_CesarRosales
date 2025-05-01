/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.labo01;

/**
 *
 * @author Cesar Rosales
 */
public class Labo01 {

    public static void main(String[] args) {
        int vector[] = {-2, 11, -4, 13, -5, 9, -3, 2, -8, 4};
        int suma_maxima = 0;
        int suma_actual = 0;
        int inicio = 0, fin = 0, temp_inicio = 0;
        for (int i = 0; i < vector.length; i++) {
            suma_actual += vector[i];
            if (suma_actual > suma_maxima) {
                suma_maxima = suma_actual;
                inicio = temp_inicio;
                fin = i;
            }
            if (suma_actual < 0) {
                suma_actual = 0;
                temp_inicio = i + 1;
            }
        }
        System.out.println("La suma maxima es: " + suma_maxima);
        System.out.println("La subsecuencia va desde la posicion " + (inicio + 1) + " hasta la posicion " + (fin + 1));
    }
}
