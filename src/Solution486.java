/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-03-24 17:26
 * @Description:
 */
public class Solution486 {
    public static void main(String[] args) {
        System.out.println(PredictTheWinner(new int[]{1}));
    }
    public static boolean PredictTheWinner(int[] nums) {
        int n=nums.length;
        //dpi,j,k代表范围为i-j，0为先手,1为后手获得最大值
        int dp[][][]=new int[n][n][2];
        for(int i=0;i<n;i++){
            dp[i][i][0]=nums[i];
            dp[i][i][1]=0;
        }
        for(int l=2;l<=n;l++){
            for(int i=0;i<n-l+1;i++){
                int j=i+l-1;
                int left=nums[i]+dp[i+1][j][1];
                int right=nums[j]+dp[i][j-1][1];
                if(left>right){
                    dp[i][j][0]=left;
                    dp[i][j][1]=dp[i+1][j][0];
                }
                else{
                    dp[i][j][0]=right;
                    dp[i][j][1]=dp[i][j-1][0];
                }
            }
        }

        return (dp[0][n-1][0]-dp[0][n-1][1])>=0;
    }
}
