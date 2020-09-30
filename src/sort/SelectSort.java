package sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author coderhu1
 * @create 2020-09-03 15:53
 */
public class SelectSort {
    public static void main(String[] args) {

//        int[] arr = {3,4,56,34,324};
//        selectSort(arr);
//        System.out.println(Arrays.toString(arr));
        //创建一个80000的数组进行测试
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*80000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String str1 = simpleDateFormat.format(date1);
        System.out.println(str1);

        selectSort(arr);

        Date date2 = new Date();
        String str2 = simpleDateFormat.format(date2);
        System.out.println(str2);
    }

    public static void selectSort(int[] arr){
        //算法：先简单，再复杂


        //原始数组：101，34，119，1
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < min){//如果是大于号，即从大到小排
                    flag = true; //标识是否发生了交换
                    min = arr[j];
                    minIndex = j;
                }
            }
            //把最小值所在的数组元素与数组第i个元素进行交换
            if(flag) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
