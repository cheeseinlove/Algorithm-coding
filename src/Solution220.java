import java.util.Comparator;
import java.util.TreeSet;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2021-01-12 23:36
 * @Description:
 */
public class Solution220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        TreeSet<Long> treeSet=new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            if (!treeSet.isEmpty()){
                //若存在范围内的数
                Long ceiling = treeSet.ceiling((long) nums[i] - (long) t);
                if (ceiling != null && ceiling <= ((long) nums[i] + (long) t)) {
                    return true;
                }
            }
            treeSet.add((long) nums[i]);
            if (treeSet.size() == k + 1) {
                treeSet.remove((long) nums[i - k]);
            }

        }
        return false;

    }
}
