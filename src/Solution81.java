/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-08-05 16:51
 * @Description:
 */
public class Solution81 {
    public static void main(String[] args) {
        int nums[]=new int[]{3,1};
        System.out.println(search(nums,1));
    }
    public static boolean search(int[] nums, int target) {
        if (nums.length==0){
            return false;
        }
        return search(nums,target,0,nums.length-1);
    }
    public static boolean search(int[] nums, int target,int left,int right){
        int mid=left+(right-left)/2;
        if (nums[mid]==target){
            return true;
        }
        if (left>=right){
            return false;
        }
        if (nums[mid]==nums[left]){
            left++;
            return search(nums,target,left,right);
        }
        if (nums[mid]>nums[left]){
            if (nums[mid]>target&&target>=nums[left]){
                return search(nums,target,left,mid-1);
            }else {
                return search(nums,target,mid+1,right);
            }

        }else {
            if (nums[mid]<target&&target<=nums[right]){
                return search(nums,target,mid+1,right);
            }else {
                return search(nums,target,left,mid-1);
            }
        }

    }
}
