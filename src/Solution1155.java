/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-05-20 09:14
 * @Description:
 */
public class Solution1155 {
    public static void main(String[] args) {
        System.out.println(numRollsToTarget(30,30,500));
    }
    public static int numRollsToTarget(int d, int f, int target) {
       int mod=1_000_000_007;
       if (target>d*f||target<d){
           return 0;
       }

       int dp[][]=new int[31][1001];
       for(int k=1;k<=f;k++){
           if (k<=target)
           dp[1][k]=1;
       }
       for(int i=2;i<=d;i++){
           for(int j=1;j<=d*f;j++){
               for(int k=1;k<=f;k++){
                   if (j-k>=0)
                   dp[i][j]=(dp[i][j]+dp[i-1][j-k])%mod;
               }
           }
       }




       return dp[d][target];

    }

}
