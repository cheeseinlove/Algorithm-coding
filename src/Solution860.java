/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-11-17 09:33
 * @Description:
 */
public class Solution860 {
    public static void main(String[] args) {
        int b[]=new int[]{5,5,10,20,5,5,5,5,5,5,5,5,5,10,5,5,20,5,20,5};
        System.out.println(lemonadeChange(b));
    }
    //10元找零需要5元，20找零需要15，15优先用10元找
    public static boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
                continue;
            } else if (bills[i] == 10) {
                if (five <= 0) {
                    return false;
                }
                ten++;
                five--;
            } else {
                if (ten > 0&&five>0) {
                    ten--;
                    five--;
                } else {
                    if (five - 3 < 0) {
                        return false;
                    }
                    five -= 3;
                }
            }
        }
        return true;
    }
}
