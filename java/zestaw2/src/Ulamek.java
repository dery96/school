public class Ulamek {
    int a;
    int b;

    Ulamek() {
        this.a = 0;
        this.b = 0;
    }

    Ulamek(int a, int b) {
        this.a = a;
        this.b = b;
    }


    public String toString() {
        return "[" + a + "/" + b + "]";
    }

    public Ulamek dodaj(Ulamek obj) {
        int tmp_a;
        int tmp_b;
        if (b != obj.b) {
            tmp_a = a * obj.b + obj.a * b;
            tmp_b = b * obj.b;
        } else {
            tmp_a = a + obj.a;
            tmp_b = b;
        }
        return new Ulamek(tmp_a, tmp_b);
    }

    public Ulamek minus(Ulamek obj) {
        int tmp_a, tmp_b;
        System.out.println(b);
        if (b != obj.b) {
            tmp_a = a * obj.b - obj.a * b;
            tmp_b = b * obj.b;
        } else {
            tmp_a = a - obj.a;
            tmp_b = b;
        }
        return new Ulamek(tmp_a, tmp_b);
    }

    public Ulamek razy(Ulamek obj) {
        return new Ulamek(a * obj.a,b * obj.b);
    }

    void odwroc() {
        int tmp = 0;
        tmp = a;
        a = b;
        b = tmp;
    }
    int nwd(int a, int b) {
        while (a != b) {
            if (a < b) {
                b -= a;
            } else {
                a -= b;
            }
        }
        return a;
    }
    void skrocPoprzezPetle() {
        // Dwie metody 1* dzielenie liczb pierwszych
        // 2* dzielenie NWD dwóch tych liczb.
        int[] primary_numbers = {
                2, 3, 5, 7, 11, 13, 17, 19, 23,
                29, 31, 37, 41, 43, 47, 53, 59,
                61, 67, 71, 73, 79, 83, 89, 97
        };
        for (int i = 0; i < primary_numbers.length; i++) {
            if (a % primary_numbers[i] == 0 && b % primary_numbers[i] == 0) {
                a /= primary_numbers[i];
                b /= primary_numbers[i];
            }
        }
        System.out.println("skracamy ulamek: " + a + " / " + b);
    }
    void skrocPoprzedNwd() {
        System.out.println("przed skróceniem: " + a + " / " + b);
        int tmp_a = a / nwd(a, b);
        b /= nwd(a, b);
        a = tmp_a;
        System.out.println("po skróceniu: " + a + " / " + b);
    }

    double rozwDziesietne() {
        double a_double = (double) a;
        return (a_double / b);
    }

}
