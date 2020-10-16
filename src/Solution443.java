/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-09-30 09:37
 * @Description:
 */
//输入：
//['a','b','b','b','b','b','b','b','b','b','b','b','b']
//
//输出：
//返回 4 ，输入数组的前4个字符应该是：['a','b','1','2']。
//压缩后的长度必须始终小于或等于原数组长度。
//
//数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
//
//在完成原地修改输入数组后，返回数组的新长度。
//
// 

public class Solution443 {
    public static void main(String[] args) {
        char[] chars= new char[]{'a','a','b','b','c','c','c'};
        int len=compress(chars);
        for(int i=0;i<len;i++){
            System.out.print(chars[i]+" ");
        }
//        System.out.println(compress(chars));
    }
    public static int compress(char[] chars) {
        int ans = 0;
        int curNum = 0;
        //写指针
        int write=0;
        //读指针
        int read=0;
        char curChar=chars[0];
        while (read < chars.length) {
            //初始化
            curChar=chars[read];
            curNum = 1;
            while (read + 1 < chars.length && chars[read] == chars[read + 1]) {
                curNum++;
                read++;
            }
            chars[write++]=curChar;
            String num=String.valueOf(curNum);
            int j=0;
            //尾数大于1才写数字
            while (curNum>1&&j<num.length()){
                chars[write++]=num.charAt(j++);
            }
            read++;
        }
        return write;
    }

    //判断几位数占几位，b2
    public static int getLen(int num) {
        if (num == 1) {
            return 1;
        }
        int ans = 0;
        while (num > 0) {
            num /= 10;
            ans++;
        }
        //字母本身占一位
        return ans + 1;
    }
}
