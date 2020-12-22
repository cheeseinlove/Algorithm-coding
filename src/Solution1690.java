/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-12-14 23:30
 * @Description:
 */
public class Solution1690 {
    public static void main(String[] args) {
        int s[]=new int[]{5,3,1,4,2};
        stoneGameVII(s);
    }

    public static int stoneGameVII(int[] stones) {
      int n=stones.length;
      //dpi,j代表i,j范围内先手能获得的最大分数，k=0,1，0代表爱丽丝的回合，1代表败者回合
      int dp[][][]=new int[n][n][2];
      int sum[]=new int[n+1];
      //i,j分数为sum[j+1]-sum[i]
      for(int i=1;i<=n;i++){
          sum[i]=sum[i-1]+stones[i-1];
      }
      for(int len=2;len<=n;len++){
          for(int i=0;i+len-1<n;i++){
              int j=i+len-1;
              //先手最大值为取了一个数后后手最大值
              int left=sum[j+1]-sum[i]-stones[i];
              int right=sum[j+1]-sum[i]-stones[j];
              dp[i][j][0]=Math.max(dp[i+1][j][1]+left,dp[i][j-1][1]+right);
              dp[i][j][1]=Math.min(dp[i+1][j][0]-left,dp[i][j-1][0]-right);
          }
      }
      return dp[0][n-1][0];
    }
}
