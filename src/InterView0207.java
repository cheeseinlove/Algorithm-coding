import tools.ListNode;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-08-04 23:38
 * @Description:
 */
public class InterView0207 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA;
        ListNode pb = headB;
        while (pa != pb) {
            pa = pa == null?headB:pa.next;
            pb =pb == null?headA: pb.next;

        }
        return pa;
    }
}
