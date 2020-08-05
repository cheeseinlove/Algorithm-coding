/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-07-29 21:50
 * @Description:
 */
public class HeadOffer35 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
      if (head==null){
          return null;
      }
      Node cur=head;
      while (cur!=null){
          Node newNode=new Node(cur.val);
          Node temp=cur.next;
          cur.next=newNode;
          newNode.next=temp;
          cur=cur.next.next;
      }
         cur=head;
        while (cur!=null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur=cur.next.next;
        }
        cur=head;

        Node newHead=cur.next;
        while (cur!=null){
            if (cur.random!=null){
                cur.next.random=cur.random.next;
            }
            Node temp=cur.next;
            cur.next=temp.next;
            cur=temp.next;
            temp.next=temp.next==null?null:temp.next.next;
        }


return newHead;
    }
}
