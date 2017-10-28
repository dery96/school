public class Okrag {
    double promien;
    Punkt srodek;

    Okrag() {
        this.promien = 0.0;
        this.srodek = new Punkt(0, 0);
    }

    Okrag(double promien, Punkt srodek) {
        this.promien = promien;
        this.srodek = srodek;
    }

    void przesun(double dx, double dy) {
        this.srodek.przesun(dx, dy);
    }

    public String toString() {
        return "[promien: " + promien + ", środek: " + srodek + "]" + srodek.toString();
    }

    double pole() {
        return 2 * 3.14 * promien;
    }

    boolean zawiera(Punkt obj) {
        double distance = Math.sqrt(Math.pow((obj.y - srodek.y), 2) + Math.pow((obj.x - srodek.x), 2));
        return (distance < promien);
    }
    boolean przecina(Okrag obj) {
        double distance = Math.sqrt(Math.pow((obj.srodek.y - srodek.y), 2) + Math.pow((obj.srodek.x - srodek.x), 2));
        return (distance < promien + obj.promien);
    }
}
