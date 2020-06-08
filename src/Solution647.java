import java.util.Arrays;

/**
 * @Author liuxun05
 * @create 2020/2/27 23:01
 **/
public class Solution647 {
    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));
    }

    public static int countSubstrings(String s) {
        int len = s.length();
        int res=0;
        boolean dp[][] = new boolean[len][len];
          for(int k=1;k<=len;k++){
              for (int start=0;start<=len-k;start++){
                  int end=start+k-1;
                  if (start==end){
                      dp[start][end]=true;
                      res++;
                  }
                else if (s.charAt(start)==s.charAt(end)&&((end-start==1)||dp[start+1][end-1])){
                    dp[start][end]=true;
                    res++;
                }

              }
          }
        return res;
    }
}
