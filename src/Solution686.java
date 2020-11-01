/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-10-22 23:03
 * @Description:
 */
public class Solution686 {
    /**
     首先我们应该知道，如果A的长度大于等于B的长度，这时B是A的重复叠加字符串只有两种情况，
     第一种就是本身B就是A的子串（比如A = “abcdefg”, B = “bcd”），
     第二种就是B是两个A的子串(A = “abcdefg”, B = “efgab”, 2 * A == “abcdefgabcdefg”)。
     如果A的长度小于B的长度，这时B是A的重复子串，则A的重复次数不超过 Bsize / Asize + 2。
     其中“Bsize / Asize”代表的B串中间A重复的次数，“+2”代表的首尾各添加一个A串。
     */
    public int repeatedStringMatch(String a, String b) {
     int lenA=a.length();
     int lenB=b.length();
     if (lenA>=lenB){
         if (a.contains(b)){
             return 1;
         }
         if ((a+a).contains(b)){
             return 2;
         }
         return -1;
     }else {
       int limit=lenB/lenA+2;
       StringBuilder sb=new StringBuilder();
       for(int i=1;i<=limit;i++){
           sb.append(a);
           if (sb.toString().contains(b)){
               return i;
           }
       }
         return -1;

     }


    }
}
