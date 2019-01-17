import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给定一个可包含重复数字的序列，返回所有不重复的全排列。
示例:
输入: [1,1,2]
输出:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
 */
public class Solution47 {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0)
            return res;
        //排序去重
        Arrays.sort(nums);
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
            if (i>0&&temp.get(i)==temp.get(i-1))
                continue;
            int num = temp.get(i);
            temp.remove(i);
            list.add(num);
            recursive(res, temp, new ArrayList<>(list));
            temp.add(i, num);
            list.remove(list.size() - 1);
        }

    }

    public static void main(String... args) {
        int nums[]=new int[]{1,1,3};
        List<List<Integer>> res=permuteUnique(nums);
        for(List list:res){
            for(int i=0;i<list.size();i++)
                System.out.print(list.get(i)+" ");
            System.out.println();
        }
    }
}
