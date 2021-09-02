package leetcode;

/**
 * @author Pradeep Arya
 */
public class ConsecutiveNumbersSum {
    public int consecutiveNumbersSum(int n) {

        int startNumber = 1;
        int sum = 0;
        int count = 1;
        int currentNumber = 1;
        int endNumber = n % 2 == 0 ? (n / 2) : (n / 2) + 1;

        if (currentNumber < n) {

            while (currentNumber <= endNumber) {

                int currentSum = sum + currentNumber;

                if (currentSum > n) {
                    while (currentSum > n) {
                        currentSum -= startNumber;
                        startNumber++;
                    }
                }


                if (currentSum == n) {
                    count++;
                }

                currentNumber++;
                sum = currentSum;


            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println("output 2 " + new ConsecutiveNumbersSum().consecutiveNumbersSum(5));
        System.out.println("output 3 " + new ConsecutiveNumbersSum().consecutiveNumbersSum(9));
        System.out.println("output 4 " + new ConsecutiveNumbersSum().consecutiveNumbersSum(15));
        System.out.println("output 1 " + new ConsecutiveNumbersSum().consecutiveNumbersSum(1));
        System.out.println("output 1 " + new ConsecutiveNumbersSum().consecutiveNumbersSum(2));
    }
}
