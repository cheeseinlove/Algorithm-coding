/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-03-12 23:46
 * @Description:
 */
public class Solution813 {
    public static void main(String[] args) {
        System.out.println(largestSumOfAverages(new int[]{1,2,3},3));
    }
    public static double largestSumOfAverages(int[] A, int K) {
        if (K == 0) return 0;

        double[][] dp = new double[K + 1][A.length];
        //前缀和
        double[] sum = new double[A.length ];
        sum[0]=A[0];
        dp[1][0]=sum[0];
        for(int i = 1; i < A.length; ++i) {
            sum[i] = sum[i-1] + A[i];
            dp[1][i] = sum[i] / (i+1);
        }
        for (int k = 2; k <= K; k++) {
            for (int i = 1; i < A.length; i++) {
                for (int j = 0; j < i; j++) {
                    dp[k][i] = Math.max(dp[k][i], dp[k - 1][j] + (sum[i] - sum[j]) / (i - j));
                }
            }
        }
        return dp[K][A.length-1];
    }
}
