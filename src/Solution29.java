/*
给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
返回被除数 dividend 除以除数 divisor 得到的商。
假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。本题中，如果除法结果溢出，则返回 2^31 − 1。
 */
public class Solution29 {
    public static int divide(int dividend, int divisor) {
        //处理异常
        if(divisor==0) return 0;
        int max=Integer.MAX_VALUE;
        int min=Integer.MIN_VALUE;
        //处理最大最小值取模的情况.int类型的最小值取模会溢出。
        long divid = (long)dividend;
        long divi = (long)divisor;
        //减少重复运算
        if(divi==1) return (int) divid;
        if(divi==-1){
            //处理溢出
            if(divid==min)
                return max;
            return (int)-divid;
        }
        boolean flag=true;
        //true代表同号
        //处理符号
        if(divid<0){
            divid=-divid;
            if(divi<0){
                divi=-divi;
            }else{
                flag=false;
            }
        }else if(divi<0){
            divi=-divi;
            flag=false;
        }
        //商
        long res = 0;
        long tmp = 0;
        long cnt =1;
        while(divi<=divid){
            //2^n次方
            cnt = 1;
            tmp = divi;
            //找到第一个大于被除数的2^n次方
            while(tmp<=divid){
                tmp<<=1;
                cnt<<=1;
            }
            res+=(cnt>>1);
            //减去基数的前一个数
            divid-=(tmp>>1);
        }

        return flag?(int)res:(int)-res;
    }
    public static void main(String...args){
System.out.print(divide(100,7));




    }
}
