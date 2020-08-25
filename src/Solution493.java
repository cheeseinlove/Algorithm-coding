/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-08-19 09:33
 * @Description:
 */
public class Solution493 {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return mergeSort(nums, new int[nums.length], 0, nums.length - 1);
    }

    public int mergeSort(int[] nums, int[] cache, int left, int right) {
        if (left >= right) return 0;

        int mid = left + ((right - left) >>> 1);
        int count = mergeSort(nums, cache, left, mid) + mergeSort(nums, cache, mid + 1, right);
        int i = left, j = mid + 1, k = left, l = left;
        while (j <= right) {
            //统计右边子数组中每一个元素能够和左边的子数组中元素构成的翻转对的数量。
            while (l <= mid && nums[l] <= 2L * nums[j]) l++;
            count += mid + 1 - l;
            //合并左右子数组
            while (i <= mid && nums[i] < nums[j]) cache[k++] = nums[i++];
            cache[k++] = nums[j++];
        }
        //合并剩余的左子数组中的元素
        while (i <= mid) cache[k++] = nums[i++];

        System.arraycopy(cache, left, nums, left, right - left + 1);
        return count;
    }

}
