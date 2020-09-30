package queue;

import java.util.Scanner;

/**
 * @author coderhu1
 * @create 2020-08-18 10:26
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while(loop){
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'a':
                    System.out.println("输入一个整数数据：");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int result = arrayQueue.getQueue();
                        System.out.printf("取出的数据是 : %d\n", result);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'h':
                    try {
                        int result = arrayQueue.headQueue();
                        System.out.printf("队列头的数据是： %d\n", result);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("输入有误");
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

//使用数组模拟队列
class ArrayQueue{
    private int maxSize;
    private int rear; //队列尾
    private int front; //队列头
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        front = -1;
        rear = -1;
        arr = new int[maxSize];
    }

    public boolean isEmpty(){
        return front == rear;
    }

    public boolean isFull(){
        return rear == maxSize - 1;
    }

    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列为满，不能添加数据！");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空不能取出数据！");
        }
        front++;
        return arr[front];
    }

    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列是空的没有数据！");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }
    }

    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，没有队列头的数据！");
        }
        return arr[front + 1];
    }
}
