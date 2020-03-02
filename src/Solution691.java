import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-03-01 23:46
 * @Description:
 */
public class Solution691 {
    public int minStickers(String[] stickers, String target) {
        int n = stickers.length;
        //存储每个单词的字符数目
        int[][] dirs = new int[n][26];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < stickers[i].length(); ++j) {
                ++dirs[i][stickers[i].charAt(j) - 'a'];
            }
        }
        Map<String, Integer> mp = new HashMap<>();
        mp.put("", 0);
        return dfs(dirs, mp, target);
    }

    private int dfs(int[][] dirs, Map<String, Integer> mp, String tar) {
        //若当前tar被消耗为空串""则直接返回0，此次没有选源串
        if (mp.containsKey(tar)) return mp.get(tar);
        int[] freq = new int[26];
        for (int i = 0; i < tar.length(); ++i) {
            ++freq[tar.charAt(i) - 'a'];
        }
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < dirs.length; ++i) {
            if (dirs[i][tar.charAt(0) - 'a'] == 0) continue;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; ++j) {
                //cnt代表当前i对应的源字符串，缺的每一个字符数目
                int cnt = freq[j] - dirs[i][j];
                for (int k = 0; k < cnt; ++k)
                    sb.append((char)(j + 'a'));
            }
            //缺的部分需要的串数
            int ans2 = dfs(dirs, mp, sb.toString());
            if (ans2 != -1) ans = Math.min(ans, 1 + ans2);
        }
        mp.put(tar, ans == Integer.MAX_VALUE ? -1 : ans);
        return mp.get(tar);
    }
}
