import java.util.Arrays;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-04-13 22:34
 * @Description:
 */
//一个范围内的数二进制中0的数目不小于1有多少种
public class POJ3252 {
    static int nums[];
    static int dp[][];

    public static void main(String[] args) {
        System.out.println(digitsDp(12) );
    }

    public static int digitsDp(int target) {
        nums = new int[33];
        int i = 0;
        while (target > 0) {
            nums[i++] = target&1;
            target = target>>1;
        }
        dp = new int[33][2 * 32 + 1];
        for (int j = 0; j < dp.length; j++) {
            Arrays.fill(dp[j], -1);
        }
        //status默认为10是为了防止越界有负数
        return dfs(i - 1, 32, true, true,"");
    }

    /**
     * status代表截止到当前位置0比1不小于的数字情况数
     *
     * @param pos
     * @param status
     * @param isZero
     * @param isUp
     * @return
     */
    public static int dfs(int pos, int status, boolean isZero, boolean isUp,String s) {
        if (pos == -1) {
            if (status - 32 >= 0) {
                return 1;
            } else {
                return 0;
            }
        }
        if (!isUp && dp[pos][status] != -1) {

            return dp[pos][status];
        }
        int up = isUp ? nums[pos] : 1;
        int ans = 0;
        for (int j = 0; j <= up; j++) {
            if((s+j).equals("000")){
                System.out.println(ans+"   "+s+j);
            }
            boolean isUp2=isUp&&j==nums[pos];
            if (isZero&&j==0){
                ans+=dfs(pos-1,status,isZero,isUp2,s+j);
                System.out.println(ans+"   "+s+j);
            }else {
                int status2=0;
                if (j==0){
                    status2=status+1;
                }
                if (j==1){
                    status2=status-1;
                }
                ans+=dfs(pos-1,status2,isZero&&j==0,isUp2,s+j);
                System.out.println(ans+"   "+s+j);

            }



        }

        if (!isUp ) {
            dp[pos][status] = ans;
        }
        return ans;
    }

}
