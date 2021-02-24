/**
 * @Author: liuxun05@meituan.com
 * @Date: 2021-01-27 23:24
 * @Description:
 */
public class Solution331 {
    public static void main(String[] args) {
        isValidSerialization("1,#");
    }
    public static boolean isValidSerialization(String preorder) {
        String tree[] = preorder.split(",");
        return preOrder(tree,0)==tree.length;
    }

    public static int preOrder(String[] tree,int cur) {
        if (cur>=tree.length){
            return cur+1;
        }
        //如果当前是空节点
        if (tree[cur].equals("#")){
            return cur+1;
        }
        int traceLeft=preOrder(tree,cur+1);
        int traceRight=preOrder(tree,traceLeft);
        return traceRight;
    }
}
