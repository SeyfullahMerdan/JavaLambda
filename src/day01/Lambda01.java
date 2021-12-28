package day01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Lambda01 {

/*
1) Lambda "Functional Programming"
		      "Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?"*** dusunulur.
		      2) "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?"*** dusunulur
 3) "Functional Programming" hiz, code kisaligi, code okunabilirligi
		       ve hatasiz code yazma acilarindan cok faydalidir.
4) Lambda sadece collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak map'lerde kullanılmaz.***!!
		      Lambda kullanmak hatasız code kullanmaktır.

	 ***Evlerimizdeki temizlik robotu gibi ne yapacagını söylüyoruz,dokunuyoruz o nasıl yapacagını bilir.*****!!!!!

   ************!!!!!!!! Ne yapacagını söylüyoruz o kendisi ne yapcagını biliyor!!!****


		*/

    public static void main(String[] args) {

    List<Integer> list= new ArrayList<>(Arrays.asList(12,13,65,3,7,34,22,60,42,55));
        System.out.println("   Method Call ile Structured     ");
    printElStructured(list);   // method call çalıştı.
		System.out.println();
		System.out.println("   Lambda Expression     ");
    printElfunctional(list);      // lambda expression çalıştı.
		System.out.println();
		System.out.println(" Method Reference ile   " );
    printElfunctional1(list);       // method reference çalıştı.
		System.out.println();
		System.out.println(" Amele,Eski yöntem ile foreach ve if kullnarak -Structured çalıştı-  " );
    printCiftElStructured(list);
		System.out.println();
		System.out.println(" Lambda Expression ile Filtreleyerek çalıştı  " );
    printCiftfunctional(list);
		System.out.println();
		System.out.println(" Lambda Expression İki Method Refere ederek functional çalıştı  " );
    printCiftfunctional2(list);
        System.out.println();
        System.out.println(" Functional ile (LAMBDA)(Lambda Expression) filtreleyerek yazdırdım. t<60 " );
    printCiftAltmisKucuk(list);
        System.out.println();
        System.out.println(" Functional ile (LAMBDA)(Lambda Expression) filtreleyerek yazdırdım. t>20  " );
    tekYirmidenBuyukPrint(list);
        System.out.println();
        System.out.println(" Functional ile map kullanarak yazdırdım. Çiftlerinin Karesini aldım." );
     ciftKarePrint (list);
        System.out.println();
        System.out.println("Functional-Map**ile elemanları işleme tabi tuttum,degiştim.Küpünün 1 fazlasnı aldım" );
    tekKupBirFazla(list);
        System.out.println();
        System.out.println("Lambda ile *** map(Math:sqrt) *** methodu ile kareköklerini aldım !! ** " );
    karekokCiftfunctional(list);
		System.out.println();
		System.out.println("Lambda ile ***--- reduce(Math::max) ---*** ile içinden bir elemanı aldım.   " );
    enBuyukEleman(list);




}
    //Structured Programming ile list elemanlerinin tamamini aralarina bosluk birakarak yazdiriniz
    public static void printElStructured(List<Integer> list) {  // parametre tipi

        for (Integer w : list) {    // Her zaman yazdırdıgımız şekilde yazdırdım. java gelenegi for eachde kullanılır
            System.out.print(w+ " ");   // 12 13 65 3 7 34 22 60 42 55
        }

    }


    //Functional Programming ile list elemanlarinin  tamamini aralarina bosluk birakarak yazdiriniz
    public static void printElfunctional(List<Integer> list) {   // Lambda ile yazdıracam. Parametre girdim.

        list.stream().forEach(t->System.out.print(t+ " ")); // listteki her bir eleman geliyor,
        // t yapıyor ve sonraki koda devam ediyor

        // Bazı methodlar dikey yapıda çalışır bu yüzden Stream ile dikey hale getiriyoruz.

        // variablem t dir. Lambda Expression:Lambda İfadesi

        // Stream :  dataları yukarıdan aşagıya akış şekline getirir. Şelale,akıştır.Dikey olarak
        //           işlem yapacagım methoda sokarım. Stream de daha çok method çalışır. Lambda methodudur!!!***
        // forEach() :  datanın parametresine göre her bir elemanı çagırıp, işler
        // t-> : Lambda operatörüdür.
        // Lambda Expression yapisi çok tavsiye edilmez, daha çok METHOD REFERENCE kullanılır.

    }



      //  Method Reference --> Kendi create ettigimiz veya javadan aldıgımız method ile
     //   Syntexi şu şekildedir >>>>>  Classname::MethodName

    public static void printEl(int t) {
 // Refere etmek için,daha sonra kullanmak için bu methodu create ettim. Daha sonra bunu çagırıp, kullanacagım
        System.out.print(t + " "); // elemanı getir,yazdır.

    }


    public static void printElfunctional1(List<Integer> list) {

        list.stream().forEach(Lambda01::printEl); // LİSTİN HER BİR ELEMANINI İÇERİDEKİ İŞLEME TABİ TUTTUM!!***

        // list,akış ol,forEach sende elemanı getir veya methodu çalıştır.
        // Yukarıdaki methodu çagırdım. Method refere ettim. Reusuble olarak çalışacam.
        // Önceden hazırlayıp bi yere koyup sonra çagıracagım.

    }


    //Structured Programming ile list elemanlarinin cift olanlarını ayni satirda aralarina bosluk birakarak yazdiriniz

    public static void printCiftElStructured( List<Integer> list ) { // Elle manuel yazacam.

        for (Integer w:list) {
            if (w%2==0) {
                System.out.print(w + " ");  // Eski yöntem ile kodu create ettim.
            }  // Kendi yazımımda hata olabilir. Lambda hatayı ve kodu daha aza indirecek bir sistem
        }

        }



    //Functional Programming ile list elemanlarinin  cift olanlarını ayni satirda aralarina bosluk birakarak yazdiriniz

    public static void printCiftfunctional(List<Integer> list) {

        list.stream().filter(t->t%2==0).forEach(Lambda01::printEl); // Listi aldım,filtreledim,if gibi çalıştı.
// For Each ile işleme soktum bu elemanları,foeEache de method refere ettim,yazdırma methodunu
        // Classı yazıp methodu çagırırsak çalışır, her methodu yazabilirz.

        // filter () --> akış içerisindeki elemanları istenen şarta göre filtreleme yapar. //lambda expression
        // filter (   method refere edilebilir --- boolean çalıştı ).

    }


    public static boolean ciftBul(int i) { // Refere edilecek tohum method create ettim. ÇAgırıp kullanacam
        // int olarak gelen verileri ikiye tam bölünüyorsa true olarak return yapıyor.
        return i%2==0;
    }


    public static void printCiftfunctional2(List<Integer> list) {

       list.stream().filter(Lambda01::ciftBul).forEach(Lambda01::printEl); // İki method refere ettim.
    // birebir şart görevi görür. Filtreler...

    }

    // Functional Programming ile (LAMBDA DEMEK!!**) list elemanlarının çift olanlarının 60'dan küçük olanlarını
    // aynı satırda aralarına boşluk koyarak yazdırınız.
    public static void printCiftAltmisKucuk (List<Integer> list) {

        list.stream().filter(t->t%2==0 & t<60).forEach(Lambda01::printEl);
// filter() --- Ya hepsini method ya da lambda expression yapacaksınız der.

    }

    //Functional Programming ile list elemanlarinin  tek olanlarini veya 20 dan buyuk
    // olanlarını ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void tekYirmidenBuyukPrint(List<Integer> list ) {

        list.
                stream().
                filter(t->t%2==1 || t>20).
                forEach(Lambda01::printEl);  //forEach(t->System.out.print( t + " "))


    }


    //Functional Programming ile list elemanlarinin  cift olanlarinin
    // karelerini ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void ciftKarePrint (List<Integer> list   ) {
    //  . >>> Method Chain yani Zincir, MEthod Zinciri oluşturur.
        list.
                stream().
                filter(Lambda01::ciftBul).
                map(t->t*t).
                forEach(Lambda01::printEl);
        // map içine aldıgı elemanları degiştirir. ...set methodu gibi... Daha çok Matematiksel işlemler
 // map elemanların update edilmesi için veya bir işleme sokulması için kullanılır!!!****
