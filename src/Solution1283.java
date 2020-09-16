/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-08-27 23:22
 * @Description:
 */
public class Solution1283 {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        // 先找数组中的最大值，用最大值作为除数，除完以后和最小
        int maxVal = 1;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        int right = maxVal;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (isLessThanThreshold(nums, threshold, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean isLessThanThreshold(int[] nums, int threshold, int divisor) {
        int sum=0;
        for (int i=0;i<nums.length;i++){
            sum+=(nums[i]-1)/divisor+1;
        }
        return sum<=threshold;
    }
}
