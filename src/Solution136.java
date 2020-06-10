/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-06-09 23:56
 * @Description:
 */
public class Solution136 {
    public static void main(String[] args) {

    }
    public static  int singleNumber(int[] nums) {
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                ans = ans ^ nums[i];
            }
        }
        return ans;


    }
}
