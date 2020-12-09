import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-11-30 23:07
 * @Description:
 */
public class Solution1338 {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int e : arr)
        {
            int count = map.getOrDefault(e, 0) + 1;
            map.put(e, count);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Comparator.comparingInt(Map.Entry::getValue));
        int index = map.size() - 1;
        int count = 0;
        int sum = 0;
        while (index > 0)
        {
            sum += list.get(index).getValue();
            count++;
            if (sum >= arr.length / 2)
            {
                return count;
            }
            index--;
        }
        return 1;


    }
}
