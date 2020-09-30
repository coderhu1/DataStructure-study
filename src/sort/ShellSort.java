package sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author coderhu1
 * @create 2020-09-04 9:32
 */
public class ShellSort {
    public static void main(String[] args) {
//        int[] arr = {8,9,1,7,2,3,5,4,6,0};
//        shellSort(arr);
        int[] arr = new int[8000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*8000000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String str1 = simpleDateFormat.format(date1);
        System.out.println(str1);

//        System.out.println(Arrays.toString(arr));
        shellSort2(arr);
//        System.out.println(Arrays.toString(arr));

        Date date2 = new Date();
        String str2 = simpleDateFormat.format(date2);
        System.out.println(str2);
    }

    //希尔排序时，对有序序列在插入时采用交换法
    //思路（算法） ===》代码
    public static void shellSort(int[] arr){
        int temp = 0;
        int count = 0;
        for (int gap = arr.length/2; gap >0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                //遍历各组中的所有元素
                for(int j = i - gap; j >= 0; j -= gap){
                    //如果步长是2，j-=2是为了比较完arr[2] arr[4]再次比较arr[0]与arr[2]
                    //如果当前元素大于加上步长后的那个元素，说明交换
                    if(arr[j] > arr[j+gap]){
                        temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }
                }
            }
//            System.out.println("希尔排序第" + (++count) + "轮后：" + Arrays.toString(arr));
        }
    }

    //改为移位法
    //相对于交换法，减少了很多不必要的赋值
    public static void shellSort2(int[] arr){
        for (int gap = arr.length/2; gap >0; gap /= 2) { //分组进行插入
            for (int i = gap; i < arr.length; i++) { //对每组进行插入排序
                int insertIndex = i - gap;
                int insertValue = arr[i];
                boolean flag = false;
                while(insertIndex >= 0 && insertValue < arr[insertIndex]){
                    arr[insertIndex + gap] = arr[insertIndex]; //前面大的数向后面移位
                    insertIndex -= gap;
                    flag = true;
                }
                if(flag) {
                    arr[insertIndex + gap] = insertValue; //待插入的值仅一次赋值
                }
            }
//            System.out.println("希尔排序第" + (++count) + "轮后：" + Arrays.toString(arr));
        }
    }
}
