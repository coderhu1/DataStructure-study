package search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author coderhu1
 * @create 2020-09-06 11:12
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,8,10,89,1000,1000,1000,1000,1234};

        List<Integer> arrayList = binarySearch2(arr,0,arr.length - 1,-1);
        if(arrayList == null) {
            System.out.println("没有找到");
        }else {
            System.out.println(arrayList);
        }
    }

    /**
     *
     * @param arr 数组
     * @param left 左边的索引
     * @param right 右边的索引
     * @param findVal 要查找的值
     * @return 找到返回下标，没找到返回-1
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal){
        //当left 》 right时，说明递归整个数组(否则不断递归），但是没有找到
        if(left > right){
            return -1;
        }

        int mid = (left + right) / 2;
        int midValue = arr[mid];

        if(findVal > midValue){
            return binarySearch(arr,mid + 1,right,findVal);
        }else if(findVal < midValue){
            return binarySearch(arr,left,mid - 1,findVal);
        }else{
            return mid;
        }
    }

    //完成一个课后思考题
    /**
     * 完成能够查找多个数值binarySearch
     *
     * 分析：
     * 1.在找到mid值，不要马上返回
     * 2.向mid索引值的左边扫描，将所有满足1000的索引加入到一个集合中
     * 3.同样向mid索引值的右边扫描
     * 4.将集合返回
     */
    public static ArrayList<Integer> binarySearch2(int[] arr, int left, int right, int findVal){
        //当left 》 right时，说明递归整个数组(否则不断递归），但是没有找到
        if(left > right){
            return null;
        }

        int mid = (left + right) / 2;
        int midValue = arr[mid];

        if(findVal > midValue){
            return binarySearch2(arr,mid + 1,right,findVal);
        }else if(findVal < midValue){
            return binarySearch2(arr,left,mid - 1,findVal);
        }else{
            ArrayList<Integer> integers = new ArrayList<>();
            //左边
            int temp = mid - 1;
            while(true){
                if( temp < 0 || arr[temp] != findVal){
                    break;
                }
                integers.add(temp);
                temp--;
            }
            //中间
            integers.add(mid);
            //右边
            temp = mid + 1;
            while(true){
                if( temp > arr.length - 1 || arr[temp] != findVal){
                    break;
                }
                integers.add(temp);
                temp++;
            }
            return integers;
        }
    }

}
