package A_SPRING_BOOT_INTERVIEW_QA;

import Collections.CodeUtils.Student;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListSample {

    public static void main(String[] args) {
        List<String> sentences = Arrays.asList("This is a sentence", "This is another sentence", "And this is yet another sentence");

        String combinedString = sentences.stream()
                .collect(Collectors.joining(" "));

        Stream.of(combinedString.toLowerCase().split(" "))
                .distinct()
                .forEach(System.out::println);

       /* Student {

            No,name,List<String> hobbies;
        }*/

//        List<Student> studentsList;
//
//        studentsList.stream()
//                .flatMap(student -> student.getHobbies().stream())
//                .distinct();
//
//        studentsList.stream()
//                .sorted(Comparator.comparing(Student::getName).reversed())
//                .collect(Collectors.toList());


        String s1 = "axx#bb#c";
        String s2 = "axbd#c#c";


        s1.indexOf("#");
        System.out.println(s1.indexOf("#"));

        if(extracted(s1).equalsIgnoreCase(extracted(s2)))
            System.out.println("EQUAL");
        else
            System.out.println("Not EQUAL");

    }

    private static String extracted(String s1) {
        StringBuilder sb = new StringBuilder(s1.length());
        for (int i = 0; i < s1.length(); i++) {
            if((i + 1) < s1.length() && String.valueOf(s1.charAt(i + 1)).equalsIgnoreCase("#")){
                i = i + 1;
            }else {
                sb.append(s1.charAt(i));
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    /*
    *
    * select t1.name, t2.val from table_1 t1
    * left join table_t2
    * on t1.client_id = t2.client_id;
    *
    * */


}
