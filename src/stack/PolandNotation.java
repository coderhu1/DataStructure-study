package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author coderhu1
 * @create 2020-09-01 22:28
 */
public class PolandNotation {
    public static void main(String[] args) {
        //计算后缀表达式的值
        //definite a reverse-poland-notation
        //(3+4)×5-6 -> 3 4 + 5 × 6 -
//        //为了方便，逆波兰表达式中数字和符号使用空格隔开
//        String suffixExpression = "30 4 + 5 * 6 -";
//        List<String> rpnList = getListString(suffixExpression);//后缀表达式转为list，以空格分隔转对于任何String类型
//        System.out.println(rpnList);
//        int res = calculate(rpnList);
//        System.out.println(res);

        //中缀表达式转后缀表达式
        String infixExpression = "1+((2+3)*4)-5";
        List<String> infixExpressionList = toInfixExpressionList(infixExpression);//中缀表达式转list
        System.out.println(infixExpressionList);
        List<String> parseSuffixExpressionList = parseSuffixExpressionList(infixExpressionList);
        System.out.println(parseSuffixExpressionList);

        System.out.println("结果是：" + calculate(parseSuffixExpressionList));
    }

    public static List<String> parseSuffixExpressionList(List<String> list){
        Stack<String> s1 = new Stack<>();
        //s2这个栈没有pop操作，还需要逆序输出，直接使用List<String>
        List<String> s2 = new ArrayList<String>();

        for (String item :
                list) {
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();//将（弹出s1栈，并且）并未入s2，相当于丢弃俩个
            } else {
                //当item的优先级小于等于s1栈顶的运算符
                while(s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)){
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }

        //将s1中剩余的运算符依次弹出加入s2
        while(s1.size() != 0){
            s2.add(s1.pop());
        }

        return s2;//List s2 正常输出即使栈s2的逆序输出
    }

    public static List<String> toInfixExpressionList(String s){
        List<String> ls = new ArrayList<>();
        int i = 0;//这是要给指针，用于遍历中缀表达式字符串
        String str;//对多位数拼接
        char c; //每遍历到一个字符，就放入到c
        do{
            if((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57){
                ls.add("" + c);
                i++;
            }else {
                //如果是一个数，需要考虑多位数的问题
                str = "";//先将str置空
                while(i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57){
                      str += c; //拼接
                      i++; //内外循环公用一个i，代表扫描指针所在的位置
                }
                ls.add(str);
            }
        }while(i < s.length());

        return ls;
    }

    public static List<String> getListString(String suffixExpression){
        String[] split = suffixExpression.split(" ");//以空格分隔
        List<String> list = new ArrayList<>();
        for (String ele: split) {
            list.add(ele);//将分割后的String数组中的每一个String加入到List中
        }
        return list;
    }

    //完成对逆波兰表达式的计算
    //对后缀表达式的list进行计算
    public static int calculate(List<String> list){
        Stack<String> stack = new Stack<>();
        //遍历ls
        for (String item : list) {
            if(item.matches("\\d+")){
                stack.push(item);
            }else{
                int num2 = Integer.parseInt(stack.pop()); //栈顶元素
                int num1 = Integer.parseInt(stack.pop()); //次顶元素
                int result = 0;
                if(item.equals("+")){
                    result = num1 + num2 ;
                }else if (item.equals("-")) {
                    result = num1 - num2; //后缀表达式为次顶元素在前
                }else if (item.equals("*")){
                    result = num1 * num2;
                }else if (item.equals("/")){
                    result = num1 / num2;
                }else {
                    throw new RuntimeException("运算符有误");
                }
                stack.push(result + "");
            }
        }
        return Integer.parseInt(stack.pop());
    }

}

//编写一个类Operation可以返回一个运算符对应的优先级
class Operation{
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String operation){
        int result = 0;
        switch (operation){
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符");
        }
        return result;
    }
}

