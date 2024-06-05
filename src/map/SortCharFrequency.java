import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collector;

public class SortCharFrequency {

    public String frequencySort(String s) {
        char[] characters = s.toCharArray();
        Map<Character, Integer> charFrequency = new TreeMap<>();
        for (Character character : characters) {
            charFrequency.merge(character, 1, Integer::sum);
        }

        System.out.println(charFrequency);
        return charFrequency.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(entry -> {
                    return new String(new char[entry.getValue()]).replace('\u0000', entry.getKey());
                })
                .collect(Collector.of(StringBuilder::new, StringBuilder::append, StringBuilder::append, StringBuilder::toString));
    }

    public static void main(String[] args) {
        System.out.println(new SortCharFrequency().frequencySort("tree"));
    }
}
