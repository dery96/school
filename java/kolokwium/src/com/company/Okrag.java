package com.company;

public class Okrag extends Figura {
    double promien = 0;
    double x = 0;
    double y = 0;

    public Okrag(double promien, double x, double y) {

        this.promien = promien;
        srodekCiezkosci.przesun(this.x, this.y);
    }

    public double pole() {
        return 3.14 * Math.pow(this.promien, 2);
    }

    public double obwod() {
        return (2*3.14*this.promien);
    }

    void a() {
        this.przesun(2, 2);
    }

    boolean stycznosc(Okrag obj) {
        double dx = Math.pow(obj.srodekCiezkosci.x - srodekCiezkosci.x, 2);
        double dy = Math.pow(obj.srodekCiezkosci.y - srodekCiezkosci.y, 2);
        double d = Math.sqrt(dx + dy);
        if (d == obj.promien + this.promien ||
                d == Math.abs(obj.promien - this.promien)) {
            return true;
        }
        return false;
    }

    boolean przecina(Okrag obj) {
        double dx = Math.pow(obj.srodekCiezkosci.x - srodekCiezkosci.x, 2);
        double dy = Math.pow(obj.srodekCiezkosci.y - srodekCiezkosci.y, 2);
        double d = Math.sqrt(dx + dy);
        if ( d > Math.abs(obj.promien - this.promien) &&
                d < obj.promien + this.promien) {
            return true;
        }
        return false;
    }
}
