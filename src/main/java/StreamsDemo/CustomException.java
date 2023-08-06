package StreamsDemo;

public class CustomException extends RuntimeException{

    CustomException(String msg){
        super("Bomm "+msg);
    }

}
