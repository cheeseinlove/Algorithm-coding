/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-01-21 14:33
 * @Description:
 */
public class Solution122 {
    public static void main(String[] args) {
        int casee1[] = new int[]{7, 1, 5, 3, 6, 4};
        int case2[] = new int[]{7, 6, 4, 3, 1};
        System.out.println(maxProfit(casee1));
        System.out.println(maxProfit(case2));
    }

    /**
     * dp[i][j] i代表天数，j代表持股情况，0是没有持股，1是有，最终肯定求dp[n-1][0];
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int dp[][] = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = 0 - prices[0];
        for (int i = 1; i < prices.length; i++) {
            //不持股
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
            //持股
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[prices.length - 1][0] < 0 ? 0 : dp[prices.length - 1][0];
    }
}
