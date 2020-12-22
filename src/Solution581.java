import java.util.Stack;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-12-18 21:06
 * @Description:
 */
public class Solution581 {
    //只需要子数组区间最小值>=左边界，最大值<=右边界
    public int findUnsortedSubarray(int[] nums) {
        Stack < Integer > stack = new Stack < Integer > ();
        //l为交换的最左端，r为交换最右端
        int l = nums.length, r = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!stack.isEmpty() &&nums[stack.peek()] > nums[i]){
                r = Math.max(r, i);
            }
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]){
                //找到当前i的正确位置,
                l = Math.min(l, stack.pop());
            }
            stack.push(i);
        }
//        stack.clear();
//        for (int i = nums.length - 1; i >= 0; i--) {
//            while (!stack.isEmpty() && nums[stack.peek()] < nums[i])
//                r = Math.max(r, stack.pop());
//            stack.push(i);
//        }
        return r - l > 0 ? r - l + 1 : 0;


    }
}
