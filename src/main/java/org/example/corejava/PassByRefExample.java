package org.example.corejava;

public class PassByRefExample {

    int age;
    String email;

    PassByRefExample(int age, String email){
        this.age = age;
        this.email = email;
    }

    @Override
    public String toString() {
        return this.age + " " + this.email;
    }

    public static void main(String[] args) {
        PassByRefExample passByRefExample1 = new PassByRefExample(24, "ssr@gg.in");
        PassByRefExample passByRefExample2 = passByRefExample1;
        changeRef(passByRefExample2);//
        System.out.println("passByRefExample1 : "+passByRefExample1);//passByRefExample1 : 24 changed@gg.in
        System.out.println("passByRefExample2 : "+passByRefExample2);//passByRefExample1 : 24 changed@gg.in


        passByRefExample2 = null;
        System.out.println("passByRefExample1 : "+passByRefExample1);
        System.out.println("passByRefExample2 : "+passByRefExample2);

    }

    public static void changeRef(PassByRefExample passByRefExample){
        passByRefExample = null;
    }
}
