package pk.petrik.hu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Statisztika {
    static List<Konyv> konyvek = new ArrayList<>();
    static List<String> irok = new ArrayList<>();
    static List<String> nemDuplazottIro;
    public static void main(String[] args) {
        Konyv peldakonyv1 = new Konyv(1,"rendezo karrier","balint",1940,501);
        konyvek.add(peldakonyv1);
        System.out.println("500 oldalnál hosszabb könyvek száma: " + feladat1());
        System.out.println((feladat2() ? "Van 1950-nél régebbi könyv " : "Nincs 1950-nél régebbi könyv "));
        System.out.println("A leghosszabb könyv: \n Szerző: " + feladat3().getAuthor() + "\n Cím: " + feladat3().getTitle()+ "\n Kiadás éve: " + feladat3().getPublish_year() + "\n Oldalszám: " + feladat3().getPage_count());
        System.out.println("A legtöbb könyvvel rendelkező szerző: " + feladat4());
    }
    static int feladat1() {
        int counter = 0;
        for (Konyv konyv : konyvek) {
            counter = ((konyv.getPage_count()>500) ? (counter+=1) : counter);
        }
        return counter;
    }
    static boolean feladat2() {
        boolean lessThan1950 = false;
        for (Konyv konyv : konyvek) {
            lessThan1950 = ((konyv.getPublish_year()<1950) ? true : false);
        }
        return  lessThan1950;
    }
    static Konyv feladat3() {
        Konyv leghosszabb = konyvek.get(0);
        for (Konyv konyv:konyvek) {
            leghosszabb = (konyv.getPage_count()> leghosszabb.getPage_count() ? konyv : leghosszabb);
        }
        return leghosszabb;
    }
    static String feladat4() {
        String legtobbetIro = "";
        int konyvSzamolo = 0;
        int legtobbKonyv = 0;

        for ( Konyv konyv: konyvek)
            irok.add(konyv.getAuthor());

        nemDuplazottIro = new ArrayList<>(new HashSet<>(irok));

        for (String iro: nemDuplazottIro) {
            for (Konyv konyv: konyvek) {
                if (iro == konyv.getAuthor()) {
                    konyvSzamolo++;

                    if (legtobbKonyv<konyvSzamolo) {
                    legtobbetIro = konyv.getAuthor();
                    legtobbKonyv = konyvSzamolo;
                    konyvSzamolo = 0;
                    }
                }
            }
        }

        return legtobbetIro;
    }

}
