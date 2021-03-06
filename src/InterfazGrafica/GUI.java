/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazGrafica;

import Controlador.Controladores;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class GUI extends JPanel implements ActionListener, ItemListener {

    JLabel urlname = new JLabel("Introduzca URL:");
    JLabel classname = new JLabel("Busqueda por Clase: ");
    static JTextField url = new JTextField();
    static JTextField c = new JTextField();
    JButton botondescargar = new JButton("Descargar");
    JButton desplegar = new JButton("Desplegar mas opciones");
    JButton screen = new JButton("Crear hoja de calculo");
    boolean url_correcta = true;
    static String txtString = ".txt";
    static String docString = ".doc";
    static String htmlString = ".html";
    static String seleccion = ".txt";

    JCheckBox buttonCH;
    //String[] lista={"a","abbr","acronym","address","applet","area","b","base","basefont","bdo","big","blockquote","body","br","button","caption","center","cite","code","col","colgroup","dd","del","dfn","dir","div","dl","dt","em","fieldset","font","form","frame","frameset","h1","h2","h3","h4","h5","h6","head","hr","html","i","iframe","img","input","ins","isindex","kbd","label","legend","li","link","map","menu","meta","noframes","noscript","object","ol","optgroup","option","p","param","pre","q","s","samp","script","select","small","span","strike","strong","style","sub","sup","table","tbody","td","textarea","tfoot","th","thead","title","tr","tt","u","ul","var"};
    ArrayList<String> etiquetas = new ArrayList<String>();
    boolean etiqueExiste = true;
    String[] lista = {"a", "body", "button", "div", "h1", "h2", "h3", "h4", "h5", "h6", "head", "html", "img", "label", "li", "ol", "p", "span", "table", "tbody", "td", "title", "tr", "u", "ul"};

    public GUI() {

        botondescargar.setName("Descarga");
        screen.setName("pantalla");
        botondescargar.addActionListener(this);
        screen.addActionListener(this);

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
        add(radioPanel, BorderLayout.NORTH);
//--------------------------------------------------------
        JPanel chekPanel = new JPanel(new GridLayout(3, 2));
        //Register a listener for the check boxes.
        for (int x = 0; x < lista.length; x++) {
            buttonCH = new JCheckBox(lista[x]);
            buttonCH.setName(lista[x]);
            buttonCH.setSelected(false);
            chekPanel.add(buttonCH);
            buttonCH.addItemListener(this);
            add(chekPanel, BorderLayout.SOUTH);
        }
        JPanel clas = new JPanel(new GridLayout(1, 1));
        clas.add(classname);
        clas.add(c);
        add(clas, BorderLayout.NORTH);
        
        JPanel bt = new JPanel(new GridLayout(0, 1));
        bt.add(screen);
        add(bt, BorderLayout.class);

    }

    public static void main(String args[]) {
        JFrame frame = new JFrame("Proyecto");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new GUI());
        //frame.setUndecorated(true);
        frame.pack();
        frame.setSize(600, 230);
        frame.setLocationRelativeTo(null);
        //frame.getRootPane().setWindowDecorationStyle(JRootPane.QUESTION_DIALOG);	
        frame.setResizable(false);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object control = e.getSource();

        System.out.println(e.getActionCommand().toString());
        if (control instanceof JButton) {
            JButton boton = (JButton) control;
            if(boton.getText().equals("Descargar")){
                try {
                    URL existe = new URL(url.getText());
                } catch (MalformedURLException ex) {
                    url_correcta = false;
                }
                if (url_correcta) {
                    Controladores.ControladorDescarga(url.getText(), etiquetas, c.getText());
                } else {
                    //Crear alertDialog
                    System.out.println("La URL: --> " + url.getText() + " <-- no es correcta");
                }
            }else if(boton.getText().equals("Crear hoja de calculo")){
                Controladores.controladorLeer();
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

    @Override
    public void itemStateChanged(ItemEvent e) {
        JCheckBox source = (JCheckBox) e.getItemSelectable();

        //System.out.println(source.getName());
        for (int i = 0; i < etiquetas.size(); i++) {
            if (etiquetas.get(i).equals(source.getName())) {
                etiquetas.remove(i);
                etiqueExiste = false;
            }
        }
        if (etiqueExiste) {
            etiquetas.add(source.getName());
        } else {
            etiqueExiste = true;
        }

        System.out.println();
        for (int i = 0; i < etiquetas.size(); i++) {
            System.out.print(etiquetas.get(i) + " ");
        }
    }
}
