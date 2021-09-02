//An n-bit gray code sequence is a sequence of 2n integers where:
//
//Every integer is in the inclusive range [0, 2n - 1],
//The first integer is 0,
//An integer appears no more than once in the sequence,
//The binary representation of every pair of adjacent integers differs by exactly one bit, and
//The binary representation of the first and last integers differs by exactly one bit.
//Given an integer n, return any valid n-bit gray code sequence.

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author Pradeep Arya
 */


class Student{
    private String name;
    private int id;
    private int rollNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                rollNumber == student.rollNumber &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, rollNumber);
    }
}

public class GreyCode {

    public List<String> binaryCodes(int n) {

        if (n == 1) {
            return Arrays.asList("0", "1");
        }

        List<String> binaryCodes = binaryCodes(n - 1);
        List<String> output = new ArrayList<>();

        for (int index = 0; index < binaryCodes.size(); index++) {
            output.add("0" + binaryCodes.get(index));
        }

        for (int index = binaryCodes.size() - 1; index >= 0; index--) {
            output.add("1" + binaryCodes.get(index));
        }

        return output;

    }

    public List<Integer> grayCode(int n) {

        List<String> grayCodes = binaryCodes(n);
        List<Integer> output = new ArrayList<>();
        for (String binaryString : grayCodes) {
            output.add(Integer.parseUnsignedInt(binaryString, 2));
        }
        return output;

    }

    public static void main(String[] args) {
        System.out.println(new GreyCode().grayCode(1));
        System.out.println(new GreyCode().grayCode(2));
    }
}
