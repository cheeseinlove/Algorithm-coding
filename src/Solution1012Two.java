import java.util.Arrays;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-04-09 23:35
 * @Description:
 */
public class Solution1012Two {
    static int num[];
    static int dp[][][][];

    public static void main(String[] args) {
        System.out.println(numDupDigitsAtMostN(896089023));
    }
    public static int numDupDigitsAtMostN(int N) {
        int i = N;
        int N2=N;
        int j = 0;
        while (i > 0) {
            i /= 10;
            j++;
        }
        num = new int[j];
        int m = j;
        while (N2 > 0) {
            num[--m] = N2 % 10;
            N2 /= 10;
        }
        dp = new int[j][2][2][1 << 10];

        for (int a = 0; a < dp.length; a++) {
            for (int b = 0; b < dp[a].length; b++) {
                for (int c = 0; c < dp[a][b].length; c++) {
                    Arrays.fill(dp[a][b][c], -1);
                }
            }
        }

        return N - dfs(0, 1, 1, 0) + 1;
    }

    public static int dfs(int index, int isUp, int isZero, int used) {
        if (index == dp.length) {
            return 1;
        }
        //能被记忆化的部分为非上界组合，前面选的数一样，这样剩下数都是随便选所以符合条件的数一样多，假设N=4000前面选的数字的种类一样如123和321,最后一位选啥都行
        if (dp[index][isUp][isZero][used]!=-1){
            return dp[index][isUp][isZero][used];
        }
        int ans=0;
        //上界值
        int up=isUp==1?num[index]:9;
        for(int i=0;i<=up;i++){
            //当前选的数用过了
            if ((used&(1<<i))!=0){
                continue;
            }
            int isUp2=0;
            //是否为上界
            if (isUp==1&&i==num[index]){
                isUp2=1;
            }
            int isZero2=0;
            if (isZero==1&&i==0){
                isZero2=1;
            }
            //若是前导0则已用过的数不算
            int used2=isZero2==1?used:used|(1<<i);
            ans+=dfs(index+1,isUp2,isZero2,used2);
        }
        dp[index][isUp][isZero][used]=ans;
        return ans;
    }
}
