package week_competition;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-12-14 09:36
 * @Description:
 */
public class Solution5625 {
    public int numberOfMatches(int n) {
        if (n==1){
            return 0;
        }
        int nectSize=n/2+n%2;
        return n/2+numberOfMatches(nectSize);
    }
}
