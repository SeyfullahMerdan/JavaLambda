package LambdaProject;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static List<Ogrenci> ogListesi=new ArrayList<>();

    public static void main(String[] args) {

        ogrenciListesi();
        notaGoreSirala();
        yasaGoreSirala();
        yasaVeCinsiyeteGore(30 , "Kız");
        ismeGoreSirala("Ahmet");
        soyIsmeGoreSirala("Can");
        ortHesapla();
    }

    private static void ortHesapla() {

        double toplam=ogListesi.stream().mapToDouble( Ogrenci::getDiplomaNotu )
                .average().getAsDouble();
        System.out.println(toplam);
        //     return toplam/ogListesi.size();



    }

    private static void soyIsmeGoreSirala(String soyad) {

        ogListesi.stream().filter(t-> t.getSoyAd().equalsIgnoreCase(soyad)).forEach(t-> System.out.println(t)   );
        System.out.println("***************");

    }

    private static void ismeGoreSirala(String isim) {

        ogListesi.stream().filter(t->t.getAd().equalsIgnoreCase(isim)).collect(Collectors.toList()).
        forEach(t-> System.out.println(t)   );
        System.out.println("***************");


    }

    private static void yasaVeCinsiyeteGore(int yas, String cinsiyet) {

       ogListesi.stream().filter(t -> t.getYas() < yas && t.getCinsiyet().equalsIgnoreCase(cinsiyet)).
        sorted(Comparator.comparing(Ogrenci::getYas)).
                forEach(System.out::println);
        System.out.println("***************");

    }

    private static void yasaGoreSirala() {

        ogListesi.stream().sorted(Comparator.comparing(Ogrenci::getYas).reversed()).forEach(System.out::println);
        System.out.println("***************");

    }

    private static void notaGoreSirala() {

        ogListesi.stream().sorted(Comparator.comparing(Ogrenci::getDiplomaNotu).reversed()).
                forEach(System.out::println);
        System.out.println("***************");
    }

    private static void ogrenciListesi() {

     ogListesi.add ( new Ogrenci ( "Ahmet" ,"Can" ,30 ,95.5, "Erkek" ));
     ogListesi.add ( new Ogrenci ( "Ali" ,"Yarba" ,25 ,90.5, "Erkek" ));
     ogListesi.add ( new Ogrenci ( "Ayşe" ,"Can" ,21 ,82.5, "Kız" ));
     ogListesi.add ( new Ogrenci ( "Merve" ,"Aslan" ,30 ,75.5, "Kız" ));
     ogListesi.add ( new Ogrenci ( "Veli" ,"Han" ,80 ,35.5, "Erkek" ));
     ogListesi.add ( new Ogrenci ( "Funda" ,"Funda" ,24 ,99.5, "Kız" ));

    }


}
