import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-06-12 12:32
 * @Description:
 */
public class Solution176 {
    public static void main(String[] args) {
        int nums[] = new int[]{3, 30, 34, 5, 9};
        System.out.println(largestNumber(nums));
    }

    public static String largestNumber(int[] nums) {
        Integer[] numsCopy = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsCopy[i] = nums[i];
        }
        //降序排列
        Arrays.sort(numsCopy, new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                int len1 = (n1 + "").length();
                int len2 = (n2 + "").length();
                //长度相同，值大的放前面
                if (len1 == len2) {
                    if (n1 > n2) {
                        return -1;
                    } else if (n1 < n2) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
                //长度不同考虑换位
                int ans1 = (int) (n1 * Math.pow(10, len2)+n2);
                int ans2 = (int) (n2 * Math.pow(10, len1)+n1);
                //n1放前面值更大
                if (ans1 > ans2) {
                    return -1;
                    //n2放前面值更大
                } else if (ans1 < ans2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i : numsCopy) {
            sb.append(i);
        }
        String res = sb.toString();
        return res.charAt(0) == '0' ? "0" : res;
    }


}
