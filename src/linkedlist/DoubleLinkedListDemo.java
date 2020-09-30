package linkedlist;

import com.hu.linkedlist.HeroNode;

/**
 * @author coderhu1
 * @create 2020-08-21 22:43
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args) {

    }
}

class DoubleLinkedList{
    private HeroNode2 head = new HeroNode2(0,"","");
}

class HeroNode2 {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next; //default value: null
    public HeroNode pre; //default value: null

    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}