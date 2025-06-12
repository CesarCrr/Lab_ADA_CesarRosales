/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaada;

/**
 *
 * @author User
 */
public class HashLineal {
    private Cliente[] tabla;
    private int capacidad;

    public HashLineal(int capacidad) {
        this.capacidad = capacidad;
        this.tabla = new Cliente[capacidad];
    }

    private int hash(String clave) {
        return Math.abs(clave.hashCode()) % capacidad;
    }

    public void insertar(Cliente cliente) {
        int index = hash(cliente.getClaveHash());
        while (tabla[index] != null) {
            index = (index + 1) % capacidad; // Reasignación lineal
        }
        tabla[index] = cliente;
    }

    public Cliente buscar(String clave) {
        int index = hash(clave);
        int original = index;
        while (tabla[index] != null) {
            if (tabla[index].getClaveHash().equals(clave)) {
                return tabla[index];
            }
            index = (index + 1) % capacidad;
            if (index == original) break; // Ciclo completo
        }
        return null;
    }
}
