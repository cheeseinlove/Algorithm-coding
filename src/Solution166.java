import java.util.HashMap;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-06-11 23:44
 * @Description:
 */
public class Solution166 {
    public static void main(String[] args) {
        int numerator1 = 1;
        int denomenator1 = 2;
        int numerator2 = 2;
        int denominator2 = 3;
        System.out.println(fractionToDecimal(numerator1, denomenator1));
        System.out.println(fractionToDecimal(numerator2, denominator2));
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        long num = numerator;
        long den = denominator;
        String sign = "";
        //确定符号
        if (num > 0 && den < 0 || num < 0 && den > 0) {
            sign = "-";
        }
        //转为正数
        num = Math.abs(num);
        den = Math.abs(den);
        //记录整数部分
        long integer = num / den;
        //计算余数
        num = num - integer * den;
        //key为当前余数，value为每一个余数除了后的商，记录位置的目的是找到循环节，value为当前小数字符串的索引位置，因为当前余数*10会作为下一次除法计算的被除数，若发现余数相同则
        HashMap<Long, Integer> map = new HashMap<>();
        int index = 0;
        String decimal = "";//记录小数部分
        int repeatIndex = -1;//保存重复的位置
        while (num != 0) {
            num *= 10;//余数乘以 10 作为新的被除数
            if (map.containsKey(num)) {
                //找到循环节break
                repeatIndex = map.get(num);
                break;
            }
            //保存被除数
            map.put(num, index);
            //保存当前的商
            long decimalPlace = num / den;
            //加到所有的商中
            decimal = decimal + decimalPlace;
            //计算新的余数
            num = num - decimalPlace * den;
            index++;
        }
        //是否存在循环小数
        if (repeatIndex != -1) {
            String dec = decimal;
            return sign + integer + "." + dec.substring(0, repeatIndex) + "(" + dec.substring(repeatIndex) + ")";
        } else {
            if (decimal == "") {
                return sign + integer;
            } else {
                return sign + integer + "." + decimal;
            }
        }
    }


}
