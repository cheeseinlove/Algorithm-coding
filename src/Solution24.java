import tools.ListNode;

public class Solution24 {
    public static ListNode swapPairs(ListNode head) {
           ListNode cur=head;
           ListNode temp=new ListNode(0);
           ListNode pre=new ListNode(0);
           if (head==null)
               return null;
           ListNode res=head.next==null?head:head.next;
           while (cur!=null&&cur.next!=null){
               pre.next=cur.next;
               temp=cur.next.next;
               cur.next.next=cur;
               cur.next=temp;
               pre=cur;
               cur=cur.next;
           }
        return res;

    }
    public static void main(String...args){
          ListNode l1=new ListNode(1);
          l1.next=new ListNode(2);
          l1.next.next=new ListNode(3);
          l1.next.next.next=new ListNode(4);
          ListNode head=swapPairs(l1);
          while (head!=null){
              System.out.print(head.val+" ");
              head=head.next;
          }
    }
}
