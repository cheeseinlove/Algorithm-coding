package tools;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-04-21 23:31
 * @Description:
 */
//经典题最长公共子序列
public class Solution1143 {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        //dp(i,j)s1的前i项和s2的前j项最长公共子串
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]+1;
                } else {
                    //这里没把dp[i-1][j-1]加进来是因为dp[i-1][j-1]<=Math.max(dp[i][j-1],dp[i-1][j])
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[n][m];
    }
    public  int longestCommonSubsequence2(String text1, String text2) {
        char[] X=text1.toCharArray();
        char[] Y= text2.toCharArray();
        int m=text1.length();
        int n=text2.length();
        int memo[] = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            int prev = 0;
            for (int j = 1; j <= n; j++) {
                int temp = memo[j];
                if (X[i - 1] == Y[j - 1]) {
                    memo[j] = prev + 1;
                } else {
                    memo[j] = Math.max(memo[j], memo[j - 1]);
                }
                prev = temp;
            }

        }
        return memo[n];
    }
}
