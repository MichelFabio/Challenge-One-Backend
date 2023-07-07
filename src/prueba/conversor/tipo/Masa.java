package prueba.conversor.tipo;

import prueba.conversor.Conversor;
import prueba.conversor.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Masa extends Conversor {
    int a,b;
    public Masa() {
        super(new String[]{"mg","cg","dg","g","Dg","Hg","Kg","libra"},new String[]{"mg","cg","dg","g","Dg","Hg","Kg","libra"}, "Masa");
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
        a = getTipoEntrada().getSelectedIndex();
        b = getTipoSalida().getSelectedIndex();
        double c = 0;
        System.out.println(getTipoEntrada().getItemCount()-1 );
        if(a == getTipoEntrada().getItemCount()-1 && b == getTipoEntrada().getItemCount()-1){
            setValorSalida(getValorEntrada().getText());
        }else if(a == getTipoEntrada().getItemCount()-1 ) {
            double ltoG = getValorEntradaDouble()/0.00220462d;
            a = 3;
            setValorEntrada(String.valueOf(ltoG));
            c = calculo();
        }else if(b == getTipoSalida().getItemCount()-1){
            b = 3;
            c = calculo();
            c = c * 0.00220462d;
        }else{
            c = calculo();
        }
        setValorSalida(String.valueOf(c));
    }
        public double calculo(){
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

