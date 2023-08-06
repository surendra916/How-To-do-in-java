package codingexamples;

import java.util.Arrays;
import java.util.Scanner;

public class FindStringsSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().toLowerCase();
        String[] s1 = s.split(" ");
        String sum = "";
        for (int i = 0; i< s1.length; i++){
           sum += calculateWeight(s1[i]);
        }
        System.out.println(Integer.parseInt(sum));

    }

    public static String calculateWeight(String s){
        int sum = 0;
        int i = 0;
        for (i= 0 ; i < s.length() / 2; i++){
            int ch1 = (s.charAt(i) - 96) - (s.charAt(s.length() - i - 1) - 96);
            ch1 = ch1<0 ? ch1 * -1 : ch1;
            sum += ch1;
        }
        if(i == s.length() / 2 && s.length() % 2 == 1)
            sum += s.charAt(i) - 96;
        return String.valueOf(sum);
    }
}
