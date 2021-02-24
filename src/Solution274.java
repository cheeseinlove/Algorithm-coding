import java.util.Arrays;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2021-01-14 23:28
 * @Description:
 */
public class Solution274 {
    public int hIndex(int[] citations) {
            if (citations.length==0){
                return 0;
            }
            int n=citations.length;
            Arrays.sort(citations);
            int ans = citations[0]==0?0:1;
            int j=0;
            for (int i = 0; i <= citations[n-1]; i++) {
                if (citations.length - j >= i) {
                    ans = Math.max(ans, i);
                }
                while (j<n&&i==citations[j]){
                    j++;
                }

            }
            return ans;

    }
}
