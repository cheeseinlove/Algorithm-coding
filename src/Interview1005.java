/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-09-03 09:28
 * @Description:
 */
public class Interview1005 {

    public static void main(String[] args) {
        String w[]=new String[]{"DirNnILhARNS hOYIFB", "SM ", "YSPBaovrZBS", "evMMBOf", "mCrS", "oRJfjw gwuo", "xOpSEXvfI"};
        String s="mCrS";
        System.out.println(findString(w,s));
    }
    public static int findString(String[] words, String s) {
        int ans = search(words, s, 0, words.length - 1);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static int search(String[] words, String s, int left, int right) {
        if (left > right) {
            return Integer.MAX_VALUE;
        }
        int mid = (right + left) >> 1;
        if (s.equals(words[mid])) {
            return mid;
        }
        if (words[mid].equals("")) {
            int leftIndex = search(words, s, left, mid - 1);
            if (leftIndex != Integer.MAX_VALUE) {
                return leftIndex;
            }
            return search(words, s, mid + 1, right);
        } else if (!isMore(s, words[mid])) {
            return search(words, s, left, mid - 1);
        } else {
            return search(words, s, mid + 1, right);
        }
    }

    public static boolean isMore(String target, String word) {
        return target.compareTo(word) > 0;
    }
}
