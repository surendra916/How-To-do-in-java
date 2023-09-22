package StreamsDemo;

import org.example.Employee;
import org.example.EmployeeDataUtil;
import org.example.InterfaceDemo;

import java.util.*;
import java.util.stream.Collectors;

/*
* All inbuilt APIs support the sorting with the natural order by default. Numerical types are sorted in ascending order,
* strings are sorted in dictionary order (lexicographically) and custom objects are sorted by the
* order implemented by the Comparable interface.
* */

public class SortingDemo implements Comparable<String> {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("zzzzzzz","iiiiii","nnnnnnn","pppp","kkkk","hkjbk");
        Collections.sort(names);// Asc // But modifies the actual collection
        Collections.sort(names, Comparator.reverseOrder()); // Descending

        String[] namesArr = (String[]) names.toArray();
        Arrays.sort(namesArr, Comparator.naturalOrder()); // also Comparator.naturalOrder()

        names.stream().sorted();// asc
        names.stream().sorted(Comparator.naturalOrder());//  same as above
        // Natural sorting is supported on classes, then those classes are implementing "Comparable" interface

        // All wrapper classes, date-time classes and String supports "natural sorting"
        // So, if we want our custom classes to support  "natural sorting", then we have to implement "Comparable" interface
        //Comparable interface has a single abstract method compareTo() that objects need to implement to have a natural ordering.

        // String, Date-time classes and wrapper classes implement "Comparable" interface out of the box.
        // So those class instances can call "compareTo()" on them
        // If primitives are there then, see below
//        public class User implements Comparable<User> {
//
//            public long id;
//        }

//        public int compareTo(final User user) {
//            if(user == null ) {
//                return -1;
//            } else {
//                return (int)(this.id - user.id);
//            }
//        }

        Map<String, Integer> map = new HashMap<>();
        // Adding elements to the Map
        // using standard put() method
        map.put("vishal", 10);
        map.put("sachin", 30);
        map.put("vaibhav", 20);

        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey()).forEach(System.out::println);

        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(System.out::println);


        String[] strings = { "abc","def","ghi","jkl","mno","pqr","stu"};
        Collections.sort(Arrays.asList(strings),Collections.reverseOrder());
        Arrays.sort(strings,Collections.reverseOrder());


        EmployeeDataUtil.getEmployees().stream()
                .sorted(Comparator.comparingLong(Employee::getAge))
                .forEach(System.out::println);

        EmployeeDataUtil.getEmployees().stream()
                .sorted(Comparator.comparing(Employee::getEmail))
                .collect(Collectors.toList());


    }

    @Override
    public int compareTo(String o) {
        return 0;
    }
}
