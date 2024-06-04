package corejava;
public class Myclass {
    static int a = 20;
    static {
        System.out.println("Static is being called");
        a++;
        System.out.println(a);
    }
    {

        System.out.println("Instance is being called");
        a++;
        System.out.println(a);
    }
    public static void main(String[] args)
    {
        Myclass obj = new Myclass();
        Myclass obj2 = new Myclass();
        Myclass obj3 = new Myclass();
    }
}
