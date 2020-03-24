/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-03-08 23:01
 * @Description:
 */
public class Solution740 {
    public int deleteAndEarn(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int max = nums[0];
        for (int i = 0; i < len; i++) if (max < nums[i]) max = nums[i];
        //nums数组每个数的个数
        int[] arr = new int[max+1];
        int[][] dp = new int[max+1][2];
        for (int i = 0; i < len; i++) arr[nums[i]]++;
        // 0 获取 1 不获取
        //nums[i]的大小都在[1, 10000]范围内
        dp[1][0] = arr[1]*1;
         dp[1][1] = 0;
        for (int i = 2; i <= max; i++) {
            // 当前数拿，上一个数不拿后者前前个数拿
            dp[i][0] = Math.max(dp[i-2][0] , dp[i-1][1]) + arr[i] * i;
            //当前数不拿，上一个数可以拿或不拿
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]);
        }
        return Math.max(dp[max][0], dp[max][1]);


    }
}
