import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-03-24 22:57
 * @Description:
 */
public class Solution1140 {
    static int len;

    public static void main(String[] args) {
        System.out.println(stoneGameII3(new int[]{2, 7, 9, 4, 4}));
    }

    public static int stoneGameII(int[] piles) {
        len = piles.length;
        int preSum[] = new int[len + 1];
        for (int i = 0; i < len; i++) {
            preSum[i + 1] =preSum[i]+ piles[i];
        }
        //缓存，在起始位置为start且M时的最大分数
        Map<Integer, Map<Integer, Integer>> cache = new HashMap<>();
        return maxScore(0, 1, cache, preSum);
    }

    public static int maxScore(int start, int M, Map<Integer, Map<Integer, Integer>> map, int preSum[]) {
        if (map.containsKey(start) && map.get(start).containsKey(M)) {
            return map.get(start).get(M);
        }
        if (start >= len) {
            return 0;
        }

        int max = 0;
        for (int i = 1; i <= 2 * M; i++) {
            int Y = Math.max(i, M);
            //后一位选手的最大分数
            int nextMax = maxScore(start + i, Y, map, preSum);
            //这里最重要，当前选手最大分数为，总分数-后一位的最大分数-start之前的分数
            max = Math.max(max, preSum[len] - preSum[start] - nextMax);
        }
        Map<Integer, Integer> map1 = new HashMap<>();
        map1.put(M, max);
        map.put(start, map1);
        return max;
    }

    public static int stoneGameII2(int[] piles) {
        len = piles.length;
        int preSum[] = new int[len + 1];
        for (int i = 0; i < len; i++) {
            preSum[i + 1] =preSum[i]+ piles[i];
        }
        int dp[][]=new int[len+1][len+1];
        for(int i=len-1;i>=0;i--){
            //为什么m上线是i因为m是从之前的已选择的堆数最大值,起始位置i=0,m=1是特殊情况
            for(int m=1;m<=i||m==1;m++){
                for(int j=1;j<=Math.min(2*m,len-i);j++){
                    dp[i][m]=Math.max(dp[i][m],preSum[len]-preSum[i]-dp[i+j][Math.max(j,m)]);
                }
            }
        }
    return dp[0][1];
    }
    public static int stoneGameII3(int[] piles) {
        len= piles.length;
        int preSum[] = new int[len + 1];
        for (int i = 0; i < len; i++) {
            preSum[i + 1] =preSum[i]+ piles[i];
        }
        int dp[][][]=new int[len+1][len+1][2];
        for(int i=len-1;i>=0;i--){
            //为什么m上线是i因为m是从之前的已选择的堆数最大值,起始位置i=0,m=1是特殊情况
            for(int m=1;m<=i||m==1;m++){
                for(int j=1;j<=Math.min(2*m,len-i);j++){
                    if(dp[i][m][0]<preSum[i+j]-preSum[i]+dp[i+j][Math.max(j,m)][1]){
                        dp[i][m][0]=preSum[i+j]-preSum[i]+dp[i+j][Math.max(j,m)][1];
                        dp[i][m][1]=dp[i+j][Math.max(j,m)][0];
                    }
                }
            }
        }
        return dp[0][1][0];
    }

}
