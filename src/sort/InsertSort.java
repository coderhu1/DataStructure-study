package sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author coderhu1
 * @create 2020-09-03 16:39
 */
public class InsertSort {
    public static void main(String[] args) {
//        int[] arr = {4,3,1,2,8,0};
//        insertSort(arr);
//        System.out.println(Arrays.toString(arr));
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*80000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str1 = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是：" + str1);

        insertSort(arr);

        Date date2 = new Date();
        String str2 = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是：" + str2);
    }

    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int insertValue = arr[i];//用于交换的元素值，即待插入的元素
            int insertIndex = i - 1;//用于比较的元素索引，初始化为交换的元素值的前一位
            boolean flag = false;

            //3 4 1 2
            while(insertIndex >= 0 && insertValue < arr[insertIndex]){
                arr[insertIndex + 1] = arr[insertIndex];//4 4 1 2    3 4 1 2 -> 3 4 4 2 -> 3 3 4 2 -> 1 3 4 2
                insertIndex--;//完成了当前的数// 值交换，判断是否向数组左边方向继续进行交换
                //先分析位于开始的特殊情况，再分析后面的一般情况
                flag = true;
            }// 4 4 1 2
            if(flag) {
                arr[insertIndex + 1] = insertValue;//把待插入的元素插入到insertIndex探针后面的数据，因为前面的数据比它小
            }// 4 3 1 2
        }
    }
}
