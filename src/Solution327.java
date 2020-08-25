import java.util.TreeMap;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-08-12 23:24
 * @Description:
 */
public class Solution327 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if(nums ==  null || nums.length == 0){
            return 0;
        }
        //键值为区间和和这个区间和出现的次数
        TreeMap<Long, Integer> tree = new TreeMap<>();
        tree.put(0L, 1);

        int count = 0;
        long sum = 0L;
        for(int num : nums){
            sum += num;
            //subMap()返回一个值在sum - upper 和sum - lower 之间的子集合，values()方法获得这个映射的值得视图
            for(int cnt : tree.subMap(sum - upper, true, sum - lower, true).values()){
                count += cnt; //统计满足条件的区间和个数
            }
            tree.put(sum, tree.getOrDefault(sum, 0) + 1);
        }
        return count;
    }


}
