package com.company;

public class Prostokat extends Figura {
    int a = 0;
    int b = 0;
    double x = 0;
    double y = 0;

    public Prostokat(int a, int b, double x, double y) {
        this.a = a;
        this.b = b;
        srodekCiezkosci.przesun(x, y);
    }

    public double pole() {
     return this.a*this.b;
    }

    public double obwod() {
        return (2*this.a)+(2*this.b);
    }

    boolean przecina(Okrag obj) {

        double dx = Math.abs(obj.x - this.x);
        double dy = Math.abs(obj.y - this.y);

        if (dx > (a/2 + obj.promien)) { return false; }
        if (dy > (b/2 + obj.promien)) { return false; }

        if (dx <= (a/2)) { return true; }
        if (dy <= (b/2)) { return true; }

        double przypadek = Math.pow((dx - a/2), 2) +
                Math.pow((dy - b/2), 2);

        return (przypadek <= (Math.pow(obj.promien, 2)));
    }
}
