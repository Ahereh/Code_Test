package Test1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName BinarySearchTree
 * @Description 二叉搜素树
 * @Author 86189
 * @Date 2022/6/30 16:44
 **/
public class BinarySearchTree {
    static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
        TreeNode(int val){
            this.val=val;
        }
    }
    public TreeNode root;

    //二叉搜索树的插入
    public boolean insert(int key){
        //二叉搜索树的插入一定是在叶子节点进行插入
        if(root==null) {
            root=new TreeNode(key);
            return true;
        }
        TreeNode cur=root;
        TreeNode pre=null;  //设置一个前置节点来判断最后cur到达null位置，要把key插入到具体的左节点位置还是右节点位置
        while(cur!=null){
            if(cur.val>key){    //如果key小于当前cur的值，那么key位于当前cur的左树
                pre=cur;
                cur=cur.left;
            } else if(cur.val<key){     //如果key大于当前cur的值，那么key位于当前cur的右树
                pre=cur;
                cur=cur.right;
            } else{     //如果key的值等于cur的值，由于搜索树无法判断与其相等的值，直接返回false
                return false;
            }
        }
        //循环走出来的，cur为null,pre为cur前一节点的位置
        TreeNode ret=new TreeNode(key);
         if(pre.val>key){
             pre.left=ret;
         } else{
             pre.right=ret;
         }
         return true;
    }

    //二叉搜索树的删除
    /**
    * @Description: remove
    * @Param:  key（要删除的节点值）
    * @return:  boolean
    */
    public boolean remove(int key){
        TreeNode cur=root;
        TreeNode parent=null;
        while(cur!=null){
            if(cur.val<key){
                parent=cur;
                cur=cur.right;
            } else if(cur.val>key){
                parent=cur;
                cur=cur.left;
            } else{
                //此处在二叉搜索树找到了要删除的节点
                removeNode(parent,cur);
                return true;
            }
        }
        return false;
    }
    /**
    * @Description:removeNOde
    * @Param:  parent(要删除节点的双亲节点),cur(要删除的节点)
    * @return:  void
    */
    public void removeNode(TreeNode parent,TreeNode cur){
        if(cur.left==null){
            //当cur节点的左节点为空的情况
            if(cur==root){
                root=cur.right;
            } else if(parent.right==cur){
                parent.right=cur.right;
            } else{
                //parent节点的左节点等于cur节点的情况
                parent.left=cur.right;
            }
        } else if(cur.right==null){
            //当cur节点的右节点为空的情况
            if(cur==root){
                root=cur.left;
            } else if(parent.right==cur){
                parent.right=cur.left;
            } else{
                //parent节点的左节点等于cur节点的情况
                parent.left=cur.left;
            }
        } else{
            //当要删除的节点cur的左节点不为null，右节点不为null
            TreeNode targetparent=cur;  //targetparent为target的前一个节点
            TreeNode target=cur.right;  //从要删除节点的右子树开始找最小值节点来替换当前要删除的cur节点
            while(target.left!=null){
                targetparent=target;
                target=target.left;
            }
            //此时的cur表示要删除的节点，用右子树的最小节点树值替换cur
            cur.val=target.val;
            //替换完才对target进行删除
            //需判断target此时是在targetparent的左树还是右树\
            //又因为在右子树找最小节点，都是一直在右子树的左子树找，那么找到后的target的左节点值一定为null
            if(targetparent.left==target){
                targetparent.left=target.right;
            } else if(targetparent.right==target){
                targetparent.right=target.right;
            }
        }
    }


    //二叉搜索树的查找
    public TreeNode search(int key){
        TreeNode cur=root;
        while(cur!=null){
            if(cur.val>key){
                cur=cur.left;
            } else if(cur.val<key){
                cur=cur.right;
            } else{
                return cur;
            }
        }
        return null;

    }
    //二叉搜索树的中序遍历(二叉搜索树的中序遍历可以直接按顺序输出其节点值)
    public void inOrder(TreeNode root){
        if(root==null) return;
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }
}
