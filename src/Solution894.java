import tools.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-07-15 09:20
 * @Description:
 */
public class Solution894 {
    private Map<Integer,List<TreeNode>> cache=new HashMap<>();
    public List<TreeNode> allPossibleFBT(int N) {
        if (N % 2 == 0) {
            return new ArrayList<>();
        }
        if(cache.containsKey(N)){
            return cache.get(N);
        }
        List<TreeNode> ans = new ArrayList<>();
        if (N == 1) {
            ans.add(new TreeNode(0));
            return ans;
        }
        for (int i = 1; i <N; i += 2) {
            List<TreeNode> leftList = allPossibleFBT(i);
            List<TreeNode> rightList = allPossibleFBT(N - i - 1);
            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    TreeNode head = new TreeNode(0);
                    head.left = left;
                    head.right = right;
                    ans.add(head);
                }
            }
        }
        cache.put(N,ans);
        return ans;
    }

}
