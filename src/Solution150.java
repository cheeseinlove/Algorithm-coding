import java.util.Stack;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-06-10 23:32
 * @Description:
 */
public class Solution150 {
    public static void main(String[] args) {
        String tokens[] = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
//        System.out.println(Integer.valueOf("-1"));
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        int size = tokens.length;
        if (size < 1) {
            return 0;
        }
        Stack<Integer> digits = new Stack<>();
        for (int i = 0; i < size; i++) {
            if (!isOp(tokens[i])) {
                digits.push(Integer.valueOf(tokens[i]));
            } else {
                int b = digits.pop();
                int a = digits.pop();
                int ans = 0;
                if (tokens[i].equals("+")) {
                    ans = a + b;
                } else if (tokens[i].equals("-")) {
                    ans = a - b;
                } else if (tokens[i].equals("*")) {
                    ans = a * b;
                } else if (tokens[i].equals("/")
                ) {
                    ans = a / b;

                }
                digits.push(ans);
            }

        }
        return digits.pop();
    }

    public static boolean isOp(String s) {
        if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
            return true;
        }
        return false;

    }
}
