import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/*
给定一个字符串，找出不含有重复字符的最长子串的长度。
 */
public class LongestSubstringWithoutReapting {
    public static  int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        int max = 0;
        int order = 0;
        int head = 0;
        for(int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) { // 字符串单独转换
                max = Math.max(order-head, max);
                head = Math.max(map.get(s.charAt(i))+1, head);
            }
            map.put(s.charAt(i), order);
            order++;
        }

        max = Math.max(order-head, max);
        return max;
    }

}
