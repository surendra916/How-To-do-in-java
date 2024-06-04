package StreamsDemo;

@FunctionalInterface
public interface FuncInterfaceDemo {
    void wish();

    static int add(){
        return 22;
    }

    default int subtract(){
        return 33;
    }
}
