package week_competition;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-06-21 10:56
 * @Description:
 */
public class Solution5441 {
    public static void main(String[] args) {
        String name[] = new String[]{"kaido", "kaido(1)", "kaido", "kaido(1)"};
        name = getFolderNames(name);
        for (int i = 0; i < name.length; i++) {
            System.out.print(name[i] + " ");
        }
    }

    private static Map<String, Integer> cnt = new HashMap<>();


    public static String[] getFolderNames(String[] names) {
        String[] ans = new String[names.length];
        for (int i = 0; i < ans.length; i++) {
            String name = names[i];
            if (cnt.containsKey(name)) {
                ans[i] = name + "(" + cnt.get(name) + ")";
                while (cnt.containsKey(ans[i])) {
                    cnt.put(name, cnt.getOrDefault(name, 0) + 1);
                    ans[i] = name + "(" + cnt.get(name) + ")";
                }
            } else {
                ans[i] = name;
            }
            //cnt.put(name, cnt.getOrDefault(name, 0) + 1);
            cnt.put(ans[i], cnt.getOrDefault(ans[i], 0) + 1);
        }
        return ans;
    }
}
