package day03;

import day01.Lambda01;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Lambda03 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(Arrays.asList("mehmet","emre","nilgün",
                                                           "yildiz","kader","emine","islam","islam","kokorec"));

        System.out.println("Alfabetik Büyük harf yazdırdım");
        bykHrfTekrarsizSira(list);
        System.out.println();
        System.out.println("TErs sıralı karakter sayısına göre");
        karakterSayisiTekrarsizTersSirali(list);
        System.out.println();
        System.out.println("Karakter sayısına göre String olarak");
        karakterSayisiSiraliEl(list);
        System.out.println();
        System.out.println("Son harfine göre tersten sıralı yaptık");
        sonHarfTersSiraliEl(list);
        System.out.println();
        System.out.println("Elemanlardan uzunlugu çift olanların karelerni tersten ayzdırdık");
        ciftKareTekrarsizTersSira( list );
        System.out.println();
        System.out.println("allmatch ile kontrol");
        harfSayisi7Kontrol(list);
        System.out.println();
        System.out.println("nonematch kontrol");
        wBaslamaKontrol(list);
        System.out.println();
        System.out.println("anymatch kontrol");
        xbitmeKontrol(list);
        System.out.println();
        System.out.println("findFirst methodu");
        karakteriEnBuyukEl(list);
        System.out.println();
        System.out.println("limit(1) toArray çalıştık");
        karakteriEnBuyukEl2(list);
        System.out.println();
        System.out.println("skip() çalıştık");
        ilkElemanHaricSonHarfSirali(list);

    }


    // list elemanlarını alfabetik büyük harf ve tekrarsız yazdırınız
    public static void bykHrfTekrarsizSira( List<String> list     ) {

        list.
                stream().   // akışa girdi
                map(t->   t.toUpperCase()  ).  // elamnlar byk harf update yaptık
                sorted().         // sorted alfabetik sıra
                distinct().    // tekrarsiz yaptı
                forEach(t->System.out.print(t + " "));  // yazdırıldı

    }


    //list elelmanlarinin character sayisini ters sirali olarak tekrarsiz yazdiriniz
    public static void karakterSayisiTekrarsizTersSirali ( List<String> list   ){
        list.
                stream().
                map(t-> t ).  //String data character sayısına update edildi. int çevrildi.
                sorted (  Comparator.reverseOrder() ). // ters sıra
                distinct().  // tekrarsiz
                forEach( t-> System.out.println(t + " ")   ); // yazdırıldı.
             // İnt alacagımız sonuç bu yüzden int method çagırdık
    }



    //list elelmanlarinin character sayisina göre küçükten büyüge yazdiriniz
    public static void karakterSayisiSiraliEl ( List<String> list   ){
        list.
                stream().
                     // 5 4 3   // Stringlerin kendisi döndü
                sorted(Comparator.comparing(t->t.length())). // karşılaştırma. filtre içinde filtre var.

                forEach(t-> System.out.print(t + " "));
    }

    //list elemanlarinin son harfine göre ters sırali yazdırınız
    public static void sonHarfTersSiraliEl ( List<String> list   ){
        list.
                stream().
                sorted( Comparator.
                        comparing(t->t.toString().
                                charAt(t.toString().length()-1)).reversed()  ).// elamanın son indexinin karakterini ters sıralar z>a
                forEach(t-> System.out.print(t + " "));
    }



    //elemanların uzunlugu çift olanlarını karelerini hesaplayan,tekrarlı olanları sdc bir kez,
    // büyükten küçgüge dogru yazdıran bir program yazdrın.
    public static void ciftKareTekrarsizTersSira( List<String> list   ){
        list.
                stream(). // String elemanlar character sayısına çevrildi.
                map(t->t.length()*t.length()).//önce map yazdım çünkü degişiklik var.eleman lengti aldık,sayı oldu akış
                filter(Lambda01::ciftBul). // önce yazarsam hata alırım, data türü int çevrilmeli önce
                distinct().
                sorted(Comparator.reverseOrder()).//ters sıra yapıldı, bykten kçge
                forEach(Lambda01::printEl);

    }



    //List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz
    public static void harfSayisi7Kontrol(List<String> list) {
        // boolean  kontrol=  list.stream().
        //     allMatch(t->t.length()<=7);//her bir elemanı harf syisini <=7 ye eslesmesine bakti
        //    if (kontrol ) {
        //        System.out.println("list elemanlari 7 harfden buyuk degil");
//
        //    }else{
        //        System.out.println("AGAM list elemanlari 7 harfden BUYUK ");
        //    }
        //System.out.println(kontrol);
        System.out.println(list.stream().allMatch(t -> t.length() <= 7)?"list elemanlari 7 harfden buyuk degil":"AGAM list elemanlari 7 harfden BUYUK ");
    }

    //List elelmanlarinin "W" ile baslamasını kontrol ediniz
    public static void wBaslamaKontrol(List<String> list){
        System.out.println(list.
                stream().
                noneMatch(t -> t.startsWith("w"))?"w ile baslayan isim kimse ayaga kalksin":"AGAM w ile baslayan isim oluuuurrr ");


    }
    //List elelmanlarinin "x" ile biten en az bir elemaı kontrol ediniz
    public static void xbitmeKontrol(List<String> list){
        System.out.println(list.
                stream().
                anyMatch(t -> t.endsWith("x"))?"x ile biten isim kimse ayaga kalksin":"AGAM x ile biten isim oluuuurrr ");
//anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
//allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
//noneMatch() --> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.

    }


        //karakter sayısı en büyük elemanı yazdırınız
    public static void karakteriEnBuyukEl( List<String> list   ){
        System.out.println(
        list.
                stream().
                sorted(Comparator.comparing(  t-> t.toString().length()).reversed()  ).//length karktr uzunluguna gre sıraladı
                findFirst()); // k>b sıraladı bir üstte ve burada ilk elemanı aldı


    }


    //karakter sayısı en büyük elemanı yazdırınız
    public static void karakteriEnBuyukEl2( List<String> list   ){
        Stream<String> sonIsim;
        System.out.println(
               sonIsim= list.
                        stream().
                        sorted(Comparator.comparing(  t-> t.toString().length()).reversed()  ).//length karktr uzunluguna gre sıraladı
                     //   findFirst()); // k>b sıraladı bir üstte ve burada ilk elemanı aldı
                limit(1)); //limit(a) akışdan çıkan alemanları a parametresine göre ilk a elamanı alır.

        System.out.println(Arrays.toString(sonIsim.toArray()));

    }


     // list elemanlarını son harfine göre sıralayıp ilk eleman hariç yazdırınız.
    public static void ilkElemanHaricSonHarfSirali ( List<String> list   ){

        list.
                stream().
                sorted( Comparator.comparing ( t-> t.charAt(t.length()-1) ) ).
                skip(1).// akıştan çıkan elemanların 1.parametreyi atlar.
                forEach(t-> System.out.print(t + " "));

    }

















}
