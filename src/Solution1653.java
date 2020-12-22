/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-12-09 22:56
 * @Description:
 */
public class Solution1653 {
    public static void main(String[] args) {
        minimumDeletions("bbaaaaabb");
    }
    public static int minimumDeletions(String s) {
        if (s.length()<2){
            return 0;
        }
        //当前位置以a结尾需要最小删除次数
        int[] dpA = new int[s.length()];
        // 当前位置以b结尾需要最小删除次数
        int[] dpB = new int[s.length()];

        if (s.charAt(0)=='a'){
            dpB[0]=1;
        }else {
            dpA[0]=1;
        }

        for(int i=1;i<s.length();i++){
            if (s.charAt(i)=='a'){

                dpA[i]=dpA[i-1];
                //删除当前的a且只能由上一位是b转化而来
                dpB[i]=dpB[i-1]+1;
            }else {
                //当前是b，但是要以a结尾只能是由a结尾转化，且删掉b
                dpA[i]=dpA[i-1]+1;
                //当前是b以b结尾则可以由两种状态转化
                dpB[i]=Math.min(dpA[i-1],dpB[i-1]);
            }
        }


        return Math.min(dpA[s.length() - 1], dpB[s.length() - 1]);
    }
}
