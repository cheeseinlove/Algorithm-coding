import tools.ListNode;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-08-04 23:21
 * @Description:
 */
public class InterView0203 {
    public static void main(String[] args) {
        ListNode l1=new ListNode(4);
        ListNode l2=new ListNode(5);
        ListNode l3=new ListNode(1);
        ListNode l4=new ListNode(9);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        deleteNode(l1);
    }
    public static void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = node;
        ListNode slow = dummy;
        ListNode fast = node;
        while (fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode temp=slow.next.next;
        slow.next=null;
        slow.next=temp;

    }
}
