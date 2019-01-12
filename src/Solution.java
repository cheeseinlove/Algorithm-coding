import java.util.ArrayList;
import java.util.List;

public class Solution {
    static int cuts = Integer.MAX_VALUE;

    public static List<List<String>> partition(String s) {
        cuts = Integer.MAX_VALUE;
        List<List<String>> res = new ArrayList<>();
        List<String> tmp = new ArrayList<String>();
        dfs(res, tmp, 0, s, table(s));
        return res;
    }

    public static void dfs(List<List<String>> res, List<String> tmp, int index, String s, boolean[][] T) {
        if (index == s.length()) {
            if (tmp.size() - 1 < cuts) {
                cuts = tmp.size() - 1;

                res.add(new ArrayList<>(tmp));
            }
        }

        for (int i = index; i < s.length(); i++) {
            if (T[index][i]) {
                tmp.add(s.substring(index, i + 1));
                dfs(res, tmp, i + 1, s,T);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static boolean[][] table(String s) {
        boolean[][] T = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            T[i][i] = true;
        }
        for (int i = 0; i < s.length(); i++) {
            //even
            int l = i - 1;
            int r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r))
                T[l--][r++] = true;
            //odd
            l = i - 1;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r))
                T[l--][r++] = true;
        }
        return T;
    }

    public static boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; j >= i; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            } else if (i == j || i == j - 1)
                break;
        }
        return true;
    }

    public static void main(String... args) {
        String test = "ab";
        System.out.print(partition(test).toString());
        System.out.print(cuts);
    }
}
