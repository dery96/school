public class BigLiczba {
    private int liczba;

    BigLiczba(int liczba) {
        this.liczba = liczba;
    }

    boolean czyPodzielna(int testNumber) {
        return (liczba % testNumber == 0);
    }

    boolean czyPierwsza() {
        int[] primary_numbers = {
                2, 3, 5, 7, 11, 13, 17, 19, 23,
                29, 31, 37, 41, 43, 47, 53, 59,
                61, 67, 71, 73, 79, 83, 89, 97
        };
        for (int i : primary_numbers) {
            // Tzw ForEach iterowanie po arrayu
            if (liczba % primary_numbers[i] == 0) {
                return true;
            }
        }
        return false;
    }
}

