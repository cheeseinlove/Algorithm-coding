/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-01-21 16:36
 * @Description:
 * 你可以无限次地完成交易，但是你每次交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了
 */
public class Solution714 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 3, 2, 8, 4, 9},2));
    }
    public static int maxProfit(int[] prices, int fee) {
      if (prices.length<2){
          return 0;
      }

      int dp[][]=new int[prices.length][2];
      dp[0][0]=0;
      dp[0][1]=-prices[0]-fee;
      for(int i=1;i<prices.length;i++){
          //持股
          //注意这里不能在买入时候扣手续费，因为只是买入可能交易未完成
          dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]-fee);
          //不持股
          dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
      }
      return dp[prices.length-1][0]<0?0:dp[prices.length-1][0];
    }
}
