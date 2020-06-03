import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-06-03 09:04
 * @Description:
 */
public class Solution54 {
    public static void main(String[] args) {
        int matrix[][] = new int[][]{{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};
        List<Integer> ans = spiralOrder(matrix);
 for(int i:ans){
     System.out.print(i+",");
 }
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        int up = 0;
        int left = 0;
        int down = row - 1;
        int right = column - 1;
        while (left <= right && up <= down){
            for (int i = left; i <= right; i++) {
                ans.add(matrix[up][i]);
            }
            up++;
            for (int i = up; i <= down; i++) {
                ans.add(matrix[i][right]);
            }
            right--;
            for (int i = right; i >= left && up <= down; i--) {
                ans.add(matrix[down][i]);
            }
            down--;
            for (int i = down; i >= up && left <= right; i--) {
                ans.add(matrix[i][left]);
            }
            left++;
        }
        return ans;

    }
}
