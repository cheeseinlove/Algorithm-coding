/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-10-14 23:22
 * @Description:
 */
public class Solution557 {
    public String reverseWords(String s) {
     String[] strings=s.split(" ");
     StringBuilder sb=new StringBuilder();
     for(String ss:strings){
         sb.append(new StringBuilder(ss).reverse()).append(" ");
     }
     return sb.toString().trim();
    }
}
