//Given a string s of '(' , ')' and lowercase English characters.
//
//Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.
//
//Formally, a parentheses string is valid if and only if:
//
//It is the empty string, contains only lowercase characters, or
//It can be written as AB (A concatenated with B), where A and B are valid strings, or
//It can be written as (A), where A is a valid string.


package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pradeep Arya
 */
public class ValidParenthesis {

//    public String minRemoveToMakeValid(String s) {
//
//        List<Character> characters = new LinkedList<>();
//        List<Integer> leftParenthesisIndex = new LinkedList<>();
//
//        int index = 0;
//        for (Character character : s.toCharArray()) {
//
//            if (character == ')') {
//                if (!leftParenthesisIndex.isEmpty()) {
//                    int parenthesisIndex = leftParenthesisIndex.remove(0);
//                    characters.add(parenthesisIndex - leftParenthesisIndex.size(), '(');
//                    characters.add(character);
//                } else {
//                    index = index == -1 ? index : index - 1;
//                }
//            } else if (character == '(') {
//                leftParenthesisIndex.add(0, index);
//            } else {
//                characters.add(character);
//            }
//            index++;
//        }
//
//        return characters.toString().replaceAll("[,\\s\\[\\]]", "");
//    }


    public String minRemoveToMakeValid(String s) {

        List<Integer> leftParenthesisIndex = new ArrayList<>();
        char[] characters = s.toCharArray();
        int index = 0;
        for (Character character : characters) {
            if (character == ')') {
                if (!leftParenthesisIndex.isEmpty()) {
                    leftParenthesisIndex.remove(leftParenthesisIndex.size() - 1);
                } else {
                    characters[index] = '.';
                }
            } else if (character == '(') {
                leftParenthesisIndex.add(index);
            }
            index++;
        }

        for (Integer leftIndex : leftParenthesisIndex) {
            characters[leftIndex] = '.';
        }

        StringBuilder output = new StringBuilder();
        for(Character character : characters){
            if(character != '.'){
                output.append(character);
            }
        }

        return output.toString();
    }


    public static void main(String[] args) {
        System.out.println("output lee(t(c)o)de " + new ValidParenthesis().minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println("output ab(c)d " + new ValidParenthesis().minRemoveToMakeValid("a)b(c)d"));
        System.out.println("output  " + new ValidParenthesis().minRemoveToMakeValid("))(("));
        System.out.println("output a(b(c)d) " + new ValidParenthesis().minRemoveToMakeValid("(a(b(c)d)"));
        System.out.println("output t(u) " + new ValidParenthesis().minRemoveToMakeValid(")))t((u)"));
    }
}
