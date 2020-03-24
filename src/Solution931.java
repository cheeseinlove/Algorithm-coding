/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-03-22 23:03
 * @Description:
 */
public class Solution931 {
    public static void main(String[] args) {
        int a[][] = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(minFallingPathSum(a));
    }

    public static int minFallingPathSum(int[][] A) {
        int dp[][] = new int[A.length][A[0].length];
        for (int i = 0; i < A[0].length; i++) {
            dp[0][i] = A[0][i];
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                int a = Integer.MAX_VALUE;
                int b = dp[i - 1][j];
                int c = Integer.MAX_VALUE;
                if (j != 0) {
                    a = dp[i - 1][j - 1];
                }
                if (j != dp[i].length - 1) {
                    c = dp[i - 1][j + 1];
                }
                dp[i][j] = Math.min(a, Math.min(b, c))+A[i][j];
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A[dp.length - 1].length; i++) {
            min = Math.min(min, dp[dp.length - 1][i]);
        }
        return min;
    }
}
