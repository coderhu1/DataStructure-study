package tree;

/**
 * @author coderhu1
 * @create 2020-09-08 19:59
 */
public class ArrayBinaryTreeDemo {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder();
        arrBinaryTree.infixOrder();
        arrBinaryTree.postOrder();
    }
}

//编写一个ArrayBinaryTree,实现顺序存储二叉树遍历

class ArrBinaryTree {
    private int[] arr;//存储数据节点的数组

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    //重载preOrder()
    public void preOrder() {
        this.preOrder(0);
        System.out.println();
    }

    public void infixOrder() {
        this.infixOrder(0);
        System.out.println();
    }

    public void postOrder() {
        this.postOrder(0);
        System.out.println();
    }
    //编写一个方法，完成顺序存储二叉树的一个前序遍历

    /**
     *
     * @param index 数组的下标
     */
    public void preOrder(int index) {
        //如果数组为空，或者arr.length = 0
        if(arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        //输出当前这个元素
        System.out.print(arr[index] + "\t");
        //向左递归遍历
        if((index * 2 + 1) < arr.length) {
            preOrder(2 * index + 1);
        }
        //向右递归遍历
        if((index * 2 + 2) < arr.length) {
            preOrder(index * 2 + 2);
        }
    }

    public void infixOrder(int index) {
        if(arr == null || arr.length == 0) {
            System.out.println("为空");
        }

        if((index * 2 + 1) < arr.length) {
            infixOrder(index * 2 + 1);
        }

        System.out.print(arr[index] + "\t");

        if((index * 2 + 2) < arr.length) {
            infixOrder(index *2 + 2);
        }
    }

    public void postOrder(int index) {
        if(arr == null || arr.length == 0) {
            System.out.println("为空");
        }

        if((index * 2 + 1) < arr.length) {
            postOrder(index * 2 + 1);
        }

        if((index * 2 + 2) < arr.length) {
            postOrder(index * 2 + 2);
        }

        System.out.print(arr[index] + "\t");
    }
}
