public class Wektor {
    private double[] wspolrzedne;

    Wektor() {
        this.wspolrzedne = new double[3];
    }

    Wektor(double[] wspolrzedne) {
        this.wspolrzedne = wspolrzedne;
    }

    public String toString() {
        return "[" + wspolrzedne[0] + ", " + wspolrzedne[1] + ", " + wspolrzedne[2] + "]";
    }

    public Wektor dodaj(Wektor obj) {
        double[] tmp_wspolrzedne = new double[3];
        for (int i = 0; i < wspolrzedne.length; i++) {
            tmp_wspolrzedne[i] = wspolrzedne[i] + obj.wspolrzedne[i];
        }
        return new Wektor(tmp_wspolrzedne);
    }

    public Wektor odejmij(Wektor obj) {
        double[] tmp_wspolrzedne = new double[3];
        for (int i = 0; i < wspolrzedne.length; i++) {
            tmp_wspolrzedne[i] = wspolrzedne[i] - obj.wspolrzedne[i];
        }
        return new Wektor(tmp_wspolrzedne);
    }

    public Wektor pomnoz(double a) {
        double[] tmp_wspolrzedne = new double[3];
        for (int i = 0; i < wspolrzedne.length; i++) {
            tmp_wspolrzedne[i] = wspolrzedne[i] * a;
        }
        return new Wektor(tmp_wspolrzedne);
    }

    public Wektor iloczyn_wektorowy(Wektor obj) {
        double[] tmp_wspolrzedne = new double[3];
        tmp_wspolrzedne[0] = wspolrzedne[1] * obj.wspolrzedne[2] - wspolrzedne[2] * obj.wspolrzedne[1];
        tmp_wspolrzedne[1] = wspolrzedne[2] * obj.wspolrzedne[0] - wspolrzedne[0] * obj.wspolrzedne[2];
        tmp_wspolrzedne[2] = wspolrzedne[0] * obj.wspolrzedne[1] - wspolrzedne[1] * obj.wspolrzedne[0];
        return new Wektor(tmp_wspolrzedne);
    }

    double iloczyn_skalarny(Wektor obj) {
        double skalar = 0;
        for (int i = 0; i < wspolrzedne.length; i++) {
            skalar += wspolrzedne[i] + obj.wspolrzedne[i];
        }
        return skalar;
    }
}
