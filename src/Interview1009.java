/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-08-31 23:34
 * @Description:
 */
public class Interview1009 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==0){
            return false;
        }
        int x=0;
        int y=matrix[0].length-1;
        while (x< matrix.length&&y>=0){
            if (matrix[x][y]==target){
                return true;
            }else if (matrix[x][y]>target){
                y--;
            }else {
                x++;
            }
        }
        return false;
    }
}
