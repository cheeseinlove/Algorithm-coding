package week_competition;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-12-21 23:13
 * @Description:
 */
public class Solution1696 {
    public static void main(String[] args) {

    }
    public int maxResult(int[] nums, int k) {
        int dp[]=new int[nums.length];
        dp[0]=nums[0];
        //o[0]存dp[i]值，o[1]存下标i
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]-o1[0];
            }
        });
        pq.add(new int[]{dp[0],0});
        for(int i=1;i<nums.length;i++){
            int max=pq.peek()[0];
            int index=pq.peek()[1];
            //如果在当前可达范围之外就出堆，之后肯定也用不上了
            while (index<i-k){
                pq.poll();
                max=pq.peek()[0];
                index=pq.peek()[1];
            }
            dp[i]=max+nums[i];
            pq.add(new int[]{dp[i],i});
        }
         return dp[nums.length-1];
    }
}
