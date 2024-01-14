package codingexamples;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CheckNumericBasedProgram {

    public static boolean checkIfPrime(int n){
        return n > 1 && IntStream.range(2, n).noneMatch(num -> num % n == 0);
    }

    public static void main(String[] args) {
        //System.out.println("Is Prime : "+checkIfPrime(2));
        //findCommonElementsFromTwoArrays();
        System.out.println(findLongestString(new String[]{ "abc", "wwww", "eeeeee", "iiiiiiiiii"}));
        System.out.println("Sum is : "+sumOfFirstTenPrimeNumbers());
    }

    public static List<Integer> sumOfFirstTenPrimeNumbers(){
        return Stream.iterate(1, i -> i + 1)
                .filter(CheckNumericBasedProgram::checkIfPrime)
                .limit(10)
                .collect(Collectors.toList());

    }

    public static int sumOfNEvennumbers(int limit){
        return IntStream.iterate(1, i -> i + 1)
                .filter(i -> i % 2 == 0)
                .limit(limit)
                .sum();
    }

    public static void findCommonElementsFromTwoArrays(){
        int[] arr1 = {1, 5, 7, 2, 8};
        int[] arr2 = {3, 4, 5, 6, 8};
        Arrays.stream(arr1)
                .filter(num -> Arrays.stream(arr2).anyMatch(n -> n == num))
                .boxed()
                .collect(Collectors.toList());
    }

    public static int[] reverseArray(int[] arr){
        IntStream.range(0, arr.length / 2)
                .forEach(i ->{
                    int temp = arr[i];
                    arr[i] = arr[arr.length - i - 1];
                    arr[arr.length - i - 1] = temp;
                });
        return arr;
    }

    public static String findLongestString(String[] strArray){
        Optional<String> max = Stream.of(strArray)
                .max(((o1, o2) -> o1.length() < o2.length() ? -1 : o1.length() == o2.length() ? 0 : 1));

        return max.orElse("default");
    }
    // removeDuplicates by maintaining order
    public static String[] removeDuplicates(String[] strArray){
        return Arrays.stream(strArray)
                .collect(Collectors.toCollection(LinkedHashSet::new))
                .toArray(String[]::new);
    }


}
