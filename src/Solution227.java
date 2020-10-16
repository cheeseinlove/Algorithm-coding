import java.util.Stack;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-09-27 21:52
 * @Description:
 */
public class Solution227 {
    public static void main(String[] args) {
//        System.out.println(calculate(" 3+5 / 2 "));
    }

    public int calculate(String s) {
        char[] arr = s.toCharArray();
        Stack<Integer> value = new Stack<>();
        char lastOp = '+';
        for (int i = 0; i < arr.length; i++) {
            if (String.valueOf(s.charAt(i)).equals(" ")) {
                continue;
            }
            if (Character.isDigit(arr[i])) {
                int tempNum = arr[i] - '0';
                while (++i < arr.length && Character.isDigit(arr[i])) {
                    tempNum = tempNum * 10 + (arr[i] - '0');
                }
                i--;

                if (lastOp == '+') value.push(tempNum);
                else if (lastOp == '-') value.push(-tempNum);
                else value.push(res(lastOp, value.pop(), tempNum));
            } else lastOp = arr[i];
        }
        int ans = 0;
        while (!value.isEmpty()) {
            ans += value.pop();
        }
        return ans;
    }

    private int res(char op, int a, int b) {
        if (op == '*') return a * b;
        else if (op == '/') return a / b;
        else if (op == '+') return a + b; //其实加减运算可以忽略
        else return a - b;
    }

}
