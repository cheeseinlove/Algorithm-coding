/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-08-11 09:17
 * @Description:
 */
public class Solution378 {
    public int kthSmallest(int[][] matrix, int k) {
        int len = matrix.length;
        //left是最小值，right是最大值
        int left = matrix[0][0];
        int right = matrix[len-1][len-1];

        //二分查找
        while(right > left){
            int mid = left + (right - left) / 2;

            //checkLessThanK(matrix, mid, k)表示：小于等于mid的值 的 数量 小于k
            /*
                想象一下，mid = 7， k = 5
                说明matrix中小于等于7的值只有（0-4）个，
                举个例子：
                    matrix中有{1 2 7 7 8 9}
                    小于等于7的有{1， 2， 7， 7}
                    第5大的数字，肯定就是从8开始找咯
                那我们要找的是第k小的数字，这个数字肯定要比mid大吧，从mid+1开始找吧
                否则，就从小于等于mid的这个部分来找吧
            */
            if(checkLessThanK(matrix, mid, k)){
                left = mid+1;
            }
            else{
                //小于等于mid的值 的 数量 大于等于k
                right = mid;
            }
        }
        return left;
    }

    //小于等于mid的数量少于K
    public Boolean checkLessThanK(int[][] matrix, int mid, int k){
        int num = 0;
        int j = 0;
        int i = matrix.length -1;

        //这个计数的方法很特别哦，不是一行一行加的。是一列一列加的！
        while(i >= 0 && j < matrix.length){
            if(matrix[i][j] <= mid) {
                j++;
                num += i+1;
            }
            else{
                i--;
            }
            if(num >= k)    return false;
        }
        return true;
    }

}
