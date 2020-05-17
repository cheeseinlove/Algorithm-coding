/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-04-19 23:09
 * @Description:
 */
public class Solution1039 {
    public static void main(String[] args) {
        int a[] = new int[]{1, 3, 1, 4, 1, 5};
        System.out.println(minScoreTriangulation(a));
    }

    public static int minScoreTriangulation(int[] A) {
     int N= A.length;
     if (N==3){
         return A[0]*A[1]*A[2];
     }
     //DP i，j代表从i到j的四边形最小面积，i<=j
     int dp[][]=new int[N][N];
     for(int length=3;length<=N;length++ ){
         for(int start=0;start<=N-length;start++){
             int end=start+length-1;
             for(int k=start+1;k<end;k++){
                 dp[start][end]=dp[start][end]==0?dp[start][k]+dp[k][end]+A[start]*A[k]*A[end]:Math.min(dp[start][end],dp[start][k]+dp[k][end]+A[start]*A[k]*A[end]);
             }
         }
     }


         return dp[0][N-1];

    }
}
