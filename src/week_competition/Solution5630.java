package week_competition;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-12-21 08:34
 * @Description:
 */
public class Solution5630 {
    public static void main(String[] args) {
        maximumUniqueSubarray(new int[]{5,2,1,2,5,2,1,2,5});
    }
    public static int maximumUniqueSubarray(int[] nums) {
      int left=0;
      int right=0;
      int ans=Integer.MIN_VALUE;
      int preSum[]=new int[nums.length+1];
      for(int i=1;i<=nums.length;i++){
          preSum[i]=preSum[i-1]+nums[i-1];
      }
      Map<Integer,Integer> win= new HashMap<>();
      while (right<nums.length){
          if (!win.containsKey(nums[right])){
              win.put(nums[right],right);
              ans=Math.max(ans,preSum[right+1]-preSum[left]);
          }else {
              if (win.get(nums[right])+1>left){
                  left=win.get(nums[right])+1;

              }
              win.put(nums[right],right);
              ans=Math.max(ans,preSum[right+1]-preSum[left]);

          }
          right++;

      }


      return ans;
    }
}
