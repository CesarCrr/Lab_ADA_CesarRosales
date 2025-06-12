/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaada;

/**
 *
 * @author User
 */
 class NodoArbol {
    Cliente cliente;
    NodoArbol izq, der;

    public NodoArbol(Cliente cliente) {
        this.cliente = cliente;
    }
}

class ArbolBinario {
    NodoArbol raiz;

    public void insertar(Cliente cliente) {
        raiz = insertarRec(raiz, cliente);
    }

    private NodoArbol insertarRec(NodoArbol nodo, Cliente cliente) {
        if (nodo == null) return new NodoArbol(cliente);
        if (cliente.getClaveHash().compareTo(nodo.cliente.getClaveHash()) < 0)
            nodo.izq = insertarRec(nodo.izq, cliente);
        else
            nodo.der = insertarRec(nodo.der, cliente);
        return nodo;
    }

    public Cliente buscar(String clave) {
        return buscarRec(raiz, clave);
    }

    private Cliente buscarRec(NodoArbol nodo, String clave) {
        if (nodo == null) return null;
        if (nodo.cliente.getClaveHash().equals(clave)) return nodo.cliente;
        if (clave.compareTo(nodo.cliente.getClaveHash()) < 0)
            return buscarRec(nodo.izq, clave);
        else
            return buscarRec(nodo.der, clave);
    }
}

public class HashEncadenamiento {
    private ArbolBinario[] tabla;
    private int capacidad;

    public HashEncadenamiento(int capacidad) {
        this.capacidad = capacidad;
        tabla = new ArbolBinario[capacidad];
        for (int i = 0; i < capacidad; i++) {
            tabla[i] = new ArbolBinario();
        }
    }

    private int hash(String clave) {
        return Math.abs(clave.hashCode()) % capacidad;
    }

    public void insertar(Cliente cliente) {
        int index = hash(cliente.getClaveHash());
        tabla[index].insertar(cliente);
    }

    public Cliente buscar(String clave) {
        int index = hash(clave);
        return tabla[index].buscar(clave);
    }
}

