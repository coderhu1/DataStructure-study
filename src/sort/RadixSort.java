package sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author coderhu1
 * @create 2020-09-05 15:43
 */
public class RadixSort {
    public static void main(String[] args) {
//        int[] arr = {53, 3, 7, 542, 748, 14, 214};
//        radixSort(arr);

        //8000000 * 11 * 4 / 1024 / 1024 / 1024
        int[] arr = new int[8000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*8000000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = simpleDateFormat.format(date1);
        System.out.println(str);

        radixSort(arr);

        Date date2 = new Date();
        String str2 = simpleDateFormat.format(date2);
        System.out.println(str2);
    }

    public static void radixSort(int[] arr) {

        //1.得到数组中最大的数的位数
        int max = arr[0];//假设第一个数就是最大数
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //得到最大数的位数
        int maxLength = (max + "").length();//很巧妙

        //定义一个二维数组，表示十个桶，每个桶就是一个一维数组
        //1.一个二位数组包含十个一维数组
        //2.为了防止在放入数的时候，数据溢出，则每个一维数组（桶），大小定位arr.length
        //3.很明确，基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];

        //为了记录每个桶中，实际存放了多少个数据，我们定义一个一维数组来记录各个桶的每次放入的数据个数
        //bucketElementCounts[0],记录的就是bucket[0]桶每次放入的数据个数
        int[] bucketElementCounts = new int[10];

        //使用循环处理代码
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //n为每个循环的递乘过程，为了去位数
            for (int j = 0; j < arr.length; j++) {
                //取出每个元素的x位
                int digitOfElement = arr[j] / n % 10;
                //放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                //bucketElementCounts[digitOfElement]记录了bucket[digitOfElement]的数据个数
                //初始化为0
                bucketElementCounts[digitOfElement]++;
            }

            //把桶中数据取回来放回原来数组
            int index = 0;
            for (int k = 0; k < bucket.length; k++) {
                //如果桶中有数组才放入到原数组
                if (bucketElementCounts[k] != 0) {
                    //循环该桶，即第k个一维数组
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        //取出元素放入到arr
                        arr[index] = bucket[k][l];
                        index++;
                    }
                }
                //第i轮处理后，需要将每个bucketElementCounts[]置0
                bucketElementCounts[k] = 0;
            }

            //检查
//            System.out.println("第x轮的效果" + Arrays.toString(arr));
        }
    }
}
