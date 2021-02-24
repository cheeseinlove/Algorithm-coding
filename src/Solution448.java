import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-12-22 22:40
 * @Description:
 */
public class Solution448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int v = Math.abs(nums[i]);
            if (nums[v - 1] > 0) {
                //变为负数
                nums[v - 1] = nums[v - 1] * -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >0) {
                ans.add(i + 1);
            }
        }

        return ans;
    }
}
