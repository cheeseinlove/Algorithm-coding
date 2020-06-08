/**
 * @Author liuxun05
 * @create 2020/2/27 23:32
 **/
public class Solution650 {
    public static void main(String[] args) {

    }

    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 0;
        //当前的数目为i
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            //i的前一个开始复制的状态为j，则必有i%j==0,且从j到i,粘贴i/j-1次，复制1次，一共i/j次
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    min = Math.min(min, dp[j] + i / j);
                }
            }
            dp[i] = min;
        }
        return dp[n];


    }
}
