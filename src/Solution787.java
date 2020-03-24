import java.util.Arrays;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-03-10 21:17
 * @Description:
 */
public class Solution787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] cost = new int[n][n];
        //转存一下
        for(int i = 0; i < flights.length; i++){
            int st = flights[i][0];
            int en = flights[i][1];
            int price = flights[i][2];
            cost[st][en] = price;
        }
// dp[i][j][k],从i站到j站最多中转k站的最小代价!
        int[][][] dp = new int[n][n][K+2];
        //初始化-1
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        int res = f(cost, src, dst, K+1, dp);
        return res >= 1000000 ? -1 : res;
    }
    private int f(int[][] cost, int src, int dst, int K, int[][][] dp){
        if(K < 0){
            return 1000000;
        }
        if(dp[src][dst][K] != -1){
            return dp[src][dst][K];
        }
        if(src == dst){
            return dp[src][dst][K] = 0;
        }
        int ans  = Integer.MAX_VALUE;
        for(int i = 0; i < cost.length; i++){
            if(cost[src][i] != 0){
                //经过i中转
                ans = Math.min(ans, cost[src][i] + f(cost, i, dst, K-1, dp));
            }
        }
        //dp用于记忆化搜索
        return dp[src][dst][K] = (ans == Integer.MAX_VALUE ? 1000000 : ans);
    }
}
