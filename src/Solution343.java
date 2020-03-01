/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-02-11 23:34
 * @Description:
 */
public class Solution343 {
    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }

    public static int integerBreak(int n) {
        int dp[] = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; j < i; j++) {
                //j*i-j代表只拆分成两个数,dp[j] * (i - j)代表至少拆分成三个数
                max = Math.max(max,Math.max(j*(i-j),dp[j] * (i - j)));
            }
            dp[i] = max;
        }


        return dp[n];
    }
}
