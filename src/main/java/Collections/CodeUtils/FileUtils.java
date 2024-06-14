package Collections.CodeUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


// https://howtodoinjava.com/java8/java-8-list-all-files-example/
public class FileUtils {

    public static List<File> readFiles(){

        //The source directory
        String directory = "C:/temp";
        // Reading only files in the directory
        try {
            List<File> files = Files.list(Paths.get(directory))
                    .map(Path::toFile)
                    .filter(File::isFile)
                    .collect(Collectors.toList());
            return files;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Path> listingAllFilesInDirectory(){
        String directory = "C:/temp";
        List<Path> pathList = new ArrayList<>();
        try (Stream<Path> stream = Files.walk(Paths.get(directory))) {
            pathList = stream.map(Path::normalize)
                    .filter(Files::isRegularFile)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return pathList;
    }

    public static void main(String[] args) {
        //readFiles();
        Employ employ1 = new Employ();
        employ1.nickNames.add(new ArrayList<>(){{ add(1); add(2); }});
        Employ employ2 = new Employ();
        employ2.nickNames.add(new ArrayList<>(){{ add(3); add(4); }});
        Employ employ3 = new Employ();
        employ3.nickNames.add(new ArrayList<>(){{ add(5); add(6); }});

        List<Employ> list =new ArrayList<>(){{ add(employ1); add(employ2); add(employ3);}};
//        list.stream()
//                .flatMap(emp -> emp.nickNames.stream().flatMap(n -> n.stream()))
//                .forEach(System.out::println);

        String str = "welcome to code decode and code decode welcome you";
        Map<String, List<String>> collect = Arrays.stream(str.split(" "))
                .collect(Collectors.groupingBy(Function.identity()));

//        collect.forEach((word, occurrenceList) -> {
//            System.out.print(word +" => "+ occurrenceList.size()+" ");//code => 2 and => 1 to => 1 decode => 2 welcome => 2 you => 1
//        });

        // For duplicate elements
//        collect.forEach((word, occurrenceList) -> {
//            if(occurrenceList.size() > 1){
//                System.out.println(word);
//            }
//        });

        // For Unique elements
        collect.entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() == 1)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);

    }
}

class Employ{

    List<List<Integer>> nickNames = new ArrayList<>();

    @Override
    public String toString() {
        return super.toString();
    }
}
