package prueba.conversor;

import prueba.conversor.tipo.Monedas;
import prueba.conversor.tipo.Temperatura;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main{
    static private JFrame frame;
    private JPanel panelText;
    private JPanel panelButton;
    private JLabel label;
    private JButton monedaButton;
    private JButton temperaturaButton;
    JPanel mainPanel;


    public Main(){
        //inicializar valores
        label = new JLabel("Que desea convertir?",JLabel.CENTER);
        monedaButton = new JButton("Moneda");
        temperaturaButton = new JButton("Temperatura");
        //Añadir listeners

        monedaButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Conversor moneda = new Monedas();
                frame.setVisible(false);

            }
        });
        temperaturaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Conversor tempertura = new Temperatura();
                frame.setVisible(false);
            }
        });

        //crear paneles
        panelText = new JPanel();
        panelText.add(label);
        panelButton = new JPanel(new FlowLayout());
        panelButton.add(monedaButton);
        panelButton.add(temperaturaButton);
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS)); // usa un BoxLayout para apilar los paneles verticalmente
        mainPanel.add(panelText);
        mainPanel.add(panelButton);
        mainPanel.setBorder(new LineBorder(Color.darkGray));

    }

    public static void setFrame(boolean flag) {
        Main.frame.setVisible(flag);
    }

    public static JFrame getFrame() {
        return frame;
    }

    public static void main(String [] args){
        frame = new JFrame("Conversor");
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);

        frame.setContentPane(new Main().mainPanel);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.pack();
        frame.setVisible(true);
    }
}