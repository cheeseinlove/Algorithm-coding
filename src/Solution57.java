import java.util.Arrays;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-06-07 12:02
 * @Description:
 */
public class Solution57 {
    public static void main(String[] args) {
        int intervals[][] = new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};

        int newI[]=new int[]{4,8};

        int [][]ans=insert(intervals,newI);
        for(int []a:ans){
            System.out.println(a[0]+" "+a[1]);
        }


    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int lenght= intervals.length;
        int[][] tmp=new int[lenght+1][2];
        int size=0,p=0;
        for (;p<intervals.length&&intervals[p][0]<newInterval[0];++p){
            tmp[size++]=intervals[p];
        }
        if (size==0||tmp[size-1][1]<newInterval[0]){   //表示没有重叠，直接追加
            tmp[size++]=newInterval;
        }else {
            tmp[size-1][1]=Math.max(tmp[size-1][1],newInterval[1]);
        }

        for (;p<intervals.length;++p){
            if (tmp[size-1][1]<intervals[p][0]){    //表示没有重叠，直接追加
                tmp[size++]=intervals[p];
            }else {
                tmp[size-1][1]=Math.max(tmp[size-1][1],intervals[p][1]);
            }
        }
        return Arrays.copyOf(tmp,size);



    }
}
