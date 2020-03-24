import java.util.Arrays;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-03-23 23:12
 * @Description:
 */
public class Solution940 {
    public int distinctSubseqII(String S) {
        int MOD = 1_000_000_007;
        int N = S.length();
        int[] dp = new int[N + 1];
        dp[0] = 1;

        int[] last = new int[26];
        Arrays.fill(last, -1);

        for (int i = 0; i < N; ++i) {
            int x = S.charAt(i) - 'a';
            dp[i + 1] = dp[i] * 2 % MOD;
            //若当前字符串之前出现过
            if (last[x] >= 0)
                //这里找规律可得出此公式
                dp[i + 1] -= dp[last[x]];
            dp[i + 1] %= MOD;
            //更新当前字符串最后出现索引
            last[x] = i;
        }
//减去空串情况
        dp[N]--;
        if (dp[N] < 0) dp[N] += MOD;
        return dp[N];


    }
}
