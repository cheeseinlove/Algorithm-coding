/**
 * @Author liuxun05
 * @create 2020/2/26 22:46
 **/
public class Solutiojn600 {
    public static void main(String[] args) {
        System.out.println(findIntegers(9));
    }
    //n比特的数有多少个符合要求的组合，满足菲波那切数列
    static int  fib(int n) {
        if (n <= 0) return 1;
        if (n == 1) return 2;
        int a = 1;
        int b = 2;
        int c = 3;
        int i = n - 2;
        while(i-->0) {
            a = b;
            b = c;
            c = a + b;
        }

        return c;
    }

   static int  findIntegers(int num) {
        if (num == 0) return 1;
        if (num == 1) return 2;
        int nbits = 0;
        //计算Num的数转二进制有几位
        while((num>>nbits)>0) {
            ++nbits;
        }
        //如果当前数以11开头，那么就是fib[n],因为fib[n]刚好是除了11开头所有的满足条件的数且值更小
        if (num>>(nbits - 2) == 3) {
            return fib(nbits);
        } else {
            //如果数10开头 就是dp[n-1]+这个数的低(n - 2)位满足要求的数字个数。
            int mask = (1 << (nbits - 1)) - 1;
            return fib(nbits - 1) + findIntegers(num & mask);
        }
    }

}
