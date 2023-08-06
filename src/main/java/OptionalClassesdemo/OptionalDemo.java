package OptionalClassesdemo;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class OptionalDemo {





    public static void main(String[] args) {

        Optional<String> stringOptional = Optional.of("Surendra Reddy ");
        String s = stringOptional.get();

//        Optional<String> stringOptional1 = Optional.of(null);// NullPointerException
//        System.out.println(stringOptional1.get());// NullPointerException -> Optional.of() method

//        Optional<String> o = Optional.ofNullable(null);// Returns empty optional
//        o.get();// No value present error

        // Is

        // map() returns transformed
        /*
        * The map() method allows us to perform an operation on each value in an optional and return the result as a new optional.
        * If the optional is empty, the function is not applied and an empty optional is returned.
        * */
//        Optional<List<String>> optionalStrings = Optional.of(new LinkedList<>(Arrays.asList("ssr", "Name", " is", " too", " short")));
//        Optional<List<String>> optionalStrings1 = optionalStrings.map(list -> {
//            list.add("boom");
//            return list;
//        });
//        optionalStrings1.ifPresent(list -> list.stream().forEach(System.out::println));

        // Example 2:
        Optional<String> optionalName = Optional.ofNullable("John");
        optionalName = Optional.empty();
        Optional<String> str = optionalName.map(name -> name.toUpperCase());
        System.out.println(str);

        Supplier<String> supplier = () -> "";
        supplier.get();

        Consumer<String> consumer = strr -> System.out.println(strr);
        consumer.accept("jhvjhv");

        Function<String, Integer> function = st -> st.length();
        Integer srre = function.apply("Srre");


    }
}
