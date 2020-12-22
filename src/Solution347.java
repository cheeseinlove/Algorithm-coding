import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-12-16 23:47
 * @Description:
 */
public class Solution347 {
    //top k问题，最大的k个数就构建size=k的小顶堆，最后留在堆里的就是最大的k个,复杂度on
    public int[] topKFrequent(int[] nums, int k) {
        int ans[] = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(entry.getKey());
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int index = 0;
        while (!pq.isEmpty()) {
            ans[index++] = pq.poll();
        }
        return ans;
    }
}
