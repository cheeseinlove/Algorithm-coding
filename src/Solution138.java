/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-07-17 21:25
 * @Description:
 */
public class Solution138 {
    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node(int val) {
            this.val = val;
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        node1.next = node2;
        Node node3 = new Node(11);
        node2.next = node3;
        Node node4 = new Node(10);
        node3.next = node4;

        Node node5 = new Node(1);
        node2.random = node1;

        node4.next = node5;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;


        copyRandomList2(node1);
    }

    public static Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        // Creating a new weaved list of original and copied nodes.
        Node ptr = head;
        while (ptr != null) {

            // Cloned node
            Node newNode = new Node(ptr.val);

            // Inserting the cloned node just next to the original node.
            // If A->B->C is the original linked list,
            // Linked list after weaving cloned nodes would be A->A'->B->B'->C->C'
            newNode.next = ptr.next;
            ptr.next = newNode;
            ptr = newNode.next;
        }

        ptr = head;

        // Now link the random pointers of the new nodes created.
        // Iterate the newly created list and use the original nodes' random pointers,
        // to assign references to random pointers for cloned nodes.
        while (ptr != null) {
            ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
            ptr = ptr.next.next;
        }

        // Unweave the linked list to get back the original linked list and the cloned list.
        // i.e. A->A'->B->B'->C->C' would be broken to A->B->C and A'->B'->C'
        Node ptr_old_list = head; // A->B->C
        Node ptr_new_list = head.next; // A'->B'->C'
        Node head_old = head.next;
        while (ptr_old_list != null) {
            ptr_old_list.next = ptr_old_list.next.next;
            ptr_new_list.next = (ptr_new_list.next != null) ? ptr_new_list.next.next : null;
            ptr_old_list = ptr_old_list.next;
            ptr_new_list = ptr_new_list.next;
        }
        return head_old;
    }

    public static Node copyRandomList2(Node head) {
        if (head==null){
            return null;
        }
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            Node replica = new Node(cur.val);
            replica.next = next;
            cur.next = replica;
            cur = replica.next;
        }


        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        Node old = head;
        Node newNode = head.next;
        Node ans = head.next;
        //断链
        while (old != null && newNode != null) {
            old.next = old.next.next;
            newNode.next = newNode.next==null?null:newNode.next.next;
            old = old.next;
            newNode = newNode.next;
        }


        return ans;

    }
}
