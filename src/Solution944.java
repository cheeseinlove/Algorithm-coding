/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-11-19 23:25
 * @Description:
 */
public class Solution944 {
    public int minDeletionSize(String[] A) {
        if (A.length == 0) {
            return 0;
        }
        int ans=0;
        int len = A[0].length();
        for(int i=0;i<len;i++){
            for(int j=0;j<A.length-1;j++){
                if (A[j].charAt(i)>A[j+1].charAt(i)){
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}
