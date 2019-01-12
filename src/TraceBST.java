import java.util.Stack;

public class TraceBST {
    //中序遍历采用非递归的方式
    public void inOrderNonRecursive(BinaryTreeNode root){
        Stack<BinaryTreeNode> stack=new Stack<BinaryTreeNode>();
        while(true){
            while(root!=null){
                stack.push(root);
                root=root.getLeft();
            }
            if(stack.isEmpty())
                break;
            root=stack.pop();
            //直到最左孩子才开始访问
            System.out.print(root.getData()+"\t");
            root=root.getRight();
        }
    }
    //前序遍历非递归的方式
    public void preOrderNonRecursive(BinaryTreeNode root){
        Stack<BinaryTreeNode> stack=new Stack<BinaryTreeNode>();
        while(true){
            while(root!=null){
                //根据根节点左孩子顺序访问
                System.out.print(root.getData()+"\t");
                stack.push(root);
                root=root.getLeft();
            }
            if(stack.isEmpty()) break;
            root=stack.pop();
            root=root.getRight();
        }
    }
    //后序遍历采用递归的方式
    public void postOrder(BinaryTreeNode root){
        if(root!=null){
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.print(root.getData()+"\t");
        }
    }

















    private static class BinaryTreeNode{
        //二叉树节点
            private int data;
            private BinaryTreeNode left;
            private BinaryTreeNode right;

            public BinaryTreeNode() {}

            public BinaryTreeNode(int data, BinaryTreeNode left, BinaryTreeNode right) {
                super();
                this.data = data;
                this.left = left;
                this.right = right;
            }

            public int getData() {
                return data;
            }

            public void setData(int data) {
                this.data = data;
            }

            public BinaryTreeNode getLeft() {
                return left;
            }

            public void setLeft(BinaryTreeNode left) {
                this.left = left;
            }

            public BinaryTreeNode getRight() {
                return right;
            }

            public void setRight(BinaryTreeNode right) {
                this.right = right;
            }
        }
    }

