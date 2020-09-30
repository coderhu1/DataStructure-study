package leetcode;

/**
 * @author coderhu1
 * @create 2020-09-08 17:52
 */
public class LuomaNumber {

    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
    }

    public static int romanToInt(String s) {
        char[] arr = new char[s.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.charAt(i);
        }

        int[] arr2 = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 'V') {
                arr2[i] = 5;
            }else if(arr[i] == 'I') {
                arr2[i] = 1;
            }else if(arr[i] == 'X') {
                arr2[i] = 10;
            }else if(arr[i] == 'L') {
                arr2[i] = 50;
            }else if(arr[i] == 'C') {
                arr2[i] = 100;
            }else if(arr[i] == 'D') {
                arr2[i] = 500;
            }else {
                arr2[i] = 1000;
            }
        }

        for (int i = 0; i < arr2.length - 1; i++) {
            if(arr2[i] < arr2[i + 1]) {
                arr2[i] = -arr2[i];
            }
        }

        int sum = 0;
        for (int i = 0; i < arr2.length; i++) {
            sum += arr2[i];
        }

        return sum;
    }
}
