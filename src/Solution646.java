import java.util.Arrays;

/**
 * @Author liuxun05
 * @create 2020/2/26 23:41
 **/
public class Solution646 {
    public static void main(String[] args) {
        int pairs[][] = new int[][]{{1, 2}, {2, 3}, {3, 4}};
        System.out.println(findLongestChain(pairs));
    }

    public static int findLongestChain(int[][] pairs) {
        if (pairs.length < 2) {
            return pairs.length;
        }
        int maxLen = 1;
        int dp[] = new int[pairs.length];
        Arrays.fill(dp, 1);
        //第一个数字升序排序
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        for (int j = 1; j < pairs.length; j++) {
            for (int i = 0; i < j; i++) {
                if (pairs[i][1] < pairs[j][0]) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                    maxLen = Math.max(maxLen, dp[j]);
                }
            }
        }
        return maxLen;

    }
}
