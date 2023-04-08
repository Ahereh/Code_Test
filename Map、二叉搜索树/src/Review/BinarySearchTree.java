package Review;

/**
 * @ClassName BinarySearchTree
 * @Description TODO
 * @Author 86189
 * @Date 2022/7/2 0:23
 **/
public class BinarySearchTree {

    static class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int key) {
            this.key = key;
        }
    }

    public TreeNode root;

    /**
     * 插入一个元素
     * @param key
     */
    public boolean insert(int key) {
        if(root==null) {
            root=new TreeNode(key);
            return true;
        }
        TreeNode cur=root;
        TreeNode pre=null;
        while(cur!=null){
            if(cur.key<key){
                pre=cur;
                cur=cur.right;
            } else if(cur.key>key){
                pre=cur;
                cur=cur.left;
            } else{
                return false;
            }
        }
        if(pre.key>key){
            pre.left=new TreeNode(key);
        } else if(pre.key<key){
            pre.right=new TreeNode(key);
        }
        return true;
    }
    //查找key是否存在
    public TreeNode search(int key) {
        TreeNode cur=root;
        while(cur!=null){
            if(cur.key<key){
                cur=cur.right;
            } else if(cur.key>key){
                cur=cur.left;
            } else{
                return cur;
            }
        }
        return null;
    }
    //删除key的值
    public void removeParation(TreeNode cur,TreeNode parent){
        if(cur.left==null){
            if(cur==root){
                root=cur.right;
            } else if(parent.left==cur){
                parent.left=cur.right;
            } else if(parent.right==cur){
                parent.right=cur.right;
            }
        } else if(cur.right==null){
            if(cur==root){
                root=cur.left;
            } else if(parent.left==cur){
                parent.left=cur.left;
            } else if(parent.right==cur){
                parent.right=cur.left;
            }
        } else{
            TreeNode targetParent=cur;
            TreeNode target=cur.right;
            while(target.left!=null){
                targetParent=target;
                target=target.left;
            }
            cur.key=target.key;
            if(targetParent.left==target){
                targetParent.left=target.right;
            } else if(targetParent.right==target){
                targetParent.right=target.right;
            }
        }
    }
    public boolean remove(int key) {
        TreeNode cur=root;
        TreeNode parent=null;
        while(cur!=null){
            if(cur.key<key){
                parent=cur;
                cur=cur.right;
            } else if(cur.key>key){
                parent=cur;
                cur=cur.left;
            } else{
                removeParation(cur,parent);
                return true;
            }
        }
        return false;
    }
}