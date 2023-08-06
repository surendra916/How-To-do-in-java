package InheritanceDemo;

abstract class AbstractDemo{
    final void boom() {
        System.out.println("boom bamm");
    }
}

class Mammal {

    String msg = "mammal";
    void sleep() {
        System.out.println("Mammal is sleeping");
    }

    void eat() {
        System.out.println("Mammal is eating");
    }
}

class Horse extends Mammal {
    void eat() {  // overrides eat() method of Mammal class
        //super.eat(); -> to call super class eat()
        System.out.println("Horse is eating");
    }
}

public class InheritanceDemoClass extends AbstractDemo{
    //void boom(){} gives error because it cannot be extended because it is "final" and its JOB is completed and no more extension

    public static void main(String[] args) {
        Mammal animal = new Horse();

        InheritanceDemoClass inheritanceDemoClass = new InheritanceDemoClass();
        inheritanceDemoClass.boom();

        /* Here animal.eat() gives "Horse is eating" because
         eat() method is getting overridden.

        Children can access all of Parents properties
        But Parents cannot access all Children properties.

         */
        animal.eat(); // Horse is eating
        animal.sleep();

        System.out.println(animal.msg);

    }
}
