package com.company;

abstract class Figura implements Mierzalne {
    Punkt srodekCiezkosci = new Punkt(0, 0);

    void przesun(double dx, double dy) {
        srodekCiezkosci.przesun(dx, dy);
    }
}
