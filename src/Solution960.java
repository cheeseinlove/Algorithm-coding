import java.util.Arrays;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-03-27 21:18
 * @Description:
 */
public class Solution960 {
    public int minDeletionSize(String[] A) {
        //edcba
     int n=A[0].length();
     int dp[]=new int[n+1];
     int max=0;
     //dpi代表数组中所有字符串以i结尾的最长不下降子序列的长度
        Arrays.fill(dp,1);

        for(int i=2;i<=n;i++){
            for (int j=1;j<i;j++){
                boolean allSame=true;
                //i,j一定时所有字符串需保持一致
                for(int k=0;k<A.length;k++){
                    if (A[k].charAt(i-1)<A[k].charAt(j-1)){
                        allSame=false;
                        break;
                    }
                }
                if (allSame){
                    //更新为以j结尾的最长不下降子序列+1
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
                max=Math.max(max,dp[i]);
            }
        }
        return n-max;
    }
}
