//In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
//
//Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien language.

package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Pradeep Arya
 */
public class AlienDictionary {

    public boolean isAlienSorted(String[] words, String order) {
        boolean isAlienSorted = true;
        Map<Character, Integer> alphabetsIndexes = new HashMap<>();

        int orderLength = order.length();
        for (int index = 0; index < orderLength; index++) {
            alphabetsIndexes.put(order.charAt(index), index);
        }

        int wordsLength = words.length;
        for (int index = 1; index < wordsLength; index++) {
            String firstWord = words[index - 1];
            String secondWord = words[index];

            int firstLength = firstWord.length();
            int secondLength = secondWord.length();
            int subIndex = 0;
            while (subIndex < firstLength && subIndex < secondLength) {
                int firstIndex = alphabetsIndexes.get(firstWord.charAt(subIndex));
                int secondIndex = alphabetsIndexes.get(secondWord.charAt(subIndex));

                if (secondIndex < firstIndex) {
                    isAlienSorted = false;
                    break;
                } else if (secondIndex > firstIndex) {
                    break;
                }
                subIndex++;
            }

            if(subIndex == firstLength || subIndex == secondLength){
                if (firstLength > secondLength) {
                    isAlienSorted = false;
                    break;
                }
            }

            if (!isAlienSorted) {
                break;
            }
        }

        return isAlienSorted;
    }


    public static void main(String[] args) {
        System.out.println("output true " + new AlienDictionary().isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println("output false " + new AlienDictionary().isAlienSorted(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz"));
        System.out.println("output false " + new AlienDictionary().isAlienSorted(new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz"));
        System.out.println("output true " + new AlienDictionary().isAlienSorted(new String[]{"kuvp", "q"}, "ngxlkthsjuoqcpavbfdermiywz"));
    }
}
