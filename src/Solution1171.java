import tools.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-07-30 09:30
 * @Description:
 */
public class Solution1171 {
    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int sum = 0;
        Map<Integer, ListNode> map = new HashMap<>();
        for (ListNode p = dummy; p != null; p = p.next) {
            sum += p.val;
            map.put(sum, p);
        }
        sum = 0;
        for (ListNode p = dummy; p != null; p = p.next) {
            sum += p.val;
            p.next = map.get(sum).next;
        }
        return dummy.next;
    }
}
