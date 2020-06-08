/**
 * @Author liuxun05
 * @create 2020/5/17 16:55
 **/
public class Solution300 {
    public static void main(String[] args) {

    }

    /**
     * max数组的更新策略为，如果当前值更大直接插入到数组末尾，如果小则覆盖掉max中比当前值大但是最小的值，因为这样覆盖使得最长递增子序列长度不变
     * 但是增长的最缓慢，所以只要有新值更大就一定使的最长递增子序列长度加1
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        if (n<2){
            return n;
        }
        int max[]=new int[n];
        max[0]=nums[0];
        int len=1;
        for(int i=1;i<n;i++){
            if (nums[i]>max[len-1]){
                max[len++]=nums[i];
            }else {
                int index=binarySearch(max,len,nums[i]);
                max[index]=nums[i];
            }
        }
        return len;
    }
    public int binarySearch(int []nums,int len,int target){

        int left=0;int right=len-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if (nums[mid]<target){
                left=mid+1;
            }
            else if (nums[mid]>target){
                right=mid-1;
            }
            else return mid;

        }
        return left;
    }

}
