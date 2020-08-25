/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-08-20 23:28
 * @Description:
 */
public class Solution704 {
    public int search(int[] nums, int target) {
     int left=0;
     int right=nums.length-1;
     while (left<=right){
         int mid=left+((right-left)>>1);
         if (nums[mid]==target){
             return mid;
         }else if (nums[mid]>target){
             right=mid-1;
         }else {
             left=mid+1;
         }
     }
     return -1;

    }
}
