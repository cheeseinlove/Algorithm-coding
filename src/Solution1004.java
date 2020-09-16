/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-09-15 23:26
 * @Description:
 */
public class Solution1004 {
    //问题转化为，求连续子数组中满足0的个数小于等于k的最长子数组长度
    public int longestOnes(int[] A, int K) {
        if(A.length==0){
            return 0;
        }
        int ans = 0;
        int current0 = 0;
        int left = 0;
        int right = 0;
        //初始化
        if (A[0] == 0) {
            current0++;
        }
        while (right < A.length && left < A.length) {
            int len = right - left + 1;
            if (current0 <= K) {
                ans = Math.max(len, ans);
                right++;
                if (right < A.length && A[right] == 0) {
                    current0++;
                }
            } else {
                if (A[left] == 0) {
                    current0--;
                }
                left++;
            }

        }
        return ans;
    }
}