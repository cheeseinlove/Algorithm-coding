/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-09-16 11:33
 * @Description:
 */
public class Solution1052 {
    public static void main(String[] args) {
        int []cus=new int[]{3};
        int []grum=new int[]{1};
        int x=1;
        System.out.println(maxSatisfied(cus,grum,x));
    }
    //问题可以转化为在小于等于X的区间内，求"老板生气：1"对应客户的和的最大值
    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {

        int total0=0;
        int left=0;
        int right=0;
        int max=0;
        int cur1=0;
        if (grumpy[0]==1){
            cur1=customers[0];
            max=customers[0];
        }else {
            total0=customers[0];
        }

        while (right<grumpy.length&&left<customers.length){
            int len =right-left+1;

            //当前窗口长度不够时尽可能新增
            if (len<X){
                right++;
                if (right<grumpy.length&&grumpy[right]==0){
                    total0+=customers[right];
                }
                if (right<grumpy.length&&grumpy[right]==1) {
                    cur1+=customers[right];
                    max=Math.max(max,cur1);
                }
            }else {
                if (grumpy[left]==1){
                    cur1-=customers[left];
                }
                left++;
            }

        }


        return max+total0;

    }
}
