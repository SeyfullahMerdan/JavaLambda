package day04;

import java.util.*;
import java.util.stream.Collectors;

public class Lambda04 {

    public static void main(String[] args) {

    TechPro trGunduz = new TechPro("yaz", "TR gunduz", 97, 124);
    TechPro engGunduz = new TechPro("kis", "ENG gunduz", 95, 131);
    TechPro trGece = new TechPro("bahar", "TR gece", 98, 143);
    TechPro engGece = new TechPro("sonbahar", "ENG gece", 93, 151);

            List <TechPro> list = new ArrayList<>(Arrays.asList(trGunduz,engGunduz,trGece,engGece));

            // Bu classda return type çalışacagız.

        System.out.println("******--allmatch ile");
        System.out.println(batchOrt92Byk(list));
        System.out.println();
        System.out.println("ogrcSayisi110az-nonematch ile");
        System.out.println(ogrcSayisi110Az(list));
        System.out.println();
        System.out.println("herhangi bir elaman-anymatch");
        System.out.println(herhangiBirBaharKonrol(list));
        System.out.println();
        System.out.println("collect ile");
        System.out.println(ogrcSayisiTersSiraliBatch(list));
        System.out.println();
        System.out.println("limit ve collectorlist ile");
        System.out.println(batchOrtTersSiraliBatch(list));
        System.out.println();
        System.out.println("limit ve collectorlist ilelimit ve skip ile collector ile");
        System.out.println(ogrcSayisiEnAz2Batch(list));
        System.out.println();
        System.out.println("filter map reduce");
        System.out.println(ogrcOrt95BykOgrcSayisi(list));
        System.out.println();
        System.out.println("maptoInt - sum Çalıştık ");
        System.out.println(ogrcOrt95BykOgrcSayisi1(list));
        System.out.println();
        System.out.println("mapToDouble ve average çalıştık");
        System.out.println(ogrcSayi130BykBatch(list));
        System.out.println();
        System.out.println("**count- cointains***");
        System.out.println(gunduzBatchSayisi(list));
        System.out.println();
        System.out.println("** max  **");
        System.out.println(ogrcSayisi130FazlaEnBykBatch(list));
        System.out.println();
        System.out.println("** getToInt ve min()  **");
        System.out.println(ogrcSayisi150AzEnKckBatch(list));



    }

// batch ortlarının 92den büyük oldugu kontrol eden pr create ediniz
     public static boolean batchOrt92Byk (List<TechPro>list) {

        return list.
                stream().
                allMatch(t->t.getBatchOrt() > 92);
        // akışdaki her eleman batchort fielda göre eşleşmesi kontrol edilcek

     }


// ögr sayılarıının 110den az olmadıgını kontrol eden pr create ediniz.
     public static boolean ogrcSayisi110Az (List<TechPro>list) {

     return list.
             stream().
             noneMatch(t-> t.getOgrcSayisi()<100);

}


    // batchlerde herhangi birinde bahar olup olmadıgnı kontrol eden bir pr create edin
    public static boolean herhangiBirBaharKonrol (List<TechPro>list) {
        return list.
                stream().
                anyMatch(t-> t.getBatch().equals("bahar"));
    }


    // batchleri ögrenci sayılarına göre b>k sıralayınız.
    public static List<TechPro> ogrcSayisiTersSiraliBatch (List<TechPro>list) {
        return list.
                stream().
                sorted(Comparator.comparing(TechPro::getOgrcSayisi).reversed()).//ögrsayısı parmetresine göre ters sıra
                collect(Collectors.toList()); // colelct()-> akışdaki elemanları istenen şarta göre toplar
        // Collectors.toList collecte toplanan elemanları liste çevirir.


    }

       // batchleri batch ortalamasına göre büykten küçüge sıralayıp ilk 3 unü yazdırınız.
    public static List<TechPro> batchOrtTersSiraliBatch (List<TechPro>list) {
        return list.
                stream().
                sorted(Comparator.comparing(TechPro::getBatchOrt).reversed()).//ögrsayısı parmetresine göre ters sıra
                  limit(3).collect(Collectors.toList()); // colelct()-> akışdaki elemanları istenen şarta göre toplar
        // Collectors.toList collecte toplanan elemanları liste çevirir.

    }

    // ögr sayısı en az olan 2. batchi yazdırınız.
    public static List<TechPro> ogrcSayisiEnAz2Batch (List<TechPro>list) {
        return list.
                stream().
                sorted(Comparator.comparing(TechPro::getOgrcSayisi)).//
                limit(2).  // ilk iki eleman alında
                skip(1). // ilk ikiyi aldıktan sonra 1. yi atladık.
                collect(Collectors.toList()); // collect()-> akışdaki elemanları istenen şarta göre toplar
        // Collectors.toList collecte toplanan elemanları liste çevirir.

    }


    //task 07--> batch ort 95 'den buyuk olan batch'lerin ogrc sayilarini toplamini yazdiriniz

    public static int ogrcOrt95BykOgrcSayisi (List<TechPro>list) {
       return list.
                stream().
                filter(t-> t.getBatchOrt()>95). // 95den büyük şartı saglandı
                map( t->t.getOgrcSayisi()).   // batch ort olan data ogrc sayisi olarak update edildi.
               // reduce(0, Integer::sum); // ogrc sayısı toplandı
                reduce(0, (t,u)-> t+ u); // ogrc sayısı toplandi

    }


    public static int ogrcOrt95BykOgrcSayisi1 (List<TechPro>list) {
        return list.
                stream().
                filter(t-> t.getBatchOrt()>95). // 95den büyük şartı saglandı
                        mapToInt( t->t.getOgrcSayisi()). // type göre int return eder ki sum() çalışır

                 sum();

    }



       // ögrenci sayıları 130dan büyük olan batchlerin batch ort bulunuz
    public static OptionalDouble ogrcSayi130BykBatch (List<TechPro>list) {
        return list.
                stream().
                filter(t-> t.getOgrcSayisi()>130). // 130'dan büyük şartı saglandı
                mapToDouble( t->t.getBatchOrt()).
                average();
    }

        // gunduz batchlerinin sayısını yazdırınız.
    public static int gunduzBatchSayisi(List<TechPro>list) {

        return (int) list.
                stream().
                filter(t-> t.getBatchName().
                        contains("gunduz")).
                count();
    }

       // ögrenci sayıları 130^dan fazla olan batchlerden en büyük batch ort'unu bulunuz.

    public static OptionalInt ogrcSayisi130FazlaEnBykBatch(List<TechPro>list) {
        return list.
                stream().
                filter(t->t.getOgrcSayisi()>130).
                mapToInt(TechPro::getBatchOrt).
                max();
    }

            // ögrenci sayıları 150'den az olan batchlerin en küçük batch ortalamasını bulunuz

    public static int ogrcSayisi150AzEnKckBatch(List<TechPro>list) {
        return list.
                stream().
                filter(t->t.getOgrcSayisi()<150).
                mapToInt(TechPro::getBatchOrt).
                min().
                getAsInt();  // bu method çıktıyı int type olarak return eder.
    }












}