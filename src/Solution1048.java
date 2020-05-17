import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-04-19 23:23
 * @Description:
 */
//和最长递增子串差不多
public class Solution1048 {
    public static void main(String[] args) {
        String words[] = new String[]{"ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj","ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru"};
        System.out.println(longestStrChain(words));
    }

    public static int longestStrChain(String[] words) {
        //排序是为了
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        //dpi代表以i结尾的符合条件最长子串
        int[] dp = new int[words.length];
        int ans = 0;

        for (int i = 1; i < words.length; i++) {
            for (int j = 0; j < i; j++) {
                if (isPreState(words[j], words[i])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    ans = Math.max(ans, dp[i]);
                }
            }
        }
        return ans+1;
    }

    public static boolean isPreState(String before, String after) {
        if (before.length() + 1 != after.length()) {
            return false;
        }
        if (after.startsWith(before) || after.endsWith(before)) {
            return true;
        }
        int flag = 0;
        int i = 0;
        for (int j = 0; j < after.length(); j++) {
            if (before.charAt(i) == after.charAt(j)) {
                i++;
            } else {
                flag++;
            }
        }
        return flag == 1;


    }

}
