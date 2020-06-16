/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-06-11 09:12
 * @Description:
 */
public class Solution162 {
    public static void main(String[] args) {

    }
    public int findPeakElement(int[] nums) {
    int left=0;
    int right=nums.length-1;
    while (left<right){
        int mid=(right-left)/2+left;
         if (nums[mid]>nums[mid+1]){
             right=mid;
         }
         else {
             left=mid+1;
         }
    }
        return left;
    }
}
