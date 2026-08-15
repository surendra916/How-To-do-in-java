package A_SPRING_BOOT_INTERVIEW_QA;

interface i1{
    default void eat(){
        System.out.println("default");
    }
}
interface i2 extends i1{

    default void eat(){
        System.out.println("I2 => default");
    }
}

interface i3 extends i1{
    default void eat(){
        System.out.println("I3 => default");
    }
}

public class DiamondProblem implements i2, i3{

    public static void main(String[] args) {
        DiamondProblem diamondProblem = new DiamondProblem();
        diamondProblem.eat();
    }

    @Override
    public void eat() {
        i2.super.eat();
    }
}
