/*
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。


 */
public class Solution42 {
    public static int trap(int[] height) {
        if(height.length==0)
            return 0;
        int res=0;
        int maxLen = height[0];
        int maxIndex = 0;
        //以最高点为分界线，分别从左和右水平照射阳光，除开柱子本身体积未被阳光照射的面积为水
        for (int i = 0; i < height.length;i++) {
            if (height[i] > maxLen) {
                maxIndex = i;
                maxLen = height[i];
            }
        }
        int left=0;
        int right=0;
        int hightest=height[0];
        int lastHeight=height[0];
        int lastManner=maxLen-lastHeight;
        if (maxIndex>0){
            left=maxLen*(maxIndex+1);
            for(int i=0;i<=maxIndex;i++){
                left-=height[i];
                if (height[i]<=lastHeight){
                    left-=lastManner;
                }
                else {
                    if (height[i]>hightest){
                        left-=maxLen-height[i];
                        hightest=height[i];
                        lastManner=maxLen-height[i];
                    }
                    else {
                        left -= maxLen - hightest;
                        lastManner=maxLen - hightest;
                    }
                }
                lastHeight=height[i];
            }
        }
        hightest=height[height.length-1];
        lastHeight=height[height.length-1];
        lastManner=maxLen-lastHeight;
        if(maxIndex<height.length-1){
            right=maxLen*(height.length-maxIndex);
            for(int j=height.length-1;j>=maxIndex;j--){
                right-=height[j];
                if (height[j]<=lastHeight){
                    right-=lastManner;
                }
                else {
                    if (height[j]>hightest){
                        right-=maxLen-height[j];
                        hightest=height[j];
                        lastManner=maxLen - height[j];
                    }
                    else {
                        right -= maxLen - hightest;
                        lastManner=maxLen - hightest;
                    }
                }
                lastHeight=height[j];

            }
        }
        res=left+right;
return res;
    }

    public static void main(String... args) {
        int nums[] = new int[]{4, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(nums));
    }
}
