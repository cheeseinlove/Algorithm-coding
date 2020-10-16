import java.util.HashSet;
import java.util.Set;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-09-21 23:12
 * @Description:
 */
public class Solution1456 {
    public int maxVowels(String s, int k) {
        int ans = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int j = 0;
        int i = 0;
        while (i < s.length()) {
            if (set.contains(s.charAt(i))) {
                max++;
            }
            if (i >= k) {
                if (set.contains(s.charAt(j))) {
                    max--;
                }
                j++;
            }
            ans = Math.max(ans, max);
            i++;
        }
        return ans;

    }
}
