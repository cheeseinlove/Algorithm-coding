import tools.ListNode;
import tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-07-17 09:08
 * @Description:
 */
public class Solution109 {
    List<Integer> value;
    public TreeNode sortedListToBST(ListNode head) {
       if (head==null){
           return null;
       }
       value=new ArrayList<>();
       while (head!=null){
           value.add(head.val);
           head=head.next;
       }
       return getNode(0,value.size()-1);
    }

    public TreeNode getNode(int left,int right){
        if (left>right){
            return null;
        }
        int mid=left+(right-left)/2;
        int midValue=value.get(mid);
        TreeNode root=new TreeNode(midValue);
        root.left=getNode(left,mid-1);
        root.right=getNode(mid+1,right);
        return root;

    }
}
