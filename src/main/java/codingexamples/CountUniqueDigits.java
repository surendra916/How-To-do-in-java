package codingexamples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountUniqueDigits {
    public static void main(String[] args) {
        Stream.of(1,2)
                        .sorted(Comparator.reverseOrder());
        System.out.println("Enter a number ranging from 1 and <= 25000 ");
        String s = String.valueOf(new Scanner(System.in).nextInt());
        System.out.println("Count is "+Arrays.stream(s.split("")).collect(Collectors.toSet()).stream().count());
    }
}
