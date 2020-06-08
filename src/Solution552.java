/**
 * @Author liuxun05
 * @create 2020/2/24 0:16
 **/
public class Solution552 {
    public int checkRecord(int n) {
        long dp[][][]=new long[2][3][n+1];   //dp[i][j][k]表示有i个A,结尾是连续j个L,长度为k的字符串所代表的组合数
        dp[0][0][1] = 1;
        dp[1][0][1] = 1;
        dp[0][1][1] = 1;

        for(int len = 2 ; len <= n ; ++len){
            dp[0][0][len] = (dp[0][0][len-1] + dp[0][1][len-1] + dp[0][2][len-1] )% 1000000007;
            dp[1][0][len] = (dp[0][0][len-1] + dp[0][1][len-1] + dp[0][2][len-1] + dp[1][0][len-1] + dp[1][1][len-1] + dp[1][2][len-1])% 1000000007;
            dp[0][1][len] = dp[0][0][len-1]% 1000000007;
            dp[1][1][len] = dp[1][0][len-1]% 1000000007;
            dp[0][2][len] = dp[0][1][len-1]% 1000000007;
            dp[1][2][len] = dp[1][1][len-1]% 1000000007;
        }
        return (int) ((dp[0][0][n] + dp[1][0][n] + dp[0][1][n] + dp[1][1][n] + dp[0][2][n] + dp[1][2][n]) % 1000000007L);
    }
}
