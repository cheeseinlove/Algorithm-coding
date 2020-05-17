import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-04-09 00:12
 * @Description:
 */
public class Solution1012 {
    public static void main(String[] args) {
        System.out.println(numDupDigitsAtMostN(125525456));
    }

    public static int numDupDigitsAtMostN(int N) {
        int i = N;
        int j=0;
        while (i > 0) {
            i/=10;
            j++;
        }
        return N-dfs(0,0,0,j,N)+1;
    }

    /**
     * 记忆化dfs超时了。。。
     * @param value
     * @param flag
     * @param index
     * @param n
     * @param target
     * @return
     */
    public static int dfs(int value, int flag, int index,int  n, int target) {
        if (index == n) {
            return 1;
        }
        int ans = 0;
        for (int i = 0; i <= 9; i++) {
            int cur=(int) (value + i * Math.pow(10, n - index - 1));
            if (cur>target){
                break;
            }
            //如果是前导0
            if (cur==0){
                ans += dfs( 0, 0, index + 1, n, target);
            }
            else if (cur <= target && ((flag & (1 << i)) == 0)) {
                ans += dfs(cur, flag | (1 << i), index + 1, n, target);
            }
        }
        return ans;
    }

}
