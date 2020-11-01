import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-10-23 09:38
 * @Description:
 */
public class Solution696 {
    //1101010100转为连续的频率数组，2，1，1，1，1，1，1，2，最终结果就是相邻两个数的最小值之和
    public int countBinarySubstrings(String s) {
        int ans = 0;
        List<Integer> count = new ArrayList<>();
        int same = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                same++;
            } else {
                count.add(same);
                same = 1;
            }
        }
        count.add(same);
        for (int i = 1; i < count.size(); i++) {
            ans += Math.min(count.get(i - 1), count.get(i));
        }
        return ans;
    }


}
