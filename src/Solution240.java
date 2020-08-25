/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-08-07 09:11
 * @Description:
 */
public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int x = 0;
        int y = matrix[0].length - 1;

        while (x < matrix.length && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] > target) {
                y--;
            } else {
                x++;
            }
        }
        return false;
    }
}
