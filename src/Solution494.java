/**
 * @Author liuxun05
 * @create 2020/2/23 1:24
 **/
public class Solution494 {
    public static void main(String[] args) {

    }
    public static int findTargetSumWays(int[] nums, int S) {
        //dp i.j,i代表数组下标为0--i的和为j的方案有dp[i][j]种
        //dp[i][j]=dp[i-1][j-nums[i]]+dp[i-1][j+nums[i]];
        //改为递推方式为
        //dp[i][j + nums[i]] += dp[i - 1][j]
        //dp[i][j - nums[i]] += dp[i - 1][j]
        int[][] dp = new int[nums.length][2001];
        dp[0][nums[0] + 1000] = 1;
        dp[0][-nums[0] + 1000] += 1;
        for (int i = 1; i < nums.length; i++) {
            for (int sum = -1000; sum <= 1000; sum++) {
                if (dp[i - 1][sum + 1000] > 0) {
                    dp[i][sum + nums[i] + 1000] += dp[i - 1][sum + 1000];
                    dp[i][sum - nums[i] + 1000] += dp[i - 1][sum + 1000];
                }
            }
        }
        return S > 1000 ? 0 : dp[nums.length - 1][S + 1000];
    }


}
