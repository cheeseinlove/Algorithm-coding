/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-08-05 23:20
 * @Description:
 */
public class Solution33 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left<=right){
            int mid = (left + right)/2;
            int midNum = nums[mid];
            if(midNum==target){
                return mid;
            }
            if(nums[left]<=midNum){
                if(nums[left]<=target && midNum>target){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            if (midNum <= nums[right]){
                if (target > midNum && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }
}
