package StreamsDemo;

import org.example.Employee;
import org.example.EmployeeDataUtil;
import org.example.InterfaceDemo;

import java.util.*;
import java.util.stream.Collectors;

public class SortingDemo {
    public static void main(String[] args) {
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
}
