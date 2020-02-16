import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author liuxun05
 * @create 2020/2/13 22:46
 **/
public class Solution354 {
    public static void main(String[] args) {
        int envelops[][] = new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        System.out.println(maxEnvelopes(envelops));
    }

    public static int maxEnvelopes(int[][] envelopes) {
        int maxEnv = Integer.MIN_VALUE;
        int len = envelopes.length;
        if (len < 2) {
            return len;
        }
        //套信封即下一个信封w,h均比上一个大才能套，类似于二维的最长自增子序列的问题，于是考虑将所有信封重新排序
        //若w,h均按升序排序再求h最长自增子序列会出错，因为w相同是不能套上的如{1,1},{1,2},{1,3}，所以将w升序，h倒序排序保证了h大的一定能套上
        // 按宽度升序排列，如果宽度一样，则按高度降序排列
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ?
                        b[1] - a[1] : a[0] - b[0];
            }
        });
        int dp[] = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            int maxSub=1;
            for(int j=i-1;j>=0;j--){
                if (envelopes[i][1]>envelopes[j][1]){
                    maxSub=Math.max(maxSub,dp[j]+1);
                }
            }
            dp[i]=maxSub;
            maxEnv = Math.max(maxEnv, dp[i]);
        }
        return maxEnv;
    }
}
