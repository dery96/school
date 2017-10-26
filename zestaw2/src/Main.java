public class Main {

    public static void main(String[] args) {

        // Ulamek
        Ulamek uobj, uobj2;
        uobj = new Ulamek(6, 3);
        uobj2 = new Ulamek(1, 2);

        System.out.println(uobj);
        System.out.println("rowiniecie dziesietne" + uobj.rozwDziesietne());
        System.out.println(uobj + "+" + uobj2 + " = " + uobj.dodaj(uobj2));
        System.out.println(uobj + "-" + uobj2 + " = " + uobj.minus(uobj2));
        System.out.println(uobj + "*" + uobj2 + " = " + uobj.razy(uobj2));
        uobj.odwroc();
        System.out.println("po odwroceniu" + uobj);
        uobj.skroc();

        // Wektor
        Wektor wobj, wobj2;
        double[] wobj_array = {2, 3, 4};
        double[] wobj_array2 = {1, 1, 1};

        wobj = new Wektor(wobj_array);
        wobj2 = new Wektor(wobj_array2);

        System.out.println("Dodawanie wektorów: " + wobj + " oraz " + wobj2 + " = " + wobj.dodaj(wobj2));
        System.out.println("Odejmowanie wektorów: " + wobj + " oraz " + wobj2 + " = " + wobj.odejmij(wobj2));
        System.out.println("Mnozenie wektoru: " + wobj + " o liczbe 2 = " + wobj.pomnoz(2));
        System.out.println("Iloczyn skalarny: " + wobj + " oraz " + wobj2 + " = " + wobj.iloczyn_skalarny(wobj2));
        System.out.println("Iloczyn wektorowy: " + wobj + " oraz " + wobj2 + " = " + wobj.iloczyn_wektorowy(wobj2));
    }
}
