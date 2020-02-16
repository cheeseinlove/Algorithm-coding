/**
 * @Author liuxun05
 * @create 2019/8/11 17:44
 **/
/*
 给定一个 n × n 的二维矩阵表示一个图像。
将图像顺时针旋转 90 度。
说明：
你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
示例 1:
给定 matrix =
[
[1,2,3],
[4,5,6],
[7,8,9]
],
原地旋转输入矩阵，使其变为:
[
[7,4,1],
[8,5,2],
[9,6,3]
]
 */
public class Solution48 {
    public static void main(String[] args) {
        int matrix[][] = new int[][]{{1, 2, 3, 4}, {5, 6, 7,8}, { 9, 10,11,12}, {13,14,15,16}};
        rotate(matrix);
        for (int m = 0; m < matrix.length; m++) {
            for (int n = 0; n < matrix[m].length; n++) {
                System.out.print(matrix[m][n] + " ");
            }
            System.out.println();
        }
    }

    public static void rotate(int[][] matrix) {
        //abs1代表左上顶点的坐标
        int abs1=0;
        //abs2代表右下顶点的坐标，abs1和abs2可以唯一标识一个正方形圈
        int abs2=matrix.length-1;
        while (abs1<abs2){
            //p1是递增指针[abs1,abs2)
            int p1=abs1;
            //p2是递减指针(abs1,abs2]
            int p2=abs2;
            while (p1<abs2){
                //左上递增，左下递减，右上递增，右下递减
                int temp=matrix[abs1][p1];//左上
                matrix[abs1][p1]=matrix[p2][abs1];//左上=左下
                matrix[p2][abs1]=matrix[abs2][p2];//左下=右下
                matrix[abs2][p2]=matrix[p1][abs2];//右下=右上
                matrix[p1][abs2]=temp;//右上=左上
                p1++;
                p2--;
            }
            //正方形向内缩一圈
            abs1++;
            abs2--;
        }
    }
}
