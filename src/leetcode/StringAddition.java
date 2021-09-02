package leetcode;

/**
 * @author Pradeep Arya
 */
public class StringAddition {

    public String addStrings(String num1, String num2) {

        int num1Length = num1.length() - 1;
        int num2Length = num2.length() - 1;

        int carry = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (num1Length >= 0 && num2Length >= 0) {

            int number1 = num1.charAt(num1Length) - 48;
            int number2 = num2.charAt(num2Length) - 48;
            int sum = number1 + number2 + carry;
            if (sum > 9) {
                carry = sum / 10;
                sum = sum % 10;
            }
            stringBuilder.insert(0, sum);

            num1Length--;
            num2Length--;
        }

        while (num1Length >= 0) {
            int number1 = num1.charAt(num1Length) - 48;
            int sum = number1 + carry;
            if (sum > 9) {
                carry = sum / 10;
                sum = sum % 10;
            }else{
                carry = 0;
            }
            stringBuilder.insert(0, sum);
            num1Length--;
        }

        while (num2Length >= 0) {
            int number2 = num2.charAt(num2Length) - 48;
            int sum = number2 + carry;
            if (sum > 9) {
                carry = sum / 10;
                sum = sum % 10;
            }else{
                carry = 0;
            }
            stringBuilder.insert(0, sum);
            num2Length--;
        }

        if (carry > 0) {
            stringBuilder.insert(0, carry);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {

        System.out.println("output 134 " + new StringAddition().addStrings("11", "123"));
        System.out.println("output 533 " + new StringAddition().addStrings("456", "77"));
        System.out.println("output 0 " + new StringAddition().addStrings("0", "0"));
    }
}
