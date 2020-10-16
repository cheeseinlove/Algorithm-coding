import java.util.Arrays;
import java.util.List;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-10-13 23:17
 * @Description:
 */
public class Solution539 {
    public int findMinDifference(List<String> timePoints) {
        int ans = Integer.MAX_VALUE;
        int minutes[] = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            String s = timePoints.get(i);
            //转分钟
            minutes[i] = Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(3));
        }
        Arrays.sort(minutes);
        for (int i = 1; i < minutes.length; i++) {
            ans = Math.min(minutes[i] - minutes[i - 1], ans);
        }
        //首尾
        ans = Math.min(1440 - minutes[minutes.length - 1] + minutes[0], ans);

        return ans;

    }
}
