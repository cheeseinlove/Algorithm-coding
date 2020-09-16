package sort;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-09-04 09:28
 * @Description:
 */
public class HeadOffer53y {
    public int search(int[] nums, int target) {
      return getHits(nums,target,0,nums.length-1);
    }
    public int getHits(int []nums,int target,int left,int right){
        if (left>right){
            return 0;
        }
        int mid=(right+left)>>1;
        if (nums[mid]==target){
            return 1+getHits(nums,target,left,mid-1)+getHits(nums,target,mid+1,right);
        }else if (nums[mid]>target){
            return getHits(nums,target,left,mid-1);
        }else return getHits(nums,target,mid+1,right);
    }
}
