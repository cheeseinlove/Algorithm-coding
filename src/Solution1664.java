/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-12-10 21:16
 * @Description:
 */
public class Solution1664 {

    public int waysToMakeFair(int[] nums) {
         int n=nums.length;
         if (n<2){
             return n;
         }
         //奇数和
         int sum1[]=new int[n];
         //偶数和
         int sum2[]=new int[n];
         sum2[0]=nums[0];
         for(int i=1;i<n;i++){
             if (i%2==0){
                 sum2[i]=sum2[i-1]+nums[i];
                 sum1[i]=sum1[i-1];
             }else {
                 sum1[i]=sum1[i-1]+nums[i];
                 sum2[i]=sum2[i-1];
             }
         }
         int ans=(sum2[n-1]-nums[0])==sum1[n-1]?1:0;
         //对于第i个数，前面的数偶数和为sum2[i-1]，奇数和为sum1[i-1]
        //后面的偶数和为sum1[n-1]-sum1[i]，后面的奇数和为sum2[n-1]-sum2[i]
         for(int i=1;i<n;i++){
             int cur1=sum1[i-1]+sum2[n-1]-sum2[i];
             int cur2=sum2[i-1]+sum1[n-1]-sum1[i];
             if (cur1==cur2){
                 ans++;
             }
         }
         return ans;

    }
}
