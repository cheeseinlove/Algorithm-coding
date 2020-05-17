import java.util.Arrays;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-04-23 23:04
 * @Description:
 */
public class Solution1105 {
    public static void main(String[] args) {
        int books[][] = new int[][]{{1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}};
        System.out.println(minHeightShelves(books, 4));
    }

    /**
     * 本题的核心思路为遍历每一本书，每遍历新的书先当做另起一层书架，然后把之前的所有书往新的一层加，直到新加的一层宽度越界
     * @param books
     * @param shelf_width
     * @return
     */
    public static int minHeightShelves(int[][] books, int shelf_width) {
        int n = books.length;
        //dp i代表前i本书的最小高度和
        int dp[] = new int[n + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        dp[1] = books[0][1];

        for (int i = 2; i <= n; i++) {
            //最后一层的宽度
            int cur_width = 0;
            int cur_height = 0;
            for (int j = i; j > 0; j--) {
                cur_width += books[j - 1][0];
                cur_height = Math.max(cur_height, books[j - 1][1]);
                //
                if (cur_width > shelf_width) {
                    break;
                }
                dp[i] = Math.min(dp[i], dp[j - 1] + cur_height);
            }
        }

        return dp[n];
    }
}
