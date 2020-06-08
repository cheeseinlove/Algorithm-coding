/**
 * @Author liuxun05
 * @create 2020/2/23 21:31
 **/
public class Solution516 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        //dp(i,j)代表i-j中最长回文子序列，分类讨论charAti,j相同不同情况
        int[][] f = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            f[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    f[i][j] = f[i + 1][j - 1] + 2;
                } else {
                    f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
                }
            }
        }
        return f[0][n - 1];
    }

}
