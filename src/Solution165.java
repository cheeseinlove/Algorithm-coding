/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-09-27 08:16
 * @Description:
 */
public class Solution165 {
    public static void main(String[] args) {
        System.out.println(compareVersion("1.01","1.001"));
    }
    public static int compareVersion(String version1, String version2) {
        String[] a1 = version1.split("\\.");
        String[] a2 = version2.split("\\.");

        for(int n = 0; n < Math.max(a1.length, a2.length); n++){
            int i = (n < a1.length ? Integer.valueOf(a1[n]) : 0);
            int j = (n < a2.length ? Integer.valueOf(a2[n]) : 0);
            if(i < j) return -1;
            else if(i > j) return 1;
        }
        return 0;
    }
}
