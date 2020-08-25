/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-08-20 23:34
 * @Description:
 */
public class Solution744 {
    public char nextGreatestLetter(char[] letters, char target) {
      int left=0;
      int right=letters.length-1;
      while (left<right){
          int mid=left+((right-left)>>1);
          if (letters[mid]<=target){
              left=mid+1;
          }else {
              right=mid;
          }
      }
      if (letters[left]<=target){
          return letters[0];
      }
      return letters[left];
    }
}