//  map -->> bir ara işlemde kullanılır. Elemanları istenen işleme göre degiştirmek update etmek için kullanlır***
    }


    // Functional Programming ile list elemanlarinin tek olanlarinin
    // kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void tekKupBirFazla (List<Integer> list   ) {
// ELEMANLAR DEGİŞİYORSA MAP KULLANMAMIZ GEREKİR !!!!
       list.
               stream().
               filter(t-> t%2==1).
               map(t->t*t*t+1).
               forEach(Lambda01::printEl);

    }


    // Functional Programming ile list elemanlarinin çift olanlarinin
    // kareköklerinin bir fazlasini ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void karekokCiftfunctional (List<Integer> list) {
       list.
               stream().
               filter(Lambda01::ciftBul).
               map(Math::sqrt).  // 3 5 7 8    4 6 8 9
               forEach(t-> System.out.println(t + " "));
   // map(Math:sqrt)  Karekökünü alma methodudur !!***
    }


    // Listin en büyük elemanını yazdırınız.
    public static void enBuyukEleman (List<Integer> list) {
                                          // 3 5 7 8    --- >>  23   //  8  // 3
        Optional<Integer> maxEl = list.stream().reduce(Math::max); // --> azaltmak anlamındadır.
        System.out.println(maxEl); // Optional[65]

        // Optional -->> Lambdanın özel typedir. Değer alabilen boş olan veya olmayan bir kap gibidir.
        //    ---> Exception gibi çalışır. Her yola açık anlamında.
        // Gelen integer degeri Stringe bile çevirebilirim!!!***
        // Wrapper Class diyebilriz.
        // Ne gönderirsen alırım, uyarım der. Çoklu Type yan Jenerik !!!
        // (Jenerik-java advance konusu) bir classdır, Integerdir. İçerisi Data Typedir.


        // reduce: --> azaltmak \\ birçok datayı tek bir dataya çevirmek için kullanılır.

        // Çok datayı bir datayı çevirir. Azalt ve bana bir şey ver.
        // (max,, min,, çarpma top. vs. işlemlerde) Bir deger return etmek için kullanılır.

        // ÖRN:: 20 elemanlı bir listenin elemanları toplamak için reduce kullanılır. ( --> reduce(sum) )
        // elemanları birbirine baglı bir şekilde işleme sokmak için reduce kullanılır !!!****


    }



}
