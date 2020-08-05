import tools.ListNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-07-29 09:15
 * @Description:
 */
public class Solution1019 {
    public int[] nextLargerNodes(ListNode head) {
        Stack stack = new Stack();
        ArrayList<Integer> data = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();

        int index = 0;
        while(head != null) {
            res.add(0);
            data.add(head.val);

            while (!stack.empty() && head.val > data.get((Integer)stack.peek())) {
                res.set((Integer)stack.pop(), head.val);
            }

            stack.push(index);
            index++;
            head = head.next;
        }

        int[] ans = new int[res.size()];

        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }

        return ans;


    }
}
