import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-10-16 20:04
 * @Description:
 */
public class Solution496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len=nums1.length;
        int ans[]=new int [len];
        int index=0;
        Arrays.fill(ans,-1);
        Map<Integer,Integer> map=new HashMap<>();

        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<nums2.length;i++){
            while(!stack.isEmpty()&&nums2[stack.peek()]<nums2[i]){
                map.put(stack.peek(),i);
                //  ans[index++]=i;
                stack.pop();
            }
            stack.push(i);
        }
        for(int i=0;i<nums1.length;i++){
            if(map.containsKey(nums1[i])){
                ans[index]=map.get(nums1[i]);

            }
            index++;
        }





        return ans;
    }
}
