import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-09-07 23:33
 * @Description:
 */
public class HeadOffer59A {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[] ans = new int[nums.length - k + 1];
        //双端队列，存储索引是为了计算当前队列头最大元素还在不在滑动窗口之内，如果只存储值的话极端情况322222
        Deque<Integer> deque = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            //我这次要添加的最大元素在滑动窗口之外了需要删除
            while (!deque.isEmpty() && deque.peek() <i- k+1) {
                deque.removeFirst();
            }
            //如果当前元素比之前从队尾遍历元素都大则删除所有，因为之前比他小的元素在之后滑动窗口移动不可能是局部最大了
            while (!deque.isEmpty() && nums[i]>=nums[deque.peekLast()]){
                deque.removeLast();
            }
            deque.addLast(i);
            if (i >= k - 1) {
                ans[index++] = nums[deque.peek()];
            }
        }

        return ans;
    }
}
