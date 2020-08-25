/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-08-24 23:28
 * @Description:
 */
public class Solution1011 {
    public static void main(String[] args) {
        int wei[]=new int[]{1,2,3,4,5,6,7,8,9,10};
//        System.out.println(shipWithinDays(wei,5));
//        System.out.println(canTrans(wei,5,48));
    }
    public  int shipWithinDays(int[] weights, int D) {
        int right = 50000 * 500;
        int left = 1;
        while (left < right) {
            int mid = (right + left) / 2;
            if (canTrans(weights, D, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public  boolean canTrans(int[] weights, int D, int K) {
        int days = 0;
        for (int i = 0; i < weights.length; ) {
            int term = K;
            //若遇到运送能力比当前货物小直接返回失败
            if (term < weights[i]) {
                return false;
            }
            while (i < weights.length&&term >= weights[i]) {
                term -= weights[i];
                i++;
            }
            days++;

        }

        return days <= D;
    }
}
