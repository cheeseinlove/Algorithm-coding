package week_competition;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-11-02 13:21
 * @Description:
 */
public class Solution5556 {
    public static void main(String[] args) {
        int []h=new int[]{4,2,7,6,9,14,12};
        int bricks=5;
        int ladders=1;
        System.out.println(furthestBuilding2(h,bricks,ladders));
    }
    /**
     *贪心的思想维护小根堆，梯子尽量用在diff最大的时候收益最大
     * 优先使用梯子，直到梯子数目=用梯子跨越的数目，当有新的一层进来，当前差值中最小的用砖头
     * 当消耗的砖头总数>bricks时返回
     **/
    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        //消耗砖头的总数
        int sum = 0;
        Queue<Integer> queue = new PriorityQueue<>();
        for(int i = 1; i < heights.length; i++) {
            int diff = heights[i] - heights[i - 1];
            if(diff > 0) {
                queue.offer(diff);
                //梯子不够了，要使用砖头了
                if(queue.size() > ladders) {
                    sum += queue.poll();
                }
                //砖头不够了，走到尽头了，因为是优先用梯子所以此时梯子肯定也用完了
                if(sum > bricks)
                    return i - 1;
            }
        }
        return n - 1;
    }

    public static int furthestBuilding2(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        //消耗砖头的总数
        int sum = 0;
        int la=ladders;
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int i = 1; i < heights.length; i++) {
            int diff = heights[i] - heights[i - 1];
            if(diff > 0) {
                queue.offer(diff);
                sum+=diff;
                //当砖头不够用了
                if(sum>bricks) {
                    //如果还有梯子，差值最大的使用梯子
                    if (la>0){
                        sum -= queue.poll();
                        la--;
                        //梯子不够了，走到尽头了，因为是优先用砖头，所以剩余砖头数目也不足以跨层了
                    }else {
                        return i-1;
                    }

                }

            }
        }
        return n - 1;
    }

}
