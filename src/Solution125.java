/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-06-09 23:29
 * @Description:
 */
public class Solution125 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("1"));

//        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
    public static boolean isPalindrome(String s) {
        int left=0;
        int right=s.length()-1;
        char words[]=s.toCharArray();
        while (left<right){
            if (isInValid(words[left])){
                left++;
                continue;
            }
            if (isInValid(words[right])){
                right--;
                continue;
            }
            if ('a'<=words[left]&&words[left]<='z'){
                words[left]=(char)(words[left]-32);
            }
            if ('a'<=words[right]&&words[right]<='z'){
                words[right]=(char)(words[right]-32);
            }
            if (words[left]!=words[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;

    }
    public static boolean isInValid(char c){
        if (('0'<=c&&c<='9')||('a'<=c&&c<='z')||('A'<=c&&c<='Z')){
            return false;
        }
        return true;
    }
}
