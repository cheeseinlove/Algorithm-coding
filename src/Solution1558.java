import java.util.Arrays;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-12-02 21:12
 * @Description:
 */
public class Solution1558 {
    public static void main(String[] args) {
        int []n=new int[]{1000000000};
        System.out.println(minOperations(n));
    }
    //乘法可以复用，加法不能复用，总次数=每个数的减法次数+最大数触除法次数,
    //我们只需要统计序列中所有数的二进制表示中 1 的数量之和，即可统计出减法操作的数量。而第二种除法操作是全体数共同执行的，它的执行次数取决于序列中所有数的二进制表示的最高位数。我们只需要记录序列中最大值的二进制表示的位数，即可算出第二种除法操作的数量。
    public static int minOperations(int[] nums) {
        int count = 0;
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            count += Integer.bitCount(num);
        }
        count += Integer.toBinaryString(max).length() - 1;
        return count;
    }
//    public static int countPlus(int value){
//        int ans=0;
//        if (value==0){
//            return 0;
//        }
//        ans+=1;
//        int log2=log(2,value);
//
//        ans+=value-Math.pow(2,log2);
//        return ans;
//    }
//    public static int log(int base,int n){
//        return (int) (Math.log(n)/Math.log(base));
//    }

}
