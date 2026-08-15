import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FedexDemo {

        public static void main(String[] args) {
            List<Integer> ls = new ArrayList<>(Arrays.asList(4,3,4,2,5,6,3,5,4,2,5));

            // take uniq, find freq,
            //HashSet<Integer> uniqueSet = new HashSet<>(ls);
            //ls.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

            Map<Object, Long> frequencyMap = ls.stream()
                    .collect(Collectors.groupingBy(num -> num, Collectors.counting()));



            // 5 -> 3
            List<Long> collect = frequencyMap.values().stream().toList().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

            frequencyMap.forEach((key, val) ->{
                if(collect.contains(val)){
                    System.out.println(key);
                }
            });

        }

}

