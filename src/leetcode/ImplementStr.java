//Implement strStr().
//
//Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
//
//Clarification:
//
//What should we return when needle is an empty string? This is a great question to ask during an interview.
//
//For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
//


package leetcode;

/**
 * @author Pradeep Arya
 */
public class ImplementStr {

    public int strStr(String haystack, String needle) {

        if (needle == null || needle.length() == 0) {
            return 0;
        }
        int output = -1;

        for (int index = 0; index < haystack.length(); index++) {
            if (haystack.charAt(index) == needle.charAt(0)) {

                boolean isPresent = true;
                int startSubIndex = 1;
                int startIndex = index;
                for (int subIndex = index + 1; subIndex < index + needle.length(); subIndex++) {

                    if (subIndex >= haystack.length()) {
                        isPresent = false;
                        break;
                    }

                    if (haystack.charAt(subIndex) != needle.charAt(startSubIndex)) {
                        isPresent = false;
                        break;
                    }

                    startSubIndex++;
                }

                if (isPresent) {
                    output = startIndex;
                    break;
                }
            }
        }

        return output;
    }

    private boolean isSubStr(String haystack, int startIndex, int endIndex, String needle, int strLength) {
        boolean isPresent = true;
        int startSubIndex = 0;
        for (int index = startIndex; index < endIndex; index++) {

            if (index >= strLength) {
                isPresent = false;
                break;
            }

            if (haystack.charAt(index) != needle.charAt(startSubIndex)) {
                isPresent = false;
                break;
            }

            startSubIndex++;
        }

        return isPresent;
    }

    public static void main(String[] args) {
        System.out.println(new ImplementStr().strStr("hello", "ll"));
        System.out.println(new ImplementStr().strStr("aaaaa", "bba"));
        System.out.println(new ImplementStr().strStr("", ""));
        System.out.println(new ImplementStr().strStr("aaa", "aaa"));
        System.out.println(new ImplementStr().strStr("aaa", "aaaa"));
        System.out.println(new ImplementStr().strStr("mississippi", "issip"));
    }
}
