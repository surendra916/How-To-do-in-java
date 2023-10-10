package ComparableAndComparator;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/*
* Comparable is an interface which defines a strategy for comparing an object with other objects of the same type.
* This is called the class's “natural ordering.”
*
* All String, Date-Time classes and Wrapper classes are "Comparable" out of the box because they implement "Comparable" interface
* and override "compareTo" method as they wanted. so that they ensure "natural ordering"
* We can also make Custom objects comparable by implementing the Generic Comparable<T> interface
*
* */

public class ComparableDemo {


    public static void main(String[] args) {

        // Sorting in DESCENDING ORDER
        List<String> list = Arrays.asList("abc","def","ghi","jkl","mno","pqr");
        //Collections.sort(list, Collections.reverseOrder());
        System.out.println(String.join("*",list));

        String[] strArray = {"abc", "def", "ghi", "jkl", "mno", "pqr"};
        Arrays.sort(strArray);
        String collect = Arrays.stream(strArray)
                .collect(Collectors.joining(","));
        System.out.println(collect);
        Person person = new Person("","");
        List<Person> list1 = new ArrayList<>();
        list1.add(person);
        Collections.sort(list1);

    }
}

class Person implements Comparable<Person>{
    private String firstName;
    private String lastName;

    private int age;

    private Long aLong;

    private LocalDate dob;

    private Date db;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    // So if we have list of persons
    // Collections.sort(persons); => This will not throw any Compile time error
    // Because Person class is Comparable now, and it compares (or) orders its elements by below-mentioned class props or states
    @Override
    public int compareTo(Person o) {
        //return Integer.compare(age, o.age); for int type either primitive or Wrapper
        //return firstName.compareTo(o.firstName);// lexicographical comparison
        //return Long.compare(aLong, o.aLong); // For Long and similarly for all wrapper
        //return dob.compareTo(o.dob);// For LocalDate
        return db.compareTo(o.db);// For Date
    }
}
