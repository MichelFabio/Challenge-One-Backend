package prueba.conversor;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.NumberFormatter;
import java.awt.*;

public class Conversor {
    private JComboBox<String> tipoEntrada;
    private JComboBox <String> tipoSalida;
    private JLabel aLabel;
    private JLabel igualLabel;
    private JTextField valorEntrada;
    private JTextField valorSalida;

    private JButton convertirButton;
    private JButton volverButton;
    private JButton salirButton;
    private JPanel panelInput;
    private JPanel panelOutput;
    private JPanel mainPanel;
    private JFrame frame;
    private double multiplicador;



    public Conversor(String [] ins,String [] outs,String tipo) {
        this.tipoEntrada = new JComboBox<>(ins);

        this.tipoSalida = new JComboBox<>(outs);
        this.aLabel = new JLabel("a");
        aLabel.setHorizontalAlignment(JLabel.CENTER);
        this.igualLabel = new JLabel("=");
        igualLabel.setHorizontalAlignment(JLabel.CENTER);
        this.valorEntrada = new JTextField(15);
        this.valorSalida = new JTextField(15);
        this.convertirButton = new JButton("Convertir");
        this.volverButton = new JButton("Volver");
        this.salirButton = new JButton("Salir");
        this.panelInput = new JPanel(new GridLayout(2,3));
        this.panelOutput = new JPanel(new GridLayout(1,3));
        this.mainPanel = new JPanel(new GridLayout(2,1));
        this.frame = new JFrame(tipo);
        //Añadir componentes de entrada y salida al panel superior

        panelInput.add(tipoEntrada);
        panelInput.add((aLabel));
        panelInput.add(tipoSalida);
        panelInput.add(valorEntrada);
        panelInput.add(igualLabel);
        panelInput.add(valorSalida);
        panelInput.setBorder(new EmptyBorder(10,50,10,50));
        panelOutput.add(volverButton);
        panelOutput.add(convertirButton);
        panelOutput.add(salirButton);
        panelOutput.setBorder(new EmptyBorder(10,50,10,50));
        mainPanel.add(panelInput);
        mainPanel.add(panelOutput);
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(600,600);
        frame.pack();
        frame.setVisible(true);

    }

    public JComboBox<String> getTipoEntrada() {
        return tipoEntrada;
    }

    public JComboBox<String> getTipoSalida() {
        return tipoSalida;
    }

    public JTextField getValorEntrada() {
        return valorEntrada;
    }

    public double getValorEntradaDouble() {
        return Double.parseDouble(this.valorEntrada.getText());
    }


    public void setValorSalida(String valorSalida) {
        this.valorSalida.setText( valorSalida);
    }

    public JButton getConvertirButton() {
        return convertirButton;
    }

    public JButton getVolverButton() {
        return volverButton;
    }
    public JButton getSalirButton() {
        return salirButton;
    }
    public JFrame getFrame() {
        return frame;
    }
    public double getMultiplicador() {
        return multiplicador;
    }

    public void setMultiplicador(double multiplicador) {
        this.multiplicador = multiplicador;
    }

    public double valorSalida(double a, double multiplicador){
        return a * multiplicador;
    }

    //Verifica que el valor ingrsado sea numérico (0-9) o tenga un divisor de miles (.)
    public boolean verificarEntrada(){
        boolean flag = true;
        String entrada = getValorEntrada().getText();
        if (!(entrada.matches("[0-9.]+"))) {
            JOptionPane.showMessageDialog(getFrame(),"Debe ingrsar un valor numérico");
            flag = false;
        }
        return flag;
    }


}
