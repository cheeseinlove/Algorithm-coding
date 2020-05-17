import java.util.TreeMap;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-04-16 23:27
 * @Description:
 */
public class Solution1027 {
    public static void main(String[] args) {
        int a[] = new int[]{22,8,57,41,36,46,42,28,42,14,9,43,27,51,0,0,38,50,31,60,29,31,20,23,37,53,27,1,47,42,28,31,10,35,39,12,15,6,35,31,45,21,30,19,5,5,4,18,38,51,10,7,20,38,28,53,15,55,60,56,43,48,34,53,54,55,14,9,56,52};
        int b[]=new int[]{27,31,31,23,27,31,35};
        System.out.println(longestArithSeqLength(a));
    }

    public static int longestArithSeqLength(int[] A) {

        int max = 0;
        int n = A.length;
        if(n<3){
            return 0;
        }
        int dp[][] = new int[n][20001];
        dp[1][A[1]-A[0]+10000]=2;
        for (int i = 2; i < n; i++) {
            for (int j = i-1; j>=0; j--) {
                int term=A[i] - A[j]+10000;
                if (dp[j][term]>0){
                    dp[i][term]=Math.max(dp[i][term],dp[j][term]+1);
                    //若dp[i][m]未更新过
                }else if(dp[i][term]==0){
                    dp[i][term]=2;
                }

                max = Math.max(max, dp[i][term]);
            }
        }




        return max;
    }
}
