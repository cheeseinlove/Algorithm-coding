/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-08-28 09:53
 * @Description:
 */
public class Solution1292 {
    int m, n;
    int[][] dp;
    public int maxSideLength(int[][] mat, int threshold) {
        m = mat.length;
        n = mat[0].length;
        dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = mat[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }
        int l = 0, h = Math.min(m, n);
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (l == h || l + 1 == h) {
                break;
            }
            if (help(mid, threshold)) {
                l = mid;
            } else {
                h = mid - 1;
            }
        }
        if (help(h, threshold)) {
            return h;
        } else {
            return l;
        }
    }
    public boolean help(int k, int threshold) {
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i - k < 0 || j - k < 0) {
                    continue;
                }
                if (dp[i][j] - dp[i - k][j] - dp[i][j - k] + dp[i - k][j - k] <= threshold) {
                    return true;
                }
            }
        }
        return false;
    }

}
