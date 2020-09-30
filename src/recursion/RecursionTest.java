package recursion;

/**
 * @author coderhu1
 * @create 2020-09-02 14:41
 */
public class RecursionTest {
    public static void main(String[] args) {
        test1(5);

        System.out.println(test2(3));
    }

    //打印问题
    public static void test1(int n){
        if(n > 2){
            test1(n-1);
        }
        System.out.println("n = " + n);
    }

    //阶乘问题
    public static int test2(int n){
        if(n == 1){
            return 1;
        }else{
            return n * test2(n-1);
        }
    }
}
