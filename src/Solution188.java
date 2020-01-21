/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-01-21 16:25
 * @Description:
 */
public class Solution188 {
    public static void main(String[] args) {
        System.out.println(maxProfit(2,new int[]{2,4,1}));
    }

    /**
     * k其实有潜在的上线，一次交易包括最少两天，所以k上线应该是n/2,如果超过n/2相当于没有限制即solution122
     * @param k
     * @param prices
     * @return
     */
    public static int maxProfit(int k, int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        if (k>prices.length/2){
            return maxProfit(prices);
        }
        int dp[][][] = new int[prices.length][k+1][2];

        for (int i = 0; i < prices.length; i++) {
            for (int j=k;j>=1;j--){
                if (i == 0) {
                    //初始化
                    dp[i][j][0]=0;
                    dp[i][j][1]=-prices[i];
                } else {
                    //不持股
                    dp[i][j][0] = Math.max(dp[i - 1][j][1] + prices[i], dp[i - 1][j][0]);
                    //持股,买入时候算一次交易所以是j-1
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                }
            }

        }
        return dp[prices.length - 1][k][0] < 0 ? 0 : dp[prices.length - 1][k][0];
    }
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
