import java.util.ArrayList;

/**
 * this class finds the sum of the digits of the factorial out of 100
 */
public class Task {
    // stored in vector v. Result is stored in v.
    static ArrayList<Integer> vector = new ArrayList<>();

    /**
     * adds the factorial number to the list
     * @param x a number from 1 to n factorial
     */
    static void multiply(int x) {
        int carry = 0;
        int size = vector.size();
        for (int i = 0; i < size; i++) {
            int res = carry + vector.get(i) * x;
            vector.set(i, res % 10);
            carry = res / 10;
        }
        while (carry != 0) {
            vector.add(carry % 10);
            carry /= 10;
        }
    }

    /**
     * this method will sum each factorial number
     * @param facrotial the factorial whose sum of numbers you want to find
     * @return the sum of the factorial numbers
     */
    static int findSumOfDigits(int facrotial) {
        vector.add(1);
        for (int i = 1; i <= facrotial; i++)
            multiply(i);
        int sum = 0;
        int size = vector.size();
        for (int i = 0; i < size; i++) {
            sum += vector.get(i);
        }
        return sum;
    }

    /**
     * method starts computation and prints the result
     */
    public static void main(String[] args) {
        int factorial = 100;
        System.out.println(findSumOfDigits(factorial));
    }
}