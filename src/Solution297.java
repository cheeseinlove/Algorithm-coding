import tools.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-06-24 08:54
 * @Description:
 */
public class Solution297 {
    public static void main(String[] args) {
        TreeNode root=deserialize("[5,2,3,null,null,2,4,3,1]");
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "[null]";
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        sb.append(Integer.toString(root.val));
        sb.append(',');
        while(!queue.isEmpty()){

            TreeNode node = queue.poll();

            if(node.left !=null) {
                queue.offer(node.left);
                sb.append(Integer.toString(node.left.val));
                sb.append(',');
            }else {
                sb.append("null");
                sb.append(',');
            }
            if(node.right!=null) {
                queue.offer(node.right);
                sb.append(Integer.toString(node.right.val));
                sb.append(',');
            }else{
                sb.append("null");
                sb.append(',');
            }
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        // System.out.println(sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String data1 = data.substring(1,data.length()-1);
        String[] d = data1.split(",");
        if(d[0].equals("null")) return null;
        TreeNode root = new TreeNode(0);
        root.val = Integer.parseInt(d[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode rootp = root;
        int i=1;
        while(i<d.length && !queue.isEmpty()){
            rootp = queue.poll();
            if(d[i].equals("null")) rootp.left = null;
            else {
                rootp.left = new TreeNode(Integer.parseInt(d[i]));
                queue.add(rootp.left);
            }
            i++;
            if(d[i].equals("null")) rootp.right = null;
            else {
                rootp.right = new TreeNode(Integer.parseInt(d[i]));
                queue.add(rootp.right);
            }
            i++;
        }
        return root;
    }
}
