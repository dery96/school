public class Macierz {
    int[] matrixArray;

    Macierz() {
        this.matrixArray
    }

    Macierz(int[] matrixArray) {
        this.matrixArray = matrixArray;
    }

    double wyznacznik() {

    double det = 0;
        return det;
    }

    void transpozycja() {

    }
    void diagonalizacja() {

    }

    public Macierz odwrotna(Macierz obj) {
        return new Macierz(obj.matrixArray);
    }
}
