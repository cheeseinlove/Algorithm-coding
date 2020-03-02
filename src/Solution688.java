/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-03-01 21:20
 * @Description:
 */
public class Solution688 {
    public double knightProbability(int N, int K, int r, int c) {
    //这题和576几乎一样 (i,j,k)代表从i,j走k步还能留在棋盘上的概率
        double dp[][][] = new double[N + 4][N + 4][K + 1];

        for (int i = 0; i <= N + 3; i++) {
            for (int j = 0; j <= N + 3; j++) {
                if (i >= 2 && i <= N + 1 && j >= 2 && j <= N + 1) {
                    dp[i][j][0] = 1;
                } else {
                    dp[i][j][0] = 0;
                }
            }
        }

        for (int k = 1; k <= K; k++) {
            for (int i = 2; i <= N + 1; i++) {
                for (int j = 2; j <= N + 1; j++) {
                    dp[i][j][k] = (dp[i - 2][j - 1][k - 1] + dp[i - 2][j + 1][k - 1] +
                            dp[i - 1][j - 2][k - 1] + dp[i - 1][j + 2][k - 1] +
                            dp[i + 1][j - 2][k - 1] + dp[i + 1][j + 2][k - 1] +
                            dp[i + 2][j - 1][k - 1] + dp[i + 2][j + 1][k - 1]) / 8.0;
                }
            }
        }
        return dp[r + 2][c + 2][K];
    }
}
