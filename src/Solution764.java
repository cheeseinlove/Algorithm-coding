import java.util.HashSet;
import java.util.Set;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-03-09 23:54
 * @Description:
 */
public class Solution764 {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        //储存坐标为0的"hash"值
        Set<Integer> banned = new HashSet();
        int[][] dp = new int[N][N];

        for (int[] mine : mines)
            banned.add(mine[0] * N + mine[1]);
        int ans = 0, count;

        //先算横向左右遍历后的最短对称轴长度
        for (int r = 0; r < N; ++r) {
            count = 0;
            //每行从左往后遍历,count记录连续1长度，即当前(r,c)的左对称轴
            for (int c = 0; c < N; ++c) {
                count = banned.contains(r * N + c) ? 0 : count + 1;
                dp[r][c] = count;
            }

            count = 0;
            //每行从右往左遍历,count记录连续1长度，即当前(r,c)的右对称轴
            for (int c = N - 1; c >= 0; --c) {
                count = banned.contains(r * N + c) ? 0 : count + 1;
                //此时dp更新为横向最短对称轴
                dp[r][c] = Math.min(dp[r][c], count);
            }
        }
//和上面for循环同理，不同的是固定列，同列从上到下，再从下到上遍历刷新竖向最短对称轴长度，最后求最小值
        for (int c = 0; c < N; ++c) {
            count = 0;
            for (int r = 0; r < N; ++r) {
                count = banned.contains(r * N + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
            }

            count = 0;
            for (int r = N - 1; r >= 0; --r) {
                count = banned.contains(r * N + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
                ans = Math.max(ans, dp[r][c]);
            }
        }

        return ans;
    }

}
