/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaada;

/**
 *
 * @author User
 */
import javax.swing.*;
import java.awt.event.*;

public class VentanaPrincipal extends JFrame {
    private JTextField txtCodigo, txtNombres, txtApellidos, txtTelefono, txtCorreo, txtDireccion, txtPostal, txtBuscar;
    private JButton btnInsertar, btnBuscar;
    private JTextArea areaResultados;

    private HashLineal hashLineal;
    private HashEncadenamiento hashEncadenado;

    public VentanaPrincipal() {
        setTitle("Gestión de Clientes - Comparación Hash");
        setSize(600, 500);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        hashLineal = new HashLineal(50);
        hashEncadenado = new HashEncadenamiento(50);

        // Campos de ingreso
        txtCodigo = new JTextField(); txtCodigo.setBounds(20, 30, 100, 25);
        txtNombres = new JTextField(); txtNombres.setBounds(130, 30, 100, 25);
        txtApellidos = new JTextField(); txtApellidos.setBounds(240, 30, 100, 25);
        txtTelefono = new JTextField(); txtTelefono.setBounds(350, 30, 100, 25);
        txtCorreo = new JTextField(); txtCorreo.setBounds(20, 60, 150, 25);
        txtDireccion = new JTextField(); txtDireccion.setBounds(180, 60, 150, 25);
        txtPostal = new JTextField(); txtPostal.setBounds(340, 60, 100, 25);

        btnInsertar = new JButton("Insertar"); btnInsertar.setBounds(450, 30, 100, 25);
        btnBuscar = new JButton("Buscar"); btnBuscar.setBounds(450, 60, 100, 25);
        txtBuscar = new JTextField(); txtBuscar.setBounds(20, 100, 300, 25);
        areaResultados = new JTextArea(); areaResultados.setBounds(20, 140, 540, 300);

        add(txtCodigo); add(txtNombres); add(txtApellidos); add(txtTelefono);
        add(txtCorreo); add(txtDireccion); add(txtPostal);
        add(btnInsertar); add(btnBuscar); add(txtBuscar); add(areaResultados);

        // Acciones
        btnInsertar.addActionListener(e -> {
            Cliente c = new Cliente(txtCodigo.getText(), txtNombres.getText(), txtApellidos.getText(),
                    txtTelefono.getText(), txtCorreo.getText(), txtDireccion.getText(), txtPostal.getText());
            long inicio1 = System.nanoTime();
            hashLineal.insertar(c);
            long tiempoLineal = System.nanoTime() - inicio1;

            long inicio2 = System.nanoTime();
            hashEncadenado.insertar(c);
            long tiempoEncadenado = System.nanoTime() - inicio2;

            areaResultados.append("Cliente insertado\n");
            areaResultados.append("Tiempo Lineal: " + tiempoLineal + " ns\n");
            areaResultados.append("Tiempo Encadenado: " + tiempoEncadenado + " ns\n\n");
        });

        btnBuscar.addActionListener(e -> {
            String clave = txtBuscar.getText();

            long inicio1 = System.nanoTime();
            Cliente c1 = hashLineal.buscar(clave);
            long tiempoLineal = System.nanoTime() - inicio1;

            long inicio2 = System.nanoTime();
            Cliente c2 = hashEncadenado.buscar(clave);
            long tiempoEncadenado = System.nanoTime() - inicio2;

            areaResultados.append("Resultado de búsqueda:\n");
            areaResultados.append("Lineal: " + (c1 != null ? c1 : "No encontrado") + " | Tiempo: " + tiempoLineal + " ns\n");
            areaResultados.append("Encadenado: " + (c2 != null ? c2 : "No encontrado") + " | Tiempo: " + tiempoEncadenado + " ns\n\n");
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaPrincipal().setVisible(true);
        });
    }
}

