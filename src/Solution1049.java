/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-04-20 23:02
 * @Description:
 */
public class Solution1049 {
    public static void main(String[] args) {
        int a[] = new int[]{2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeightII(a));
    }

    /**
     * 这道题的核心在于问题转化为01背包，碰撞后的值最小可以转为问题怎么样选石子使重量最接近totalSum/2
     *
     * @param stones
     * @return
     */
    public static int lastStoneWeightII(int[] stones) {
        int n = stones.length;

        int sum = 0;
        for (int value : stones) {
            sum += value;
        }
        //重量为i的背包最多的重量
        int dp[] = new int[sum / 2 + 1];
        for (int i = 0; i < n; i++) {
            for (int j = sum / 2; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }

          //石子被分为两堆，一堆是被选的B，一堆是没被选的A,A+B=SUM，ans=A-B=SUM-2*B
        return sum - 2 * dp[sum / 2];
    }

}
