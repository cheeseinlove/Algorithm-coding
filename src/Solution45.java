/*
给定一个非负整数数组，你最初位于数组的第一个位置。
数组中的每个元素代表你在该位置可以跳跃的最大长度。
你的目标是使用最少的跳跃次数到达数组的最后一个位置。
输入: [2,3,1,1,4]
输出: 2
解释: 跳到最后一个位置的最小跳跃数是 2。
     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 */
public class Solution45 {
    public static  int jump(int[] nums) {
        if(nums.length == 1) return 0;
        int reach = 0;
        int nextreach = nums[0];
        int step = 0;
        //reach代表当前格子所能跳下一步的所有范围，在这个范围之中看能不能走到终点，不能则step++
        //nextreach动态更新在当前范围中（同一个step）所能走的最远距离
        for(int i = 0;i<nums.length;i++){
            nextreach = Math.max(i+nums[i],nextreach);
            if(nextreach >= nums.length-1) return (step+1);
            if(i == reach){
                step++;
                reach = nextreach;
            }
        }
        return step;
    }
    public static void main(String...args){




    }

}
