package prueba.conversor.tipo;

import prueba.conversor.Conversor;
import prueba.conversor.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Monedas extends Conversor {
    private int a;
    private int b;
    public Monedas() {
        super(new String[]{"Pesos","Dolares","Euros","Libras","Yen","Won"},new String[]{"Pesos","Dolares","Euros","Libras","Yen","Won"},"Currency");
        a =0;
        b = 0;
        getConvertirButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(verificarEntrada()){
                    encontrarMultiplicador();
                    double v = valorSalida(getValorEntradaDouble(),getMultiplicador());
                    setValorSalida(String.valueOf(v));
                }

            }
        });
        getVolverButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.setFrame(true);
                getFrame().dispose();
            }
        });
        getSalirButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.getFrame().dispose();
                getFrame().dispose();
            }
        });
    }
    public double encontrarMultiplicador(){
        a = getTipoEntrada().getSelectedIndex();
        b = getTipoSalida().getSelectedIndex();

        if(a == 0){
            switch(b){
                case 0 : setMultiplicador(1d); break;
                case 1 : setMultiplicador(0.00024d);break;
                case 2 : setMultiplicador(0.00022d);break;
                case 3 : setMultiplicador(0.00019d);break;
                case 4 : setMultiplicador(0.035d);break;
                case 5 : setMultiplicador(0.32d);break;
            }
        } else if (a == 1) {
            switch(b){
                case 0 : setMultiplicador(4275.00d);break;
                case 1 : setMultiplicador(1d);break;
                case 2 : setMultiplicador(0.92d);break;
                case 3 : setMultiplicador(0.79d);break;
                case 4 : setMultiplicador(144.56d);break;
                case 5 : setMultiplicador(1313.66d);break;
            }
        } else if (a == 2) {
            switch(b){
                case 0 : setMultiplicador(4554.44d);break;
                case 1 : setMultiplicador(1.09d);break;
                case 2 : setMultiplicador(1d);break;
                case 3 : setMultiplicador(0.86d);break;
                case 4 : setMultiplicador(157.8d);break;
                case 5 : setMultiplicador(1432.99d);break;
            }
        } else if (a == 3) {
            switch(b){
                case 0 : setMultiplicador(5302.27d);break;
                case 1 : setMultiplicador(1.27d);break;
                case 2 : setMultiplicador(1.16d);break;
                case 3 : setMultiplicador(1d);break;
                case 4 : setMultiplicador(183.73d);break;
                case 5 : setMultiplicador(1668.17d);break;
            }
        } else if (a==4) {
            switch(b){
                case 0 : setMultiplicador(0.12d);break;
                case 1 : setMultiplicador(0.0069d);break;
                case 2 : setMultiplicador(0.0063d);break;
                case 3 : setMultiplicador(0.0054d);break;
                case 4 : setMultiplicador(1d);break;
                case 5 : setMultiplicador(9.08d);break;
            }

        }else if(a == 5){
            switch(b){
                case 0 : setMultiplicador(3.18d);break;
                case 1 : setMultiplicador(0.00076d);break;
                case 2 : setMultiplicador(0.00070d);break;
                case 3 : setMultiplicador(0.00060d);break;
                case 4 : setMultiplicador(0.11d);break;
                case 5 : setMultiplicador(1d);break;
            }
        }
        return getMultiplicador();
    }
    @Override
    public double valorSalida(double a, double multiplicador){
        return a * multiplicador;
    }


}
