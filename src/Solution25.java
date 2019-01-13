import tools.ListNode;

/*
给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
示例 :
给定这个链表：1->2->3->4->5
当 k = 2 时，应当返回: 2->1->4->3->5
当 k = 3 时，应当返回: 3->2->1->4->5
 */
public class Solution25 {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode pre = null;
        ListNode newPre = null;
        ListNode end = head;
        ListNode cur = head;
        ListNode start = null;
        ListNode outIndex = head;
        //第一次循环找到返回的head
        for (int i = 0; i < k - 1; i++) {
            head = head.next;
            //超出长度无法找到head返回原链
            if (head == null)
                return outIndex;
        }
        while (true) {
            for (int j = 0; j < k; j++) {
                if (j == 0)
                    newPre = end;
                if (end == null)
                    return head;
                end = end.next;
            }
            start = pre;
            ListNode t1 = null;
            ListNode t2 = null;
            for (int i = 0; i < k; i++) {
                t1 = cur.next;
                t2 = cur;
                if (i == 0) {
                    cur.next = end;
                } else if (i == k - 1) {
                    if (start != null)
                        start.next = cur;
                    cur.next = pre;
                } else {
                    cur.next = pre;
                }
                cur = t1;
                pre = t2;
            }
            //由于每组反转过后pre指针指向上一组第一个元素所以需要更新pre，为上一组第一个元素
            pre = newPre;
        }
    }

    public static void main(String... args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        ListNode head = reverseKGroup(l1, 6);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }

    }
}
