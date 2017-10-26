public class Main {

    public static void main(String[] args) {

        Ulamek obj, obj2;
        obj = new Ulamek(6, 3);
        obj2 = new Ulamek(1, 2);

        System.out.println(obj);
//
//        double x = obj.rozwDziesietne();
//        System.out.println("rowiniecie dziesietne" + x);
//
//        Ulamek obj3 = obj.dodaj(obj2);
//        System.out.println("po dodaniu" + obj3);
//        Ulamek obj4 = obj.minus(obj2);
//        Ulamek obj4 = obj.razy(obj2);
//
//        obj.odwroc();
//        System.out.println("po odwroceniu" + obj);
        obj.skroc();

    }

}
