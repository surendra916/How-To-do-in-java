package Collections.CodeUtils;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Student implements Comparable<Student>{
    private String name;
    private int age;
    private Date dob;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return age == student.age && Objects.equals(name, student.name) && Objects.equals(dob, student.dob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, dob);
    }

    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setName("John Doe");
        student1.setAge(20);
        student1.setDob(new Date(2004, 5, 15)); // Note: This constructor is deprecated, use Calendar or LocalDate

        // Create second student object
        Student student2 = new Student();
        student2.setName("John Doe");
        student2.setAge(20);
        student2.setDob(new Date(2004, 5, 15));
//        student2.setName("Alice Smith");
//        student2.setAge(22);
//        student2.setDob(new Date(2002, 8, 25));

        boolean equals = student1.equals(student2);
        System.out.println("Equal? "+ equals);

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        Collections.sort(students);

        students.stream().sorted(Comparator.comparingDouble(Student::getAge).thenComparingInt(Student::getAge)).collect(Collectors.toList());

    }

    @Override
    public int compareTo(Student o) {
        return this == o ? 0 : o.getName().compareTo(this.getName());
    }
}

