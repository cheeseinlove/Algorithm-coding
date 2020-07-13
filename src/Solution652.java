import tools.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-07-09 23:21
 * @Description:
 */
public class Solution652 {
        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            List<TreeNode> res = new ArrayList<>();
            HashMap<String, Integer> map = new HashMap<>();
            if (root == null) return res;
            saveRoute(root, res, map);
            return res;
        }

        //递归获取每个子树的路径，保存于Map中
        private String saveRoute(TreeNode node, List<TreeNode> res, HashMap<String, Integer> map) {
            if (node == null) return "";
            //自底向上获取每个节点的序列化值
            String route = node.val + "," + saveRoute(node.left, res, map) + "," + saveRoute(node.right, res, map);
            //将结果放入map，判断是否有相同子树
            //避免出现多次相同子树
            if (map.get(route) != null && map.get(route) == 1) {
                res.add(node);
            }
            map.put(route, map.getOrDefault(route, 0) + 1);

         return route;
        }
}