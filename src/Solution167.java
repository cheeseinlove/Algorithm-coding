/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-08-06 23:23
 * @Description:
 */
public class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        for(int i=0;i<numbers.length;i++){
            int index=binarySearch(numbers,0,numbers.length-1,target-numbers[i]);
            if (index!=-1&&index!=i){
                ans[0]=(i>index?index:i)+1;
                ans[1]=(i>index?i:index)+1;
                break;
            }
        }
        return ans;
    }
    public int binarySearch(int [] numbers,int left,int right,int target){
        if (left>right){
            return -1;
        }
        int mid=left+(right-left)/2;
        if (numbers[mid]==target){
            return mid;
        }
        int index=-1;
        if (numbers[mid]>target){
            index=binarySearch(numbers,left,mid-1,target);
        }else {
            index=binarySearch(numbers,mid+1,right,target);
        }
        return index;

    }

    //双指针
    public int[] twoSum2(int[] numbers, int target) {
        int[] ans = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] < target) {
                left++;
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                ans[0] = left + 1;
                ans[1] = right + 1;
                break;
            }
        }

        return ans;
    }
}
