import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
给定一个非负整数数组，你最初位于数组的第一个位置。
数组中的每个元素代表你在该位置可以跳跃的最大长度。
判断你是否能够到达最后一个位置。
 */
public class Solution55 {
    public static boolean canJump(int[] nums) {
        //n表示当前格能到最后格所需最小步数
        int n=1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]>=n)
            {
                n=1;
            }
            else
            {
                n++;
            }
            if(i==0&&n>1)
            {
                return false;
            }
        }
        return true;
//        Queue<Integer> queue=new LinkedList();
//        queue.add(nums.length-1);
//        Map<Integer,Boolean> map=new HashMap<>();
//        if (nums.length==1)
//            return true;
//        while (!queue.isEmpty()){
//            int index=queue.poll();
//            for(int i=index-1;i>=0;i--){
//                if (nums[i]>=index-i&&!map.getOrDefault(i,false)){
//                    queue.offer(i);
//                    map.put(i,true);
//                    if (i==0)
//                        return true;
//                }
//            }
//            if (queue.isEmpty())
//            return false;
//
//
//        }
//
//        return true;
    }
    public static void main(String...args){
       int nums[]=new int[]{3,2,1,0,4};
       System.out.println(canJump(nums));
    }
}
