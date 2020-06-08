
/**
 * @Author liuxun05
 * @create 2020/2/20 22:13
 **/
public class Solution474 {
    public static void main(String[] args) {
        System.out.println(findMaxForm(new String[]{"10", "0001", "111001", "1", "0"},5,3));
    }
    public static int findMaxForm(String[] strs, int m, int n) {
        //dp(i,j)表示i个0和j个1最多能拼出的字符个数
     int dp[][]=new  int[m+1][n+1];
        for (String s:strs){
            int cost[]=cost(s);
            //必须倒序因为状态转移方程使用之前的状态，每个字符串只能选择一次
            for (int i=m;i>=cost[0];i--){
                for (int j=n;j>=cost[1];j--){
                    //选当前字符串或者不选
                    dp[i][j]=Math.max(1+dp[i-cost[0]][j-cost[1]],dp[i][j]);
                }
            }
        }


     return dp[m][n];
    }
    public static int[] cost(String s){
        int res[]=new int[2];
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='0'){
                res[0]++;
            }
            else {
                res[1]++;
            }
        }
    return res;
    }
}
