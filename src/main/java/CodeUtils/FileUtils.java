package CodeUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
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
        readFiles();
    }
}
