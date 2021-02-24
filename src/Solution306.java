/**
 * @Author: liuxun05@meituan.com
 * @Date: 2021-01-19 23:43
 * @Description:
 */
public class Solution306 {
    public boolean isAdditiveNumber(String num) {


        for (int i = 0; i < num.length() - 2; i++) {
            for (int j = i + 1; i < num.length() - 1; j++) {
                if (dfs(Long.valueOf(num.substring(0, i + 1)), Long.valueOf(num.substring(i + 1, j + 1)), num, j + 1)) ;
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(long a1, long a2, String num, int index) {
        if (index == num.length()) {
            return true;
        }

        for (int i = index + 1; i <= num.length(); i++) {
            long cur = Long.valueOf(num.substring(index, i));
            if (cur == a1 + a2) {
                return dfs(a2, cur, num, i);
            } else if (cur > a1 + a2) {
                return false;
            }
        }
        return false;
    }
}
