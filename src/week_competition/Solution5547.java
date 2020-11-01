package week_competition;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author liuxun05
 * @create 2020/10/25 11:10
 * [-3,-6,-8,-4,-2,-8,-6,0,0,0,0]
[5,4,3,2,4,7,6,1,7]
[6,5,6,3,7,10,7,4,10]
 **/
public class Solution5547 {
    public static void main(String[] args) {
        int nums[]=new int[]{-3,-6,-8,-4,-2,-8,-6,0,0,0,0};
        int l[]=new int[]{5,4,3,2,4,7,6,1,7};
        int r[]=new int[]{6,5,6,3,7,10,7,4,10};
        List<Boolean> ans=checkArithmeticSubarrays(nums,l,r);
        for(boolean f:ans){
            System.out.println(f);
        }
    }
    public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int n=nums.length;
      int min[][]=new int[n][n];
      int max[][]=new int[n][n];
      int sum[]=new int[n+1];
      for(int i=0;i<n;i++){
          for(int j=i;j<n;j++){
              if (i==j){
                  min[i][j]=nums[i];
                  max[i][j]=nums[i];
              }else {
                  min[i][j]=Math.min(nums[j],min[i][j-1]);
                  max[i][j]=Math.max(nums[j],max[i][j-1]);
              }
          }
      }
      for(int i=1;i<=n;i++){
          sum[i]=sum[i-1]+nums[i-1];
      }
      List<Boolean> ans=new ArrayList<>();
        for(int i=0;i<l.length;i++){
            int left=l[i];
            int right=r[i];
            int tar=(min[left][right]+max[left][right])*(right-left+1);
            int real=2*(sum[right+1]-sum[left]);
            ans.add(tar==real);
        }
        return ans;
    }
}
