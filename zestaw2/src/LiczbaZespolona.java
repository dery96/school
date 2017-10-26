public class LiczbaZespolona {
    private int a;
    private int i;

    LiczbaZespolona(int a, int i) {
        this.a = 0;
        this.i = 0;
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
        return super.toString();
    }
}
