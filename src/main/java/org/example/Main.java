package org.example;

import java.security.PrivilegedAction;
import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

public class Main {

    //@FunctionalInterface
    public interface FunctionalInterface2{
        void show();
        void show2();
    }

    @FunctionalInterface
    interface InterfaceForLambda{
        String wish(String msg);
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        FunctionalInterfaceDemo functionalInterfaceDemo = (n1,n2) -> {
            return n1 + n2;
        };
        System.out.println("Main.main after add is "+ functionalInterfaceDemo.add(2,3));


        InterfaceForLambda interfaceForLambda = msg -> msg;
        Function<String, String> func = interfaceForLambda::wish;
        System.out.println(func.apply("Good morning"));

        // Using anonymous inner class
        FunctionalInterface2 functionalInterface2 = new FunctionalInterface2() {
            @Override
            public void show() {
                System.out.println("Main.show  functionalInterface2 ");
            }

            @Override
            public void show2() {
                System.out.println("Second abstract method");
            }
        };

        functionalInterface2.show();
        functionalInterface2.show2();





        List<String> cities = new ArrayList<>();
        cities.add(null);
        cities.add("Mumbai");
        cities.add("Goa");
        cities.add("Pune");

        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);

        Stream.of(1,2,4).findFirst().orElseGet(() -> 2);

        boolean b = ints.stream().mapToInt(el -> el).allMatch(el -> el > 2);


        Function<String, Character> stringCharacterCharacterFunction = (String city) -> city.charAt(0);
        cities.stream().map(stringCharacterCharacterFunction).forEach(System.out::println);
        //Consumer, Predicate and Supplier are Functional interfaces.

        // Consumer
        /*
          void accept(T value);
          default Consumer<T> andThen(Consumer<? super T> after);
        */
        Consumer stringConsumer = city -> System.out.println(city);
        stringConsumer.accept("Delhi");
        cities.forEach(stringConsumer);

        // Predicate
        /*
            boolean test(T value);
            default Predicate<T> and(Predicate<? super T> other);
            default Predicate<T> negate();
            default Predicate<T> or(Predicate<? super T> other);
            static <T> Predicate<T> isEqual(Object targetRef);
            static <T> Predicate<T> not(Predicate<? super T> target);
        */
        Predicate<String> stringPredicate = city -> city.equalsIgnoreCase("Delhi");
        stringPredicate.test("Delhi");
        cities.stream().filter(Objects::nonNull).filter(stringPredicate).forEach(System.out::println);

        // Supplier
        // Supplier supplies / returns something

        Supplier<String> stringPrivilegedAction = () -> "Supplier normal String";
        Optional<String> stringOptional = Optional.ofNullable(null);
        stringOptional.orElse(stringPrivilegedAction.get());



    }
}