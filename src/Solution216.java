import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2021-01-12 23:45
 * @Description:
 */
public class Solution216 {
    List<List<Integer>> ans;

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k == 0) {
            return ans;
        }
        ans = new ArrayList<>();
        for (int i = 1; i <= 9 && i <= n; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(i);
            dfs(temp, k - 1, i, n, i);
        }
        return ans;
    }

    public void dfs(List<Integer> cur, int k, int sum, int n, int last) {
        if (k == 0 && sum == n) {
            ans.add(cur);
            return;
        }
        for (int i = last + 1; i <= 9; i++) {
            if (sum + i <= n) {
                cur.add(i);
                dfs(new ArrayList<>(cur), k - 1, sum + i, n, i);
                cur.remove(cur.size() - 1);
            }
        }
    }

}
