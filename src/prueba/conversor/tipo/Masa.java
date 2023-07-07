package prueba.conversor.tipo;

import prueba.conversor.Conversor;
import prueba.conversor.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Masa extends Conversor {
    public final String [] ins = {"mg","cg","dg","g","Dg","Hg","Kg"};
    public Masa() {
        super(new String[]{"mg","cg","dg","g","Dg","Hg","Kg"},new String[]{"mg","cg","dg","g","Dg","Hg","Kg"}, "Masa");
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
        int a = getTipoEntrada().getSelectedIndex();
        int b = getTipoSalida().getSelectedIndex();
        int c = a -b;
        int cAbs = Math.abs(c);
        int d = 1;
        for(int i = 0; i < cAbs; i++){
            d *= 10;
        }
        if(c < 0){
            setValorSalida(String.valueOf(getValorEntradaDouble()/d));
        }else if (c == 0){
            setValorSalida(getValorEntrada().getText());
        }else if(c>0){
            setValorSalida(String.valueOf(getValorEntradaDouble()*d));
        }
    }
}
