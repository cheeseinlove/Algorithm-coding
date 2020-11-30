import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-11-24 23:45
 * @Description:
 */
public class Solution846 {
    public boolean isNStraightHand(int[] hand, int W) {
        int len = hand.length;
        if (len % W != 0) {
            return false;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        while (map.size() > 0) {
            int i = 0;
            int start = map.firstKey();
            while (i < W) {
                if (!map.containsKey(start + i)) {
                    return false;
                }
                map.put(start + i, map.get(start + i) - 1);
                if (map.get(start + i) == 0) {
                    map.remove(start + i);
                }
                i++;
            }
        }
        return true;
    }
}
