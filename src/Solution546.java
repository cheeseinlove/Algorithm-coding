/**
 * @Author liuxun05
 * @create 2020/2/23 22:38
 **/
public class Solution546 {
    public int removeBoxes(int[] boxes) {
        if (boxes == null || boxes.length == 0) {
            return 0;
        }
        int n = boxes.length;

//        令dp[i][j]表示从j开始，长度为i的字符串。
//        dp[i][j] = Math.max(dp[i-1][j] + 1, 最后一个字符与前面任意多个相同字符联合起来得分的最大值);
//        所以对于dp，需要使用深度搜索找到 最后一个字符，与前面任意多个字符联合起来的最大得分。
//
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n - i; j++) {
                if (i == 1) {
                    dp[i][j] = 1; // 1个字符得分为1
                } else {
                    // 深度搜索
                    dp[i][j] = Math.max(dp[i - 1][j] + 1, deepSearch(boxes, j, i + j - 1, boxes[i + j - 1], 1, dp));
                }
            }
        }
        return dp[n][0];
    }

    private int deepSearch(int[] box, int start, int end, int cur, int count, int[][] dp) {
        int max = dp[end - start][start] + count * count;
        int preEnd = end;
        for (int i = end - 1; i >= start; i--) {
            // 连续的情况直接加
            if (box[i] == cur && box[i + 1] == cur) {
                count++;
                int ret = dp[i - start][start] + count * count;
                max = Math.max(max, ret);
                preEnd = i;
            } else if (box[i] == cur) { // 非连续的情况 需要加中间的得分
                // 获得中间的得分
                int ret = dp[preEnd - i - 1][i + 1];
                // 继续深度搜索
                ret += deepSearch(box, start, i, cur, count + 1, dp);
                // 取最大值
                max = Math.max(max, ret);
            }
        }
        // 返回与任意位置结合后连续得分的最大值
        return max;
    }



}
