import java.util.Stack;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-11-18 23:43
 * @Description:
 */
public class Solution921 {
    public static void main(String[] args) {
        System.out.println(minAddToMakeValid("())"));
        System.out.println(minAddToMakeValid("((("));
        System.out.println(minAddToMakeValid("()"));
        System.out.println(minAddToMakeValid("()))(("));
    }
    public static int minAddToMakeValid(String S) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<S.length();i++){
            if (S.charAt(i)=='('){
                stack.push(S.charAt(i));
            }else {
                if (!stack.isEmpty()&&stack.peek()=='('){
                    stack.pop();
                }else {
                    stack.push(S.charAt(i));
                }
            }
        }
        return stack.size();

    }
}
