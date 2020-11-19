import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-11-11 09:20
 * @Description:
 */
public class Solution435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length==0){
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1]==o2[1]){
                    return o1[0]-o2[0];
                }
                return o1[1]-o2[1];
            }
        });

        int sum=0;
        int l=intervals[0][0];
        int r=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            //若a,b分离则当前区间取b
            if (intervals[i][0]>=r){
                l=intervals[i][0];
                r=intervals[i][1];
                //若a,b有交集但不包含，窗口取a，取消b区间，因为b可能影响之前或之后的区间，影响面更广
            }else if (intervals[i][1]>r){
                //取消当前i的区间
                sum++;
                //若b包含a，但是b的左边界总是大于等于a的左边界，窗口取b，取消a区间，因为a更长
            }else {
                sum++;
                l=intervals[i][0];
                r=intervals[i][1];
            }
        }
        return sum;
    }
}
