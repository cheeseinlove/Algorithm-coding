/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-08-06 23:12
 * @Description:
 */
public class Solution154 {
    public int findMin(int[] nums) {
        int min=Integer.MAX_VALUE;
        int left=0;
        int right=nums.length-1;

        while (left<=right){
            int mid=left+(right-left)/2;
            min=Math.min(min,nums[mid]);

            if (nums[mid]==nums[left]){
                left++;
                continue;
            }
            if (nums[mid]<=nums[right]){
                right=mid-1;
            }else {
                left=mid+1;
            }

        }

        return min;

    }
}
