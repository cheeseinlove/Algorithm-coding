import tools.ListNode;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-07-20 09:24
 * @Description:
 */
public class Solution142 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(7);
        ListNode node2 = new ListNode(13);
        node1.next = node2;
        ListNode node3 = new ListNode(11);
        node2.next = node3;
        ListNode node4 = new ListNode(10);
        node3.next = node4;



        node4.next = node1;

        detectCycle(node1);
    }

        //求入环节点即可以转化为求环大小，因为双指针起始位置距离为环大小时，相遇位置即入环位置
    //求环大小只需要找到双指针第一次相遇节点，然后再转圈回到原点
    public static ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode meet = null;
        while (slow != null&&meet==null) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                meet = slow;
            }
        }
        ListNode cycle = meet.next;
        int size = 1;
        while (cycle != meet) {
            cycle = cycle.next;
            size++;
        }
        fast = head;
        slow = head;
        //fast先走size步
        while (size > 0) {
            fast = fast.next;
            size--;
        }
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
            if (fast == slow) {
                return fast;
            }
        }
        return fast;
    }
}
