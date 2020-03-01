/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-02-08 22:58
 * @Description: 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 */
public class Solution221 {
    public static void main(String[] args) {
        char matrix[][] = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        System.out.println(maximalSquare(matrix));
    }

    public static int maximalSquare(char[][] matrix) {
        if(matrix.length<1){
            return 0;
        }
        int maxLen = Integer.MIN_VALUE;
        //dp(i,j)表示以i,j坐标为右下角顶点的正方形边长
        int dp[][]=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                //边界值
                if (i==0||j==0){
                    dp[i][j]=Integer.parseInt(String.valueOf(matrix[i][j]));
                    maxLen=Math.max(maxLen,dp[i][j]);
                    continue;
                }
                if (matrix[i][j]=='1'){
                    //状态转移方程是上一个，左一个，以及左上角一个的最小值的原因是，当前状态一定是由这三个前置状态中的一个演变而来
                    //新的正方形一定会包含这三个小的正方形，类比于木桶理论，木桶装水多少取决于最低木板
                    // 三个距离为1的小格最短边长才是状态变化的前置状态
                   dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i-1][j-1]),dp[i][j-1])+1;
                    maxLen=Math.max(maxLen,dp[i][j]);
                }
            }
        }




        return maxLen*maxLen;
    }
}
