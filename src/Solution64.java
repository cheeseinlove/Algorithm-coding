/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-06-04 09:09
 * @Description:
 */
public class Solution64 {
    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
        long m=2147395599l*21473l;
        System.out.println(m);
    }

    public static int mySqrt(int x) {

         if (x<2){
             return x;
         }

         long left=1;
         long right=x;
         while (left<=right){
             long mid=left+(right-left)/2;
             long m=mid*mid;
             long n=(mid+1)*(mid+1);
             if (m==x){
                 return new Long(mid).intValue();
             }
             else if (m>x){
                 right=mid-1;
             }
             else if (m<x){
                 if (n>x){
                     return new Long(mid).intValue();
                 }
                 left=mid+1;
             }
         }
         return -1;
    }
}
