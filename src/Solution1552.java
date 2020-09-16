import java.util.Arrays;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-08-27 09:44
 * @Description:
 */
public class Solution1552 {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        //m个球，最大间距
        int hi = (position[position.length - 1] - position[0]) / (m - 1);
        int lo = 1;
        int ans = 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            //如果距离mid能摆下那么间距需要加大
            if (check(position, mid, m)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid-1;
            }
        }
        return ans;
    }

    boolean check(int[] position, int distance, int m) {
        int count = 1;
        int i = 0;
        for (int j = 1; j < position.length; j++) {
            if (position[j] - position[i] >= distance) {
                i = j;
                count++;
                if (count >= m) return true;
            }
        }
        return false;
    }


}
