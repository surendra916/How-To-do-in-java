package org.example;

public class Employee{
    private Integer empId;
    private Integer age;
    private String name;

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    private String email;

    public Employee(Integer empId, Integer age, String name, String email) {
        this.empId = empId;
        this.age = age;
        this.name = name;
        this.email = email;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
