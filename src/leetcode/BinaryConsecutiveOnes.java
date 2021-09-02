package leetcode;

/**
 * @author Pradeep Arya
 */
public class BinaryConsecutiveOnes {

//    public int findIntegers(int n) {
//        return (int) IntStream.range(0, n + 1).filter(number -> {
//            boolean isValid = true;
//
//            int prev = 0;
//            while (number > 0) {
//                int current = number % 2;
//                if (current == 1 && prev == current) {
//                    isValid = false;
//                    break;
//                }
//                prev = current;
//                number /= 2;
//
//            }
//            return isValid;
//        }).count();
//    }

    public int findIntegers(int n) {
        int maxDigits = 0;
        int number = n;
        while (number > 0) {
            maxDigits++;
            number /= 2;
        }
        System.out.println(maxDigits);

        int secondLastCount = 1;
        int lastCount = 2;

        int digit = 2;
        while (digit <= maxDigits) {
            int currentDigitCount = lastCount + secondLastCount;
            secondLastCount = lastCount;
            lastCount = currentDigitCount;
            digit++;
        }

        return lastCount;
    }

    public static void main(String[] args) {
        System.out.println("output 5 " + new BinaryConsecutiveOnes().findIntegers(5));
        System.out.println("output 514229 " + new BinaryConsecutiveOnes().findIntegers(100000000));
        System.out.println("output 4 " + new BinaryConsecutiveOnes().findIntegers(4));
    }
}
