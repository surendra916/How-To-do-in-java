package Baeldung;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class UniqueElementCount {


    int[] arr2 = {1,2,3,4,3,0,5,3,4,0};
    Supplier<Stream<Integer>> arraySupplier = () -> {
        Set<Integer> integersSet = new HashSet<>(arr2.length);
        return Arrays.stream(arr2).boxed().filter(num -> integersSet.add(num));
    };

    private static void usingSet(int arr[]){
        Set<Integer> integersSet = new HashSet<>(arr.length);
        //Arrays.stream(arr).filter(num -> integersSet.add(num)).forEach(System.out::println);
        long count = Arrays.stream(arr).filter(num -> integersSet.add(num)).count();
        System.out.println("using SET is "+ count);
    }
    private static int uniqCountWithStream(int[] arr){
        long count = Arrays.stream(arr).distinct().count();
        System.out.println("long count with STREAMS is "+count);
        return (int) count;
    }

    public void usingSupplier(){
        System.out.println(arraySupplier.get().collect(Collectors.toMap(i-> i, i-> i+" - "+i)));
    }


    public static void main(String[] args) {
        //new UniqueElementCount().usingSupplier();
        new UniqueElementCount().findAllDuplicates(Arrays.asList("abc", "def", "ghi"));

        // Using regular approach
        int[] arr = {1,2,3,4,3,0,5,3,4,0};
        int len = arr.length;
        int unique[] = new int[len];
        Arrays.fill(unique, -1);
        int index = 0;
        unique[index] = arr[0];
        int uniqueCount = 1;
        for(int i = 1; i < len; i++)
        {
            if(!isExists(unique, arr[i])){
                unique[++index] = arr[i];
                uniqueCount++;
            }
        }
       // System.out.println("uniqueCount is "+ uniqueCount);


        // Using streams
        int[] arr1 = {1,2,3,4,3,0,5,3,4,0};
        //uniqCountWithStream(arr1);

        //using SET
        //usingSet(arr1);



    }

    private static boolean isExists(int[] unqArr, int item){
        boolean exists = false;
        for(int j = 0; j < unqArr.length; j++){
            if(unqArr[j] == item){
                exists = true;
                break;
            }
        }
        return exists;
    }

    private String[] arrayListToStringArr(){
        ArrayList<String> list = new ArrayList<>(Arrays.asList("abc", "def", "ghi"));
//        String[] strings = new String[list.size()];
//        return list.toArray(strings);
        //or
        return list.toArray(String[]::new);
    }

    private List<Integer> primitiveToWrapper(){
//        return IntStream.rangeClosed(1,10)
//                .boxed().collect(Collectors.toList());
        // OR
        Stream<Double> boxed = IntStream.rangeClosed(1, 10)
                .mapToDouble(n -> n).boxed();

        // OR
        return IntStream.rangeClosed(1,10)
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private List<String> getFirstNElements(int limit){
        ArrayList<String> list = new ArrayList<>(Arrays.asList("abc", "def", "ghi"));
//        return Arrays.stream(IntStream.rangeClosed(1, limit)
//                .mapToObj(i -> list.get(i))
//                .collect(Collectors.joining("==")).split("=="))
//                .collect(Collectors.toList());
        // OR

        return list.stream()
                .limit(5)
                .collect(Collectors.toList());

    }

    private void listToLongArray(){
        Long[] longs = new Long[10];
        LongStream.of(1L, 2L, 3L, 4L, 5L)
                .boxed()
                .toArray(Long[]::new);

        // OR
        LongStream.of(1L, 2L, 3L, 4L, 5L)
                .mapToObj(num -> num)
                .forEach(System.out::println);
    }

    private void findLongestWordInString(){
        String str = "Experts argue that mentally strong individuals are resilient";

        Arrays.stream(str.split(" "))
                .mapToInt(String::length)
                .max()
                .ifPresent(System.out::println);
    }

    private void findIndexOfElement(List<String> list){
       list.indexOf("");
       // OR
        String[] strings = list.toArray(String[]::new);
        int foundIndex = Arrays.binarySearch(strings, "suri");
    }

    private void findAllDuplicates(List<String> list){
        Set<String> stringsSet = new LinkedHashSet<>();
        list.stream()
                .filter(str -> !stringsSet.add(str))
                .forEach(System.out::println);

    }
}

