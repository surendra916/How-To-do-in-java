package A_SPRING_BOOT_INTERVIEW_QA;

import java.util.*;

public class GapInc {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 1, 3,3, 5));
        System.out.println(print(integers));
    }

    private static List<Integer> print(List<Integer> integers) {

        Set<Integer> integerSet = new LinkedHashSet<>(integers);
        ArrayList<Integer> sortedList = new ArrayList<>(integerSet);
        Collections.sort(sortedList);
        for(int i = 0; i < integers.size(); i++){
           if(i > sortedList.size())
               sortedList.add(sortedList.get(i - 1) + 1);
        }
        return sortedList;
    }


}
