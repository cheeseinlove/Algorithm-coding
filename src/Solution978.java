/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-04-01 23:04
 * @Description:
 */
public class Solution978 {
    public static void main(String[] args) {
        int A[] = new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9};
        System.out.println(maxTurbulenceSize(A));
    }

    public static int maxTurbulenceSize(int[] A) {
        int n = A.length;
        if (n < 2) {
            return n;
        }

        int dp[][] = new int[n][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        int max = 1;
        for (int i = 1; i <= n - 1; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
               if(A[i]>A[i-1]){
                   dp[i][0]+=dp[i-1][1];
               }
               else if (A[i]<A[i-1]){
                   dp[i][1]+=dp[i-1][0];
               }
               max=Math.max(max,Math.max(dp[i][0],dp[i][1]));
        }

        return max;
    }
}
