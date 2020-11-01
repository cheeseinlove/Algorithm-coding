import java.util.Stack;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-10-22 09:24
 * @Description:
 */
public class Solution678 {
    public boolean checkValidString(String s) {
        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left.push(i);
            } else if (s.charAt(i) == '*') {
                star.push(i);
            } else {
                //优先使用(栈，因为*能变成(,*,)或空串
                if (!left.isEmpty()) {
                    left.pop();
                } else {
                    if (!star.isEmpty()) {
                        //变成(
                        star.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        //使用*当做)消耗剩余的(,*必须在(右边
        while (!left.isEmpty() && !star.isEmpty()) {
            if (left.pop() > star.pop()) return false;
        }
        //只要(消耗完就算成功，因为*能变空串
        return left.isEmpty();


    }
}
