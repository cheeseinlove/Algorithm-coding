/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-09-01 23:41
 * @Description:
 */
public class Solution1201 {

    public int nthUglyNumber(int n, int a, int b, int c) {
        if (a == 1 || b == 1 || c == 1) return n;

        // 两两组合的最小公倍数
        long lcmAB = lcm(a, b);
        long lcmAC = lcm(a, c);
        long lcmBC = lcm(b, c);
        // 三个数的最小公倍数
        long lcm = lcm(lcmAB, c);

        int min = Math.min(Math.min(a,b),c);
        long left = min, right =(long)Math.pow(min,n);
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long count = mid / a + mid / b + mid / c - mid / lcmAB - mid / lcmAC - mid / lcmBC + mid / lcm;
            if(count == n){
                left = mid;
                break;
            } else if (count > n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return (int)(left - Math.min(Math.min(left % a,left % b),left % c));
    }

    // 最小公倍数
    private long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    // 最大公因数
    private long gcd(long a, long b) {
        while (b>0){
            long temp=a%b;
            a=b;
            b=temp;
        }
        return a;
    }
}
