package com.company;

import java.awt.font.FontRenderContext;

public class Main {

    public static void main(String[] args) {
        Punkt a = new Punkt(1, 2);
        a.przesun(1, 1);
        System.out.println(a);

        Okrag okr_obj = new Okrag(1, 1, 1);
        System.out.println(okr_obj.pole());

        System.out.println(okr_obj.obwod());

        Prostokat prost_obj = new Prostokat(1, 2, 1, 2);
        System.out.println(prost_obj.pole());
        System.out.println(prost_obj.obwod());

        System.out.println(prost_obj.przecina(okr_obj));
        System.out.println(okr_obj.przecina(okr_obj));
        System.out.println(okr_obj.stycznosc(okr_obj));


        Mierzalne[] lista ={
                new Okrag(2, 1, 1),
                new Okrag(2, 1, 1),
                new Prostokat(1, 2, 2, 2),
                new Prostokat(1, 2, 2, 2),
        };

        double suma = 0;

        for(int i=0;i<lista.length;i++)
        {
            suma += lista[i].pole();
        }

        System.out.println(suma);

    }
}
