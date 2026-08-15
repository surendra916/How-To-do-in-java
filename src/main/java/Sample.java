import java.util.*;
import java.util.stream.Collectors;

public class Sample {
    public static void main(String[] args) {
        String s  = "I am A developer";

        Map<String, Long> occurrencesMap = Arrays.stream(s.toLowerCase().split(""))
                .collect(Collectors.groupingBy(chr -> chr, LinkedHashMap::new,Collectors.counting()));
        boolean flag = false;
//        occurrencesMap.forEach((key, value) -> {
//            if(!key.equals(" ") && value > 1){
//                System.out.println("Key : "+ key);
//            }
//        });

        occurrencesMap.keySet()
                //.stream().collect(Collectors.toCollection(LinkedHashSet::new))
                .stream()
                .filter(key -> !key.equals(" ") && occurrencesMap.get(key) > 1)
                .findFirst()
                .ifPresent(n -> System.out.println(n));

        //System.out.println(occurrencesMap);



    }
}
