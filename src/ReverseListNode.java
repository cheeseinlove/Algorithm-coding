import tools.ListNode;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-06-16 15:17
 * @Description:
 */
public class ReverseListNode {
    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        ListNode node6=new ListNode(6);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        ListNode root= reverse2(node1,1,5);

        while (root!=null){
            System.out.print(root.val+" ");
            root=root.next;
        }

    }
    public static ListNode reverse(ListNode root){
        ListNode pre=null;
        ListNode cur=root;
        while (cur!=null){
            ListNode temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return pre;
    }

    /**
     * 翻转第m个到第n个链表
     * @param root
     * @param m
     * @param n
     */
    public static ListNode reverse2(ListNode root,int m,int n){
     ListNode begin=root;
     int index=1;
     while (index<m-1){
         begin=begin.next;
         index++;
     }
     ListNode newEnd=begin.next;
     ListNode pre=null;
     ListNode cur=begin.next;
     ListNode temp=null;
     if(m==1){
         cur=root;
         newEnd=root;
         index=0;
     }
     while (index<n){
         temp=cur.next;
         cur.next=pre;
         pre=cur;
         cur=temp;
         index++;
     }
     if (m!=1) {
         begin.next = pre;
     }
     newEnd.next=temp;

     return m==1?pre:root;
    }
}
