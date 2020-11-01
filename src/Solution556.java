import java.util.Arrays;
import java.util.Stack;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-10-19 22:22
 * @Description:
 */
public class Solution556 {
    public static void main(String[] args) {
        System.out.println(nextGreaterElement(12));
    }
    public static int nextGreaterElement(int n) {
        int len=0;
        int k=n;
        Stack<Integer> stack=new Stack<>();
        while (k>0){
            k/=10;
            len++;
        }
        int src[]=new int[len];
        k=n;
        for(int i=0;i<len;i++){
            src[len-1-i]=(k%10);
            k/=10;
        }
        int index=-1;
        int i=len-1;
        for(;i>=0;i--){
            //利用单调栈找第一次发生了覆盖，即数字左边比右边小
            while (!stack.isEmpty()&&(src[i])<(src[stack.peek()])){
                index=stack.pop();
            }
            //一旦找到了则break
            if (index!=-1){
                int temp=src[i];
                src[i]=src[index];
                src[index]=temp;
                break;
            }
            stack.push(i);
        }
        if (index==-1){
            return -1;
        }
        int newBegin=i+1;
        //剩下长度从小到大排序，因为高位换了更大的了
        int restLen=len-(i+1);
        int rest[]=new int[restLen];
        for(int j=0;j<restLen;j++){
            rest[j]=src[++i];
        }
        Arrays.sort(rest);
        for(int j=0;j<restLen;j++){
            src[j+newBegin]=rest[j];
        }
        long ans=0;
        for(int j=0;j<len;j++){
            ans=10*ans+src[j];
        }
        if (ans>Integer.MAX_VALUE){
            return -1;
        }
        return (int)ans;

    }
}
