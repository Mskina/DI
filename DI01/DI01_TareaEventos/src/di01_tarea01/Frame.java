/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di01_tarea01;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Clase Frame, que será la que usemos para dibujar la calculadora
 * @author Iván Estévez Sabucedo
 */
public class Frame extends JFrame {

    // Creamos un array de botones para mostrar los resultados de la multiplicación
    private Boton[] botonesResultado = new Boton[10];
    
    /**
     * Constructor
     */
    public Frame() {
        setTitle("Tabla de Multiplicar");
        setSize(450, 700); // Ancho x Largo
        setMinimumSize(new Dimension(300, 550));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Panel principal, en el que irá toda la interfaz
        JPanel mainPanel = new JPanel(new GridBagLayout());

        // Panel de la multiplicación (título, selector y botones de resultado)
        JPanel panelMultiplicar = new JPanel(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();

        //Título
        JLabel textoTitulo = new JLabel("Tabla de Multiplicar");
        textoTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        c.gridx = 0; // Columna
        c.gridy = 0; // Fila
        c.gridwidth = 3; // Número de columnas que ocupa
        c.weightx = 1; // % de importancia horizontal
        c.weighty = 1; // % de importancia vertical
        c.fill = GridBagConstraints.CENTER; // Cómo rellenar el espacio alrededor del componente
        c.insets = new Insets(5, 5, 5, 5); // Márgenes
        panelMultiplicar.add(textoTitulo, c);

        // ComboBox
        JComboBox<String> cb = new JComboBox<String>();
        for (int i = 0; i <= 9; i++) {
            cb.addItem(String.valueOf(i));
        }
        c.gridx = 0; // Columna
        c.gridy = 1; // Fila
        c.gridwidth = 3;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 1, 5, 1);
        panelMultiplicar.add(cb, c);

        c.gridwidth = 1;
        c.weightx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 5, 5);

        // Tabla de multiplicar
        for (int i = 0; i <= 9; i++) {
            c.gridx = 0; // Columna
            c.gridy = i + 2; // Fila
            panelMultiplicar.add(new Boton(String.valueOf(i)), c);

            c.gridx = 1; // Columna
            c.gridy = i + 2; // Fila
            panelMultiplicar.add(new Boton("="), c);

            c.gridx = 2; // Columna
            c.gridy = i + 2; // Fila
            Boton btn = new Boton(" ");
            panelMultiplicar.add(btn, c);
            botonesResultado[i] = btn;
        }

        // Panel para la operación de suma (etiquetas, textos y botón)
        JPanel panelSuma = new JPanel(new GridBagLayout());
        c = new GridBagConstraints(); // Reiniciamos los valores

        c.gridwidth = 1;
        c.weighty = 1;

        // Texto número + resultado
        c.weightx = 0.1;  // Para las 3
        c.fill = GridBagConstraints.HORIZONTAL; // Para las 3
        c.insets = new Insets(0, 5, 0, 5); // Para las 3

        c.gridx = 0; // Columna
        c.gridy = 0; // Fila        
        panelSuma.add(new JLabel("Número 1: "), c);

        c.gridx = 0; // Columna
        c.gridy = 1; // Fila
        panelSuma.add(new JLabel("Número 2: "), c);

        c.gridx = 0; // Columna
        c.gridy = 2; // Fila
        panelSuma.add(new JLabel("Resultado"), c);

        // Áreas de texto
        c.weightx = 0.2;
        c.weighty = 1;
        c.insets = new Insets(0, 5, 0, 5);

        JTextField textoNumero1 = new JTextField(5);
        c.gridx = 1; // Columna
        c.gridy = 0; // Fila
        panelSuma.add(textoNumero1, c);

        JTextField textoNumero2 = new JTextField(5);
        c.gridx = 1; // Columna
        c.gridy = 1; // Fila
        panelSuma.add(textoNumero2, c);

        JTextField textoResultado = new JTextField(5);
        textoResultado.setEditable(false);
        c.gridx = 1; // Columna
        c.gridy = 2; // Fila
        panelSuma.add(textoResultado, c);

        // Botón sumar
        Boton botonSumar = new Boton("Sumar");
        c.gridx = 2; // Columna
        c.gridy = 0; // Fila
        c.gridheight = 3;
        c.weightx = 0.5;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(7, 7, 7, 7);
        panelSuma.add(botonSumar, c);

        c = new GridBagConstraints(); // Volvemos a reiniciar
        c.weightx = 0.5;
        c.weighty = 0.5;

        // Juntamos los dos paneles en el main
        c.gridx = 0; // Columna
        c.gridy = 0; // Fila
        c.fill = GridBagConstraints.BOTH;
        mainPanel.add(panelMultiplicar, c);

        c.gridx = 0; // Columna
        c.gridy = 1; // Fila        
        mainPanel.add(panelSuma, c);
        add(mainPanel);

        // LISTENERS
        // Listener del ComboBox (saber qué opción se ha seleccionado)
        cb.addItemListener((e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String item = (String) e.getItem();
                int numeroMarcado = Integer.parseInt(item);

                Matematica m = new Matematica(numeroMarcado);
                for (int i = 0; i <= 9; i++) {
                    Boton btn = botonesResultado[i];
                    btn.setText(String.valueOf(m.multiplicar(i)));
                }
                //System.out.println("Número seleccionado: " + item); // Comprobación por consola
            }
        });

        // Listener del botón Sumar
        botonSumar.addActionListener((e) -> {
            if (!textoNumero1.getText().matches("[+-]?\\d+")
                    || !textoNumero2.getText().matches("[+-]?\\d+")) {
                JOptionPane.showMessageDialog(mainPanel, "Recuerda: para sumar hacen falta dos números", "¡Oh, no!", HEIGHT);
            }
            int coeficiente = Integer.parseInt(textoNumero1.getText());
            Matematica m = new Matematica(coeficiente);

            textoResultado.setText(String.valueOf(m.sumar(Integer.parseInt(textoNumero2.getText()))));

            //System.out.println("Clic"); // Comprobación por consola de que detectó el clic           
        });

        textoNumero2.addActionListener(ae -> {
            if (!textoNumero1.getText().matches("[+-]?\\d+")
                    || !textoNumero2.getText().matches("[+-]?\\d+")) {
                JOptionPane.showMessageDialog(mainPanel, "Recuerda: para sumar hacen falta dos números", "¡Oh, no!", HEIGHT);
            }
            int coeficiente = Integer.parseInt(textoNumero1.getText());
            Matematica m = new Matematica(coeficiente);

            textoResultado.setText(String.valueOf(m.sumar(Integer.parseInt(textoNumero2.getText()))));
        }
        );

    }
}
