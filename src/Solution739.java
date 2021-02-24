import java.util.Stack;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-12-22 21:32
 * @Description:
 */
public class Solution739 {
    public static void main(String[] args) {
        dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }
    public static int[] dailyTemperatures(int[] T) {
        int ans[]=new int[T.length];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<T.length;i++){
            while (!stack.isEmpty()&&T[i]>T[stack.peek()]){
                int old=stack.pop();
                ans[old]=i-old;
            }
            stack.push(i);
        }
        return ans;
    }
}
