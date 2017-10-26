public class WielomianKwadratowy {
    double[] wspolczynniki;


    WielomianKwadratowy(double[] wspolczynniki) {
        this.wspolczynniki = new double[3];
    }

    public String toString() {
        StringBuilder wsploczynnikiStr = new StringBuilder();
        StringBuilder liczba = new StringBuilder();

        for (int i = 0; i < wspolczynniki.length; i++) {
            // z powodu tego, że w Javie obiekty String są niemodyfikalne
            // operacja np: s += "cos" utworzy nowy obiekt poprzez StringBuilder a potem przywraca na String
            // taka operacja konkatenacji w pętli powoduje, że optymalizacja jest OKROPNA!.
            // w tej sytuacji tworzy obiekt StringBuilder dodajac s i "cos" a nastepnie zwraca ten obiekt połączony
            // jako string.
            // StringBuffer - klasa synchronizowana, StringBuilder juz nie w przypadku programów jednowątkowych
            // stosujemy Stringbuilder
            liczba.append((wspolczynniki[i] > 0) ? String.valueOf(wspolczynniki[i]) : "-" + String.valueOf(wspolczynniki[i]));
            wsploczynnikiStr.append(liczba + "x^" + String.valueOf(Math.pow(i, 2)) + " ");
        }
        return wsploczynnikiStr.toString();
    }

    public WielomianKwadratowy dodaj(WielomianKwadratowy obj) {
        double[] tmp_wspolczynniki = new double[3];
        for (int i = 0; i < wspolczynniki.length; i++) {
            tmp_wspolczynniki[i] = wspolczynniki[i] + obj.wspolczynniki[i];
        }
        return new WielomianKwadratowy(tmp_wspolczynniki);
    }

    public WielomianKwadratowy pomnoz(WielomianKwadratowy obj) {
        double[] tmp_wspolczynniki = new double[3];
        for (int i = 0; i < wspolczynniki.length; i++) {
            tmp_wspolczynniki[i] = wspolczynniki[i] * obj.wspolczynniki[i];
        }
        return new WielomianKwadratowy(tmp_wspolczynniki);
    }

    String miejsceZerowe() {
        double delta = Math.pow(wspolczynniki[1], 2) - 4 * wspolczynniki[2] * wspolczynniki[0];
        if (delta > 0) {
            double x1 = ((-1)*wspolczynniki[1] - Math.sqrt(delta)) / 2*wspolczynniki[2];
            double x2 = ((-1)*wspolczynniki[1] + Math.sqrt(delta)) / 2*wspolczynniki[2];
            return ("[ x1: "+ String.valueOf(x1) + ", x2: " + String.valueOf(x2));
        }
        return "brak rzeczywistych mejsc zerowych";
    }

}