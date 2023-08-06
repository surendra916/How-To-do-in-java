package StreamsDemo;

import org.example.Employee;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("abc","def","ghi","jkl","mno","pqr");

        List<Employee> employees = Arrays.asList(
                new Employee(1,22,"ddd","vvvv@gg.in"),
                new Employee(2,66,"sss","xxxx@gg.in"),
                new Employee(3,77,"fffr","bbbb@gg.in"),
                new Employee(4,11,"eee","qqqq@gg.in"),
                new Employee(5,55,"strr","uuuu@gg.in")
        );

        //Collections.sort(employees);

        List<String> list1 = new ArrayList<>(Arrays.asList("abc","def","ghi","jkl","mno","pqr"));

        System.out.println(employees);

        //employees.stream().sorted(Comparator.comparing(Employee::getEmpId).reversed()).forEach(System.out::println);
        // We can chain multiple comparator calls like below
        //employees.stream().sorted(Comparator.comparing(Employee::getEmpId).thenComparingLong(Employee::getAge)).forEach(System.out::println);

        Supplier<Stream<Employee>> supplier = () -> employees.stream();

        supplier.get().findAny().ifPresent(ep -> System.out.println(ep.getEmail()));

            String[] strings = supplier.get().map(emp -> emp.getEmail()).toArray(String[]::new);
        // Similarly
        boolean b = supplier.get().noneMatch(emp -> "ssr".equalsIgnoreCase(emp.getName()));

    }
}
