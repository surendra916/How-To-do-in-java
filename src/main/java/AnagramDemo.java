import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AnagramDemo {
    public static void main(String[] args) {
        String str1 = "race";
        String str2 = "care";

        if(getSortedString(str1).equalsIgnoreCase(getSortedString(str2))){
            System.out.println(str1 + " and " + str2 +" are Anagrams");
        }else {
            System.out.println("Not Anagrams");
        }

    }

    private static String getSortedString(String str) {
        return Stream.of(str.split(""))
                .sorted()
                .collect(Collectors.joining());
    }
}
