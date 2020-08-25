/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-08-06 09:16
 * @Description:
 */
public class Solution153 {
    private static int min=Integer.MAX_VALUE;

    public static void main(String[] args) {
        int []nums=new int[]{4,5,6,7,0,1,2};
        System.out.println(findMin(nums));
    }
    public static int findMin(int[] nums) {
            rangeSearch(nums,0,nums.length-1);
            return min;
    }
    public static void rangeSearch(int[] nums,int left,int right) {
        if (left>right){
            return ;
        }
        int mid=left+(right-left)/2;
        min=Math.min(min,nums[mid]);
        if (nums[mid]<=nums[right]){
            rangeSearch(nums,left,mid-1);
        }else {
            rangeSearch(nums,mid+1,right);
        }
    }
}
