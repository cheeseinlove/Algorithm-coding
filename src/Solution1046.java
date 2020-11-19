import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-11-12 22:33
 * @Description:
 */
public class Solution1046 {
    public static void main(String[] args) {
        int a[]=new int []{2,2};
        System.out.println(lastStoneWeight(a));
    }
    public static int lastStoneWeight(int[] stones) {
        if (stones.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i : stones) {
            pq.add(i);
        }
        while (pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();
            if (x!=y){
                pq.add(Math.abs(x-y));
            }

        }
        return pq.isEmpty()?0:pq.peek();

    }
}
