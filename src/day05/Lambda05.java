package day05;

import day01.Lambda01;

import java.util.stream.IntStream;

public class Lambda05 {

    public static void main(String[] args) {
        System.out.println("TASK =01 - STructured,FUnctional");
        System.out.println(topla(10));
        System.out.println(topla1(10));
        System.out.println(topla2(10));
        System.out.println("TASK02-CiftBul-Filter");
        System.out.println(toplaCift(10));
        System.out.println(toplaCift1(10));
        System.out.println("TASK03");
        System.out.println("TASK04");
        System.out.println("TASK05");
        System.out.println("TASK06");
        System.out.println("TASK07");
        System.out.println("TASK08");
        System.out.println("TASK09");

    }



    // TASK01 Structured ve Functional Programming ile 1'den X2e kadar tamsayıları toplayan bir pr yazınız.
    public static int topla (int x){   // Structured-Core Java ile toplama yaptım
        int toplam=0;
        for (int i = 0; i <= x; i++) {
            toplam+=i;
        }
        return toplam;
    }
    // Functional Programming-Lambda ile
    public static int topla1 (int x){
        return IntStream.range(1,x+1).sum(); // 1 2 3 .. x elemanları akışa sokup topladı. Filter/Map/Reduce çalşacgz..
 // intStream verileri akışa sokar.Tek başına akışı saglamaz.String-Stream gibi. Sonrasında her şeyi çalışabilriz.
    }

    public static int topla2(int x) {
        return IntStream.rangeClosed(1,x).sum(); // 1 ve x dahildir. Yukarıdakinde 1'den Xe X dahil degildi
        // bu yüzden Xi almak için X+1 yapmıştık , burada ikiside dahil,ekstra düşünmeye gerek yok!.
    }


    // TASK02  -----  1den Xe kadar çift tamsayıları toplayan bir pr yazınız

    public static int toplaCift(int x) {
        return IntStream.   // sayıları akışa soktum
                rangeClosed(1,x).  // xe kadar olanı x dahil aldım
                filter(t->t%2==0).  // expresiion yaptım,şart koştum
                sum();  // topladım
    }

    public static int toplaCift1(int x) {
        return IntStream.
               iterate(2,t->t+2). // bu akışı verir bize ama bu akış sonsuza kadar gider.
               limit(x/2).//sonsuz döngüyü kırmak için Xe kadar limit koydum,Xe geldigi zaman bitiyor
                sum(); //ilk 10 eleman demek --- limit(10)
    }



   // TASK03 -- İlk x pozitif çift sayıyı toplayan pr yazınız.
/*
    public static int ilkXPozitifCiftSayi(int x) {
        return list


    } */
















}
