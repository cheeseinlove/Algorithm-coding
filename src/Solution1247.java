/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-11-23 08:36
 * @Description:
 */
public class Solution1247 {

    //先换连续的如YY-XX这种只需要一次交换，而XY-YX需要两次
    public int minimumSwap(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return -1;
        }
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();


        // 当s1[i]!=s2[i]时，如果s1[i]=x，那么c1++；如果s1[i]=y，那么c2++；
        // 偶数个c1代表着（xx，yy），需要一次交换
        // 偶数个c2代表着（yy，xx），需要一次交换
        // 一个c1+一个c2代表着（xy，yx）或（yx，xy），需要两次交换
        // 优先考虑一次交换
        int c1=0,c2=0;
        for(int i=0;i<ch1.length;i++){
            if(ch1[i]!=ch2[i]){
                if(ch1[i]=='x') c1++;
                else c2++;
            }
        }
        //若X或Y的总数为奇数那么返回-1
        if((c1+c2)%2==1) return -1;
        //xyCnt+yxCnt肯定是个偶数，那么又分两种情况，即“奇数+奇数”和“偶数+偶数”；
        //基于上面的分析，可以发现每2个xyCnt或yxCnt对应一次移动，1个xyCnt与1个yxCnt对应两次移动
        if (c1 % 2 != 0) {
            return c1 / 2 + c2 / 2 + 2;
        } else {
            return c1 / 2 + c2 / 2;
        }

  }
}
