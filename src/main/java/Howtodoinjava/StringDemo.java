package Howtodoinjava;

import java.util.*;
import java.util.function.*;
import java.util.stream.IntStream;

public class StringDemo {

    String name;
    static Integer age;

    public static void main(String[] args) {
        String blogName1 = new String("howtodoinjava.com");
        //blogName1 = "howtodoinjava.com";
        String blogName2 = new String("howtodoinjava.com");
        String blogName3 = new String("howtodoinjava.com");

//        System.out.println(blogName1 == blogName2); // == checks fro referential equality
//        System.out.println(blogName1.equals(blogName2)); // equals checks for contents of strings
//
//        System.out.println(blogName1.startsWith("w",3));
//        System.out.println(blogName1.indexOf("w"));
//        System.out.println(blogName1.concat(" ** ").concat(blogName3));
//        System.out.println(blogName1.replace('w','W'));
//        System.out.println(blogName1.replace("how","where"));
        System.out.println(blogName1.contentEquals(new StringBuilder(blogName2)));
        CharSequence s = "ssr";
        String st = "ssr";
//        System.out.println(st.contains(s));
//        System.out.println(String.join(",","a","b","c","d","e"));

        System.out.println(String.join("**", Arrays.asList("a","b","c","d","e")));

        // If a String with content “howtodoinjava” already exists, the new literals will be pointing to the already existing literal.
        // In the case of String objects, a new String object will be created in the heap every time.
        String a = "howtodoinjava";
        String b = "howtodoinjava";
//        System.out.println(a == b);     //true
//
//        String c = new String("howtodoinjava");
//        System.out.println( a == c);// false => because object reference is in HEAP, and string literals obj ref is in string const pool

        // "equals" checks the string contents
        // "==" checks for referential equality
        StringDemo stringDemo = null;

        //stringDemo.reverseString("");
        //System.out.println(stringDemo.name);
        //stringDemo.toString();
        //int age1 = stringDemo.age;
        //System.out.println("age is "+age);

        List<String> list = Arrays.asList("a", "b", "c", "d", "e");
        list.set(4,"f");


        Function<String, Integer> stringIntegerFunction = str -> st.length();
        stringIntegerFunction.apply("Boom");

        BiFunction<String,String,Integer> stringStringIntegerBiFunction = (String s1, String s2) -> {
            System.out.println("Executed");
            return Integer.valueOf(2);
        };

        stringStringIntegerBiFunction.apply("","");

        Consumer<String> consumer = str -> System.out.println(str);
        consumer.accept("Consume API");

        BiConsumer<String,String> biConsumer = (str1,str2) -> System.out.println("Accepted 2 values");
        biConsumer.accept("","");

        Supplier<Integer> supplier = () -> 2;
        supplier.get();

        Predicate<Integer> integerPredicate = i -> i % 2 == 0;
        integerPredicate.test(2);

        BiPredicate<String, Integer> stringIntegerBiPredicate = (str, len) -> str.length() == len;
        stringIntegerBiPredicate.test("suri",4);

        String ssr = "surendra";
        ssr.indexOf("ra");
        System.out.println(ssr.indexOf("ra"));
    }

    public String reverseString(String string) {
        if (string.isEmpty()) {
            return string;
        }
        return reverseString(string.substring(1)) + string.charAt(0);
    }
}
