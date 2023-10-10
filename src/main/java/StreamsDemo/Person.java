package StreamsDemo;

public class Person {
    private String name;
    private int age;
    private double salary;

    private String gender;

    private String department;

    public Person() {
    }

    public Person(String name, int age, double salary, String gender, String department) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.gender = gender;
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
