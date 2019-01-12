import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 4sum leetcode18
 */
public class Sum4 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){
            if(i==0||nums[i]!=nums[i-1]){
                //i代表四个数中最小的数
                int tar=target-nums[i];
                for (int j=i+1;j<nums.length-1;j++){
                    //nums[i]和nums[j}可以相等
                    if(j==i+1||nums[j]!=nums[j-1]){
                        int left=j+1;
                        int right=nums.length-1;
                        while (left<right){
                            int sum=nums[j]+nums[left]+nums[right];
                            if (sum==tar){
                                res.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[left],nums[right])));
                                int lastLeft=nums[left];
                                int lastRight=nums[right];
                                while (nums[++left]==lastLeft&&left<right);
                                while (nums[--right]==lastRight&&left<right);

                            }
                            else if(sum>tar)
                                right--;
                            else if(sum<tar)
                                left++;
                        }
                    }
                }



            }
        }

        return res;
    }
    public static void main(String...args){
        int nums[]={-1,0,1,2,-1,-4
        };

        List<List<Integer>> res=fourSum(nums,-1);

        for (int i=0;i<res.size();i++){
            List<Integer> list=res.get(i);
            for(int j=0;j<list.size();j++)
                System.out.print(list.get(j)+" ");
            System.out.println();
        }

    }
}
