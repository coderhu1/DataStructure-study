package tree;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author coderhu1
 * @create 2020-09-11 9:29
 */
public class HeapSort {
    public static void main(String[] args) {
        //升序排列
//        int arr[] = {4, 6, 8, 5, 9};
//        heapSort(arr);
        int[] arr = new int[8000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String str1 = simpleDateFormat.format(date1);
        System.out.println(str1);

        heapSort(arr);

        Date date2 = new Date();
        String str2 = simpleDateFormat.format(date2);
        System.out.println(str2);
    }

    public static void heapSort(int arr[]) {
        System.out.println("heap sort start");

        //最终代码
        for (int i = arr.length / 2 -1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
//        System.out.println(Arrays.toString(arr));

        int temp = 0;
        for (int j = arr.length - 1; j > 0; j--) {
            //交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
            //倾向与把小的数放在右下方
        }

//        System.out.println(Arrays.toString(arr));
    }

    //将一个数组（二叉树）构建成大顶堆
    /**
     * 功能：完成将以i对应的非叶子节点的数，调整成大顶堆
     * {4，6，8，5，9} -》 {4，9，8，5，6}
     * @param arr 待调整的数组
     * @param i 表示非叶子节点在数组中索引
     * @param length 表示对多少个元素进行调整，lengh在逐渐减少
     */
    public static void adjustHeap(int arr[], int i, int length) {
        //这么写，与在21行的遍历方式相关，不需要验证下轮循环是否有大于上轮循环的数
        //从下向上，从右向左遍历
        int temp = arr[i];//先取出当前元素的值，保存在临时变量，准备交换用
        //开始调整
        //k * 2 + 1 是k的左子节点
        for (int k = 2 * i + 1; k < length; k = k * 2 + 1) {
            //k+1<length为了防止索引溢出
            if(k + 1 < length && arr[k] < arr[k + 1]) {//说明左子节点的值小于右子节点的值
                k++;//k指向右子节点
            }
            //因为自下向上，自左向右进行，只需向右下延申
            if(arr[k] > temp) {//如果子节点大于父节点
                arr[i] = arr[k];//把较大的值赋给当前节点
                i = k;//!!! i指向k，继续循环比较
            }else {
                break;
            }
        }
        //当for循环结束后，我们已经将以i为父节点的树的最大值放到了顶部
        arr[i] = temp;
        //完成交换
    }
}
