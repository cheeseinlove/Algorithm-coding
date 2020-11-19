import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-11-09 10:29
 * @Description: 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以纵坐标并不重要，因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。
 * <p>
 * 一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 * <p>
 * 给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。
 * <p>
 *  
 * 示例 1：
 * <p>
 * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
 * 输出：2
 * 解释：对于该样例，x = 6 可以射爆 [2,8],[1,6] 两个气球，以及 x = 11 射爆另外两个气球
 */
public class Solution452 {
    public static void main(String[] args) {
        int a[][] = new int[][]{{-2147483646, -2147483645}, {2147483646, 2147483647}};

        System.out.println(findMinArrowShots(a));
    }

    //贪心的思想要使弓箭数量最小就要让一根箭射穿更多的气球,这道题有点像合并区间
    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return Integer.compare(o1[0], o2[0]);
                }
                return Integer.compare(o1[1], o2[1]);
            }
        });
        int sum = 1;
        int l = points[0][0];
        int r = points[0][1];
        //三种情况A,B而言，1.AB完全分离,sum++，2.AB部分相接，3.AB完全包含，后面两种情况取公共部分来达到局部贪心最优
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > r) {
                sum++;
                l = points[i][0];
                r = points[i][1];
            } else if (points[i][0] >= l && points[i][1] <= r) {
                l = points[i][0];
                r = points[i][1];
            } else {
                l = points[i][0];
            }
        }

        return sum;
    }
}
