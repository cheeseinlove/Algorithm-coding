/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-03-09 22:40
 * @Description:
 */
public class Solution746 {
    public static void main(String[] args) {
        int cost[] = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int cost2[]=new int[]{10, 15, 20};
        System.out.println(minCostClimbingStairs(cost2));
    }

    public static int minCostClimbingStairs(int[] cost) {
        if (cost.length <= 2) {
            return cost[cost.length - 1];
        }
        //dp[i]代表当前位置最小花费
        int dp[]=new int[cost.length ];

        dp[0]=cost[0];
        dp[1]=cost[1];
        for(int i=2;i<cost.length;i++){
            dp[i]=Math.min(dp[i-1],dp[i-2])+cost[i];
        }


        int minLast=Math.min(dp[cost.length-1],dp[cost.length-1]);
        int minLastTwo=Math.min(dp[cost.length-2],dp[cost.length-2]);
        return Math.min(minLast,minLastTwo);

    }

}
