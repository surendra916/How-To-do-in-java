package org.example;

import java.util.Arrays;
import java.util.List;

@FunctionalInterface
public interface EmployeeDataUtil {
    void wish();

    static List<Employee> getEmployees(){
        return Arrays.asList(
                new Employee(1,22,"ddd","vvvv@gg.in"),
                new Employee(2,66,"sss","xxxx@gg.in"),
                new Employee(3,77,"fffr","bbbb@gg.in"),
                new Employee(4,11,"eee","qqqq@gg.in"),
                new Employee(5,55,"strr","uuuu@gg.in")
        );
    }
}
