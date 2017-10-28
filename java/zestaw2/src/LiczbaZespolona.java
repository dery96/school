public class LiczbaZespolona {
    private int a;
    private int i;

    LiczbaZespolona(int a, int i) {
        this.a = a;
        this.i = i;
    }

    public LiczbaZespolona dodaj(LiczbaZespolona obj) {
        int tmp_a = a + obj.a;
        int tmp_i = i + obj.i;
        return new LiczbaZespolona(tmp_a, tmp_i);
    }

    public LiczbaZespolona odejmij(LiczbaZespolona obj) {
        int tmp_a = a - obj.a;
        int tmp_i = i - obj.i;
        return new LiczbaZespolona(tmp_a, tmp_i);
    }

    public LiczbaZespolona pomnoz(LiczbaZespolona obj) {
        int tmp_a = a * obj.a;
        int tmp_i = i * obj.i;
        return new LiczbaZespolona(tmp_a, tmp_i);
    }

    public String toString() {
        String strA = (a == 1) ? "a " : a + "a ";
        strA = (a == 0) ? "" : strA;

        String strI = (i > 0) ? "+ " + i : "" + i;
        strI = (i == 0) ? "" : strI;

        return strA + strI + "i ";
    }
}
