import java.util.Arrays;

/**
 * @Author liuxun05
 * @create 2020/2/16 20:08
 **/
//给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
public class Solution377 {
    public static void main(String[] args) {
        int nums[] = new int[]{0};
        System.out.println(combinationSum42(nums, 0));
    }

    public static int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        return recursion(nums, target, 0);
    }

    public static int recursion(int[] nums, int target, int sum) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] == target) {
                res += 1;
            } else if (sum + nums[i] < target) {
                res += recursion(nums, target, sum + nums[i]);
            } else {
                return res;
            }
        }
        return res;
    }

    public static int combinationSum42(int[] nums, int target) {
        //dp[i]为当target=i时的组合数
        int dp[] = new int[target + 1];
        Arrays.sort(nums);
        for (int i = 0; i <= target; i++) {
             for(int j=0;j<nums.length;j++){
                 if (i==nums[j]){
                     dp[i]+=1;
                 }
                 else if (i>nums[j]){
                     dp[i]+=dp[i-nums[j]];
                 }
                 else {
                     continue;
                 }
             }
        }
        return dp[target];
    }
}
