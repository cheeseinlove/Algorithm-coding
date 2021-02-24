package week_competition;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-12-28 08:48
 * @Description:
 */
public class Solution5638 {
    //贪心算法，尽量每次吃快要腐烂的苹果
    public int eatenApples(int[] apples, int[] days) {
        int ans = 0;
        //死亡时间小的优先级更高
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0] + o1[1]) - (o2[0] + o2[1]);
            }
        });
        int i=0;
        for ( ;i < apples.length; i++) {
            //先放苹果
            if (days[i]>0&&apples[i]>0){
                pq.add(new int[]{days[i],i});
            }
            //再吃苹果
            //如果死亡时间最近的已经死亡或者已经没有苹果可以吃那么出队
            while (!pq.isEmpty()&&(i>=pq.peek()[0]+pq.peek()[1]||apples[pq.peek()[1]]<=0)){
                pq.poll();
            }
            //吃苹果
            if (!pq.isEmpty()){
                apples[pq.peek()[1]]--;
                ans++;
            }
        }
        //处理剩下的苹果
        while (!pq.isEmpty()){
            while (!pq.isEmpty()&&(i>=pq.peek()[0]+pq.peek()[1]||apples[pq.peek()[1]]<=0)){
                pq.poll();
            }
            //吃苹果
            if (!pq.isEmpty()){
                apples[pq.peek()[1]]--;
                ans++;
            }
            i++;
        }
        return ans;

    }
}
