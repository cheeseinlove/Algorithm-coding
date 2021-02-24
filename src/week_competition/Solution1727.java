package week_competition;

import java.util.Arrays;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2021-01-18 23:38
 * @Description:
 */
public class Solution1727 {
    public int largestSubmatrix(int[][] matrix) {
        int res = 0;
        int m = matrix.length, n= matrix[0].length;
        int[] heights = new int[n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                //用来记录当前行以及以上行的每列连续1的个数
                heights[j] = matrix[i][j] == 0 ? 0 : heights[j] + 1;
            }
            //防止对heights数组污染
            int[] temp = heights.clone();
            //排序后统计连续矩形最大值
            Arrays.sort(temp);
            //枚举每个高度的矩形并取最大值
            for(int j = 0; j < n; j++)
                res = Math.max(res, temp[j] * (n - j));
        }
        return res;
    }
}
