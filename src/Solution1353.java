import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-11-25 23:14
 * @Description:
 */
public class Solution1353 {
    //贪心思想，优先参加能参加的结束时间最小的会议
    public int maxEvents(int[][] events) {
        Arrays.sort(events,(o1, o2)->o1[0]-o2[0]);
        int i=0;
        int day=1;
        int res=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>();//默认小顶堆；存储的是候选参加的会议；
        while(i<events.length || !pq.isEmpty()){
            //将day天开始能参加的所有会议入堆；
            while(i<events.length && events[i][0] == day){
                pq.offer(events[i++][1]);
            }
            //将已经结束的会议删除；（即：没机会参加到的；）；
            while(!pq.isEmpty() && pq.peek() < day){
                pq.poll();
            }
            //此时的堆顶元素就是我们今天（即day天）要参加的那一个会议；
            // 一天只能参加一场会议将结束时间最早的安排了;
            if(!pq.isEmpty()){
                res++;
                pq.poll();//决定参加这个会议后，记得弹出pq候选队列；
            }
            day++;
        }
        return res;

    }
}
