package stack;

import java.util.Scanner;

/**
 * @author coderhu1
 * @create 2020-08-31 21:03
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        //test ArrayStack
        ArrayStack stack = new  ArrayStack(4);
        String key = "";
        boolean loop = true;//control exit-function
        Scanner scanner = new Scanner(System.in);

        while(loop){
            System.out.println("show:表示显示栈");
            System.out.println("exit：退出程序");
            System.out.println("push：表示添加数据到栈");
            System.out.println("pop:表示从栈中取出数据");
            key = scanner.next();
            switch (key){
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("Please enter a number");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int result = stack.pop();
                        System.out.println("the result is " + result);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("already exit");
    }
}

class ArrayStack{
    private int maxSize;
    private int[] stack;
    private  int top = -1;

    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    public boolean isFUll(){
        return top == maxSize - 1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int value){
        if(isFUll()){
            System.out.println("the stack is full");
            return;
        }
        top++;
        stack[top] = value;
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("The stack is Empty");
        }
        int value = stack[top];
        top--;
        return value;
    }

    public void list(){
        if(isEmpty()){
            System.out.println("This stack is empty");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] = %d\n", i, stack[i]);
        }
    }
}
