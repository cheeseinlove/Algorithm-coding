import java.lang.reflect.Array;
import java.util.*;

/*
 3sum leetcode15 med

 */
public class Sum3 {
    public static List<List<Integer>> threeSum(int[] nums) {
     List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i==0||nums[i]!=nums[i-1]){
            //i代表三个数中最小的数
            int left=i+1;
            int right=nums.length-1;
            while (left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if (sum==0){
                    res.add(new ArrayList<>(Arrays.asList(nums[i],nums[left],nums[right])));
                    int lastLeft=nums[left];
                    int lastRight=nums[right];
                    while (nums[++left]==lastLeft&&left<right);
                    while (nums[--right]==lastRight&&left<right);

                }
                else if(sum>0)
                    right--;
                else if(sum<0)
                    left++;
            }
        }
        }

        return res;
    }
    public static void main(String...args){
        int nums[]={-2,0,1,1,2};

        List<List<Integer>> res=threeSum(nums);

        for (int i=0;i<res.size();i++){
            List<Integer> list=res.get(i);
            for(int j=0;j<list.size();j++)
                System.out.print(list.get(j)+" ");
            System.out.println();
        }

    }
}
