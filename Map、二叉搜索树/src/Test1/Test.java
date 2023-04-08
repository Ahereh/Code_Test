package Test1;

/**
 * @ClassName Test
 * @Description 二叉树搜索树
 * @Author 86189
 * @Date 2022/6/30 16:44
 **/
public class Test {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree=new BinarySearchTree();
        int []arr=new int[]{10,4,29,35,18,27,5,13,43,22};
        /*         二叉树搜索树
                   10
                  /  \
                 4     29
                  \   /  \
                  5  18  35
                     / \   \
                    13 27   43
                       /
                      22
        */
        for (int i = 0; i < arr.length; i++) {
            binarySearchTree.insert(arr[i]);
        }
        binarySearchTree.inOrder(binarySearchTree.root);
        System.out.println();
        System.out.print("查找： ");
        BinarySearchTree.TreeNode ret=binarySearchTree.search(18);
        try{
            System.out.println(ret.val);
        } catch (NullPointerException s){
            System.out.println("找不到要搜索的节点");
            s.printStackTrace();
        }
        System.out.println("==============");
        binarySearchTree.remove(10);    //以删除10为例，删完后的二叉搜索树根节点为原右子树中的最小节点13
        System.out.println("测试");
    }
}
