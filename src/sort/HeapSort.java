package sort;


import java.util.Arrays;
import java.util.Random;

/**
 * 大顶堆
 * 思路分析
 * 1.找到每个子树父节点index=n/2-1,n为数组长度。
 * 2.遍历每一个父节点，对于每个父节点来说，左孩子为2n+1,右孩子为2n+2,单颗子树进行上浮。
 * 3.完成步骤1.2后得到一个最大值置于数组末尾，然后重复12
 *
 * @author liuxun05@meituan.com
 */
public class HeapSort {

    static final int KB = 1024;

    private static int[] buildMaxHeap(int[] arr, int length) {
        //构建大顶堆,n/2-1代表数组最后一个节点对应的父节点索引
        for (int i = (length / 2 - 1); i >= 0; i--) {
            floating(arr, i, length);
        }
        return arr;


    }

    /**
     * 上浮
     *
     * @param arr
     * @param cur
     * @param length
     * @return
     */
    private static int[] floating(int[] arr, int cur, int length) {
        int temp = arr[cur];
        //2n+2右子节点，2n+1左子节点
        //若右子节点更大则交换
        if (2 * cur + 2 <= length - 1 && arr[cur] < arr[2 * cur + 2]) {
            arr[cur] = arr[2 * cur + 2];
            arr[2 * cur + 2] = temp;
            temp = arr[cur];
        }
        //若左子节点更大则交换
        if (2 * cur + 1 <= length - 1 && arr[cur] < arr[2 * cur + 1]) {
            arr[cur] = arr[2 * cur + 1];
            arr[2 * cur + 1] = temp;
        }
        return arr;
    }

    public static int[] heapSort(int[] arr) {
        int temp = 0;
        for (int i = arr.length; i >= 2; i--) {
            arr = buildMaxHeap(arr, i);
            temp = arr[0];
            arr[0] = arr[i - 1];
            arr[i - 1] = temp;
        }

        return arr;
    }

    public static int[] minK(int[] bigNum, int k) {
        int[] minK = buildMaxHeap(Arrays.copyOfRange(bigNum, 0, k), k);
        for (int i = k; i < bigNum.length; i++) {
            if (bigNum[i] < minK[0]) {
                minK[0] = bigNum[i];
                buildMaxHeap(minK, k);
            }
        }
        return minK;

    }


    public static void main(String... args) {

        int unsortedArr[] = new int[]{10, 4, 6, 7, 3, 2, 11};
        int sortedArr[] = heapSort2(unsortedArr);
        for (int i = 0; i < sortedArr.length; i++) {
            System.out.println(sortedArr[i]);
        }
//        int[] bigNum = new int[KB * KB];
//        for (int i = 0; i < bigNum.length; i++) {
//            Random random = new Random();
//            int a = random.nextInt(10000) + 1;
//            bigNum[i] = a;
//        }
//        System.out.println(bigNum.length + "  ");
//        int[] minK = minK(bigNum, 200);
////        heapSort(minK);
//
//        for (int i = 0; i < minK.length; i++) {
//            System.out.print(minK[i] + " ");
//        }
    }

    /**
     * @Description: 上面是用大根堆从后往前排序达到最终升序，这里是小根堆从前往后排序达到最终升序
     */
    public static int[] heapSort2(int[] nums) {
        int ans[]=new int[nums.length];
        for (int i = 0; i < nums.length ; i++) {
            heapSort2(nums, nums.length-i);
            int min=nums[0];
            nums[0]=nums[nums.length-i-1];
            nums[nums.length-i-1]=min;
            ans[i]=min;
        }
        return ans;
    }

    public static void heapSort2(int[] nums, int len) {
        for (int i = len - 1; i >= 1; i--) {
            int parent = (i - 1) / 2;
            if ( nums[parent] > nums[i]) {
                int temp = nums[parent];
                nums[parent] = nums[i];
                nums[i] = temp;
            }
        }
    }
}

