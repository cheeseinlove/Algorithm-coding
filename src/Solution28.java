/*
给定一个 haystack 字符串和一个 needle 字符串，
在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 */
public class Solution28 {
    public static int strStr(String haystack, String needle) {
        if (haystack==null||needle==null)
            return -1;
        int len1=haystack.length();
        int len2=needle.length();
        if (len2==0)
            return 0;
        if (len1<len2)
            return -1;
        int start=-1;
        int i=0,j=0;

        while (i<len1){
            if (haystack.charAt(i)==needle.charAt(j)&&start<0){
                start=i;
                j++;
            }
            else if (start>=0){
                if (haystack.charAt(i)==needle.charAt(j))
                    j++;
                else {
                    i=start;
                    start=-1;
                    j=0;
                }
            }
            i++;
            if (j==len2)
                return start;
        }
            return -1;


    }
    public static void main(String...args){
          String s1="aaa";
          String s2="aa";
          System.out.print(strStr(s1,s2));
    }
}
