package LambdaPraktice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Q01 {


    public static void main(String[] args) {

            List<String> list=new ArrayList<>();
            list.add("Angle");
            list.add("Andy");
            list.add("Ali");
            list.add("Emrah");
            list.add("Nilgun");
            System.out.println(list.stream()
                    .filter(t -> t.startsWith("A"))
                    .filter(t -> t.length() < 5)
                    .map(String::toUpperCase)
                    .collect(Collectors.toList()));

    }

}
