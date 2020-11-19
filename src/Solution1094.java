import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-11-12 23:31
 * @Description:
 */
public class Solution1094 {
    public static void main(String[] args) {
        int tr[][]=new int[][]{{3,6,9},{10,2,3},{1,6,8},{2,1,6},{9,3,9}};
        System.out.println(carPooling(tr,12));
    }
    //最大乘车人数不超过容量，那么就是求区间的最大值了
    //将trips分解为两个数组，上车的，和下车的，每个时刻我只要关注上下车人数就好了，不需要关注trips
    public static boolean carPooling(int[][] trips, int capacity) {
      if(trips.length==0){
          return true;
      }
      int in_car[]=new int[1001];
      int off_car[]=new int[1001];
      for(int i=0;i<trips.length;i++){
          in_car[trips[i][1]]+=trips[i][0];
          off_car[trips[i][2]]+=trips[i][0];
      }
      int cur=0;
       for(int i=0;i<=1000;i++){
           cur=cur+in_car[i]-off_car[i];
           if (cur>capacity){
               return false;
           }
       }
        return true;
    }
}

