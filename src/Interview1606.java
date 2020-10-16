import java.util.Arrays;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-10-13 23:43
 * @Description:
 */
public class Interview1606 {
    public static void main(String[] args) {
        int a[]=new int[]{-2147483648,1};
        int b[]=new int[]{2147483647,0};
        System.out.println(smallestDifference(a,b));
    }
    //排序后双指针，指针移动原则小的数往大的数靠拢
    public static int smallestDifference(int[] a, int[] b) {
        long ans = Integer.MAX_VALUE;
        Arrays.sort(a);
        Arrays.sort(b);

        int i = 0;
        int j = 0;
        //有一个指针出去了就结束
        while (i<a.length&&j<b.length){
            long diff=a[i]-b[j];
            if (diff<0){
                diff=-diff;
            }
            ans=Math.min(diff,ans);
            if (a[i]<b[j]){
                i++;
            }else {
                j++;
            }
        }

        return (int) ans;
    }
}
