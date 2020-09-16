/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-09-03 23:41
 * @Description:
 */
public class HeadOffer11 {
    public int minArray(int[] numbers) {
        int left=0;
        int right=numbers.length-1;
        while (left<numbers.length-1&&numbers[left]==numbers[left+1]){
            left++;
        }
        while (right>0&&numbers[right]==numbers[right-1]){
            right--;
        }
        while (left<right){
            int mid=(right+left)>>1;
            if (numbers[mid]<=numbers[right]){
                right=mid;
            }else {
                left=mid+1;
            }
        }
        return numbers[left];
    }
}
