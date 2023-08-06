package codingexamples;

import java.util.Scanner;

public class CountNonRepeatingNumbers {
    public static void main(String[] args) {
        System.out.println("Enter a number ranging from 1 and <= 25000 ");
        String num = new Scanner(System.in).next();
        int gcount = 0;
        for(int i = 0; i < num.length(); i++){
            int finalI = i;
            if(num.chars().filter(character -> {
                return character == num.charAt(finalI);
            }).count() == 1)
                gcount++;
        }
        System.out.println("Count is "+gcount);
    }
}
