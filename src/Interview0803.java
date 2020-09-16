/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-09-02 23:15
 * @Description:
 */
public class Interview0803 {
    public int findMagicIndex(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        int ans = search(nums, left, right);
        return ans == Integer.MAX_VALUE ? -1 : ans;

    }

    public int search(int[] nums, int left, int right) {
        int min = Integer.MAX_VALUE;
        if (left>right){
            return min;
        }
        int mid = (left + right) >> 1;
        if (nums[mid] == mid) {
            min = Math.min(min, mid);
        }
        int leftMin = search(nums, left, mid - 1);
        min = Math.min(leftMin, min);
        //如果左边和中间都没有，返回右边结果
        if (min == Integer.MAX_VALUE) {
            return search(nums, mid + 1, right);
        }
        return min;
    }
}
