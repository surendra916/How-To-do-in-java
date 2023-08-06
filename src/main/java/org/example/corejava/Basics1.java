package org.example.corejava;

class Foo
{
    private String attribute;
    public Foo (String a){
        this.attribute = a;
    }
    public String getAttribute() {
        return attribute;
    }
    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }
}
public class Basics1
{
    public static void main(String[] args){
        Foo f = new Foo("f");
        //changeReference(f); // It won't change the reference!
        //modifyReference(f); // It will change the object that the reference variable "f" refers to!
        System.out.println("Basics1.main "+f.getAttribute());
        controlFlowDemo();
    }
    public static void changeReference(Foo a) {
        Foo b = new Foo("b");
        a = b;
    }
    public static void modifyReference(Foo c) {
        c.setAttribute("c");
        System.out.println("Modified ref is "+c.getAttribute());
    }

    public static void controlFlowDemo(){

        String s = "sui";

        if(s.equals("suri")){
            System.out.println("Its suri");
        } else if (s.equals("ssr")) {
            System.out.println("It's ssr");
        }else {
            System.out.println("something else");
        }

    }

}