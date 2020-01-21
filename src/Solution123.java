/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-01-20 16:45
 * @Description: 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * <p>
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,3,5,0,0,3,1,4]
 * 输出: 6
 * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。  
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
 */
public class Solution123 {
    public static void main(String[] args) {
        int case1[] = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
        int case2[] = new int[]{1, 2, 3, 4, 5};
        int case3[] = new int[]{7, 6, 4, 3, 1};
        System.out.println(maxProfit(case1));
        System.out.println(maxProfit(case2));
        System.out.println(maxProfit(case3));
    }

    /**
     * 交易一次
     *
     * @param prices
     * @return
     */
    public static int maxProfit1(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int res = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            max = Math.max(prices[i] - min, max);
            min = Math.min(prices[i], min);
        }
        return max < 0 ? 0 : max;
    }

    public static int maxProfit1(int[] prices, int begin, int end) {
        int length = end - begin + 1;
        if (length < 2) {
            return 0;
        }
        int res = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = begin; i <= end; i++) {
            max = Math.max(prices[i] - min, max);
            min = Math.min(prices[i], min);
        }
        return max < 0 ? 0 : max;
    }

    /**
     * 笨办法，将数组一分为二转化为两个子数组分别买单次股票，但是耗时很多，
     * 执行用时 :
     * 563 ms
     * , 在所有 Java 提交中击败了
     * 8.26%
     * 的用户
     * 内存消耗 :
     * 37.9 MB
     * , 在所有 Java 提交中击败了
     * 55.06%
     * 的用户
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {

        if (prices.length < 2) {
            return 0;
        }

        int res = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            max = Math.max(max, maxProfit1(prices, 0, i) + maxProfit1(prices, i + 1, prices.length - 1));
        }

        return max;
    }

    /**
     * 采用dp table的方法解决，首先定义三种状态1.天数 2.最多交易次数 3.当前是否持有股票，那么就需要一个三维dp数组来表示状态，
     * dp[i][k][0 or 1]
     * 0 <= i <= n-1, 1 <= k <= K
     * n 为天数，大 K 为最多交易数（）此题为2，但可以演变
     * 此问题共 n × K × 2 种状态，全部穷举就能搞定。
     *
     * for 0 <= i < n:
     *     for 1 <= k <= K:
     *         for s in {0, 1}:
     *             dp[i][k][s] = max(buy, sell, rest)
     *
     * 显然我们最后求的值是dp[n-1][K][0]
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {

        if (prices.length < 2) {
            return 0;
        }
        //最大交易次数
        int k=2;
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

}
