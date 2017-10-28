class Prostokat {
    double dlugosc;
    double szerokosc;
    Punkt wierzcholek;

    Prostokat() {
        this.dlugosc = 0.0;
        this.szerokosc = 0.0;
        this.wierzcholek = new Punkt(0, 0);
    }

    Prostokat(double dlugosc, double szerokosc, Punkt wierzcholek) {
        this.dlugosc = dlugosc;
        this.szerokosc = szerokosc;
        this.wierzcholek = wierzcholek;
    }

    void przesun(double dx, double dy) {
        this.wierzcholek.przesun(dx, dy);
    }

    boolean zawiera(Punkt obj) {
        double distance = Math.sqrt(Math.pow((obj.y - wierzcholek.y), 2) + Math.pow((obj.x - wierzcholek.x), 2));
        return (distance < dlugosc && distance < szerokosc);
    }

    boolean przecina(Okrag obj) {
        double distance = Math.sqrt(Math.pow((obj.srodek.y - wierzcholek.y), 2) + Math.pow((obj.srodek.x - wierzcholek.x), 2));
        return (distance < dlugosc + obj.promien || distance < szerokosc + obj.promien);
    }

    public String toString() {
        return "[dl: " + dlugosc + ", sz: " + szerokosc + "]" + wierzcholek.toString();
    }

    double pole() {
        return dlugosc * szerokosc;
    }

    double obwod() {
        return 2 * dlugosc + 2 * szerokosc;
    }
}