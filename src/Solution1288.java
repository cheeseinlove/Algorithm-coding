import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-11-24 23:13
 * @Description:
 */
public class Solution1288 {
    public int removeCoveredIntervals(int[][] intervals) {
        if (intervals.length==0){
            return 0;
        }
        //按照起始区间升序，结束区间降序排序，因为这样只用判断后面的结束区间是不是小于等于前一区间就好了
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]){
                    return o2[1]-o1[1];
                }
                return o1[0]-o2[0];
            }
        });
        //重叠次数
        int ans=0;
        int l=intervals[0][0];
        int r=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            //二者分离
            if (intervals[i][0]>=r){
                l=intervals[i][0];
                r=intervals[i][1];
            //包含取大的
            }else if(intervals[i][1]<=r){
                ans++;
            //相交取右边的区间
            }else {
                l=intervals[i][0];
                r=intervals[i][1];
            }

        }

        return intervals.length-ans;
    }
}
