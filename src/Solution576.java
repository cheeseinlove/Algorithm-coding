/**
 * @Author liuxun05
 * @create 2020/2/24 23:18
 **/
public class Solution576 {
    public static void main(String[] args) {

    }

    public int findPaths(int m, int n, int N, int i, int j) {
        int MOD = 1000000007;
        //i,j,k代表从i,j经过k步移到网外的方法数
        long dp[][][] = new long[m + 2][n + 2][N + 1];
        //初始化网外边界值为1
        for (int k = 0; k <= m + 1; k++) {
            dp[k][0][0] = 1;
            dp[k][n + 1][0] = 1;
        }
        for (int k = 0; k <= n + 1; k++) {
            dp[0][k][0] = 1;
            dp[m + 1][k][0] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int x = 1; x <= m; x++) {
                for (int y = 1; y <= n; y++) {
                    dp[x][y][k] = (dp[x - 1][y][k - 1] + dp[x + 1][y][k - 1] + dp[x][y - 1][k - 1] + dp[x][y + 1][k - 1]) % MOD;
                }
            }
        }

        int sum = 0;
        //步数不一定用完
        for (int k = 0; k <= N; k++) {
            sum = (int) (sum + dp[i + 1][j + 1][k]) % MOD;
        }
        return sum;
    }
}
