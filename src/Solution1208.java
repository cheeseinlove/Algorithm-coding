/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-09-16 22:46
 * @Description:
 */
public class Solution1208 {
    public static void main(String[] args) {
        String s="abcd";
        String t="bcdf";
        System.out.println(equalSubstring(s,t,3));
    }
    public static int equalSubstring(String s, String t, int maxCost) {

        int maxSize=0;
        int right=0;
        int left=0;
        int curCost=0;
        while (right<s.length()&&left<s.length()){
            curCost+=getCost(s.charAt(right),t.charAt(right));
            if (curCost>maxCost){
                while (curCost>maxCost){
                    curCost-=getCost(s.charAt(left),t.charAt(left));
                    left++;
                }
            }
            //先记录长度保证当前curCost<=maxCost
            maxSize=Math.max(maxSize,right-left+1);
           right++;


        }

        return maxSize;
    }


    //单个字符转换的差值
    public static int getCost(char s,char t){
        return Math.abs(s-t);
    }
}
