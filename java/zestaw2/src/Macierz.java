public class Macierz {
    double[][] matrix;

    Macierz() {
        this.matrix = new double[3][3];
    }

    Macierz(double[][] matrix) {
        this.matrix = matrix;
    }

    void mnozenie(double[][] tablica, double liczba) {
        for (int i = 0; i < tablica.length; i++) {
            for (int j = 0; j < tablica[0].length; j++) {
                tablica[i][j] *= liczba;
            }
        }
    }

    double wyznacznik() {
        double a = matrix[0][2] * matrix[1][1] * matrix[2][0];
        double b = matrix[0][0] * matrix[1][2] * matrix[2][1];
        double c = matrix[0][1] * matrix[1][0] * matrix[2][2];
        return a + b + c;
    }

    public Macierz transpozycja(Macierz obj) {
        double[][] arrayTranspozycji = new double[3][3];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                arrayTranspozycji[j][i] = matrix[i][j];
                ;
            }
        }
        return new Macierz(arrayTranspozycji);
    }

//    public Macierz diagonalizacja() {
//        // Jesli wyznacznik macierzy nie jest rowny 0 to istnieje macierz odwrotna
//        if (wyznacznik() != 0) {
//            double[] a = {matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1]};
//            double[] b = {matrix[0][2] * matrix[2][1] - matrix[0][1] * matrix[2][2]};
//            double[] c = {matrix[0][1] * matrix[1][2] - matrix[0][2] * matrix[1][1]};
//            double[] d = {matrix[1][2] * matrix[2][0] - matrix[0][0] * matrix[2][2]};
//            double[] e = {matrix[0][0] * matrix[2][2] - matrix[0][2] * matrix[2][0]};
//            double[] f = {matrix[0][2] * matrix[1][0] - matrix[0][0] * matrix[1][2]};
//            double[] g = {matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][1]};
//            double[] h = {matrix[0][1] * matrix[0][2] - matrix[0][0] * matrix[2][1]};
//            double[] i = {matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0]};
//            double[][] diagonalMatrix = {a, b, c, d, e, f};
//            return new Macierz(mnozenie(diagonalMatrix, 1 / wyznacznik()));
//        }
    // czyzby żle?
        // Co zwrocic jesli nie mamy co?
        // Pytanie do prowadzacego zajecia?
//        return new Macierz(matrix);
//    }

    public Macierz odwrotna(Macierz obj) {
        return new Macierz(obj.matrix);
    }
}
