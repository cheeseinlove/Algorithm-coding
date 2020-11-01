/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-10-20 23:41
 * @Description:
 */
public class Solution680 {
    public static void main(String[] args) {
        System.out.println();
    }
    public static boolean validPalindrome(String s) {

        int i=0;
        int j=s.length()-1;
        while (i<j){
            if (s.charAt(i)!=s.charAt(j)){
              return validPalindrome(s,i,j-1)||validPalindrome(s,i+1,j);
            }
            i++;
            j--;
        }
        return true;
    }
    public static boolean validPalindrome(String s,int i,int j) {
        while (i<j){
            if (s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;

    }

}
