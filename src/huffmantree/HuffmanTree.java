package huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author coderhu1
 * @create 2020-09-11 14:39
 */
public class HuffmanTree {

    public static void main(String[] args) {
        int arr[] = {13, 7, 8, 3, 29, 6, 1};

        Node root = createHuffmanTree(arr);
        preOrder(root);
    }

    public static void preOrder(Node root) {
        if(root != null) {
            root.preOrder();
        }else {
            System.out.println("Empty tree!");
        }
    }

    /**
     *
     * @param arr
     * @return ����root�ڵ�
     */
    public static Node createHuffmanTree(int[] arr) {
        //��һ��Ϊ�˲�������
        //1.����arr����
        //2.��arr��ÿ��Ԫ�ع���һ��Node
        //3.��Node���뵽ArrayList��
        List<Node> nodes = new ArrayList<>();
        for (int value :
                arr) {
            nodes.add(new Node(value));
        }
        //����
        Collections.sort(nodes);
//        System.out.println(nodes);

        while(nodes.size() > 1) {
            //ȡ�����ڵ�Ȩֵ��С�����Ŷ�����
            //��1��ȡ��Ȩֵ��С�Ľڵ㣨��������
            Node left = nodes.get(0);
            //(2)ȡ�ڶ�С�Ľڵ�
            Node right = nodes.get(1);
            //(3)����һ���µĶ�����
            Node parent = new Node(left.value + right.value);

            parent.left = left;
            parent.right = right;

            //(4)��ArrayListɾ��������Ķ�����
            nodes.remove(left);
            nodes.remove(right);
            //(5)��parent���뵽nodes
            nodes.add(parent);
            Collections.sort(nodes);

//            System.out.println(nodes);
        }
        return nodes.get(0);
    }
}

//�����ڵ���
//Ϊ����Node����֧������Collections���Ϲ���������
//��nodeʵ��comparable�ӿ�
class Node implements Comparable<Node>{
    int value; //�ڵ�Ȩֵ
    Node left; //ָ�����ӽڵ�
    Node right; //ָ�����ӽڵ�

    //ǰ�����
    public void preOrder () {
        System.out.println(this);

        if(this.left != null) {
            this.left.preOrder();
        }

        if(this.right != null) {
            this.right.preOrder();
        }
    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        //��˳���ʾ��С������
        return this.value - o.value;
    }
}