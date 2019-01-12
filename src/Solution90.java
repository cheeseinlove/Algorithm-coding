import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution90 {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res =new LinkedList<>();
        Arrays.sort(nums);
        recur(res,new LinkedList<Integer>(),0,nums);
        return res;
    }
    private  static void recur(List<List<Integer>> res,LinkedList<Integer> temp,int index,int []nums){
        res.add(temp);
        for(int i=index;i<nums.length;i++){
            LinkedList next=new LinkedList<>(temp);
            if(i>index&&nums[i]==nums[i-1]) continue;
            temp.add(nums[i]);
            recur(res,next,i+1,nums);
//            temp.pollLast();
        }




    }
    public static void main(String...args){
        int a[]=new int[]{1,2,2};
        System.out.print(subsetsWithDup(a).toString());
    }
}
