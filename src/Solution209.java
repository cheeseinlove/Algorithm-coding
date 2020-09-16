import java.util.Arrays;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-09-09 23:12
 * @Description:
 */
public class Solution209 {
    public static void main(String[] args) {
        int nums[]=new int[]{1,2,3,4,5};
        System.out.println(minSubArrayLen2(11,nums));
    }
    public static int minSubArrayLen(int s, int[] nums) {
        if (nums.length==0){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int r = 0;
        int l = 0;
        int value = nums[0];
        while (r<nums.length&&l<nums.length) {
            if (value < s) {
                r++;
                if (r<nums.length)
                value += nums[r];
            } else {
                min = Math.min(min, r - l + 1);
                value -= nums[l];
                l++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    public static int minSubArrayLen2(int s, int[] nums) {
        if (nums.length==0){
            return 0;
        }
        int ans=Integer.MAX_VALUE;
        int[] preSum = new int[nums.length+1];
        int sum=0;
        //aj-ai>=s,aj-s>=ai,j>i
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            preSum[i+1]=sum;
        }
        for(int i=0;i<nums.length;i++){
            int target=preSum[i]+s;
            //找到大于等于a[i]+s的最小j
            int index= Arrays.binarySearch(preSum,target);
            if (index<0){
                index=-index-1;
            }
            if (index>i&&index<=nums.length){
                ans=Math.min(ans,index-i);
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;


    }
}
