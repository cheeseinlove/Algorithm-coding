/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-08-26 23:40
 * @Description:
 */
public class Solution1482 {
    public int minDays(int[] bloomDay, int m, int k) {
        int left = 0;
        int maxDay = Integer.MIN_VALUE;
        for (int i : bloomDay) {
            maxDay = Math.max(maxDay, i);
        }
        int right = maxDay;

        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (canGetMFlower(bloomDay, mid, m, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (left==maxDay&&!canGetMFlower(bloomDay,maxDay, m, k)){
            return -1;
        }
        return left;

    }

    public boolean canGetMFlower(int[] bloomDay, int day, int m, int k) {
        int count = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            int term=0;
            while (i < bloomDay.length&&bloomDay[i] <= day){
                term++;
                i++;
            }
            count+=term/k;
        }

        return count>=m;
    }
}
