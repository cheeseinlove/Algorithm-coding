/**
 * @Author: liuxun05@meituan.com
 * @Date: 2021-01-06 23:55
 * @Description:
 */
public class Solution268 {
    public int missingNumber(int[] nums) {
        int n=nums.length;
     int sum=0;
     for(int i:nums){
         sum+=i;
     }
     return n*(n+1)/2-sum;
    }
}
