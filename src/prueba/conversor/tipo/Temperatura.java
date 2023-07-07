package prueba.conversor.tipo;

import prueba.conversor.Conversor;
import prueba.conversor.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Temperatura extends Conversor {

    public Temperatura() {
        super(new String[]{"Celsius","Kelvin","Farenheit"},new String[]{"Celsius","Kelvin","Farenheit"},"Temperatura");
        getConvertirButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(verificarEntrada()){
                    encontrarMultiplicador();
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
    //dependiendo de los index de los comboBox el valor de salida cambia
    public void encontrarMultiplicador(){
        int a = getTipoEntrada().getSelectedIndex();
        int b = getTipoSalida().getSelectedIndex();
        double d = 0d;
        if(a == 0){
            switch (b){
                case 0 : d = getValorEntradaDouble(); setValorSalida(String.valueOf(d)); break;
                case 1 : d = getValorEntradaDouble() + 273.15d; setValorSalida(String.valueOf(d)); break;
                case 2 : d = (getValorEntradaDouble() * 1.8d) + 32; setValorSalida(String.valueOf(d)); break;
            }
        }
        if(a == 1){
            switch (b){
                case 0 : d = getValorEntradaDouble() - 273.15d; setValorSalida(String.valueOf(d)); break;
                case 1 : d = getValorEntradaDouble(); setValorSalida(String.valueOf(d)); break;
                case 2 : d = (getValorEntradaDouble() - 273.15d)* (9/5) + 32; setValorSalida(String.valueOf(d)); break;
            }
        }
        if(a == 2){
            switch (b){
                case 0 : d = ((32 *getValorEntradaDouble())-32)*(5/9); setValorSalida(String.valueOf(d)); break;
                case 1 : d = (getValorEntradaDouble() - 32d)*(5/9) +273.15d; setValorSalida(String.valueOf(d)); break;
                case 2 : d = getValorEntradaDouble(); setValorSalida(String.valueOf(d)); break;
            }
        }
    }


}
