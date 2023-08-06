package StreamsDemo;

import java.util.function.BiFunction;
import java.util.function.Function;

public class MethodReferenceExample {

    @FunctionalInterface
    public interface wish{
        void greet();
    }

    public static void wish(){
        System.out.println("This is a method ref");
    }

    public int add(int a, int b){
        return a + b;
    }

    public int getStringLength(String s){
        if(s == null){
            throw new CustomException("Invalid String is being passed");
        }
        return s.length();
    }


    public static void main(String[] args) {
        MethodReferenceExample methodReferenceExample = new MethodReferenceExample();
        wish wish = MethodReferenceExample::wish;
        wish.greet();

        BiFunction<Integer,Integer,Integer> function = methodReferenceExample::add;
        System.out.println(function.apply(3,2));

        Function<String, Integer> integerFunction = methodReferenceExample::getStringLength;
        System.out.println("length of string is "+integerFunction.apply("surendar"));





    }
}
