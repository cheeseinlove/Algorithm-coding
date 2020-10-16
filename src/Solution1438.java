import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-09-18 00:05
 * @Description:
 */
public class Solution1438 {
    public static void main(String[] args) {
        Deque<Integer> maxQ = new LinkedList<>();
        int nums[]=new int[]{1,2,3};
        for(int end=0;end<nums.length;end++) {
            while (!maxQ.isEmpty() && maxQ.peekLast() < nums[end]) {
                maxQ.pollLast();
            }
            maxQ.add(nums[end]);
        }
        System.out.println(maxQ);
    }
    //用单调队列维护当前窗口的最大值和最小值，保持最大值与最小值的差小于 limit 即可。
    public int longestSubarray(int[] nums, int limit) {
        //这里维护的是最大值们对应的下标
        Deque<Integer> maxQ = new LinkedList<>();
        Deque<Integer> minQ = new LinkedList<>();
        int ans = 0;
        //窗口左沿
        int start = 0;
        //窗口右沿
        for (int end = 0; end < nums.length; end++) {
            //右沿元素进入窗口、维护最大值单调队列，，
            // 队头为最大值，那么后面加入的值 num 如果比 前面加入的值 还大，那么 最大值 就跟 前面的加入值 无关
            //                因为前面的值最先入队，也是最先出队的，它无论出不出队，最大值都是 后面入队的这个值 num
            //                同理，最小队也一样
            while (!maxQ.isEmpty() && nums[maxQ.peekLast()] < nums[end]) {
                maxQ.pollLast();
            }
            maxQ.add(end);
            //右沿元素进入窗口、维护最小值单调队列
            while (!minQ.isEmpty() && nums[minQ.peekLast()] > nums[end]) {
                minQ.pollLast();
            }
            minQ.add(end);

            //如果当前窗口的最大值最小值的差大于 limit，则不断缩小窗口（左沿++），直至最大值变小或者最小值变大从而满足 limit 限制
            while (!maxQ.isEmpty() && !minQ.isEmpty() && nums[maxQ.peek()] - nums[minQ.peek()] > limit) {
                if (maxQ.peek() <= start) maxQ.poll();
                if (minQ.peek() <= start) minQ.poll();
                start++;
            }
            ans = Math.max(ans, end - start + 1);
        }
        return ans;
    }
}
