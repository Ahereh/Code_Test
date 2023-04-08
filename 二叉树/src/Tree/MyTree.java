package Tree;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName MyTree
 * @Description 二 叉 树
 * @Author 86189
 * @Date 2022/5/14 15:30
 **/
public class MyTree {
    public class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public TreeNode root;

    public void creatTree(){
        TreeNode treeNode1=new TreeNode(1);
        TreeNode treeNode2=new TreeNode(2);
        TreeNode treeNode3=new TreeNode(3);
        TreeNode treeNode4=new TreeNode(4);
        TreeNode treeNode5=new TreeNode(5);
        TreeNode treeNode6=new TreeNode(6);
        TreeNode treeNode7=new TreeNode(7);
        root=treeNode1;
        treeNode1.left=treeNode2;
        treeNode1.right=treeNode3;
        treeNode2.left=treeNode4;
        treeNode2.right=treeNode5;
        treeNode3.left=treeNode6;
        treeNode3.right=treeNode7;
    }
    //前序遍历（递归）
    public void preOrder(TreeNode root){
        if(root==null){
            return ;
        }
        System.out.print(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
    // 中序遍历
    public void inOrder(TreeNode root){
        if(root==null){
            return ;
        }
        inOrder(root.left);
        System.out.print(root.val);
        inOrder(root.right);
    }
    // 后序遍历
    public void postOrder(TreeNode root){
        if(root==null){
            return ;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val);
    }
    public static int leafSize=0;   //叶子节点数
    //求叶子节点个数(遍历)
    public int getLeafNodeCount1(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.right==null&&root.left==null){
            leafSize++;
        }
        getLeafNodeCount1(root.left);
        getLeafNodeCount1(root.right);
        return leafSize;
        //也可以不用返回值，直接引用类名访问静态变量leafSize即可
    }
    //求叶子节点个数（子问题）
    public int getLeafNodeCount2(TreeNode root){
        if(root==null){
            return 0;
        }
        if(root.right==null&&root.left==null){
            return 1;
        }
        return getLeafNodeCount2(root.left)+getLeafNodeCount2(root.right);
    }

    //求k层的总节点数
    public int getKLeveleNodeCount(TreeNode root,int k){
        if(root==null){
            return 0;
        }
        if(k==1){
            return 1;
        }
        return getKLeveleNodeCount(root.left,k-1)+
                getKLeveleNodeCount(root.right,k-1);
    }
    /*
    获取二叉树的高度(深度遍历)
    */
    public static int length=0;
    public int getHeight(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftH=getHeight(root.left);
        int rightH=getHeight(root.right);
        return leftH>rightH?(leftH+1):(rightH+1);
        // return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }

    // 检测值为value的元素是否存在.
    public TreeNode find(TreeNode root, int val) {
        if(root == null) return null;
        if(root.val == val) return root;
        TreeNode ret=find(root.left,val);
        if(ret!=null){
            return ret;
        }
        ret=find(root.right,val);
        if(ret!=null){
            return ret;
        }
        return null;
    }
    //层序遍历（广度）
    Queue<TreeNode> queue = new LinkedList<>();
    void levelOrder(TreeNode root) {
        if(root == null) return;
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode ret=queue.poll();
            System.out.print(ret.val+" ");
            if(ret.left!=null)
            queue.offer(ret.left);
            if(ret.right!=null)
            queue.offer(ret.right);
        }

    }
}
