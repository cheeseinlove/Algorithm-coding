import tools.ListNode;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-08-04 23:38
 * @Description:
 */
public class InterView0206 {
    public boolean isPalindrome(ListNode head) {
        // 使用快慢指针，慢指针在进行操作的时候，顺带的进行链表的翻转，在进行半个链表之间的比较


        if(head == null){
            return true;
        }
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode slow = dummyNode;
        ListNode fast = dummyNode;
        ListNode prev = null;

        // 使用快慢指针找到链表的中间位置，并翻转慢指针前的链表
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            // 链表翻转
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        ListNode rigth;
        if(fast != null){
            // 不为空，表示链表size为偶数
            // 0 -> 1 -> 2 -> 3, prev指向1，slow指向2，要比较prev与right，先确定位置1与2的val是不是一样的
            if(slow.val != slow.next.val){
                return false;
            }
            // rigth从3开始
            rigth = slow.next.next;
        }
        else{
            // 为空，表示链表size为奇数
            // 0 -> 1 -> 2 -> 3 -> 4, prev指向1，slow指向2
            // rigth从3开始
            rigth = slow.next;
        }
        // 比较两个链表
        while(prev != null && rigth != null){
            if(prev.val != rigth.val){
                return false;
            }
            prev = prev.next;
            rigth = rigth.next;
        }
        return true;

    }
}
