package search;

/**
 * @author coderhu1
 * @create 2020-09-06 16:06
 */
public class InsertValueSearch {
    public static void main(String[] args) {
//        int[] arr = new int[100];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = i + 1;
//        }
        int[] arr = {1,8,10,89,1000,1000,1000,1000,1234};

        insertValueSearch(arr,0,arr.length - 1,1000);
        binarySearch(arr,0,arr.length - 1, 1000);
    }

    public static int insertValueSearch(int[] arr, int right, int left, int findVal){
        System.out.println("hello");

        if(left > right || findVal < arr[0] || findVal > arr[arr.length - 1]){
            //这个判断必须有，否则造成mid越界
            return -1;
        }

        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midValue = arr[mid];

        if(findVal > midValue){
            //右递归
            return insertValueSearch(arr,mid + 1,right,findVal);
        }else if(findVal < midValue){
            //左递归
            return insertValueSearch(arr,left,mid - 1,findVal);
        }else{
            return mid;
        }
    }

    public static int binarySearch(int[] arr, int left, int right, int findVal){
        System.out.println("二分查找");
        
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
}
