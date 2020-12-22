package sort;

import java.util.Stack;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-12-17 23:31
 * @Description:
 */
public class Solution394 {
    public static void main(String[] args) {
        System.out.println(decodeString("2[abc]3[cd]ef"));
    }

    public static String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        Stack<Character> cache = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                //缓存[]中的字母
                while (stack.peek() != '[') {
                    cache.push(stack.pop());
                }
                //出栈[
                stack.pop();
                //拿到重复次数
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() <= '9' && stack.peek() >= '0') {
                    sb.insert(0, stack.pop());
                }
                int size = Integer.parseInt(sb.toString());
                StringBuilder cacheSb = new StringBuilder();
                while (!cache.isEmpty()) {
                    cacheSb.append(cache.pop());
                }
                //重复几次入栈
                for (int j = 0; j < size; j++) {
                    for (int k = 0; k < cacheSb.length(); k++) {
                        stack.push(cacheSb.charAt(k));
                    }
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        char[] ans = new char[stack.size()];

        for (int i = stack.size() - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return String.valueOf(ans);

    }
}
