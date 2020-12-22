package week_competition;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-12-14 09:42
 * @Description:
 */
public class Solution5626 {
    public int minPartitions(String n) {
        if (n.length()==0){
            return 0;
        }
     int min=0;

     for(int i=0;i<n.length();i++){
         int j=(n.charAt(i)-'0');
         min=Math.max(min,j);
     }
     return min;
    }
}
