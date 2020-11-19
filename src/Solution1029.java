import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-11-12 21:28
 * @Description:
 */
public class Solution1029 {
    //N个人前往A，N个人前往B。问题可以转化为2N个人全部去B，然后从2N中选N个去A，肯定是选cost[i]A-cost[i]B最小的人
    //类似于top k的问题，2n个人中选n个最小的
    public int twoCitySchedCost(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        int n = costs.length / 2;
        //大根堆
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int total = 0;
        for (int i = 0; i < costs.length; i++) {
            total += costs[i][1];
            pq.add(costs[i][0] - costs[i][1]);
            if (pq.size() > n) {
                pq.poll();
            }
        }
        while (!pq.isEmpty()) {
            total += pq.poll();
        }
        return total;

    }
}
