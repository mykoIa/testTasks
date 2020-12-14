import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * the class implements an algorithm for outputting all correct combinations of n pairs of parentheses
 */
public class Task {
    /**
     * recursively fills array list
     * @param list keeps all options in parentheses
     * @param leftRem number of left parentheses
     * @param rightRem number of right brackets
     */
    public static void addParen(ArrayList list, int leftRem, int rightRem, char[] str, int index) {
        if (leftRem < 0 || rightRem < leftRem) return;
        if (leftRem == 0 && rightRem == 0) {
            list.add(String.copyValueOf(str));
        } else {
            str[index] = '(';
            addParen(list, leftRem - 1, rightRem, str, index + 1);
            str[index] = ')';
            addParen(list, leftRem, rightRem - 1, str, index + 1);
        }
    }

    /**
     * generates parentheses
     * @param count number of open and closed parentheses
     * @return a list that stores all possible options
     */
    public static ArrayList generateParens(int count) {
        char[] str = new char[count*2];
        ArrayList list = new ArrayList();
        addParen(list, count, count, str, 0);
        return list;
    }

    /**
     * prints the result stored in the list
     * @param list stores all results
     */
    public static void printResult(ArrayList list) {
        for (Object s : list) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(reader.readLine());
            if (count > 0) {

            }
            printResult(generateParens(count));
        }
    }
}
