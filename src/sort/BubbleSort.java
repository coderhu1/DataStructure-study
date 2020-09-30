package sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *时间复杂度： O(n^2)
 * @author coderhu1
 * @create 2020-09-03 10:59
 */
public class BubbleSort {
    public static void main(String[] args) {
//        int[] arr = {3,9,-1,10,20};
////        int[] arr = {1,2,3,4,5};
//
//        bubbleSort(arr);
//        System.out.println(Arrays.toString(arr));
        //测试冒泡排序速度O（n^2)，测试80000个数组的数组
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*80000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str1 = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是：" + str1);

        bubbleSort(arr);

        Date date2 = new Date();
        String str2 = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是：" + str2);
    }

    //将前面的冒泡排序算法封装成方法
    public static void bubbleSort(int[] arr){
        int temp = 0;//作临时变量
        boolean flag = false;//标识变量，表示是否进行过交换，优化方式来减少不必要的交换

        for (int i = 0; i < arr.length - 1; i++) { // 0 1 2 3 4
            // arr.length - 1 表示遍历少一个元素
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j+1]){ //把较小的值放在arr数组前面，每次都可以确定最大的值
                    //像水泡一样把较大的值后移
                    flag = true;
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
//            System.out.println("第" + (i + 1) + "趟排序后的数组");
//            System.out.println(Arrays.toString(arr));

            if(!flag){
                break;//说明在该趟排序中，一次交换都没发生过
            } else {
                flag = false;//重置flag进行下次判断
            }
        }
    }
}
