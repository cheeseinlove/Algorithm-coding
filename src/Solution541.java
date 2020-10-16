/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-10-14 09:28
 * @Description:
 */
public class Solution541 {
    public static void main(String[] args) {
        String s="abcdefghqw";
        System.out.println(reverseStr(s,2));
    }
    public static String reverseStr(String s, int k) {
       StringBuilder sb=new StringBuilder();
       StringBuilder temp=new StringBuilder();
       int j=1;
       for(int i=0;i<s.length();i++){
           if (j<=k){
               temp.append(s.charAt(i));
               j++;
           }else {
               if (temp.length()>0) {
                   sb.append(temp.reverse());
                   temp.setLength(0);
               }
               sb.append(s.charAt(i));
           }
           if ((i+1)%(2*k)==0){
               j=1;
           }
       }
        if (temp.length()>0) {
            sb.append(temp.reverse());
        }

       return sb.toString();
    }
}
