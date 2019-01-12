/*
最大连续子数组和
 */
public class MaxSubArraySum {
    public static int maxSubArray(int[] nums) {
        //dp[i]表示以nums[i]结尾的子数组最大值
        int dp[]=new int[nums.length];
        int max;
        dp[0]=nums[0];
        max=nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            if(dp[i]>max)
                max=dp[i];
        }
        return max;
    }
}
