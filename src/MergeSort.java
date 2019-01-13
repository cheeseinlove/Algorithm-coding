/*
归并排序时间复杂度nlogn
 */
public class MergeSort {
public static void mergeSort(int nums[],int left,int right,int temp[]){
    if(left<right){
        int mid=(left+right)/2;
        mergeSort(nums,left,mid,temp);
        mergeSort(nums,mid+1,right,temp);
        mergeArray(nums,left,right,mid,temp);
    }

}
//将nums的start...mid和mid+1...end合并
public static void mergeArray(int nums[],int start,int end,int mid,int temp[]){

     int i=start;
     int j=mid+1;
     int k=0;
     while (i<=mid&&j<=end){
         if(nums[i]<nums[j])
             temp[k++]=nums[i++];
         else
             temp[k++]=nums[j++];
     }
     while (i<=mid) temp[k++]=nums[i++];
     while (j<=end) temp[k++]=nums[j++];
     for( i=0;i<k;i++){
         nums[start+i]=temp[i];
     }

}

    public static void main(String...args){
        int nums[]=new int[]{1,4,5,2,3,4,1,2,6,7,12,5,9,21};
        int  temp[]=new int[nums.length];
        mergeSort(nums,0,nums.length-1,temp);
       for(int i=0;i<nums.length;i++)
           System.out.print(nums[i]+" ");
    }

}
