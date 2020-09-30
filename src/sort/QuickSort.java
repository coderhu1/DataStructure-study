package sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author coderhu1
 * @create 2020-09-04 22:30
 */
public class QuickSort {
    public static void main(String[] args) {
//        int[] arr = {-9,78,0,23,-567,70};
//        quickSort(arr,0,arr.length - 1);
//        System.out.println(Arrays.toString(arr));
        int[] arr = new int[8000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*8000000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String str = simpleDateFormat.format(date1);
        System.out.println(str);

        quickSort(arr,0,arr.length - 1);

        Date date2 = new Date();
        String str2 = simpleDateFormat.format(date2);
        System.out.println(str2);
    }

    public static void quickSort(int[] arr, int left, int right){
        int l = left;
        int r = right;
        int pivot = arr[(right + left)/2];//pivot 中轴
        int temp = 0; //临时变量，交换时使用
        //while循环的目的是让比pivot小的值放到左边，比pivot大的值放在右边
        while(l < r){
            //双指针查找
            //在pivot左边一直找，找到大于等于pivot值，才退出
            while(arr[l] < pivot){
                l += 1;
            }
            //在pivot右边一直找，找到小于等于pivot值，才退出
            while(arr[r] > pivot){
                r -= 1;
            }

            //作一次判断
            //如果l >= r 说明pivot的左右两的值，已经按照左边全部是
            //小于等于pivot，右边全是大于等于pivot的值
            if(l >= r){
                break;
            }

            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;


            //如果交换完后，发现这个arr[l] == pivot值相等r--，前移
            if(arr[l] == pivot){
                r -= 1;
            }
            //如果交换完后，发现这个arr[l] == pivot值相等l++，后移
            //意味着交换前arr[l] == pivot l自增1
            if(arr[r] == pivot){
                l += 1;
            }
        }


        //如果l == r，必须l++，r--，否则为出现栈溢出
        if(l == r){
            l += 1;
            r -= 1;
        }
        //向左递归
        if(left < r){
            quickSort(arr,left,r);//不理解
        }
        //向右递归
        if(right > l){
            quickSort(arr,l,right);//不理解
        }
    }
}
