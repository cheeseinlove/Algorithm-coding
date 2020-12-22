/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-12-09 20:06
 * @Description:
 */
public class Solution1616 {
    public boolean checkPalindromeFormation(String a, String b) {
     return check(a,b)||check(b,a);
    }
    //只需要两个字符串连起来，首尾两端的回文串长度为单个字符串的长度即可
    private boolean check(String a,String b){
        char[] stra = a.toCharArray();
        char[] strb = b.toCharArray();
        int left = 0;
        int length = stra.length;
        //找到首尾最长开始不等的位置
        while (left<=length/2){
            if (stra[left]==strb[length-1-left])
                left++;
            else
                break;
        }
        //如果超过一半都是相等的，直接返回true
        if (left>=length/2)
            return true;
        //否则判断中间未遍历的部分是否是回文
        if (isPa(a.substring(left,length-left)) || isPa(b.substring(left,length-left)))
            return true;
        return false;
    }

    //判断是否回文
    private boolean isPa(String string){
        char[] str  =string.toCharArray();
        for (int i=0;i<str.length/2;i++){
            if (str[i]!=str[str.length-1-i])
                return false;
        }
        return true;
    }

}
