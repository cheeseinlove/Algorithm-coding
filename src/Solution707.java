
/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-07-27 23:32
 * @Description:
 */
public class Solution707 {

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        System.out.println(linkedList.get(1));            //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        System.out.println(linkedList.get(1));             //返回3


    }
  static   class MyLinkedList {
        private class ListNode {
            public int val;
            public ListNode next;

            public ListNode(int x) {
                val = x;
            }
        }
        private ListNode head;
        private ListNode tail;
        private int size = 0;

        /**
         * Initialize your data structure here.
         */
        public MyLinkedList() {

        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {
            if (index >= size || index < 0) {
                return -1;
            }
            ListNode cur = head;

            while (index > 0) {
                cur = cur.next;
                index--;
            }
            return cur.val;
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            ListNode node = new ListNode(val);
            node.next = head;
            head = node;
            if (tail == null) {
                tail = node;
            }
            size++;
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            ListNode node = new ListNode(val);
            if (tail == null) {
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
            if (head == null) {
                head = node;
            }
            size++;
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {
            ListNode node = new ListNode(val);
            if (size == 0) {
                head = node;
                tail = node;
            } else {
                if (index <= 0) {
                    node.next = head;
                    head = node;
                } else if (index >= size) {
                    tail.next = node;
                    tail = node;
                } else {
                    ListNode cur = head;
                    index--;
                    while (index > 0) {
                        index--;
                        cur = cur.next;
                    }
                    ListNode temp = cur.next;
                    cur.next = node;
                    node.next = temp;
                }
            }
            size++;
        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            if (index >= 0 && index < size) {
                if (index == 0) {
                    ListNode temp = head.next;
                    head = null;
                    head = temp;
                    if (size == 1) {
                        tail = null;
                    }
                } else {
                    ListNode cur = head;
                    int p = index - 1;
                    while (p > 0) {
                        p--;
                        cur = cur.next;
                    }
                    ListNode temp = cur.next.next;
                    if (index == size - 1) {
                        tail = cur;
                    }
                    cur.next = temp;
                    size--;
                }


            }
        }
    }
}