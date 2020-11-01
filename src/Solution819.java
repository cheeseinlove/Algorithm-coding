import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-10-28 23:24
 * @Description:
 */
public class Solution819 {
    public static void main(String[] args) {
        String p = "Bob. hIt, baLl";
        String[] ban = new String[]{"bob","hit"};
        System.out.println(mostCommonWord(p, ban));
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        String ans = "";
        int max = Integer.MIN_VALUE;
        paragraph=paragraph.replace(",", " ");
        paragraph=paragraph.replace(".", " ");
        paragraph=paragraph.replace(";", " ");
        paragraph=paragraph.replace("'", " ");
        paragraph=paragraph.replace("!", " ");
        paragraph=paragraph.replace("?", " ");

        String[] s = paragraph.split(" ");
        Set<String> banSet = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < banned.length; i++) {
            banSet.add(banned[i]);
        }
        for (int i = 0; i < s.length; i++) {
            if (s[i].trim().equals("")){
                continue;
            }
            if (banSet.contains(s[i].toLowerCase())) {
                continue;
            }
            map.put(s[i].toLowerCase(), map.getOrDefault(s[i].toLowerCase(), 0) + 1);
            if (map.get(s[i].toLowerCase()) > max) {
                max = map.get(s[i].toLowerCase());
                ans = s[i].toLowerCase();
            }
        }
        return ans;
    }



}
