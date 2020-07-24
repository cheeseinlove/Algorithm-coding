import tools.ListNode;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-07-16 09:16
 * @Description:
 */
public class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {


        if (head == null) return head;  // 若head为空则直接返回null
        ListNode dummy = new ListNode(-1);  // 建立一个虚拟头结点
        ListNode tail = dummy;  // 定义一个尾巴，用于尾插法。
        for (ListNode l = head, r = head; l != null; l = r) {
            while (r != null && r.val == l.val) r = r.next;  // 只要r不为空并且与l的值相等则一直向后移动
            if (l.next == r) {  // 若长度为1，则通过尾插法加入。
                tail.next = l;  // 基本的尾插法
                tail = l;
                tail.next = null;  // 这里记得将尾部的后面置为null，不然可能后面会带着一些其他的节点。
            }
        }
        return dummy.next;


    }


    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) return head;  // 若head为空则直接返回null
        ListNode dummy = new ListNode(-1);

        ListNode tail = dummy;
        ListNode cur = head;
        ListNode next = head;

        while (next != null) {
            while (next != null && cur.val == next.val) {
                next = next.next;
            }
            if (cur.next == next) {
                tail.next = cur;
                tail = tail.next;
                tail.next = null;
            }
            cur = next;

        }
        return dummy.next;
    }
}
