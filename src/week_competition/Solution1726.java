package week_competition;

import java.util.Arrays;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2021-01-18 23:10
 * @Description:
 */
public class Solution1726 {
    public static void main(String[] args) {
        tupleSameProduct(new int[]{1,2,4,5,10});
    }
    public static int tupleSameProduct(int[] nums) {
        int ans = 0;
        if (nums.length < 4) {
            return 0;
        }
        Arrays.sort(nums);

        for(int left=0;left<nums.length;left++){
            for(int right = nums.length - 1;right>=0;right--){
                int l = left + 1;
                int r = right - 1;
                int cur = nums[left] * nums[right];
                while (l < r) {
                    if (nums[l] * nums[r] < cur) {
                        l++;
                    } else if (nums[l] * nums[r] > cur) {
                        r--;
                    } else {
                        ans+=8;
                        l++;
                        r--;
                    }
                }
            }
        }

        return ans;
    }
}
