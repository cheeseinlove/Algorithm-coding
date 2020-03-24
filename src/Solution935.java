/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-03-23 00:11
 * @Description:
 */
public class Solution935 {
    public static void main(String[] args) {
        System.out.println(knightDialer(161));
    }
    //定义四个状态A(1,3,7,9),B(2,8),C(4,6),D(0)
    //An代表走了n步到A的结果数
    //An=2(Bn-1+Cn-1),Bn=An-1,Cn=2Dn-1+An-1,Dn=Cn-1
    public static int knightDialer(int N) {
        long cns=1000_000_007;
       long nums[]=new long[]{4,2,2,1};
       if(N==1){
           //特殊情况能走5
        return 10;
       }
       for(int i=2;i<=N;i++){
           long a=nums[0];
           long b=nums[1];
           long c=nums[2];
           long d=nums[3];
           nums[0]=(2*(b+c))%cns;
           nums[1]=a%cns;
           nums[2]=(a+2*d)%cns;
           nums[3]=c%cns;
       }
       return (int) ((nums[0]+nums[1]+nums[2]+nums[3])%cns);
    }
}
