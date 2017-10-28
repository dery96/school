public class Main {

    public static void main(String[] args) {
        Punkt punkt_object;
        punkt_object = new Punkt(-1, 1);

        System.out.println("punkt: " + punkt_object);
//        punkt_object.przesun(2, 2);
//        System.out.println("po przesunieciu: " + punkt_object);

        Prostokat obj;
        obj = new Prostokat(3, 4, punkt_object);

        Punkt pobj = new Punkt(1, 2);
        System.out.println(obj.zawiera(pobj));
//        System.out.println("prostokat: " + obj);
//        System.out.println("Pole prostokata: " + obj.pole());
//        System.out.println("Obwód prostokąta: " + obj.obwod());
//        obj.przesun(2, 2);
//        System.out.println("Wierzcholek prostokątu po przesinieciu: " + obj);

    }
}

