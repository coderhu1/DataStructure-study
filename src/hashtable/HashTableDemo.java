package hashtable;

import java.util.Scanner;

/**
 * @author coderhu1
 * @create 2020-09-06 20:42
 */
public class HashTableDemo {

    public static void main(String[] args) {

        //
        HashTable hashTab = new HashTable(7);

        String key = "";
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("add");
            System.out.println("list");
            System.out.println("exit");

            key = sc.next();
            switch(key){
                case "add":
                    System.out.println("输入id");
                    int id = sc.nextInt();
                    System.out.println("输入名字");
                    String name = sc.next();
                    Employee employee = new Employee(id,name);
                    hashTab.add(employee);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "exit":
                    sc.close();
                    System.exit(0);
                    break;
            }
        }
    }
}

class HashTable {
    private EmployeeLinkedList[] employeeLinkedListArray;
    private int size;//表示一共有多少条链表

    //构造器
    public HashTable(int size) {
        this.size = size;
        //初始化
        employeeLinkedListArray = new EmployeeLinkedList[size];
        //不要忘了分别初始化每一个链表
        for (int i = 0; i < size; i++) {
            employeeLinkedListArray[i] = new EmployeeLinkedList();
        }
    }

    //添加雇员，先找hash值，通过哈希值找在数组的哪个位置，即哪条链表
    public void add(Employee employee){
        //根据员工的id，得到该员工应该添加到哪条链表
        int empLinkedListNO = hashFun(employee.id);
        //将emp添加到对应到链表中
        employeeLinkedListArray[empLinkedListNO].add(employee);
    }

    //也就是调用各个链表的list
    public void list() {
        for (int i = 0; i < size; i++) {
            employeeLinkedListArray[i].list(i);
        }
    }

    //编写散列函数，使用一个简单的取模法
    public int hashFun(int id){
        return id % size;
    }
}

class Employee {
    public int id;
    public String name;
    public Employee next;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class EmployeeLinkedList {
    //不带头节点，头指针，即第一个Employee,因此我们这个链表的head时直接指向第一个Employee
    private Employee head;

    //说明
    //1.假定，当添加雇员时，id时自增长的，即id的分配总是从小到大
    //  因此我们将该雇员直接加入到本链表的最后即可
    public void add(Employee employee){
        //如果是添加第一个雇员
        if(head == null){
            head = employee;
        }
        //如果不是第一个
        Employee currentEmployee = head;
        while(true){
            if(currentEmployee.next == null){
                break;
            }
            currentEmployee = currentEmployee.next;
        }
        //退出时，直接将emp加入链表
        currentEmployee.next = employee;
    }

    public void list(int no) {
        if(head == null){
            System.out.println("第" + (no + 1) + "链表为空");
            return;
        }
        System.out.println("第" + (no + 1) + "链表的信息为");
        Employee currentEmployee = head;//辅助指针
        while(true){
            System.out.println("当前节点是" + currentEmployee.id + " " + currentEmployee.name);
            if(currentEmployee.next == null){
                //currentEmp已经是最后节点
                currentEmployee = currentEmployee.next;
            }
        }
    }
}
