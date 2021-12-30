package LambdaPraktice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Q03 {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();

        list.add("Lutfullah");
        list.add("Emine");
        list.add("Emine");
        list.add("Ugur");
        list.add("Yusuf");
        list.add("Seyfullah");
        list.add("Hakan");

// konsoldaki farklı ögeleri uzunluklarıyla birlikte yazdıralım
        list.stream().distinct().sorted().forEach(t-> System.out.println(t + "=" + t.length()));
        System.out.println();
 //Konsoldaki farklı öğeleri yazdırın, son karakterlerine göre sıralayın.
        list.stream().
                distinct().
                sorted(Comparator.comparing(t->t.charAt(t.length()-1))).
                forEach(t-> System.out.println(t));
        System.out.println();
// konsoldaki farklı ögeleri yazdırın, uzunluklarına göre sıralayın
        list.stream().
                distinct().
                sorted(Comparator.comparing(t->t.length())).
                forEach(t-> System.out.println(t));


        System.out.println();
   // konsoldaki farklı ögeleri ters sırada yazdırın
        list.stream().distinct().sorted(Comparator.reverseOrder()).forEach(t-> System.out.println(t));

  // Uzunlugu 7den küçük olan farklı ögeleri ters sırada konsolda büyük harfle yazdırınız

        list.
                stream().
                filter(t->t.length()<7).
                distinct().
                map(t->t.toUpperCase()).
                sorted(Comparator.reverseOrder()).
                forEach(t-> System.out.println());












    }
}
