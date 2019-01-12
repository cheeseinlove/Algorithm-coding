import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
类似 3 4 5 1 2  ，4 5 6，1 2
翻滚不重复数字数组，二分法查找最小值
核心思想为两指针第一个指向第一递增队列，第二指针指向第二个递增队列
若两指针距离为1，则第二指针为最小
*/
public class RoatingArray {
    public static int search(int a[], int start, int end) {

        int mi = (end - start) / 2 + 1;
        int i = 0;
        int j = end;
        while (j - i != 1) {
            if (a[mi] > a[i])
                i = mi;
            else if (a[mi] < a[j])
                j = mi;
            mi = (j - i) / 2 + i;
        }
        return a[j];

    }
    public static void main(String...args){
        int a[]=new int[]{3,4,5,7,12,18,1,2};
        System.out.println(search(a,0,a.length-1));

    }
}
