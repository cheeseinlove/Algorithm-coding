/**
 * @Author liuxun05
 * @create 2020/2/17 12:52
 **/
//给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
public class Solution416 {
    public static void main(String[] args) {
        int nums[] = new int[]{2, 2, 3, 5};
        int nums2[] = new int[]{1, 2, 3, 5};
        System.out.println(canPartition(nums));
        System.out.println(canPartition2(nums));
    }

    public static boolean canPartition(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //总和奇数返回
        if ((sum & 1) == 1) {
            return false;
        }
        //dpi,j代表0，i的数组能否形成和为j
        boolean dp[][] = new boolean[nums.length][sum / 2 + 1];
        for(int i=0;i<=sum / 2;i++){
            dp[0][i]=nums[0]==i;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= sum / 2; j++) {
                if (nums[i] == j) {
                    dp[i][j] = true;
                continue;
                }
                if (nums[i]<j){
                    //dp[i - 1][j]代表不选当前物品，dp[i-1][j - nums[i]]代表选当前物品
                dp[i][j] = dp[i - 1][j] || dp[i-1][j - nums[i]];
            }}
        }

        return dp[nums.length - 1][sum / 2];
    }
    public static boolean canPartition2(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum / 2;

        boolean[][] dp = new boolean[len][target + 1];
        // 初始化成为 true 虽然不符合状态定义，但是从状态转移来说是完全可以的
        dp[0][0] = true;

        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {

                dp[i][j] = dp[i - 1][j];

                if (nums[i] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }

            // 由于状态转移方程的特殊性，提前结束，可以认为是剪枝操作
            if (dp[i][target]) {
                return true;
            }
        }
        return dp[len - 1][target];

    }


}
