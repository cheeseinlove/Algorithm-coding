import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-08-13 23:26
 * @Description:
 */
public class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        List<Integer> intersection = new ArrayList<>();
        int index1 = 0, index2 = 0;
        while (index1 < length1 && index2 < length2) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                intersection.add(nums1[index1]);
                index1++;
                index2++;
            }
        }
        return intersection.stream().mapToInt(Integer::intValue).toArray();

    }


}
