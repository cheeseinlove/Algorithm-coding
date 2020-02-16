/**
 * @Author liuxun05
 * @create 2020/2/16 17:52
 **/
public class Solution375 {
    public static void main(String[] args) {
        System.out.println(getMoneyAmount2(10));


    }
    public static int calculate(int low, int high) {
        if (low >= high)
            return 0;
        int minres = Integer.MAX_VALUE;
        for (int i = low; i <= high; i++) {
            int res = i + Math.max(calculate(i + 1, high), calculate(low, i - 1));
            minres = Math.min(res, minres);
        }

        return minres;
    }
    //递归解决，计算你至少需要拥有多少现金才能确保你能赢得这个游戏。即选数是由我决定的(决定了是在每个区间的最小花费)，确定正确数字是由你决定的（每次判断猜中与否都是判断失败除非low=high）
    public static int getMoneyAmount1(int n) {
        return calculate(1, n);
    }
    //二维dp，从区间长度入手因为区间长的dp是有区间短的dp转移而来
    public static int getMoneyAmount2(int n) {
        int dp[][]=new int[n+1][n+1];
        for (int len=1;len<=n;len++){
            for (int begin=1;begin<=n-len+1;begin++){
                int end=begin+len-1;
                if (len==1){
                    dp[begin][end]=0;
                }
                else {
                    int min=Integer.MAX_VALUE;
                    for (int pivot=begin;pivot<end;pivot++){
                        int max=Math.max(dp[begin][pivot-1],dp[pivot+1][end])+pivot;
                        min=Math.min(min,max);
                    }
                    dp[begin][end]=min;
                }
            }
        }


        return dp[1][n];
    }
}
