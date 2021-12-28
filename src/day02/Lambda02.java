package day02;

import day01.Lambda01;
import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class Lambda02 {

    // sout -- psvm + TAB  --> main ve syso kısayolu !!!
    // variable. sout yazdıktan sonra TAB basınca Syso için alıyor direk..

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(12, -3, 65, 3, 7, 34, 22,15, 42, 15));

        System.out.println("***** Lambda ile t-> t  yazdırdım.  **Reduce(Integer::max) methodu ile *****");
        ciftKAreMax(list);
        System.out.println("***** Lambda ile t-> t  yazdırdım.  **reduce(0, (t, u) -> t + u) ile yazdırdım *****");
        toplaEl1(list);
        System.out.println("***** Method reference ile yaptım.   **Math::addExact / Integer::sum *****");
        toplaEl2(list);
        System.out.println("***** Method reference ile yaptım.   **Math::multiplyExact ile *****");
        carpCiftEl1(list);
        System.out.println("***** Method reference ile yaptım.   **reduce(-1, (x, y) -> (x*y)); *****");
        carpCiftEl2(list);

        System.out.println("***** En küçük elamanı dört farklı yolla buldum *****");
        min1(list);
        min2(list);
        min3(list);
        min4(list);

        distinctT(list);
        System.out.println("*****  *****");
        System.out.println("***** filter und reduce *****");
        onbestenBykKckTekSayi(list);
        System.out.println("*****  *****");
        System.out.println("***** akışa giren elemanlarının karesini yazdırıp sıraladım *****");
        ciftKareKckByk(list);
        System.out.println("*****  *****");
        System.out.println("***** akışa giren elemanları sorted(Comparator.reverseOrder()). sıraladım *****");
        tekKareBykKck(list);




    }

    // Listin çift elemanlarının karelerini alınız. En büyügünü yazdırınız.
    public static void ciftKAreMax(List<Integer> list) {
                                                     //   4  6  8             //  16  36  64         //  64
        Optional<Integer> maxEl = list.stream().filter(Lambda01::ciftBul).map(t -> t * t).reduce(Integer::max);

        // int maxEl = list.stream().filter(Lambda01::ciftBul).map(t -> t * t).reduce(Integer::max);
        // int hata veriyor, java öngöremedigi için optional olmasını istiyor, belki int sınırını aşacak vs vs diye..

        // reduce() returne edilen eleman null yada int 'den buyuk olur ihtimali icin Java;
        // guvenlik olarak handle ederek Optional class'ı şart koşuyor.

        Optional<Integer> maxEl1 = list.stream().filter(Lambda01::ciftBul).map(t -> t * t).reduce(Math::max);
        // reduce(Math::max) da kullanılabilir ancak reduce(Integer::max); daha spesific oldugu için daha
        // hızlı çalışır. Daha küçük daha çabuk gibi düşünebilirz.

        System.out.println(maxEl);

    }


    // listteki tüm elemanların toplamını yazdırınız.   Lambda Expression ile. t->t...
    public static void toplaEl1(List<Integer> list) {
        // Map ve Reduce farkı

        // Elemanları update edeceksek Map ama eleman sayısı degişecekse Reduce !!!***
        // 5 6 7 -> 8 9 10 olacaksa MAP ama 5 6 7 -> 18 olacaksa REDUCE !!***
        // Akıştaki elemanlarda meydana gelecek degişiklikler içindir Map kullanımı...***


        // int toplamMathle = list.stream().reduce(Math::sum);

        int toplam = list.stream().reduce(0, (t, u) -> t + u);

        /*
    (  alt tuşuna basarak,aynı anda 3 satırda işlem..    t her zaman ilk degerini atanan degerden alır
   (  alt tuşuna basarak,aynı anda 3 satırda işlem..     u her zaman degerini list.stream() den alır
   ( alt tuşuna basarak,aynı anda 3 satırda işlem..      t ilk degerden sonraki degerlerini işlemden alır
         */

                  /*                t              u
               t 0'dan aldı ilk degeri u listten aldı topladı ve sonucu x'e atadı kendisi diger degeri aldı...
                                    0              5              5
                                    5             -8              -3
                                   -3              13              10
                                    10             24              34
                                                       ---> 34
                   */


        System.out.println(toplam);


    }


    // listteki tüm elemanların toplamını yazdırınız. Method Reference ile
    public static void toplaEl2(List<Integer> list) {

        Optional<Integer> toplam = list.stream().reduce(Integer::sum); // Method reference yaptım.
        Optional<Integer> toplam2 = list.stream().reduce(Math::addExact); // Method reference yaptım.
        System.out.println(toplam);
    }


    // listteki Çift elemanların çarpımını yazdrınız. Method reference yaparak yapalım.
    public static void carpCiftEl1(List<Integer> list) {

        Optional<Integer> carp = list.stream().filter(Lambda01::ciftBul).reduce(Math::multiplyExact);
        // multiplyExact çarpım işlemi yapar
        System.out.println(carp);


    }


    // listteki çift elemanların çarpımını yazdrınız. Lambda expression yaparak yapalım.
    public static void carpCiftEl2(List<Integer> list) {

        Integer carp = list.stream().filter(Lambda01::ciftBul).reduce(1, (x, y) -> (x * y));

        System.out.println(carp);
        // pozitif deger üretin
        Integer carppoz = list.stream().filter(Lambda01::ciftBul).reduce(-1, (x, y) -> (x * y));

        // identity olayı bize farklı opsiyonlar tanır. Mesela negatif sonucu pozitif yapabilriz
        // yüzde ellisini alabiliriz 0,5 yazarak.
        // math::abs classı --- mutlak deger alır...

        System.out.println(carppoz);

    }


    // listteki elemanların en küçügünü 4 farklı yöntem ile yazdırınız

    // 1. Yöntem  --- Method Reference --> Integer class
    public static void min1(List<Integer> list) {
        Optional<Integer> min = list.stream().reduce(Integer::min);
        System.out.println(min);
    }

    // 2. Yöntem  --- Method Reference --> Math class
    public static void min2(List<Integer> list) {
        Optional<Integer> min = list.stream().reduce(Math::min);
        System.out.println(min);
    }

    // 3. Yöntem  --- Method Reference --> Kendi classımdan oluştudugum merhodu çagırarak yapacam
    public static int minBul(int x, int y) {
        return x<y ? x : y ;   // Returnu ternary yaparak döndürecem. x küçükse xi degilse y yi döndür dedim.
    }
    // Eger toplama ile ilgili bir method yazıyor olsaydım; boş konteynr oluşturup atmalıydım.

    public static void min3(List<Integer> list) {
        Optional<Integer> min = list.stream().reduce(Lambda02::minBul);
        System.out.println(min);
    }


    // 4. Yöntem  --- Lambda expression -- Sort ile sırala en baştakini ver diyecem
    public static void min4(List<Integer> list) {
        int min = list.stream().reduce(   Integer.MAX_VALUE, (x,y) -> x<y?x:y    );

        // x ilk degeri identity den alacagı için MAXValue aldık. Y küçük olacak ve ilkinde y sonuç olacak,
        // sonra y -> x olacak,x ikinci degerini sonuçtan alıyor.. Y şelaleden alıyor. Y ikinci degeri alacak
        // y 11 ise küçük olursa sonuç 11 olacak, x 11 olacak y 8 olacak sonra x 8 olacak y şelaleden geldi
        // -7 oldu sonrasında x -7 olack şelalden -82 sonuca gelcek.
 // min dersek şelaleden ne sonuç gelirse gelsin o min degeri vercek sonuç, sonsuz döngü gibi olacak.O yüzden max..

        System.out.println(min);

    }



    // distinct kullanımı  --- tekrarlanan elemanları çıkarır, işleme almaz. - + duyarlılıgı vardır.!
    public static void distinctT ( List<Integer> list  ) {

        list.stream().distinct().filter(t->t%2!=0).map(t->t+1).forEach(t-> System.out.print(t + " "));

    }

    public static void maxEl2 ( List<Integer> list  ) {

        Integer maxEl2=list.stream().distinct().reduce( Integer.MIN_VALUE, (t,u)->t>u?t:u );
        System.out.println(maxEl2); // ilk degeri en küçük yapıyorum ki bana list dışından bir sonuç vermesin.
        //ör. -1000 dedim,listeden-2000gelirse bana sonuç-1000 döner,liste dışı bir sonuçtr,byüzdn en kçk degeri verdim
    }

    public static void maxEl3(List<Integer> list) {

        Integer maxEl3=list.stream().distinct().sorted().reduce(Integer.MIN_VALUE, (t,u)->u  );
        System.out.println(maxEl3);// sorted yaptım,sıraladım,çünkü biliyorum ki gelcek bir sonraki eleman daha byk..

    }

     // listteki 15'den büyük en küçük tek sayıyı yazdırınız.
    public static void onbestenBykKckTekSayi(List<Integer> list   ){

        System.out.println( list.stream().filter(t-> t%2==1 & t>15).reduce(Integer::min)    );

    }


    // listtin çift elemanlarının kareleri küçükten büyüge yazdırınız.
    public static void ciftKareKckByk(List<Integer> list   ){

        list.
                stream().
                filter(t->t%2==0).  // Lambda01::ciftBul
                map(t->t*t).
                sorted().  // Natural ordere göre sıralanır...
                forEach(Lambda01::printEl);

    }

    // listtin tek elemanlarının kareleri büyükten küçüge yazdırınız.
    public static void tekKareBykKck(List<Integer> list   ){

        list.
                stream().
                filter(t->t%2==1).
                map(t->t*t).
                sorted(Comparator.reverseOrder()).  // akışa giren elemanları ters sıralarrr
                forEach(Lambda01::printEl);

    }







}