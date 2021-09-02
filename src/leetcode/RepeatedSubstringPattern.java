//Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.

package leetcode;

/**
 * @author Pradeep Arya
 */
public class RepeatedSubstringPattern {

//    public boolean repeatedSubstringPattern(String s) {
//        boolean isRepeatedSubString = false;
//        int strLength = s.length();
//        int subStringLength = 1;
//        while (subStringLength <= strLength / 2) {
//            String subString = s.substring(0, subStringLength);
//
//            int subStringCount = strLength / subStringLength;
//
//            String newString = "";
//            while (subStringCount > 0) {
//                newString += subString;
//                subStringCount--;
//            }
//
//            if (newString.equals(s)) {
//                isRepeatedSubString = true;
//                break;
//            }
//
//
//            subStringLength++;
//        }
//
//        return isRepeatedSubString;
//    }

    public boolean repeatedSubstringPattern(String s) {
        boolean isRepeatedSubString = false;
        int strLength = s.length();
        int subStringLength = 1;
        while (subStringLength <= strLength / 2) {
            if(strLength%subStringLength==0){
                String subString = s.substring(0, subStringLength);

                int startIndex = subStringLength;
                int endIndex = startIndex + subStringLength;

                boolean isValid = true;
                while (endIndex <= strLength) {
                    String currentSubString = s.substring(startIndex, endIndex);
                    if (!subString.equals(currentSubString)) {
                        isValid = false;
                        break;
                    }
                    startIndex = endIndex;
                    endIndex = startIndex + subStringLength;
                }

                if (isValid && startIndex >= strLength) {
                    isRepeatedSubString = true;
                    break;
                }
            }


            subStringLength++;
        }

        return isRepeatedSubString;
    }

    public static void main(String[] args) {

        System.out.println(new RepeatedSubstringPattern().repeatedSubstringPattern("abab"));
        System.out.println(new RepeatedSubstringPattern().repeatedSubstringPattern("aba"));
        System.out.println(new RepeatedSubstringPattern().repeatedSubstringPattern("abcabcabcabc"));
        System.out.println(new RepeatedSubstringPattern().repeatedSubstringPattern("babbabbabbabbab"));
        System.out.println(new RepeatedSubstringPattern().repeatedSubstringPattern("abac"));
        System.out.println(new RepeatedSubstringPattern().repeatedSubstringPattern("aabaaba"));

    }
}
