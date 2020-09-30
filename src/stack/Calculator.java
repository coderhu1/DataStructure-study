package stack;

/**
 * @author coderhu1
 * @create 2020-09-01 15:40
 */
public class Calculator {
    public static void main(String[] args) {
        String expression = "30+2*6-2";
        ArrayStack2 numberStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        String keepNum = "";

        while(true){
//            ch = expression.charAt(index);
            ch = expression.substring(index,index+1).charAt(0);
            if(operStack.isOper(ch)){
                if(!operStack.isEmpty()){
                    if(operStack.priority(ch) <= operStack.priority(operStack.peek())){
                        num1 = numberStack.pop();
                        num2 = numberStack.pop();
                        oper = operStack.pop();
                        res = numberStack.cal(num2, num1, oper);
                        numberStack.push(res);
                        operStack.push(ch);
                    }else {
                        operStack.push(ch);
                    }
                }else{
                    operStack.push(ch);
                }
            }else{
//                numberStack.push(ch - 48);
                //处理多位数
                keepNum += ch;

                if(index == expression.length() - 1){
                    numberStack.push(Integer.parseInt(keepNum));
                }else {
                    //判断下一个字符是否是操作符，是即把当前的keepNum换成数字入栈，否则把keepNum留给下一个循环里，加上后来的数字再入栈
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        numberStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }

            //let index plus 1 and
            index++;
            if(index >= expression.length()){
                break;
            }
        }

        while(true){
            if(operStack.isEmpty()){
                break;
            }
            num1 = numberStack.pop();
            num2 = numberStack.pop();
            oper = operStack.pop();
            res = numberStack.cal(num1, num2, oper);
            numberStack.push(res);
        }
        System.out.println("the result is :" + numberStack.pop());
    }
}

//we need to give the ArrayStack more function
class ArrayStack2{
    private int maxSize;
    private int[] stack;
    private  int top = -1;

    public ArrayStack2(int maxSize){
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //to return the value of top of the stack
    public int peek(){
        return stack[top];
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

    //return the priority of the operater
    public int priority(int oper){
        if(oper == '*'  || oper == '/'){
            return 1;
        }else if (oper == '+' || oper == '-'){
            return 0;
        }else {
            return -1; // we assume there are only four operators.
        }
    }

    public boolean isOper(char val){
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    public int cal (int num1, int num2, int oper){
        int result = 0;
        switch (oper){
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num2 - num1;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num2 / num1;
                break;
            default:
                break;
        }
        return result;
    }
}