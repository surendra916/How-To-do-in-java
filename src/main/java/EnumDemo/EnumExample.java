package EnumDemo;

import java.util.Arrays;

public class EnumExample {


    enum Color {
        RED("Reddehe"),
        GREEN("GREEN"),
        BLUE("BLUE"),
        YELLOW("YELLOW");

        private String colorEnumValue;
        Color(String color) {
            this.colorEnumValue = color;
        }

        public String getStrColor(){
            return this.colorEnumValue;
        }
    }


    public static void main(String[] args) {
        String color = Color.RED.getStrColor();
        //Arrays.stream(Color.values()).forEach(c ->System.out.println(c.ordinal()));
        System.out.println(color);
        System.out.println(Color.RED.getStrColor());
        System.out.println(Color.BLUE.getStrColor());
        System.out.println(Color.YELLOW.getStrColor());
        System.out.println(Color.GREEN.getStrColor());
        //printColor("reD");
    }

    public static void printColor(String str){
        Color color = Color.valueOf(str.toUpperCase());
        switch (color){
            case RED -> System.out.println("Red in color");
            case BLUE -> System.out.println("Blue color");

            default -> System.out.println("White");
        }
    }
}
