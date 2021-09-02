package leetcode;

/**
 * @author Pradeep Arya
 */
public class XOROperation {

    public int xorOperation(int n, int start) {

        int output = start;

        for (int index = 1; index < n; index++) {
            output ^= (start + 2 * index);
        }
        return output;
    }


    public static void main(String[] args) {
        System.out.println(new XOROperation().xorOperation(5, 0));
        System.out.println(new XOROperation().xorOperation(4, 3));
        System.out.println(new XOROperation().xorOperation(1, 7));
        System.out.println(new XOROperation().xorOperation(10, 5));
    }
}
