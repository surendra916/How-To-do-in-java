package ComparableAndComparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ComparableDemo {


    public static void main(String[] args) {

        // Sorting in DESCENDING ORDER
        List<String> list = Arrays.asList("abc","def","ghi","jkl","mno","pqr");
        //Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);

        String[] strArray = {"abc", "def", "ghi", "jkl", "mno", "pqr"};
        Arrays.sort(strArray);
        String collect = Arrays.stream(strArray)
                .collect(Collectors.joining("--"));
        System.out.println(collect);

    }
}
