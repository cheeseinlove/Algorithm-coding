import java.util.Arrays;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-12-07 23:33
 * @Description:
 */
public class Solution1663 {
    //保证字典序最小，优先从右开始放置较大值的字符
    public String getSmallestString(int n, int k) {
        char ans[] = new char[n];
        Arrays.fill(ans, 'a');
        if (n == k) {
            return String.valueOf(ans);
        }
        char v='a';
        char val[]=new char[26];
        for(int i=0;i<val.length;i++){
            val[i]=v++;
        }
        int sum=n;
        for(int i=ans.length-1;i>=0;i--){
            if (k-sum>25){
                ans[i]='z';
                sum+=25;
            }else {
                ans[i]=val[k-sum];
                break;
            }
        }
        return String.valueOf(ans);
    }
}
