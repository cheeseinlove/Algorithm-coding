/**
 * @Author: liuxun05@meituan.com
 * @Date: 2021-01-04 23:21
 * @Description:
 */
public class Solution1712 {
    public int waysToSplit(int[] nums) {
        int n = nums.length;
        // 计算前缀和
        int[] sums = new int[n];
        sums[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }

        final int MOD = 1000000000 + 7;
        long ans = 0;
        // 第一刀的最大值：sum(nums) / 3
        int t = sums[n - 1] / 3;
        //i为第一刀的位置
        for (int i = 0; i < n && sums[i] <= t; i++) {
            // 二分查找第二刀的最小值：sum(mid) == sum(left)
            // 在 [i+1, n] 中二分查找 sums[i] * 2，sums[i] 为到 i 为止元素和，因为是前缀数组，因而应该查找 sum(left) + sum(mid)
            int left = lowerBound(i + 1, n - 1, sums, sums[i] * 2);
            // 二分查找第二刀的最大值：sum(mid) == sum(mid + right) / 2
            // 在 [i+1, n] 中二分查找 sums[i] + (sums[n - 1] - sums[i]) / 2)，因为是前缀数组，因而应该查找 sum(left) + sum(mid + right) / 2
            int right = upperBound(i + 1, n - 1, sums, sums[i] + (sums[n - 1] - sums[i]) / 2);
            if (right >= left) {
                ans += right - left + 1;
            }
        }
        return (int) (ans % MOD);
    }

    public int lowerBound(int left, int right, int[] nums, int target) {
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            //向上取整left=mid+1
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int upperBound(int left, int right, int[] nums, int target) {
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left - 1;
    }

}
