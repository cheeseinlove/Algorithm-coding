import java.util.Arrays;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-09-01 09:28
 * @Description:
 */
public class Interview1708 {


        public int bestSeqAtIndex(int[] height, int[] weight) {
            int len = height.length;
            int[][] person = new int[len][2];
            for (int i = 0; i < len; ++i)
                person[i] = new int[]{height[i], weight[i]};
            Arrays.sort(person, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
            int[] dp = new int[len];
            int res = 0;
            for (int[] pair : person) {
                int i = Arrays.binarySearch(dp, 0, res, pair[1]);
                if (i < 0)
                    i = -(i + 1);
                dp[i] = pair[1];
                if (i == res)
                    ++res;
            }
            return res;
        }







}
