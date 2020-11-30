import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-11-26 21:36
 * @Description:
 */
public class Solution1400 {
    //能构成的回文串的个数>=奇数次出现的字符种数
    public boolean canConstruct(String s, int k) {
        if (k > s.length()) {
            return false;
        }
        if (k == s.length()) {
            return true;
        }
        Map<Character, Integer> map = new HashMap<>();
        //统计次数
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int count = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                count++;
            }
        }
        return k >= count;
    }
}
