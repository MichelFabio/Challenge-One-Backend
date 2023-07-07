package prueba.conversor.tipo;

import prueba.conversor.Conversor;
import prueba.conversor.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Distancia extends Conversor {
    int a,b;

    public Distancia() {
                super(new String[]{"mm","cm","dm","m","Dm","Hm","Km"}, new String[]{"mm","cm","dm","m","Dm","Hm","Km"}, "Distancia");
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
    public void encontrarMultiplicador(){
        double de = calculo();
        setValorSalida(String.valueOf(de));
    }
    public double calculo(){
        a = getTipoEntrada().getSelectedIndex();
        b = getTipoSalida().getSelectedIndex();
        int c = a-b;
        int cAbs = Math.abs(c);
        double val = 0;
        int d = 1;
        for(int i = 0; i < cAbs; i++){
            d *= 10;
        }
        if(c < 0){
            val = getValorEntradaDouble()/d;
        }else if (c == 0){
            val = getValorEntradaDouble();
        }else if(c>0){
            val = getValorEntradaDouble()*d;
        }
        System.out.println(val);
        return val;

    }
}
