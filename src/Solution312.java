/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-02-09 12:13
 * @Description:
 */
public class Solution312 {
    public static void main(String[] args) {
        int nums[] = new int[]{3, 1, 5, 8};

        System.out.println(maxCoins(nums));
    }

    public static int maxCoins(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int n = nums.length;
        //dp[i][j]代表的是包含边界i,j的最大得分
        int[][] dp = new int[n][n];
        //枚举区间长度
        for (int len = 1; len <= n; len++) {
            //枚举起点
            for (int i = 0; i <= n - len; i++) {
                //区间终点
                int j = i + len - 1;
                //枚举分割点,根据分割点分割出两个子状态，需要考虑左区间的右端点比0大，右区间的左端点比n小
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j], (k - 1 >= 0 ? dp[i][k - 1] : 0) + (k + 1 < n ? dp[k + 1][j] : 0) + nums[k] * (i - 1 >= 0 ? nums[i - 1] : 1) * (j + 1 < n ? nums[j + 1] : 1));
                }
            }
        }
        return dp[0][n - 1];
    }
}
