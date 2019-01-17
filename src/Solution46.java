import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给定一个没有重复数字的序列，返回其所有可能的全排列。
示例:
输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */
public class Solution46 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0)
            return res;
        List<Integer> temp =new ArrayList<>() ;
        for(int i=0;i<nums.length;i++)
            temp.add(nums[i]);
        List<Integer> list = new ArrayList<>();
        recursive(res, temp, list);
        return res;
    }

    public static void recursive(List<List<Integer>> res, List<Integer> temp, List<Integer> list) {
        if (temp.size() == 0){
            res.add(list);
        return ;
        }
        for (int i = 0; i < temp.size(); i++) {
            int num = temp.get(i);
            temp.remove(i);
            list.add(num);
            recursive(res, temp, new ArrayList<>(list));
            temp.add(i, num);
            list.remove(list.size() - 1);
        }

    }

    public static void main(String... args) {
        int nums[]=new int[]{1,2,3};
        List<List<Integer>> res=permute(nums);
        for(List list:res){
            for(int i=0;i<list.size();i++)
                System.out.print(list.get(i)+" ");
            System.out.println();
        }
    }
}
