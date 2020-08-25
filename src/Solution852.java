/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-08-21 21:17
 * @Description:
 */
public class Solution852 {
    public static void main(String[] args) {
        int a[]=new int[]{0,0,0};
        System.out.println(peakIndexInMountainArray(a));
    }
    public static int peakIndexInMountainArray(int[] A) {
        // 1.[定左右]
        int l = 0;
        int r = A.length-1;

        // 2.[定区间]
        while (l <= r) {// [l,r]
            // 3.[取中值]
            int mid = l + (r-l)/2;

            // 4.[进退]
            if (A[mid+1] > A[mid]) {// 上坡
                l = mid + 1; // [爬坡]
            } else if (A[mid-1] > A[mid]){// 下坡
                r = mid - 1; // [返回坡顶]
            } else {
                return mid;
            }

        }

        // 5.[无功而返]
        return -1;

    }
}
