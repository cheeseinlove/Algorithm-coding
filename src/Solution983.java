/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-04-07 22:49
 * @Description:
 */
public class Solution983 {
    public static void main(String[] args) {
        int days[] = new int[]{1,4,6,9,10,11,12,13,14,15,16,17,18,20,21,22,23,27,28}  ;
        int costs[] = new int[]{3, 13, 45};
        System.out.println(mincostTickets(days, costs));
    }

    public static int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int dp[] = new int[days[n - 1] + 1];
        int j = 0;
        for (int i = 1; i < dp.length; i++) {
            //如果当天必须有票，最小值则有三种情况，当天买一天，当天不买用7天的票，当天不买用30天的票
            if (i == days[j]) {
                dp[i] = dp[i - 1] + costs[0];
                int buy7 = i - 7 + 1;
                int buy30 = i - 30 + 1;
                dp[i] = buy7 > 1 ? Math.min(dp[i], dp[buy7-1] + costs[1]) : Math.min(dp[i], dp[0]+costs[1]);
                dp[i] = buy30 > 1 ? Math.min(dp[i], dp[buy30-1] + costs[2]) : Math.min(dp[i], dp[0]+costs[2]);

                j++;
            } else {
                //当天不买票
                dp[i] = dp[i - 1];
            }

        }
        return dp[days[n - 1]];
    }
}
