package A_SPRING_BOOT_INTERVIEW_QA.ConceptAndCoding;

import Collections.CodeUtils.Student;

public class ReflectionApi {

    /*
    *  JVM creates a "Class" class for every class in java during runtime
    *  metadata that Class class stores in about variables, props and methods
    *
    *
    * */

    // Reflection of class
    Student student = new Student();


    Class aClass = student.getClass();
    Class class2 = Student.class;
    Class class3 = Class.forName("Student");

    public ReflectionApi() throws ClassNotFoundException {
        Runnable t = () -> {
            System.out.println("");
        };
        Thread thread = new Thread(() -> {});

    }
}
