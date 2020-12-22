package sort;

/**
 * @Author: liuxun05@meituan.com
 * @Date: 2020-12-21 23:02
 * @Description:
 */
public class QuickSort {
    public static void main(String[] args) {
        int num[]=new int[]{5,1,3,4,6,3};
        sort(num,0,num.length-1);
    }
    public static void sort(int num[],int l,int r){
        if (l>=r){
            return;
        }
        int key=num[r];
        int i=l;
        int j=r;
        while (i<j){

            while (num[i]<=key&&i<j){
                i++;
            }
            while (num[j]>=key&&i<j){
                j--;
            }
            if (i<j){
                int temp=num[i];
                num[i]=num[j];
                num[j]=temp;
            }
        }
        num[r]=num[i];
        num[i]=key;
        sort(num,l,i-1);
        sort(num,i+1,r);
    }
}
