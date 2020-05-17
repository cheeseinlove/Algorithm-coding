import java.util.Arrays;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-05-14 22:17
 * @Description:
 */
//本体思路i,j双指针遍历段回文可能的每一个小段，只用遍历一半的字符长度因为段回文是对称的
public class Solution1147 {
    public static void main(String[] args) {
        System.out.println(longestDecomposition("volvo"));
    }
    public static int longestDecomposition(String text) {

        int n=text.length(),ans=1;
        //dp[i]表示0,i间若能构成段回文段数量
        int dp[]=new int[n/2+1];
        char[] char1=text.toCharArray();
        Arrays.fill(dp,-1);
        dp[0]=0;
        //设置比较回文的起点
        int left=0;
        //只用算半边就行了，最后再判断下中间是否有字符未处理
        for(int i=1;i<=n/2;i++)
            for(int j=left;j<i;j++){
                //[0:j]中没有段式回文，不用再去比较j后面的了
                if(dp[j]==-1) continue;
                if(!check(char1,j,i,n)) continue;
                dp[i]=dp[j]+1;
                //更新left起点,i前面的字符串是段氏回文了，已经处理好了。
                left=i;
            }
        //如果left*2<n说明最中间还有一段字符没有处理，就单独作为一个段氏回文。
        return Math.max(ans,dp[left]*2+(left*2<n?1:0));

    }
    public static boolean check(char[] char1,int j,int i,int n){
        //n-i为后面字符串的起点,(m-j)为每次增加的量
        for(int m=j;m<i;m++)
            if(char1[m]!=char1[n-i+(m-j)]) return false;
        return true;
    }


}
