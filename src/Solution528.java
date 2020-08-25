import java.util.Random;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-08-19 23:18
 * @Description:
 */
public class Solution528 {
    //总和
    int sum;
    //前缀和
    int[] preSum;

    Random random=new Random();
    public Solution528(int[] w) {
        preSum = new int[w.length];
        int i=0;
        for (int j : w) {
            sum+=j;
            preSum[i++]=sum;
        }
    }

    public int pickIndex() {
        //随机数为[0,sum)
      int randKey=random.nextInt(sum);
      int left=0;
      int right=preSum.length-1;
      //概率即模拟为随机数在前缀和数组的区间
      while (left!=right){
          int mid=left+((right-left)>>1);
          if (randKey>=preSum[mid]){
              left=mid+1;
          }else {
              right=mid;
          }
      }
      return left;
    }
}
