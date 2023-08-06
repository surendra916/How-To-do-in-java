package GenericsDemo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;

class SampleClass<T, E> {
    private T data; // variable of T type
    private E data1; // variable of T type

    interface Boom<T>{
        void process(T t);
    }



    public SampleClass(T data, E datas) {
        this.data = data;
        data1 = datas;
    }

    public void printDataType() {
        System.out.println("Type: " + this.data.getClass().getSimpleName());
    }
}


public class Generic {
    public static void main(String[] args) {
        SampleClass<Integer, String> intObj = new SampleClass<>(3, ""); // Integer
        intObj.printDataType();

        SampleClass<String, Integer> stringObj = new SampleClass<>("Java", 4); // String
        stringObj.printDataType();

        SampleClass.Boom boom = (T) -> {
            String s = T instanceof String ? "instance of String" : "instnace of int";

            System.out.println(s);
        };

//        HashMap<String, Integer>

        boom.process("Sure");
        boom.process(3);
    }
}
