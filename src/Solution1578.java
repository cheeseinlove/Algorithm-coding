import java.util.PriorityQueue;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-12-03 19:55
 * @Description:
 */
public class Solution1578 {
    public int minCost(String s, int[] cost) {
        int ans = 0;
        int max = 0;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum = cost[i];
            max = cost[i];
            while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                sum+=cost[i + 1];
                max = Math.max(max, cost[i + 1]);
                i++;
            }
            ans+=sum-max;
        }
        return ans;
    }
}
