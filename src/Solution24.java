import tools.ListNode;

public class Solution24 {
    public static ListNode swapPairs(ListNode head) {
           ListNode cur=head;
           ListNode temp=new ListNode(0);
           ListNode pre=new ListNode(0);
           if (head==null)
               return null;
           ListNode res=head.next==null?head:head.next;
           //需要翻转当前元素的条件
           while (cur!=null&&cur.next!=null){
               //若temp为空相当于一个终结符
               temp=cur.next.next;
               //连接之前元素
               pre.next=cur.next;
               //相邻元素翻转
               cur.next.next=cur;
               //连接之后元素
               cur.next=temp;
               //更新pre指针
               pre=cur;
               //进入下一组翻转
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
