/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-03-19 20:45
 * @Description:
 */
public class Solution879 {
    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        int M=1_000_000_007;
        int N=profit.length;
         //dp[i][j][k]代表考虑前i个profit的情况下，在可用人数为j个情况下，能获取利润至少为k的情况数
        //dp[i][j][k] = dp[i - 1][j][k] + dp[i - 1][j - g][max(k - p, 0)]; 前者是不选第i种方案，后者是选第i种方案
        int dp[][][]=new int[N+1][G+1][P+1];


        for (int i = 0; i <= N; ++i) {
            for (int j = 0; j <= G; ++j) {
                dp[i][j][0] = 1;
            }
        }
        for (int i = 1; i <= N; ++i) {
            //当前计划消耗人数
            int g = group[i - 1];
            //当前计划收益
            int p = profit[i - 1];
            for (int j = 1; j <= G; ++j) {
                for (int k = 0; k <= P; ++k) {
                    //不选当前计划
                    dp[i][j][k] = dp[i - 1][j][k];
                    //若人数够才能选当前计划
                    if (j >= g) {
                        dp[i][j][k] += dp[i - 1][j - g][Math.max(k - p, 0)];
                    }
                    dp[i][j][k] %= M;
                }
            }
        }
        return dp[N][G][P];
    }
}
