import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-11-25 23:36
 * @Description:
 */
public class Solution1403 {
    public static void main(String[] args) {
        List<Integer> ans=minSubsequence(new int[]{4,4,7,6,7});
        System.out.println(ans);
    }
    public static List<Integer> minSubsequence(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        Arrays.sort(nums);
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        //目标和应该大于target
        int target=sum/2;
         int cur=0;
         for(int i=nums.length-1;i>=0;i--){
             cur+=nums[i];
             ans.add(nums[i]);
             if (cur>target){
                 return ans;
             }
         }

        return ans;
    }
}
