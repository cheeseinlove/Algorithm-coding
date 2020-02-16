import java.util.TreeSet;

/**
 * @Author liuxun05
 * @create 2020/2/13 23:38
 **/
//这个题两个启示：1.遍历矩形中的矩形用固定左右移动上下方式，每行前缀和递增相加即为矩形和，2.不大于k的最大子序和用两数相减
public class Solution363 {
    public static void main(String[] args) {
        int envelops[][] = new int[][]{{1,0,1}, {0, -2,3}};
        int k=2;
        System.out.println(maxSumSubmatrix(envelops,k));
    }
    public static int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int max = Integer.MIN_VALUE;
        for (int left = 0; left < cols; left++) {
            int[] preSum = new int[rows];
            for (int right = left; right < cols; right++) {
                //划分左右边界，并求出在此边界下的行前缀和
                // right从left+1开始,每次循环会全部加到preSum一次(求行前缀和的方式)
                for (int i = 0; i < rows; i++) {
                    preSum[i] += matrix[i][right];
                }
                //找到不大于k的最大子序和
                // 2 第1行(left,right)前缀和
                // 7 第2行(left,right)前缀和
                // 8 第3行(left,right)前缀和
                // 1 第4行(left,right)前缀和
                // 9 第5行(left,right)前缀和
                //求 [2,7,8,1,9] 不大于k的最大子序列,为什么是连续递增子序列因为pre[i]代表第i行的前缀和，pre连续子序列和代表在左右边界一定的
                //情况下的矩形遍历
                max = Math.max(maxPreSum(preSum, k), max);
            }
        }
        return max;
    }

    //要求sum(i,j)即从i到j的和，可以sum(0,j) - sum(0,i-1)。所以sum(0,j) - sum(0,i-1)<=k。
//这样的话，我们用一个遍历，求出sum(0,i)，并且把所有的值存入set，然后每一次都求出一个下界，即sum(0,i)-k，然后在之前的结果中找大于等于这个界的最小值，如果存在，就是一个候选值，然后再把sum(0,i)也放入set。
//不大于k的最大子序和 O(nlgn)
    public static int maxPreSum(int[] nums, int k) {
        int sum = 0, max = Integer.MIN_VALUE;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        for (int num : nums) {
            sum += num;
            //ceiling方法返回集合中大于等于e的最小值，没有就返回null
            Integer min = set.ceiling(sum - k);
            if (min != null) {
                max = Math.max(max, sum - min);
            }
            set.add(sum);
        }
        return max;

    }
}
