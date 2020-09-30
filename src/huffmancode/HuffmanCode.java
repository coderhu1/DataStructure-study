package huffmancode;

import java.util.*;

/**
 * @author coderhu1
 * @create 2020-09-12 9:49
 */
public class HuffmanCode {

    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] bytes = content.getBytes();
        System.out.println(bytes.length);

        List<Node> nodes = getNodes(bytes);
        System.out.println(nodes);

        Node root = createHuffmanTree(nodes);
        root.preOrder();
    }

    public static void preOrder(Node root) {
        if(root != null) {
            root.preOrder();
        }else {
            System.out.println("Huffmantree is empty.");
        }
    }
    /**
     *
     * @param bytes �����ֽ�����
     * @return ���ص���List��ʽ
     */
    private static List<Node> getNodes(byte[] bytes) {
        ArrayList<Node> nodes = new ArrayList<>();

        //����bytes
        HashMap<Byte, Integer> counts = new HashMap<>();
        for (byte b :
                bytes) {
            Integer count = counts.get(b);
            if(count == null) {
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }

        for (Map.Entry<Byte, Integer> entry: counts.entrySet()) { //����foreachѭ��
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }

        return nodes;
    }

    private static Node createHuffmanTree(List<Node> nodes) {
        while(nodes.size() > 1) {
            Collections.sort(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parent = new Node(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;

            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }
        return nodes.get(0);
    }
}

//����node�ڵ㣬����������Ȩֵ
class Node implements Comparable<Node>{
    Byte data;// 'a' -> 97
    int weight;//���ַ����ֵĴ���
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        //��С������
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    //ǰ�����
    public void preOrder() {
        System.out.println(this);

        if(this.left != null) {
            this.left.preOrder();
        }

        if(this.right != null) {
            this.right.preOrder();
        }
    }
}
