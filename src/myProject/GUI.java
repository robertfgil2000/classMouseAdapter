package myProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * This class is used for show how use MouseAdapter class.
 * The object panelMouse is able to respond to mouseClicked event and keyTyped event too.
 * @autor Paola-J Rodriguez-C paola.rodriguez@correounivalle.edu.co
 * @version v.1.0.0 date:23/11/2021
 */
public class GUI extends JFrame {

    private Header headerProject;
    private JPanel panelMouse;
    private JTextArea mensajes;
    private Escucha escucha;

    /**
     * Constructor of GUI class
     */
    public GUI(){
        initGUI();

        //Default JFrame configuration
        this.setTitle("MouseAdapter class");
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {
        //Set up JFrame Container's Layout
        //Create Listener Object and Control Object
        escucha = new Escucha();
        //Set up JComponents
        headerProject = new Header("Using MouseAdapter class", Color.BLACK);
        this.add(headerProject,BorderLayout.NORTH); //Change this line if you change JFrame Container's Layout

        panelMouse = new JPanel();
        panelMouse.addMouseListener(escucha);
        panelMouse.addKeyListener(escucha);
        panelMouse.setFocusable(true);
        panelMouse.setBackground(Color.BLUE);
        panelMouse.setPreferredSize(new Dimension(600,120));

        mensajes = new JTextArea(7,3);
        mensajes.setEditable(false);
        JScrollPane scroll = new JScrollPane(mensajes);

        add(panelMouse,BorderLayout.CENTER);
        add(scroll,BorderLayout.SOUTH);
    }

    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUI miProjectGUI = new GUI();
        });
    }

    /**:
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha extends MouseAdapter implements KeyListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            panelMouse.setBackground(Color.CYAN);
            mensajes.append("mouseClicked was detected \n");
        }

        @Override
        public void keyTyped(KeyEvent e) {
            mensajes.append("keyTyped was detected \n"+
                    "Tecla alfa numérica = "+e.getKeyChar()+"\n");
            if(e.getKeyChar()==KeyEvent.VK_M){
                panelMouse.setBorder(BorderFactory.createTitledBorder("M was typed ..."));
                panelMouse.setBackground(Color.GRAY);
            }else{
                panelMouse.setBorder(null);
                panelMouse.setBackground(Color.BLUE);
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}
