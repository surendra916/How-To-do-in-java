package A_SPRING_BOOT_INTERVIEW_QA;


abstract class AbstractClass{
    void wish(){

    }
}
interface Interface{
     void wish();
}

public class LTIDemo extends AbstractClass implements Interface{
    @Override
    public void wish() {

    }
}
