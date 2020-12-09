package week_competition;

import java.util.Arrays;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-12-06 20:58
 * @Description:
 */
public class Solution5618 {
    public int maxOperations(int[] nums, int k) {
        int ans = 0;
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int cur = nums[l] + nums[r];
            if (cur < k) {
                l++;
            } else if (cur > k) {
                r--;
            } else {
                ans++;
                l++;
                r--;
            }

        }
        return ans;
    }
}
