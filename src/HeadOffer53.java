/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-09-03 23:41
 * @Description:
 */
public class HeadOffer53 {
    public int missingNumber(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while (left<right){
            int mid=(right+left)>>1;
            if (nums[mid]==mid){
                left=mid+1;
            }else {
                right=mid;
            }
        }
        if(left==nums.length-1&&nums[left]==left){
            return left+1;
        }
        return left;
    }
//    public int search(int num[],int left,int right){
//        if (left>right){
//            return -1;
//        }
//        int mid=(right+left)>>1;
//        if (mid==num[mid]){
//            int leftV=search(num,left,mid-1);
//            return leftV==-1?search(num,mid+1,right):leftV;
//        }
//        //不可能有nums[mid]<mid情况
//            return search(num,left,mid);
//
//    }
}
