import tools.ListNode;

import java.util.Stack;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-08-03 22:58
 * @Description:
 */
public class Solution1290 {
    public int getDecimalValue(ListNode head) {
        ListNode cur = head;
        int ans = 0;
        while (cur != null) {
            ans = ans * 2 + cur.val;
            cur = cur.next;
        }

        return ans;
    }
}
