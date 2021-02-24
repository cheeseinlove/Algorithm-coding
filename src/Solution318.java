/**
 * @Author: liuxun05@meituan.com
 * @Date: 2021-01-26 22:17
 * @Description:
 */
public class Solution318 {
    public int maxProduct(String[] words) {
        //记录每个单词的字母种类
        int hash[] = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                hash[i] |= 1 << (c - 'a');
            }
        }
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                //无重复的词
                if ((hash[i] & hash[j]) == 0) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }

            }
        }
        return ans;
    }
}
