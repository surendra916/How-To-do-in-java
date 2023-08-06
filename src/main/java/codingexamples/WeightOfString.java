package codingexamples;


import java.util.Scanner;

public class WeightOfString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input1 = sc.nextLine();
        input1  = input1.toLowerCase();
        int sum = 0;
        String vowels = "aeiou";
        String specialChars = "/*!@#$%^&*()\"{}_[]|\\?/<>,.";
        int input2 = sc.nextInt();
        for (int i = 0; i< input1.length(); i++){
            String s = input1.charAt(i) + "";
            if(input2 == 1 && !s.trim().equals("")){
                if(specialChars.contains(s)){
                    continue;
                }
                sum += input1.charAt(i) - 'a' + 1;
                System.out.println("Weight of "+ s + " is : "+(input1.charAt(i) - 'a' + 1));
            }else if(input2 == 0 && !s.trim().equals("") && !(vowels.contains(s) || specialChars.contains(s))){
                System.out.println("Weight of "+ s + " is : "+(input1.charAt(i) - 'a' + 1));
                sum += input1.charAt(i) - 'a' + 1;
            }
        }
        System.out.println("Weight of "+ input1 + "is "+sum);
    }
}
