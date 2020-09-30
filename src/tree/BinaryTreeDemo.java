package tree;

/**
 * @author coderhu1
 * @create 2020-09-08 14:01
 */
public class BinaryTreeDemo {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        //说明，我们先手动创建该二叉树，后面我们学习递归的方式创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);

        binaryTree.setRoot(root);

        //测试
//        System.out.println("前序遍历");
//        binaryTree.preOrder();
//
//        System.out.println("中序");
//        binaryTree.infixOrder();
//
//        System.out.println("后序");
//        binaryTree.postOrder();

        //前序遍历查找 4
//        System.out.println("前序遍历查找...");
//        HeroNode resNode = binaryTree.preOrderSearch(5);
//        if(resNode != null) {
//            System.out.println(resNode);
//        }else {
//            System.out.println("没找到");
//        }

        //中序遍历查找 3
//        System.out.println("中序遍历查找...");
//        HeroNode resNode = binaryTree.infixOrderSearch(5);
//        if(resNode != null) {
//            System.out.println(resNode);
//        }else {
//            System.out.println("没找到");
//        }

        //后序遍历查找 2
//        System.out.println("后序遍历查找...");
//        HeroNode resNode = binaryTree.postOrderSearch(5);
//        if(resNode != null) {
//            System.out.println(resNode);
//        }else {
//            System.out.println("没找到");
//        }

        //测试删除
        System.out.println("删除前，前序遍历");
        binaryTree.preOrder();

        binaryTree.delNode(5);

        System.out.println("删除后，前序遍历");
        binaryTree.preOrder();
    }
}

class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //删除节点
    public void delNode(int no) {
        if(root != null) {
            if(root.getNo() == no) {
                root = null;
            }else {
                root.delNode(no);
            }
        }else {
            System.out.println("空树，无法删除");
        }
    }

    public void preOrder() {
        if(this.root != null) {
            this.root.preOrder();
        }else {
            System.out.println("当前二叉树为空，无法遍历");
        }
    }

    public void infixOrder() {
        if(this.root != null) {
            this.root.infixOrder();
        }else {
            System.out.println("为空");
        }
    }

    public void postOrder() {
        if(this.root != null) {
            this.root.postOrder();
        }else {
            System.out.println("为空");
        }
    }

    //前序遍历查找
    public HeroNode preOrderSearch(int no) {
        if(root != null) {
            return root.preOrderSearch(no);
        }else {
            return null;
        }
    }

    public HeroNode infixOrderSearch(int no) {
        if(root != null) {
            return root.infixOrderSearch(no);
        }else {
            return null;
        }
    }

    public HeroNode postOrderSearch(int no) {
        if(root != null) {
            return root.postOrderSearch(no);
        }else {
            return null;
        }
    }
}


class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;
    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //递归删除节点,其实就是前序遍历,并没有对父节点的删除，所以父节点删除也要写在其他方法中
    public void delNode(int no) {
        if(this.left != null && this.left.no == no){
            this.left = null;
            return;
        }

        if(this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }

        if(this.left != null) {
            this.left.delNode(no);
        }

        if(this.right != null) {
            this.right.delNode(no);
        }
    }

    //先编写前序遍历的方法
    public void preOrder() {
        System.out.println(this);//先输出父节点
        //递归向左子树前序遍历
        if(this.left != null) {
            this.left.preOrder();
        }
        //递归向右子树前序遍历
        if(this.right != null) {
            this.right.preOrder();
        }
    }

    public void infixOrder() {
        //递归向左子树中序遍历
        if(this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right != null) {
            this.right.infixOrder();
        }
    }

    public void postOrder() {
        if(this.left != null) {
            this.left.postOrder();
        }
        if(this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    //前序遍历查找
    public HeroNode preOrderSearch(int no) {
        //找到返回节点，所有遍历完了没找到才能返回null，要不然会提前结束遍历
        HeroNode resNode = null;

        System.out.println("进入前序遍历查找");
        if(this.no == no) {
            return this;
        }

        if(this.left != null) {
            resNode = this.left.preOrderSearch(no);
            if(resNode != null){
                return resNode;
            }
        }

        if(this.right != null) {
            resNode = this.right.preOrderSearch(no);
            if(resNode != null){
                return resNode;
            }
        }

        return null;
    }

    public HeroNode infixOrderSearch(int no) {
        HeroNode resNode = null;

        if(this.left != null) {
            resNode = this.left.infixOrderSearch(no);
            if(resNode != null){
                return resNode;
            }
        }

        System.out.println("进入中序遍历");
        if(this.no == no) {
            return this;
        }

        if(this.right != null) {
            resNode = this.right.infixOrderSearch(no);
            if(resNode != null){
                return resNode;
            }
        }

        return null;
    }

    public HeroNode postOrderSearch(int no) {
        HeroNode resNode = null;

        if(this.left != null) {
            resNode = this.left.postOrderSearch(no);
            if(resNode != null){
                return resNode;
            }
        }

        if(this.right != null) {
            resNode = this.right.postOrderSearch(no);
            if(resNode != null){
                return resNode;
            }
        }

        System.out.println("进入后序遍历");
        if(this.no == no) {
            return this;
        }

        return null;
    }
}