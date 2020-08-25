/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-08-07 20:58
 * @Description:
 */
public class Solution275 {
    public int hIndex(int[] citations) {
        int len = citations.length;
        if (len == 0) {
            return 0;
        }
        int left = 0;
        int right = citations.length - 1;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int sum = mid + citations[mid];
            if (sum == len) {
                return len - mid;
            } else if (sum < len) {
                left = mid + 1;
            } else {
                ans = Math.max(ans,len - mid);
                right = mid - 1;
            }
        }


        return ans;


    }


}
