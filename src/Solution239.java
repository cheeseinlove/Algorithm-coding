import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-09-18 11:28
 * @Description:
 */
public class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
       int ans[]=new int[nums.length-k+1];

       int index=0;
       Deque<Integer> deque=new LinkedList<>();
       for(int i=0;i<nums.length;i++){
           while (!deque.isEmpty() && deque.peek() < i - k + 1) {
               deque.removeFirst();
           }
               while (!deque.isEmpty()&&nums[deque.peekLast()]<nums[i]){
               deque.pollLast();
           }
           deque.add(i);


           if (i>=k-1){
               ans[index++]=nums[deque.peekFirst()];
           }
       }



       return ans;

    }
}
