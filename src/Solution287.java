/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-08-10 08:53
 * @Description:
 */
public class Solution287 {
    public int findDuplicate(int[] nums) {
        int n = nums.length - 1;
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int cnt = 0;
            for (int i = 0; i <= n; i++) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }
            int leftPartSize = mid ;
            if (cnt > leftPartSize) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }
        return left;
    }
}
