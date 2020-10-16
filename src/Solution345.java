/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-09-28 09:25
 * @Description:
 */
public class Solution345 {
    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
    }
    public static String reverseVowels(String s) {
      int l=0;
      int r=s.length()-1;
        char[] arr = s.toCharArray();
        while (l<r){
          while (l<r&&!isVowel(arr[l])){
              l++;
          }
          char ll=arr[l];
          while (l<r&&!isVowel(arr[r])){
              r--;
          }
          char rr=arr[r];
          if (l<r){
              arr[l]=rr;
              arr[r]=ll;
          }
            l++;
            r--;
      }
        return new String(arr);
    }
    public static boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                ||ch=='A'|| ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';

    }
}
