/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-10-14 23:14
 * @Description:
 */
public class Solution551 {
    public boolean checkRecord(String s) {
        int countA = 0;
        int serialL = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                serialL = 0;
                countA++;
            } else if (s.charAt(i) == 'L') {
                serialL++;
            } else {
                serialL = 0;
            }
            if (countA > 1 || serialL > 2) {
                return false;
            }
        }
        return true;
    }
}
