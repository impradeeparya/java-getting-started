/*Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.*/


package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Pradeep Arya
 */
public class WordBreak {

    public boolean validateWordBreak(String input, Map<String, Integer> frequency, Map<Integer, Boolean> memory, int index) {
        if (index == input.length()) {
            return true;
        }

        if (memory.getOrDefault(index, false)) {
            return true;
        }

        String str = "";
        for (int subIndex = index; subIndex < input.length(); subIndex++) {
            str = str + input.charAt(subIndex);
            if (frequency.get(str) != null && validateWordBreak(input, frequency, memory, subIndex + 1)) {
                memory.put(index, true);
                break;
            }
        }

        return memory.getOrDefault(index, false);
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        Map<String, Integer> frequency = new HashMap<>();
        wordDict.forEach(word -> frequency.put(word, 1));
        Map<Integer, Boolean> processedWords = new HashMap<>();

        return validateWordBreak(s, frequency, processedWords, 0);
    }

    public static void main(String[] args) {
        System.out.println("output true " + new WordBreak().wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println("output true " + new WordBreak().wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println("output false " + new WordBreak().wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
        System.out.println("output true " + new WordBreak().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")));
    }
}
