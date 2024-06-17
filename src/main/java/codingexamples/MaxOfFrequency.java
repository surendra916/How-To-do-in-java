package codingexamples;

import java.util.*;
import java.util.concurrent.Flow;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MaxOfFrequency {
    public static void main(String[] args) {
        String str = new Scanner(System.in).next();
        getFrequencyOfAlphabets(str);

    }

    public static void getFrequencyOfAlphabets(String str){
        int [] freq = new int[26];
        for(int i = 0; i < str.length(); i ++) {
            freq[str.charAt(i) - 'a']++;
        }
        for (int i = 0; i< str.length(); i++){
            int i1 = freq[str.charAt(i) - 'a'];
            if(i1 > 0){
                System.out.println("count of "+ str.charAt(i) + " is : "+ i1);
            }
        }
    }
}

/*
*
*   (char)('a'-32) => A
*   (char)('A'+32) => a
*
* */