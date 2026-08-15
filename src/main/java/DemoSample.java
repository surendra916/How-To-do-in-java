import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class DemoSample {
    public static void main(String[] args) {

        String alphabets = "abcdefghijklmnopqrstuvwxyz";

        List<List<String>> myList = Arrays.asList(
                Arrays.asList("1", "3", "99", "2", "14", "2"),
                Arrays.asList("111", "7", "199", "abc","92", "14", "20"),
                Arrays.asList("10", "31", "9", "21", "243", "432"),
                Arrays.asList("31", "13", "999", "5", "41", "222"),
                Arrays.asList("10", "31", "401",null, "42", "11", "77")
        );

        int sum = myList.stream()
                .flatMap(List::stream)
                .filter(obj -> obj != null && !alphabets.contains(obj))
                .mapToInt(Integer::valueOf)
                .filter(num -> num % 2 == 1)
                //.peek(System.out::println)
                .sum();

        System.out.println("Sum of the Odd numbers is "+ sum);


    }


}
