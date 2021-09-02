package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Pradeep Arya
 */
public class TwoStringAnagram {

    public int minSteps1(String s, String t) {

        AtomicInteger count = new AtomicInteger();

        Map<Character, Integer> sFrequency = new HashMap<>();
        s.chars().forEach(character -> sFrequency.merge((char) character, 1, Integer::sum));


        Map<Character, Integer> tFrequency = new HashMap<>();
        t.chars().forEach(character -> tFrequency.merge((char) character, 1, Integer::sum));

        sFrequency.forEach((k, v) -> {
            if (tFrequency.getOrDefault(k, 0) < v) {
                count.addAndGet((v - tFrequency.getOrDefault(k, 0)));
            }
        });


        return count.get();

    }

    public int minSteps(String s, String t) {
        AtomicInteger count = new AtomicInteger();

        Map<Character, Integer> tFrequency = new HashMap<>();
        t.chars().forEach(character -> tFrequency.merge((char) character, 1, Integer::sum));

        s.chars().forEach(character -> {
            Integer tCount = tFrequency.get((char) character);
            if (tCount != null) {
                tCount -= 1;
                tFrequency.put((char) character, tCount);
            } else {
                count.incrementAndGet();
            }
        });

        tFrequency.forEach((k, v) -> {
            if (v < 0) {
                count.addAndGet(Math.abs(v));
            }
        });


        return count.get();
    }

    public static void main(String[] args) {
        System.out.println("output 1 " + new TwoStringAnagram().minSteps("bab", "aba"));
        System.out.println("output 5 " + new TwoStringAnagram().minSteps("leetcode", "practice"));
        System.out.println("output 0 " + new TwoStringAnagram().minSteps("anagram", "mangaar"));
        System.out.println("output 0 " + new TwoStringAnagram().minSteps("xxyyzz", "xxyyzz"));
    }
}
