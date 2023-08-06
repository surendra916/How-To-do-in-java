import java.util.Optional;

public interface GlobalUtil {

    static Optional<String> getOptionalString(){
        return Optional.ofNullable("Sample string");
    }

    static Optional<Object> getNullable(){
        return Optional.of(null);
    }



}
