/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-12-29 23:42
 * @Description:
 */
public class Solution384 {
    int[] array;
    int []origin;
    public Solution384(int[] nums) {
        array=nums;
//        origin=new int[nums.length];
////        for(int i=0;i<nums.length;i++){
////            origin[i]=nums[i];
////        }
        //深拷贝
       origin=nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        array=origin;
        origin=origin.clone();
      return origin;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
          for(int i=0;i<array.length;i++){
              //返回[i,n]的随机数
              int rand = (int)(Math.random() * (array.length - i)) + i;
              int temp=array[i];
              array[i]=array[rand];
              array[rand]=temp;
          }
          return array;
    }
}
