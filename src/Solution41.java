import java.util.HashMap;
import java.util.Map;

/*
给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
示例 1:
输入: [1,2,0]
输出: 3

示例 2:
输入: [3,4,-1,1]
输出: 2

示例 3:
输入: [7,8,9,11,12]
输出: 1
说明:
你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 */
public class Solution41 {
    public static int firstMissingPositive(int[] nums) {
            if(nums.length==0)
                return 1;
        Map<Integer,Integer> map=new HashMap();
        int max=0;
        //找到最大数并筛选nums
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max)
                max=nums[i];
            map.put(nums[i],1);
        }
        //由于找最小正整数所以从1开始遍历，遍历到max为止
        for(int i=1;i<max;i++){
//            if (map.getOrDefault(i,-1)==-1)
            if (!map.containsKey(i))
                return i;
        }
        return max+1;
    }

    public static void main(String... args) {
        int nums[]=new int[]{7,8,9,11,12};
        System.out.println(firstMissingPositive(nums));
    }
}
