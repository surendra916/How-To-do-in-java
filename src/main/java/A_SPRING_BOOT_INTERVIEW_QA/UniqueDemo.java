package A_SPRING_BOOT_INTERVIEW_QA;


import java.util.HashMap;
import java.util.List;

// A generic class that can hold any type of object
    class Box<T, G, M> {
        private T value;

        private G other;

        public void setValue(T value) {
            this.value = value;
        }

        public G getOther() {
            return other;
        }

        public void setOther(G other) {
            this.other = other;
        }

        public T getValue() {
            return value;
        }
    }

    public class UniqueDemo {
        public static void main(String[] args) {
            // Creating a Box for Integer
            Box<Integer, String, String> integerBox = new Box<>();
            integerBox.setValue(123);
            System.out.println("Integer Value: " + integerBox.getValue()); // Output: Integer Value: 123

            // Creating a Box for String
            Box<String, Double, Class> stringBox = new Box<>();
            stringBox.setValue("Hello Generics");
            System.out.println("String Value: " + stringBox.getValue()); // Output: String Value: Hello Generics
        }
    }


    // polymorphism overloading and overriding
    // multithreading and executor service
    // java memory mgmt
    // Garbage Collection
    // access modifiers and use of DEFAULT
    // Spring security
    // JPA Specification
    // Design pattern
    // SQL Queries
    // Junit
    // File Handling
    // duplicate count in string and remove it
    // print second highest value from the array
    // Lazy and Eager Fetch( One to Many Relationships),
    // HashMap internal
    // Concurrent HashMap and Fail Fast or Fail safe iterators