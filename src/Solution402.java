import java.util.Stack;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-11-30 08:29
 * @Description:
 */
public class Solution402 {
    public static void main(String[] args) {
        removeKdigits("1432219",3);
    }
    //求移除K位给定字符串的子序列最值。可以用单调栈遍历
    public static String removeKdigits(String num, int k) {
        int remove = k;
        if (remove >= num.length()) {
            return "0";
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            while (!stack.isEmpty() && num.charAt(i) < num.charAt(stack.peek()) && remove > 0) {
                stack.pop();
                remove--;
            }
            stack.push(i);
        }
        while (remove > 0) {
            stack.pop();
            remove--;
        }
        int len=stack.size();
        char[] ans = new char[len];
        while (!stack.isEmpty()) {
            ans[--len] = num.charAt(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        //移除前导0
        while (i < ans.length && ans[i] == '0') {
            i++;
        }
        if (i==ans.length){
            return "0";
        }
        while (i < ans.length) {
            sb.append(ans[i++]);
        }
        return sb.toString();
    }
}
