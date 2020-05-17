/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-04-22 21:33
 * @Description:
 */
public class LIS {
    public static void main(String[] args) {
 int a[]=new int[]{3,2,4,9,5,7};
        System.out.println(LIS(a,a.length));
    }
    private static int LIS(int[] arr, int n) {
        int[] maxValue = new int[n];
        maxValue[0] = arr[0];
        int len = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] > maxValue[len - 1]) {
                maxValue[len++] = arr[i];
            }else {
                int index = binarySearch(maxValue,len,arr[i]);
                maxValue[index] = arr[i];
            }
        }
        return len;
    }

    private static int binarySearch(int[] maxValue, int len, int x) {
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (maxValue[mid] < x) {
                left = mid + 1;
            }else if (maxValue[mid] > x){
                right = mid -1;
            }else {
                return mid;
            }
        }
        return left;
    }


}
