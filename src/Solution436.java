import java.util.TreeMap;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-08-11 23:04
 * @Description:
 */
public class Solution436 {
    public int[] findRightInterval(int[][] intervals) {
        int len = intervals.length;
        int[] ans = new int[len];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < len; i++) {
            int key = intervals[i][0];
            int value = i;
            if (map.containsKey(key)) {
                value = map.get(key) > value ? value : map.get(key);
            }
            map.put(key, value);
        }
        for(int i = 0; i < len; i++ ){
            Integer ceilingKey=map.ceilingKey(intervals[i][1]);
            if (ceilingKey==null){
                ans[i]=-1;
            }else {
                ans[i]=map.get(ceilingKey);
            }
        }


        return ans;
    }
}
