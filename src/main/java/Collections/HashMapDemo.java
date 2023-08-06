package Collections;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**?
 * Hashmp is a collection of ELEMENTS
 * ELEMENTS -> "Key - Value" pair in HashMap
 * Collections only store Reference types
 */
public class HashMapDemo {
    public static void main(String[] args) {

        Map<String, Integer> playersScore = new HashMap<>(16);
        playersScore.put("Robert", 145);
        playersScore.put("James", 121);
        playersScore.put("Antony", 136);
        playersScore.put("John", 78);
        System.out.println(playersScore);

        // For getting KEYS -> playersScore.keySet() -> Returns a "Set" Of Keys because hashmaps only store Unique keys
        // For getting VALUES -> playersScore.values() -> Returns a Collection of whatever type it was storing.

        // For getting ELEMENT("Key - Value") -> playersScore.entrySet() => Eventually "Set" of Entries

        Set<Map.Entry<String, Integer>> entries = playersScore.entrySet();

        playersScore.entrySet().stream()
                .map((Map.Entry<String, Integer> entry)->{
                    entry.setValue(1);
                    return entry.getValue();
                }).forEach(System.out::println);

        for (Map.Entry<String, Integer> entry: playersScore.entrySet()) {
            entry.setValue(2);
            System.out.println(entry.getValue());
        }


    }
}
