package A_SPRING_BOOT_INTERVIEW_QA;

public class FunctionalInterfaceDemo {

    @FunctionalInterface
    interface i1{

        void abs();

        default void firstDefault(){
            System.out.println("firstDefault");
        }

        static void wish(){
            System.out.println("hai people");
        }
    }

    @FunctionalInterface
    interface i2 extends i1{

        @Override
        void abs();
    }

}
