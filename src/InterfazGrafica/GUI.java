/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazGrafica;

import Controlador.Controladores;
import Funcionalidad.DescargarWeb;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class GUI extends JPanel implements ActionListener {

    JLabel urlname = new JLabel("Introduzca URL:");
    static JTextField url = new JTextField();
    JButton botondescargar = new JButton("Descargar");
    boolean url_correcta = true;
    static String txtString = ".txt";
    static String docString = ".doc";
    static String htmlString = ".html";
    static String seleccion = ".txt";

    public GUI() {

        botondescargar.setName("Descarga");
        botondescargar.addActionListener(this);

        url.setPreferredSize(new Dimension(300, 20));
        //----------------------------------------------
        JRadioButton txt = new JRadioButton(txtString);
        txt.setActionCommand(txtString);
        txt.setSelected(true);
        txt.setName("txt");
        JRadioButton doc = new JRadioButton(docString);
        doc.setActionCommand(docString);
        doc.setName("doc");
        JRadioButton html = new JRadioButton(htmlString);
        html.setActionCommand(htmlString);
        html.setName("html");

        //Grupo.
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(txt);
        grupo.add(doc);
        grupo.add(html);

        txt.addActionListener(this);
        doc.addActionListener(this);
        html.addActionListener(this);
//--------------------------------------------------------
        JPanel text = new JPanel(new GridLayout(0, 1));
        text.add(urlname);
        add(text, BorderLayout.LINE_START);
        //--------------------------------------------------------
        JPanel boton = new JPanel(new GridLayout(0, 1));
        boton.add(botondescargar);
        add(url, BorderLayout.CENTER);
        add(boton, BorderLayout.CENTER);
//--------------------------------------------------------
        JPanel radioPanel = new JPanel(new GridLayout(1, 1));
        radioPanel.add(txt);
        radioPanel.add(doc);
        radioPanel.add(html);
        add(radioPanel, BorderLayout.EAST);
//--------------------------------------------------------

    }

    public static void main(String args[]) {
        JFrame frame = new JFrame("Proyecto");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new GUI());
        frame.pack();
        frame.setSize(600, 100);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object control = e.getSource();
        if (control instanceof JButton) {
            try {
                URL existe = new URL(url.getText());
            } catch (MalformedURLException ex) {
                url_correcta = false;
            }
            if (url_correcta) {
                Controladores.ControladorDescarga(url.getText(), seleccion);
            } else {
                //Crear alertDialog
                System.out.println("La URL: --> " + url.getText() + " <-- no es correcta");
            }
        } else {
            seleccion = e.getActionCommand().toString();
        }


    }

    public static String getUrl() {
        return url.getText();
    }

    public static String getSeleccion() {
        return seleccion;
    }
    
}