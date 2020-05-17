package tools;

import java.util.TreeMap;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-04-21 22:16
 * @Description:
 */
public class Solution1074 {
    public static void main(String[] args) {
        int matrix[][] = new int[][]{{1, -1}, {-1, 1}};
        System.out.println(numSubmatrixSumTarget(matrix, 0));
    }

    public static int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n = matrix.length;
        int ans = 0;

        for (int left = 0; left < matrix[0].length; left++) {
            //维护每一个左右区间的前缀和
            int preSum[] = new int[n];
            for (int right = left; right < matrix[0].length; right++) {
                for (int k = 0; k < n; k++) {
                    preSum[k] += matrix[k][right];
                }

                ans += binarySearch(preSum, target);
            }
        }
        return ans;

    }

    public static int binarySearch(int nums[], int target) {
        int sum = 0;
        int ans = 0;
        //key为递增和，value为重复次数
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - target)) {
                ans += map.get(sum - target);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);

        }
        return ans;
    }
}
