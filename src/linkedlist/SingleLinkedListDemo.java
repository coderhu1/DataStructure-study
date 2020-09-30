package linkedlist;

import java.util.Stack;

/**
 * @author coderhu1
 * @create 2020-08-19 23:51
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero5 = new HeroNode(5, "Tom", "Song");
        HeroNode hero6 = new HeroNode(6, "Mary", "Wang");
        HeroNode hero7 = new HeroNode(7, "Tim", "Li");

        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //test add (by the number value) method
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);

        //test default add method
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);

        singleLinkedList.list();
        System.out.println();

        //test the update method
//        HeroNode hero4new = new HeroNode(4, "Guo", "Yu");
//        singleLinkedList.update(hero4new);
//        singleLinkedList.list();

        //test the delete method
        singleLinkedList.del(4);
        singleLinkedList.list();

        //test the getLength method
        System.out.println(getLength(singleLinkedList.getHead()));

        //test the findLastIndexNode
        HeroNode result = findLastIndexNode(singleLinkedList.getHead(),4);
        System.out.println("result is :" + result);

        //test the reverseSingleLinkedList method
        System.out.println("test the reverseSingleLinkedList method");
        reverseList(singleLinkedList.getHead());
        singleLinkedList.list();
        System.out.println();

        //test the reverseListHan method
        System.out.println("test the reverseListHan method");
        reverseListHan(singleLinkedList.getHead());
        singleLinkedList.list();
        System.out.println();

        //test the reversePrint method
        System.out.println("test the reversePrint method");
        reversePrint(singleLinkedList.getHead());
        System.out.println();

        //test the mergeLists method
        System.out.println("test the mergeLists method");
        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        singleLinkedList1.add(hero5);
        singleLinkedList1.add(hero6);
        singleLinkedList1.add(hero7);

        mergeLists(singleLinkedList.getHead(),singleLinkedList1.getHead());
        singleLinkedList.list();
    }

    //merge two linkedlists
    public static void mergeLists(HeroNode head1, HeroNode head2){
        if(head2.next == null){
            return;
        }
        HeroNode current = head1;
        while(current.next != null){
            current = current.next;
        }
        current.next = head2.next;
    }

    //use stack to print the linkedlist
    public static void reversePrint(HeroNode head){
        if(head.next == null){
            return;
        }
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;

        while(cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        while(stack.size() > 0){
            System.out.println(stack.pop());
        }
    }

    //to get the length of the linkedlist
    public static int getLength(HeroNode head){
        if(head.next == null){
            return 0;
        }
        HeroNode current = head.next;
        int length = 0;
        while(current != null){
            length++;
            current = current.next;
        }
        return length;
    }

    // to get the kth-to-last heronode
    public static HeroNode findLastIndexNode(HeroNode head,int index){
        if(head.next == null){
            return null;
        }
        int size = getLength(head);
        //exam whether the value of index is right
        if(index <= 0 || index > size){
            System.out.println("Please enter a proper integer");
            return null;
        }
        HeroNode current = head;
        for (int i = 0; i < size - index + 1; i++) {
            current = current.next;
        }
        return current;
    }

    //My personal solution to reverse the linkedlist
    public static void reverseList(HeroNode head){
        if(head.next == null || head.next.next == null){
            return;
        }

        SingleLinkedList newSingleLinkedList = new SingleLinkedList();
        HeroNode current = head.next;
        HeroNode next = current.next;
        while(true){
            newSingleLinkedList.addAtFirstPosition(current);
            current = next;
            if(current == null){
                break;
            }
            next = next.next;
            //must learn to place loop-end-conditions in suitable places
//            if(next == null){
//                newSingleLinkedList.addAtFirstPosition(current);
//                break;
//            }
        }
        head.next = newSingleLinkedList.getHead().next;
    }

    //Han's solution to reverse the linkedlist
    public static void reverseListHan(HeroNode head){
        if(head.next == null || head.next.next == null){
            return;
        }

        HeroNode current = head.next;
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0,"","");

        while(current != null){
            next = current.next;
            current.next = reverseHead.next; //当刚生成reverseHead时不应该属性值next为null吗，也没事代表只有一个节点，最后的节点next值都为null
            reverseHead.next = current;
            current = next;
        }
        head.next = reverseHead.next;
    }
}

class SingleLinkedList {
    //带头结点的单链表
    private HeroNode head = new HeroNode(0,"","");

    public HeroNode getHead(){
        return head;
    }

    public void add(HeroNode heroNode){
        HeroNode temp = head;
        //to goto the last position in the linkedlist
        while(true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    //used by the linkedlist-reversing function
    public void addAtFirstPosition(HeroNode newHeroNode){
        if(head.next == null){
            head.next = newHeroNode;
            newHeroNode.next = null;
            return;// must use return to end the method earlier
        }
        newHeroNode.next = head.next;
        head.next = newHeroNode;
    }

    public void addByOrder(HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = false;//to know the number we added is in reality
        // to go to the position we add heronode
        while(true){
            if(temp.next == null){
                break;
            }

            if(temp.next.no > heroNode.no){//get the right position just between the temp and temp.next
                break;
            }else if(temp.next.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //进行添加
        if(flag){
            System.out.println("the heroNode that is needed is already in the linkedlist.");
        }else{
            //插入操作
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //change the heronode information according to the number value
    //according to the heronode.no
    public void update(HeroNode newHeroNode){
        if(head.next == null){
            System.out.println("the linkedlist is empty");
            return;
        }

        HeroNode temp = head.next;
        boolean flag = false;
        while(true){
            if(temp == null){
                break; // already in the last position in the linkedlist
            }
            if(temp.no == newHeroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag){
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        }else {
            System.out.println("Don't find the new heronode");
        }
    }

    public void list(){
        HeroNode temp = head.next;
        if(temp == null){
            System.out.println("This linkedlist is empty.");
            return;
        }
        //print the heronode from the first position in the linkedlist
        while (true){
            if(temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public void del(int no){
        if(head.next == null){
            System.out.println("This linkedlist is empty.");
            return;
        }
        HeroNode temp = head;
        boolean flag = false; //point if there is a heronode whose no is no
        while(true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            //temp is a auxiliary delete node
            temp.next = temp.next.next;
        }else{
            System.out.println("Don't find the heronode with no.");
        }
    }
}

class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
