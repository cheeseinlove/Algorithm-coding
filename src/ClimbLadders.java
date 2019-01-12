/*
爬梯子一次爬一楼或两楼，n楼有多少种爬法,n>0
 */
public class ClimbLadders {
    public static int climb(int n){
        if (n<2)
            return n;
        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++)
            dp[i]=dp[i-2]+dp[i-1];
        return dp[n];


    }
    public static void main(String...args){
        System.out.println(climb(4));

    }
}
