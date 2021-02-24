/**
 * @Author: liuxun05@meituan.com
 * @Date: 2021-01-19 23:17
 * @Description:
 */
public class Solution299 {
    public String getHint(String secret, String guess) {
     int a=0;
     int b=0;
     int sCount[]=new int[10];
     int gCount[]=new int[10];
     for(int i=0;i<secret.length();i++){
         if (secret.charAt(i)==guess.charAt(i)){
             a++;
             continue;
         }
         sCount[secret.charAt(i)-'0']++;
         gCount[guess.charAt(i)-'0']++;
     }
     for(int i=0;i<sCount.length;i++){
         b+=Math.min(sCount[i],gCount[i]);
     }






     return a+"A"+b+"B";
    }
}
