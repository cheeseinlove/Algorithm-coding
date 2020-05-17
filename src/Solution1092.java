import java.util.Arrays;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-04-22 23:22
 * @Description:
 */
public class Solution1092 {
    public static void main(String[] args) {
        String a = "abac";
        String b = "cab";
        System.out.println(shortestCommonSupersequence(a, b));

    }

    /**
     * 求最短超序列=两字符串最长公共子序列lcs+s1的剩余部分+s2的剩余部分
     *
     * @param str1
     * @param str2
     * @return
     */
    public static String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        String dp[][] = new String[n + 1][m + 1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],"");
        }
        String lcs = "";
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + str1.charAt(i - 1);
                } else {
                    //这里没把dp[i-1][j-1]加进来是因为dp[i-1][j-1]<=Math.max(dp[i][j-1],dp[i-1][j])
                    dp[i][j] = dp[i][j - 1].length() > dp[i - 1][j].length() ? dp[i][j - 1] : dp[i - 1][j];
                }
            }
        }
        lcs = dp[n][m];
        String ans = "";
        int i = 0, j = 0;
        for (char ch : lcs.toCharArray()) {
            //不同字符串的字符相对顺序无关，所以先遍历str1和先遍历str2都可以
            while (i < n && str1.charAt(i) != ch)
                ans += str1.charAt(i++);
            while (j < m && str2.charAt(j) != ch)
                ans += str2.charAt(j++);
            ans += ch;
            ++i;
            ++j;
        }
        //加上每个字符串在LCS之后的字符
        return ans + str1.substring(i) + str2.substring(j);


    }
}