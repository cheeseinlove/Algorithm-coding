import tools.ListNode;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-08-03 23:13
 * @Description:
 */
public class Interview0201 {
    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(3);
        ListNode l5=new ListNode(2);
        ListNode l6=new ListNode(1);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=l6;
        removeDuplicateNodes(l1);
    }
    public static ListNode removeDuplicateNodes(ListNode head) {
      int []bits=new int[20000/32+1];
      ListNode cur=head;
      while (cur!=null&&cur.next!=null){
          bits[cur.val/32]|=1<<(cur.val%32);
          if ((bits[cur.next.val/32]&1<<(cur.next.val%32))!=0){
              cur.next=cur.next.next;
          }else {
              cur=cur.next;
          }
      }
      return head;
    }
}
