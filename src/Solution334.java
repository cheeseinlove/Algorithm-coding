import java.util.Stack;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-12-24 22:33
 * @Description:
 */
public class Solution334 {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] <= nums[stack.peek()]) {
                stack.pop();
            }
            stack.push(i);
            if (stack.size() >= 3) {
                return true;
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]) {
                stack.pop();
            }
            stack.push(i);
            if (stack.size() >= 3) {
                return true;
            }
        }


        return false;


    }

    public boolean increasingTriplet2(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        for (int i : nums) {
            if (i <= a) {
                a = i;
            } else if (i <= b) {
                b = i;
            } else {
                return true;
            }
        }
        return false;
    }
}
