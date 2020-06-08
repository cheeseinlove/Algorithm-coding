/**
 * @Author liuxun05
 * @create 2020/2/29 23:35
 **/
public class Solution664 {
    public int strangePrinter(String s) {
        int len = s.length();
        if(len==0){
            return  0;
        }
        //i,j代表i，j区间内的打印最小次数
        int dp[][] = new int[len][len];
        for (int i = 0; i < len; i++) {
            //单个字母初始化1
            dp[i][i] = 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                //第一种情况分开打印
                dp[i][j] = 1 + dp[i + 1][j];
                for (int k = i + 1; k < j; k++) {
                    if (s.charAt(i) == s.charAt(k)) {
                        //中间有字母和i相同i放到i+1,k的序列打印
                        dp[i][j] = Math.min(dp[i][j], dp[i + 1][k] + dp[k + 1][j]);
                    }
                }
                if (s.charAt(i) == s.charAt(j)) {
                    //首尾相同，第二种情况的特殊版
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j]);
                }

            }
        }
        return dp[0][len - 1];

    }
}
