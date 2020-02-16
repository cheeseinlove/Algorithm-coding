/**
 * @Author liuxun05
 * @create 2020/2/16 22:22
 **/
//给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。
//输入:
//nums = [7,2,5,10,8]
//        m = 2
//
//        输出:
//        18
//
//        解释:
//        一共有四种方法将nums分割为2个子数组。
//        其中最好的方式是将其分为[7,2,5] 和 [10,8]，
//        因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。

public class Solution410 {
    public static void main(String[] args) {
        int nums[] = new int[]{7, 2, 5, 10, 8};
        System.out.println(splitArray(nums, 3));
    }

    public static int splitArray(int[] nums, int m) {
        //dp[i][j]表示nums[0]到nums[i-1]分成j份，所有分法中子数组和的最大值的最小值
        //于是有dp[i][j]=math.min(math.max(dp[k][j-1]+sum(k+1,i)),dp[i][j]）,sum(k+1,i)可以用前缀和之差表示
        int dp[][] = new int[nums.length + 1][m + 1];
        int preSum[] = new int[nums.length + 1];
        for (int i = 0; i <= nums.length; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        //preSum[len]表示数组总和
        for (int i = 1; i <= nums.length; i++) {
            preSum[i] =preSum[i-1]+ nums[i - 1];
        }
        dp[0][0]=0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                for(int k=0;k<i;k++){
                    //为什么？
                    int max=Math.max(dp[k][j-1],preSum[i]-preSum[k]);
                    dp[i][j]= Math.min(dp[i][j],max);
                }
            }
        }

        return dp[nums.length][m];
    }
}
