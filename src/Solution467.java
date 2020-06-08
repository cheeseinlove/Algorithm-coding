/**
 * @Author liuxun05
 * @create 2020/2/19 20:28
 **/
public class Solution467 {
    public static void main(String[] args) {

    }
    public static int findSubstringInWraproundString(String p) {
        int len = p.length();
        if (len == 0) return 0;
        int[] map = new int[26];
        //dp代表当前i位置结尾的最长子串长度
        int dp = 0;
        int sum = 0;
        char[] arr = p.toCharArray();
        for (int i=0; i<len; i++) {
            char c = arr[i];
            //若arr[i]和arr[i-1]连续则dp++
            if (i == 0 || (c-arr[i-1] -1)%26 == 0) {
                dp++;
            } else dp = 1;
            int cnt = map[c-'a'];
            if (dp > cnt) {
                //这里有个技巧，相同结尾的子串，长度差即为新增的子串种类数目如abyzab,a和yza都是a结尾，一个dp为1，一个dp为3，新增子串种类为2即yza，za
                sum += dp - cnt;
                map[c-'a'] = dp;
            }
        }
        return sum;


    }
}
