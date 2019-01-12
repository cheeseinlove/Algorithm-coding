/*leetcode 415
给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
注意：
num1 和num2 的长度都小于 5100.
num1 和num2 都只包含数字 0-9.
num1 和num2 都不包含任何前导零。
你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 */
public class BigIntegerAdd {
    public static String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder(5200);
        int carry = 0;
        int l1 = num1.length();
        int l2 = num2.length();
        while(l1>0 || l2 > 0 || carry > 0) {
            int tem = carry;
            if(l1 > 0) {
                l1--;
                tem = tem + num1.charAt(l1) - '0';
            }
            if(l2 > 0) {
                l2--;
                tem = tem + num2.charAt(l2) - '0';
            }
            carry = tem/10;
            result.append(tem%10);
        }
        return result.reverse().toString();
//        String result = "";
//        char[] n1 = num1.toCharArray();
//        char[] n2 = num2.toCharArray();
//        if(num1.length() < num2.length()) {
//            n1 = n2;
//            n2 = num1.toCharArray();
//        }
//
//        int l1 = n1.length;
//        int l2 = n2.length;
//        int carry = 0;
//        for (int i = l2-1; i >= 0; i--) {
//            l1--;
//            int p = n2[i] + n1[l1] - '0'*2 + carry;
//            carry = p/10;
//            result = p%10 +result;
//        }
//        for(l1--;l1 >= 0;l1--) {
//            int p = n1[l1] - '0' + carry;
//            carry = p/10;
//            result = p%10 + result;
//        }
//        if(carry != 0) {
//            result = carry + result;
//        }
//        return result;
    }


    public static void main(String... args) {
    System.out.println(addStrings("6849","321"));

    }
}
