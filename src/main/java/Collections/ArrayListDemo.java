package Collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

public class ArrayListDemo {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(90);
        list.add(50);
        list.add(10);
        //System.out.println(list);

        // modify element
        //int modifiedElement = list.set(1, 200);
        //System.out.println("modified element is "+ modifiedElement + " and list is : "+ list);

        // We can pass any collection implementation classes to constructor ex: Set, List, etc..,
        //List<Integer> list2 = new ArrayList<>(list);
        //System.out.println("list2 is "+list2);

        List<Integer> list2 = new ArrayList<>();
        list2.addAll(list);
        //System.out.println(list);
        System.out.println(list2);

        list.indexOf(2);

        List<Integer> integers = list2.subList(1, 3); // [90, 50, 10]
        integers.set(1,100);  // Modifying the sublist returned list will also change the underlying list on which sublist is being performed.
        System.out.println(integers);  // [50, 100]
        System.out.println(list2); // [90, 50, 100] // So list2 also got changed

        ListIterator<Integer> integerListIterator = integers.listIterator();



    }
}
