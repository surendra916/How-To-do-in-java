package A_SPRING_BOOT_INTERVIEW_QA;

import java.util.*;

class SingletonDemoClass implements Cloneable{

    private static SingletonDemoClass singletonDemo;


    private SingletonDemoClass(){

    }

    public static SingletonDemoClass getInstance(){
        if(singletonDemo == null){
            singletonDemo = new SingletonDemoClass();
        }
        return singletonDemo;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException{
        //return super.clone();
        throw new CloneNotSupportedException("Clone is not supported");
    }
}



public class Main{
    public static void main(String[] args) throws CloneNotSupportedException {
//        Object obj = SingletonDemoClass.getInstance();
//
//        SingletonDemoClass instance1 = SingletonDemoClass.getInstance();
//        SingletonDemoClass instance2 = (SingletonDemoClass) instance1.clone();
//
//        System.out.println(instance1.hashCode()); // 1705736037
//        System.out.println(instance2.hashCode()); // 455659002

        List<Integer> list = new ArrayList<>(List.of(0,5,7,4,10));
        Collections.sort(list);
        int minDiff = Integer.MAX_VALUE;
        Map<List<Integer>, Integer> pairsMap = new HashMap<>(list.size());
        for(int i = 0; i < list.size() - 1; i++){
            int tempDiff = Math.abs(list.get(i) - list.get(i+1));
            if(tempDiff < minDiff){
                minDiff = tempDiff;
            }
            pairsMap.put(List.of(list.get(i) , list.get(i+1)), tempDiff);

        }
        System.out.println("Minimum difference is "+ minDiff + " and its pairs are : ");
        int finalDiff = minDiff;
        pairsMap.forEach((listt, value) -> {
            if(value.equals(finalDiff)){
                System.out.println(listt);
            }
        });

        // Frequency of character in a string - 1
//        Map<String, Long> collect = Arrays.stream("Surendra".split(""))
//                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
//
//        System.out.println(collect);

        // Frequency of character in a string - 2
//        String str = "Surendra";
//        Map<Character, Integer> map = new HashMap<>();
//        for(char c : str.toCharArray()){
//            map.put(c, map.getOrDefault(c, 0) + 1);
//        }
//        System.out.println(map);

        // Here both hash codes are different, so it breaks Singleton Design Pattern
        // To avoid this we can use "throw new CloneNotSupportedException("Clone is not supported"); "
    }
}




