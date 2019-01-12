public class QuickSort {
    public static void sort(int a[], int start, int end) {
        if(start>=end)
            return;
        int key = a[start];
        int left = start;
        int right = end;

        while (right > left) {
            while (right > left) {
                if (a[right] < key)
                    break;

                right--;
            }
            while (right > left) {
                if (a[left] >key)
                    break;
                left++;
            }
            if (right>left){
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            }
        }
        int p=key;
        a[start]=a[right];
        a[right]=key;
        sort(a, start, left-1);
        sort(a, left + 1, end);


    }
    public  static void quickSort(int[] a, int low, int high) {
        //1,找到递归算法的出口
        if( low > high) {
            return;
        }
        //2, 存
        int i = low;
        int j = high;
        //3,key
        int key = a[ low ];
        //4，完成一趟排序
        while( i< j) {
            //4.1 ，从右往左找到第一个小于key的数
            while(i<j && a[j] > key){
                j--;
            }
            // 4.2 从左往右找到第一个大于key的数
            while( i<j && a[i] <= key) {
                i++;
            }
            //4.3 交换
            if(i<j) {
                int p = a[i];
                a[i] = a[j];
                a[j] = p;
            }
        }
        // 4.4，调整key的位置
        int p = a[i];
        a[i] = a[low];
        a[low] = p;
        //5, 对key左边的数快排
        quickSort(a, low, i-1 );
        //6, 对key右边的数快排
        quickSort(a, i+1, high);
    }
    public static void main(String... args) {
        int a[] = new int[]{3, 6, 12, 6, 18, 3, 9, 5, 7};
        sort(a,0,a.length-1);
//        quickSort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i]+" ");

    }
}
