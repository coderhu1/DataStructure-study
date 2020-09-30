package tree.threadedbinarytree;

/**
 * @author coderhu1
 * @create 2020-09-09 8:44
 */
public class ThreadedBinaryTreeDemo {

    public static void main(String[] args) {
        HeroNode root = new HeroNode(1, "tom");
        HeroNode node2 = new HeroNode(3, "jack");
        HeroNode node3 = new HeroNode(6, "tom");
        HeroNode node4 = new HeroNode(8, "mary");
        HeroNode node5 = new HeroNode(10, "king");
        HeroNode node6 = new HeroNode(14, "dim");

        //二叉树，后边会递归创建，现在手动创建
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        //测试线索化
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNodes();

        //测试10号节点
        System.out.println(node5.getLeft());
        System.out.println(node5.getRight());

        //当线索化二叉树后，不能再使用原来的遍历方法了
        threadedBinaryTree.threadedList();
    }
}


class ThreadedBinaryTree {
    private HeroNode root;

    private HeroNode pre = null;
    //为了实现线索化需要创建一个指向当前节点的前驱节点的引用变量
    //在递归进行线索化时，该pre总是保留前一个节点

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //编写对二叉树进行中序线索化的方法
    public void threadedNodes() {
        threadedNodes(root);
    }
    /**
     *
     * @param node 当前需要线索化的节点
     */
    public void threadedNodes(HeroNode node) {
        if(node == null) {
            return;
        }

        //先线索化左子树
        threadedNodes(node.getLeft());

        //线索化当前节点,有点难度
        //处理当前节点的前去节点
        if(node.getLeft() == null) {
            //让当前节点的左指针指向前驱节点
            node.setLeft(pre);
            node.setLeftType(1);
        }

        //处理后继节点,下一次来处理的
        if(pre != null && pre.getRight() == null) {
            //让前驱节点的右指针指向当前结点
            pre.setRight(node);
            pre.setRightType(1);
        }

        //!!!每处理一个节点后，让当前节点时下一个节点的前驱节点
        pre = node;

        //线索化右子树
        threadedNodes(node.getRight());
    }

    //遍历中序线索化二叉树的方法
    public void threadedList() {
        //定义一个变量，存储当前遍历的节点，从root开始
        HeroNode node = root;
        while(node != null) {
            //循环的找到leftType == 1的节点，第一个就是8
            //后面随着循环，node会变化
            //遍历到左下角
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }

            System.out.println(node);

            //靠这个回右上角
            while (node.getRightType() == 1) {
                node = node.getRight();
                System.out.println(node);
            }

            //穿到右下角
            node = node.getRight();
        }
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

    //遍历
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

    //遍历查找
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

    //说明
    //1 如果leftType == 0 表示指向的是左子树，如果1则表示指向前驱节点
    //2 如果rightType == 0
    private int leftType;
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

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
